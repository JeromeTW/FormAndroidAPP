package com.example.jerome.helloformapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_text);
        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(text);
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_text);
        layout.addView(textView);
    }
}
