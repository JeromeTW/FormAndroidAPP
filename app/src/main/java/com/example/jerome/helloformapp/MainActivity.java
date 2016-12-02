package com.example.jerome.helloformapp;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


import Modal.DataItem;
import Modal.Section;
import Modal.TextPrinter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.key;
import static android.R.attr.value;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.nameEditText)
    EditText nameEditText;
    @BindView(R.id.maleRadioBtn)
    RadioButton maleRadioBtn;
    @BindView(R.id.femaleRadioBtn)
    RadioButton femaleRadioBtn;
    @BindView(R.id.textView3)
    TextView textView3;
    @BindView(R.id.birthDatePicker)
    DatePicker birthDatePicker;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.startDatePicker)
    DatePicker startDatePicker;
    @BindView(R.id.textView5)
    TextView textView5;
    @BindView(R.id.goodRadioBtn)
    RadioButton goodRadioBtn;
    @BindView(R.id.normalRadioBtn)
    RadioButton normalRadioBtn;
    @BindView(R.id.badRadioBtn)
    RadioButton badRadioBtn;
    @BindView(R.id.descriptionEditText)
    EditText descriptionEditText;
    @BindView(R.id.activity_main)
    ScrollView activityMain;
    @BindView(R.id.submitBtn)
    Button submitBtn;

    public static final String TAG = "MyActivity";
    public static final String NAME = "姓名";
    public static final String BIRTHDAY = "出生日期";
    public static final String GENDER = "型別";
    public static final String ACCEPTION_DAY = "收案日期";
    public static final String DESCRIPTION = "注記";

    public static final String SECTION_NAME_1TH = "個案基本資料";
    private TextPrinter textPrinter;


    //region Events
    /**
     * @param view 多個控件 不同點擊事件
     */
    @OnClick({R.id.goodRadioBtn, R.id.normalRadioBtn, R.id.badRadioBtn})
    public void setDiffEvents(View view) {
        switch (view.getId()) {
            case R.id.goodRadioBtn:
                goodRadioBtn.setChecked(true);
                normalRadioBtn.setChecked(false);
                badRadioBtn.setChecked(false);
                break;

            case R.id.normalRadioBtn:
                goodRadioBtn.setChecked(false);
                normalRadioBtn.setChecked(true);
                badRadioBtn.setChecked(false);
                break;

            case R.id.badRadioBtn:
                goodRadioBtn.setChecked(false);
                normalRadioBtn.setChecked(false);
                badRadioBtn.setChecked(true);
                break;
        }

    }
    @OnClick(R.id.maleRadioBtn) void maleBtnClicked() {
        maleRadioBtn.setChecked(true);
        femaleRadioBtn.setChecked(false);
    }
    @OnClick(R.id.femaleRadioBtn) void femaleRadioClicked() {
        maleRadioBtn.setChecked(false);
        femaleRadioBtn.setChecked(true);
    }
    @OnClick(R.id.submitBtn) void submit() {
        String nameString = nameEditText.getText().toString();
//        Log.v(TAG, NAME + ": " + nameString);
        // 月份從0開始算，所以要加一
//        String birthdayString = birthDatePicker.getYear() + "/" + (birthDatePicker.getMonth() + 1) + "/" + birthDatePicker.getDayOfMonth();
        String birthdayString = getDateString(birthDatePicker);
//        Log.v(TAG, BIRTHDAY + ": " + birthdayString);
        String genderString = maleRadioBtn.isChecked()? "male" : "female";
//        Log.v(TAG, GENDER + ": " + genderString);
//        String acceptString = startDatePicker.getYear() + "/" + (startDatePicker.getMonth() + 1) +
//                "/" +
//                startDatePicker.getDayOfMonth();
        String acceptString = getDateString(startDatePicker);
        String description1thString = descriptionEditText.getText().toString();

        List<DataItem> itemArray = new ArrayList<DataItem>();
        itemArray.add(new DataItem(NAME, nameEditText.getText().toString()));
        itemArray.add(new DataItem(GENDER, genderString));
        itemArray.add(new DataItem(BIRTHDAY, birthdayString));
        itemArray.add(new DataItem(ACCEPTION_DAY, acceptString));
        itemArray.add(new DataItem(DESCRIPTION, description1thString));



        Section nameSection = new Section(itemArray, SECTION_NAME_1TH);
        textPrinter.sectionArray.add(nameSection);

        Time now = new Time();
        now.setToNow();
        String dateString = now.format("%Y%m%d_%H%M%S") + "_" + nameString;
        writeToFile(dateString, textPrinter.print(), this);
//        readFromFile(this);
    }
    @OnClick(R.id.descriptionEditText) void descriptionTextClicked() {
        activityMain.scrollTo(0,activityMain.getBottom());
    }
    // endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        List<Section> sectionArray = new ArrayList<Section>();
        textPrinter = new TextPrinter(sectionArray);


    }
    // region Create String
    private String getDateString(DatePicker datePicker) {
        return datePicker.getYear() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker
                .getDayOfMonth();
    }
    private String getPerformanceString() {
        String result = "";
        if (goodRadioBtn.isChecked() == true) {
            result = "佳，不須增強即可全程安坐配合評估。";
        } else if (normalRadioBtn.isChecked() == true) {
            result = "尚可，需玩具／口語增強方可配合評估。";
        } else if (badRadioBtn.isChecked() == true) {
            result = "待加強，需頻繁予以增強方可短暫配合評估活動。";
        }
        return result;
    }
    // endregion

    // region Write/ Read File
    String readFromFile(Context context) {
        String ret = "";
        try {
            InputStream inputStream = context.openFileInput("JeromeTestSaveFile.txt");
            if (inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null ) {
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
    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
    /* Checks if external storage is available to at least read */
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
                albumName );
        if (!file.mkdirs()) {
            Log.e(TAG, "Directory not created");
        }
        return file;
    }
    // 取得外部公共儲存空間(指定檔案為相簿類型)
    public  File getAlnumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                albumName);
        if (!file.mkdirs()) {
            Log.e(TAG, "Directory not created");
        }
        return file;
    }
    // 取得外部公共儲存空間(指定檔案為檔案類型)
    public  File getFileStorageDir(String albumName) {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                albumName);
        if (!file.mkdirs()) {
            Log.e(TAG, "Directory not created");
        }
        return file;
    }
    public  void writeToFile(String fileName, String body, Context context)
    {
        FileOutputStream fos = null;

        try {
//            final File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/folderName/" );
            final File dir = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES),
                    fileName );
            if (!dir.exists())
            {
                if(!dir.mkdirs()){
                    Log.e("ALERT","could not create the directories");
                }
            }

            final File myFile = new File(dir, fileName + ".txt");

            if (!myFile.exists())
            {
                myFile.createNewFile();
            }

            fos = new FileOutputStream(myFile);

            fos.write(body.getBytes());
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    // endregion
}
