package com.example.jerome.helloformapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HelpActivity extends AppCompatActivity {

    @BindView(R.id.textView8)
    TextView textView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        ButterKnife.bind(this);
        String webLink = "\n語言治療評估報告小幫手希望能簡化台灣語言治療師評估統計的工作，並上傳至Google Drive，方便您管理。\n\n" +
                "獻給我美麗善良的另一半────Celeste.\n\n" +
                "\n\n" +
                "程式源碼在: https://github.com/JeromeTW/FormAndroidAPP" +
                "\n\n" +
                "聯絡Email: jerome.developer.tw@gmail.com" +
                "\n\n" +
                "<div>Icons made by <a href=\"http://www.freepik.com\" title=\"Freepik\">Freepik</a> from <a href=\"http://www.flaticon.com\" title=\"Flaticon\">www.flaticon.com</a> is licensed by <a href=\"http://creativecommons.org/licenses/by/3.0/\" title=\"Creative Commons BY 3.0\" target=\"_blank\">CC 3.0 BY</a></div>";
        textView8.setText(Html.fromHtml(webLink.replace("\n","<br />")));
    }
}
