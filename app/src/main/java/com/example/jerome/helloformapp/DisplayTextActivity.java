package com.example.jerome.helloformapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ScrollView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DisplayTextActivity extends AppCompatActivity {

    @BindView(R.id.resultEditText)
    EditText resultEditText;
    @BindView(R.id.activity_display_text)
    ScrollView activityDisplayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_text);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        resultEditText.setText(text);
    }
}
