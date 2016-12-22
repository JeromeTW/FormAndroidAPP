package com.example.jerome.helloformapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.jerome.helloformapp.MainActivity.EXTRA_CASE_NAME;
import static com.example.jerome.helloformapp.MainActivity.EXTRA_SHOULD_CLEAN_FORM;
import static com.example.jerome.helloformapp.MainActivity.EXTRA_TEXT;

public class DisplayTextActivity extends AppCompatActivity {

    @BindView(R.id.resultEditText)
    EditText resultEditText;
    @BindView(R.id.activity_display_text)
    ScrollView activityDisplayText;

    public static final String TAG = "DisplayTextActivity";
    private static final int INTENT_TO_GOOGLE_DRIVE_ACTIVITY = 0;
    Boolean didSaveText = false;
    String caseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_text);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String text = intent.getStringExtra(EXTRA_TEXT);
        caseName =  intent.getStringExtra(EXTRA_CASE_NAME);
        resultEditText.setText(text);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.display_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Time now = new Time();
        now.setToNow();
        String fileString = now.format("%Y%m%d_%H%M%S") + "_" + caseName;
        switch (item.getItemId()) {
            /*
            case R.id.saveMenuBtn:
                writeToFile(fileString, resultEditText.getText().toString(), this);
                Toast.makeText(this, R.string.submitSuccessfullyToast, Toast.LENGTH_SHORT).show();
                didSaveText = true;
                return true;*/
            case R.id.clearFormMenuBtn:
                if (didSaveText == true) {  // 如果已經保存了就不跳出提示
                    backToPreviousActivityAndClearForm();
                } else {
                    showClearFormDialog();
                }
                return true;
            case R.id.saveToGoogleDriveMenuBtn:
                Intent intent = new Intent(this, GoogleDriveActivity.class);
                intent.putExtra(EXTRA_TEXT, resultEditText.getText().toString());
                intent.putExtra(EXTRA_CASE_NAME, fileString);
                startActivityForResult(intent, INTENT_TO_GOOGLE_DRIVE_ACTIVITY);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showClearFormDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(DisplayTextActivity.this);
        dialog.setTitle(R.string.clearFormDialogTitle);
        dialog.setMessage(R.string.clearFormDialogMessage);
        // 為了讓按鈕位置符合用戶習慣，於是將setPositiveButton設置為取消；setNegativeButton設置為確認
        dialog.setPositiveButton(R.string.clearFormDialogCancelButton, new DialogInterface.OnClickListener
                () {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.setNegativeButton(R.string.clearFormDialogComfireButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                backToPreviousActivityAndClearForm();
            }
        });
        dialog.show();
    }
    private void backToPreviousActivityAndClearForm() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putBoolean(EXTRA_SHOULD_CLEAN_FORM, true);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        this.finish();
    }

    /*
    // region Write/ Read File
    String readFromFile(Context context) {
        String ret = "";
        try {
            InputStream inputStream = context.openFileInput("JeromeTestSaveFile.txt");
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }
                inputStream.close();
                ret = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            Log.e(TAG, "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e(TAG, "Can not read file: " + e.toString());
        }
        return ret;
    }

    // Checks if external storage is available for read and write
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    // Checks if external storage is available to at least read
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals
                (state)) {
            return true;
        }
        return false;
    }

    // 取得外部私有儲存空間(指定檔案為相簿類型)
    public File getAlubemStorageDir(Context context, String albumName) {
        // Get the directory for the app's private pictures directory.
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                albumName);
        if (!file.mkdirs()) {
            Log.e(TAG, "Directory not created");
        }
        return file;
    }

    // 取得外部公共儲存空間(指定檔案為相簿類型)
    public File getAlnumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                albumName);
        if (!file.mkdirs()) {
            Log.e(TAG, "Directory not created");
        }
        return file;
    }

    // 取得外部公共儲存空間(指定檔案為檔案類型)
    public File getFileStorageDir(String albumName) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                albumName);
        if (!file.mkdirs()) {
            Log.e(TAG, "Directory not created");
        }
        return file;
    }

    public void writeToFile(String fileName, String body, Context context) {
        FileOutputStream fos = null;

        try {
//            final File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/folderName/" );
            final File dir = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                    fileName);
            if (!dir.exists()) {
                if (!dir.mkdirs()) {
                    Log.e("ALERT", "could not create the directories");
                }
            }

            final File myFile = new File(dir, fileName + ".txt");

            if (!myFile.exists()) {
                myFile.createNewFile();
            }

            fos = new FileOutputStream(myFile);

            fos.write(body.getBytes());
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/
    // endregion
}
