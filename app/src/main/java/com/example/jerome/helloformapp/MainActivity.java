package com.example.jerome.helloformapp;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
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
import Modal.JeCheckBoxGroup;
import Modal.JeRadioGroup;
import Modal.Section;
import Modal.TextPrinter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


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

    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.textView7)
    TextView textView7;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.textView1_1_2)
    TextView textView112;
    @BindView(R.id.checkBox1_1_2_1)
    CheckBox checkBox1121;
    @BindView(R.id.checkBox1_1_2_2)
    CheckBox checkBox1122;
    @BindView(R.id.checkBox1_1_2_3)
    CheckBox checkBox1123;
    @BindView(R.id.checkBox1_1_2_4)
    CheckBox checkBox1124;
    @BindView(R.id.checkBox1_1_2_5)
    CheckBox checkBox1125;
    @BindView(R.id.checkBox1_1_2_6)
    CheckBox checkBox1126;
    @BindView(R.id.textView1_1_3)
    TextView textView113;
    @BindView(R.id.checkBox1_1_3_1)
    CheckBox checkBox1131;
    @BindView(R.id.checkBox1_1_3_2)
    CheckBox checkBox1132;
    @BindView(R.id.checkBox1_1_3_3)
    CheckBox checkBox1133;
    @BindView(R.id.checkBox1_1_3_4)
    CheckBox checkBox1134;
    @BindView(R.id.checkBox1_1_3_5)
    CheckBox checkBox1135;
    @BindView(R.id.checkBox1_1_3_6)
    CheckBox checkBox1136;
    @BindView(R.id.checkBox1_1_3_7)
    CheckBox checkBox1137;
    @BindView(R.id.textView1_1_4)
    TextView textView114;
    @BindView(R.id.checkBox1_1_4_1)
    CheckBox checkBox1141;
    @BindView(R.id.checkBox1_1_4_2)
    CheckBox checkBox1142;
    @BindView(R.id.textView1_1_5)
    TextView textView115;
    @BindView(R.id.RadioBtn1_1_5_1)
    RadioButton RadioBtn1151;
    @BindView(R.id.RadioBtn1_1_5_2)
    RadioButton RadioBtn1152;
    @BindView(R.id.RadioBtn1_1_5_3)
    RadioButton RadioBtn1153;
    @BindView(R.id.textView1_1_6)
    TextView textView116;
    @BindView(R.id.checkBox1_1_6_1)
    CheckBox checkBox1161;
    @BindView(R.id.checkBox1_1_6_2)
    CheckBox checkBox1162;
    @BindView(R.id.checkBox1_1_6_3)
    CheckBox checkBox1163;
    @BindView(R.id.checkBox1_1_6_4)
    CheckBox checkBox1164;
    @BindView(R.id.checkBox1_1_6_5)
    CheckBox checkBox1165;
    @BindView(R.id.checkBox1_1_6_6)
    CheckBox checkBox1166;
    @BindView(R.id.textView1_1_7)
    TextView textView117;
    @BindView(R.id.checkBox1_1_7_1)
    CheckBox checkBox1171;
    @BindView(R.id.checkBox1_1_7_2)
    CheckBox checkBox1172;
    @BindView(R.id.checkBox1_1_7_3)
    CheckBox checkBox1173;
    @BindView(R.id.checkBox1_1_7_4)
    CheckBox checkBox1174;
    @BindView(R.id.checkBox1_1_7_5)
    CheckBox checkBox1175;
    @BindView(R.id.checkBox1_1_7_6)
    CheckBox checkBox1176;
    @BindView(R.id.checkBox1_1_7_7)
    CheckBox checkBox1177;
    @BindView(R.id.checkBox1_1_7_8)
    CheckBox checkBox1178;
    @BindView(R.id.checkBox1_1_7_9)
    CheckBox checkBox1179;
    @BindView(R.id.textView1_1_8)
    TextView textView118;
    @BindView(R.id.RadioBtn1_1_8_1)
    RadioButton RadioBtn1181;
    @BindView(R.id.RadioBtn1_1_8_2)
    RadioButton RadioBtn1182;
    @BindView(R.id.RadioBtn1_1_8_3)
    RadioButton RadioBtn1183;
    @BindView(R.id.textView1_2_1)
    TextView textView121;
    @BindView(R.id.RadioBtn1_2_1_1)
    RadioButton RadioBtn1211;
    @BindView(R.id.RadioBtn1_2_1_2)
    RadioButton RadioBtn1212;
    @BindView(R.id.RadioBtn1_2_1_3)
    RadioButton RadioBtn1213;
    @BindView(R.id.textView1_2_2)
    TextView textView122;
    @BindView(R.id.checkBox1_2_2_1)
    CheckBox checkBox1221;
    @BindView(R.id.checkBox1_2_2_2)
    CheckBox checkBox1222;
    @BindView(R.id.checkBox1_2_2_3)
    CheckBox checkBox1223;
    @BindView(R.id.textView1_2_3)
    TextView textView123;
    @BindView(R.id.checkBox1_2_3_1)
    CheckBox checkBox1231;
    @BindView(R.id.checkBox1_2_3_2)
    CheckBox checkBox1232;
    @BindView(R.id.checkBox1_2_3_3)
    CheckBox checkBox1233;
    @BindView(R.id.checkBox1_2_3_4)
    CheckBox checkBox1234;
    @BindView(R.id.textView1_3_1)
    TextView textView131;
    @BindView(R.id.textView1_3_1_1)
    TextView textView1311;
    @BindView(R.id.RadioBtn1_3_1_1)
    RadioButton RadioBtn1311;
    @BindView(R.id.RadioBtn1_3_1_2)
    RadioButton RadioBtn1312;
    @BindView(R.id.textView1_4_1)
    TextView textView141;
    @BindView(R.id.textView1_4_1_1)
    TextView textView1411;
    @BindView(R.id.RadioBtn1_4_1_1)
    RadioButton RadioBtn1411;
    @BindView(R.id.RadioBtn1_4_1_2)
    RadioButton RadioBtn1412;
    @BindView(R.id.RadioBtn1_4_1_3)
    RadioButton RadioBtn1413;
    @BindView(R.id.textView1_4_2_1)
    TextView textView1421;
    @BindView(R.id.RadioBtn1_4_2_1)
    RadioButton RadioBtn1421;
    @BindView(R.id.RadioBtn1_4_2_2)
    RadioButton RadioBtn1422;
    @BindView(R.id.RadioBtn1_4_2_3)
    RadioButton RadioBtn1423;
    @BindView(R.id.textView1_5_1)
    TextView textView151;
    @BindView(R.id.textView1_5_1_2)
    TextView textView1512;
    @BindView(R.id.RadioBtn1_5_1_1)
    RadioButton RadioBtn1511;
    @BindView(R.id.RadioBtn1_5_1_2)
    RadioButton RadioBtn1512;
    @BindView(R.id.RadioBtn1_5_1_3)
    RadioButton RadioBtn1513;
    @BindView(R.id.textView1_5_2)
    TextView textView152;
    @BindView(R.id.RadioBtn1_5_2_1)
    RadioButton RadioBtn1521;
    @BindView(R.id.RadioBtn1_5_2_2)
    RadioButton RadioBtn1522;
    @BindView(R.id.RadioBtn1_5_2_3)
    RadioButton RadioBtn1523;
    @BindView(R.id.RadioBtn1_5_2_4)
    RadioButton RadioBtn1524;
    @BindView(R.id.textView1_5_3)
    TextView textView153;
    @BindView(R.id.RadioBtn1_5_3_1)
    RadioButton RadioBtn1531;
    @BindView(R.id.RadioBtn1_5_3_2)
    RadioButton RadioBtn1532;
    @BindView(R.id.RadioBtn1_5_3_3)
    RadioButton RadioBtn1533;
    @BindView(R.id.RadioBtn1_5_3_4)
    RadioButton RadioBtn1534;
    @BindView(R.id.textView1_5_4)
    TextView textView154;
    @BindView(R.id.RadioBtn1_5_4_1)
    RadioButton RadioBtn1541;
    @BindView(R.id.RadioBtn1_5_4_2)
    RadioButton RadioBtn1542;
    @BindView(R.id.RadioBtn1_5_4_3)
    RadioButton RadioBtn1543;
    @BindView(R.id.RadioBtn1_5_4_4)
    RadioButton RadioBtn1544;
    @BindView(R.id.textView2_1_1)
    TextView textView211;
    @BindView(R.id.textView2_1_1_1)
    TextView textView2111;
    @BindView(R.id.RadioBtn2_1_1_1)
    RadioButton RadioBtn2111;
    @BindView(R.id.RadioBtn2_1_1_2)
    RadioButton RadioBtn2112;
    @BindView(R.id.RadioBtn2_1_1_3)
    RadioButton RadioBtn2113;
    @BindView(R.id.textView2_1_1_2_1)
    TextView textView21121;
    @BindView(R.id.DatePicker2_1_1_2_2)
    DatePicker DatePicker21122;
    @BindView(R.id.textView2_1_1_2_2)
    TextView textView21122;
    @BindView(R.id.EditText2_1_1_2_2)
    EditText EditText21122;
    @BindView(R.id.textView2_1_1_2_3)
    TextView textView21123;
    @BindView(R.id.EditText2_1_1_2_3)
    EditText EditText21123;
    @BindView(R.id.textView2_1_1_2_4)
    TextView textView21124;
    @BindView(R.id.RadioBtn2_1_1_2_4_1)
    RadioButton RadioBtn211241;
    @BindView(R.id.RadioBtn2_1_1_2_4_2)
    RadioButton RadioBtn211242;
    @BindView(R.id.RadioBtn2_1_1_2_4_3)
    RadioButton RadioBtn211243;
    @BindView(R.id.RadioBtn2_1_1_2_4_4)
    RadioButton RadioBtn211244;
    @BindView(R.id.RadioBtn2_1_1_2_4_5)
    RadioButton RadioBtn211245;
    @BindView(R.id.RadioBtn2_1_1_2_4_6)
    RadioButton RadioBtn211246;
    @BindView(R.id.RadioBtn2_1_1_2_4_7)
    RadioButton RadioBtn211247;
    @BindView(R.id.RadioBtn2_1_1_2_4_8)
    RadioButton RadioBtn211248;
    @BindView(R.id.RadioBtn2_1_1_2_4_9)
    RadioButton RadioBtn211249;
    @BindView(R.id.textView2_2_1)
    TextView textView221;
    @BindView(R.id.textView2_2_1_1)
    TextView textView2211;
    @BindView(R.id.RadioBtn2_2_1_1_1)
    RadioButton RadioBtn22111;
    @BindView(R.id.RadioBtn2_2_1_1_2)
    RadioButton RadioBtn22112;
    @BindView(R.id.RadioBtn2_2_1_1_3)
    RadioButton RadioBtn22113;
    @BindView(R.id.textView2_2_2_1)
    TextView textView2221;
    @BindView(R.id.checkBox2_2_2_1_1)
    CheckBox checkBox22211;
    @BindView(R.id.checkBox2_2_2_1_2)
    CheckBox checkBox22212;
    @BindView(R.id.checkBox2_2_2_1_3)
    CheckBox checkBox22213;
    @BindView(R.id.checkBox2_2_2_1_4)
    CheckBox checkBox22214;
    @BindView(R.id.checkBox2_2_2_1_5)
    CheckBox checkBox22215;
    @BindView(R.id.checkBox2_2_2_1_6)
    CheckBox checkBox22216;
    @BindView(R.id.checkBox2_2_2_1_7)
    CheckBox checkBox22217;
    @BindView(R.id.checkBox2_2_2_1_8)
    CheckBox checkBox22218;
    @BindView(R.id.checkBox2_2_2_1_9)
    CheckBox checkBox22219;
    @BindView(R.id.checkBox2_2_2_1_10)
    CheckBox checkBox222110;
    @BindView(R.id.textView2_3_1)
    TextView textView231;
    @BindView(R.id.textView2_3_1_1)
    TextView textView2311;
    @BindView(R.id.RadioBtn2_3_1_1_1)
    RadioButton RadioBtn23111;
    @BindView(R.id.RadioBtn2_3_1_1_2)
    RadioButton RadioBtn23112;
    @BindView(R.id.RadioBtn2_3_1_1_3)
    RadioButton RadioBtn23113;
    @BindView(R.id.textView2_3_2_1)
    TextView textView2321;
    @BindView(R.id.checkBox2_3_2_1_1)
    CheckBox checkBox23211;
    @BindView(R.id.checkBox2_3_2_1_2)
    CheckBox checkBox23212;
    @BindView(R.id.checkBox2_3_2_1_3)
    CheckBox checkBox23213;
    @BindView(R.id.checkBox2_3_2_1_4)
    CheckBox checkBox23214;
    @BindView(R.id.checkBox2_3_2_1_5)
    CheckBox checkBox23215;
    @BindView(R.id.checkBox2_3_2_1_6)
    CheckBox checkBox23216;
    @BindView(R.id.checkBox2_3_2_1_7)
    CheckBox checkBox23217;
    @BindView(R.id.checkBox2_3_2_1_8)
    CheckBox checkBox23218;
    @BindView(R.id.checkBox2_3_2_1_9)
    CheckBox checkBox23219;
    @BindView(R.id.checkBox2_3_2_1_10)
    CheckBox checkBox232110;
    @BindView(R.id.checkBox2_3_2_1_11)
    CheckBox checkBox232111;
    @BindView(R.id.checkBox2_3_2_1_12)
    CheckBox checkBox232112;
    @BindView(R.id.textView2_3_3_1)
    TextView textView2331;
    @BindView(R.id.RadioBtn2_3_3_1_1)
    RadioButton RadioBtn23311;
    @BindView(R.id.RadioBtn2_3_3_1_2)
    RadioButton RadioBtn23312;
    @BindView(R.id.RadioBtn2_3_3_1_3)
    RadioButton RadioBtn23313;
    @BindView(R.id.RadioBtn2_3_3_1_4)
    RadioButton RadioBtn23314;
    private TextPrinter textPrinter;
    private JeRadioGroup performanceGroup;
    private JeRadioGroup genderGroup;   // 暫時不用
    private JeRadioGroup radioGroup1151;
    private JeRadioGroup radioGroup1181;
    private JeRadioGroup radioGroup1211;
    private JeRadioGroup radioGroup1311;
    private JeRadioGroup radioGroup1411;
    private JeRadioGroup radioGroup1421;
    private JeRadioGroup radioGroup1511;
    private JeRadioGroup radioGroup1521;
    private JeRadioGroup radioGroup1531;
    private JeRadioGroup radioGroup1541;
    private JeRadioGroup radioGroup2111;
    private JeRadioGroup radioGroup211241;
    private JeRadioGroup radioGroup22111;
    private JeRadioGroup radioGroup23111;
    private JeRadioGroup radioGroup23311;

    private JeCheckBoxGroup checkBoxGroup1121;
    private JeCheckBoxGroup checkBoxGroup1131;
    private JeCheckBoxGroup checkBoxGroup1141;
    private JeCheckBoxGroup checkBoxGroup1171;
    private JeCheckBoxGroup checkBoxGroup1221;
    private JeCheckBoxGroup checkBoxGroup1231;
    private JeCheckBoxGroup checkBoxGroup22211;
    private JeCheckBoxGroup checkBoxGroup23211;


    //region Events

    /**
     * @param button 多個控件 不同點擊事件
     */
    @OnClick({R.id.goodRadioBtn, R.id.normalRadioBtn, R.id.badRadioBtn})
    public void setDiffEvents(RadioButton button) {
        performanceGroup.didSelectRadio(button);
    }

    @OnClick(R.id.maleRadioBtn)
    void maleBtnClicked() {
        maleRadioBtn.setChecked(true);
        femaleRadioBtn.setChecked(false);
    }

    @OnClick(R.id.femaleRadioBtn)
    void femaleRadioClicked() {
        maleRadioBtn.setChecked(false);
        femaleRadioBtn.setChecked(true);
    }

    @OnClick(R.id.submitBtn)
    void submit() {
        String nameString = nameEditText.getText().toString();
//        Log.v(TAG, NAME + ": " + nameString);
        // 月份從0開始算，所以要加一
//        String birthdayString = birthDatePicker.getYear() + "/" + (birthDatePicker.getMonth() + 1) + "/" + birthDatePicker.getDayOfMonth();
        String birthdayString = getDateString(birthDatePicker);
//        Log.v(TAG, BIRTHDAY + ": " + birthdayString);
        String genderString = maleRadioBtn.isChecked() ? "male" : "female";
//        Log.v(TAG, GENDER + ": " + genderString);
//        String acceptString = startDatePicker.getYear() + "/" + (startDatePicker.getMonth() + 1) +
//                "/" +
//                startDatePicker.getDayOfMonth();
        String acceptString = getDateString(startDatePicker);
        String description1thString = descriptionEditText.getText().toString();

        List<DataItem> itemArray = new ArrayList<DataItem>();
        itemArray.add(new DataItem(getString(R.string.je_xingming), nameEditText.getText().toString()));
        itemArray.add(new DataItem(getString(R.string.je_xingbie), genderString));
        itemArray.add(new DataItem(getString(R.string.je_chushengriqi), birthdayString));
        itemArray.add(new DataItem(getString(R.string.je_shouanriqi), acceptString));
        itemArray.add(new DataItem(getString(R.string.je_zhuji), description1thString));


        Section nameSection = new Section(itemArray, getString(R.string.je_geanjibenziliao));
        textPrinter.sectionArray.add(nameSection);

        Time now = new Time();
        now.setToNow();
        String dateString = now.format("%Y%m%d_%H%M%S") + "_" + nameString;
        writeToFile(dateString, textPrinter.print(), this);
//        readFromFile(this);
    }

    /*
    @OnClick(R.id.descriptionEditText)
    void descriptionTextClicked() {
        activityMain.scrollTo(0, activityMain.getBottom());
    }
    // endregion
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ButterKnife.setDebug(true);
        setupRadioGroups();
        setupCheckBoxGroups();
        List<Section> sectionArray = new ArrayList<Section>();
        textPrinter = new TextPrinter(sectionArray);
    }

    // region Create String
    private String getDateString(DatePicker datePicker) {
        return datePicker.getYear() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker
                .getDayOfMonth();
    }

    /*
    private String getPerformanceString() {
        String result = "";
        if (goodRadioBtn.isChecked() == true) {
//            result = "佳，不須增強即可全程安坐配合評估。";
            result = goodRadioBtn.getText().toString();
        } else if (normalRadioBtn.isChecked() == true) {
            result = "尚可，需玩具／口語增強方可配合評估。";
        } else if (badRadioBtn.isChecked() == true) {
            result = "待加強，需頻繁予以增強方可短暫配合評估活動。";
        }
        Log.v(TAG, result);
        return result;
    }*/

    private void setupRadioGroups() {
        performanceGroup = new JeRadioGroup(getString(R.string.je_peihedu), goodRadioBtn, normalRadioBtn,
                badRadioBtn);
        radioGroup1151 = new JeRadioGroup(getString(R.string.je_textView115), RadioBtn1151, RadioBtn1152,
                RadioBtn1153);
        radioGroup1181 = new JeRadioGroup(getString(R.string.je_textView118), RadioBtn1181, RadioBtn1182,
                RadioBtn1183);
        radioGroup1211 = new JeRadioGroup(getString(R.string.je_textView121), RadioBtn1211, RadioBtn1212,
                RadioBtn1213);
        radioGroup1311 = new JeRadioGroup(getString(R.string.je_textView1311), RadioBtn1311,
                RadioBtn1312);
        radioGroup1411 = new JeRadioGroup(getString(R.string.je_textView141), RadioBtn1411, RadioBtn1412,
                RadioBtn1413);
        radioGroup1421 = new JeRadioGroup(getString(R.string.je_textView1421), RadioBtn1421, RadioBtn1422,
                RadioBtn1423);
        radioGroup1511 = new JeRadioGroup(getString(R.string.je_textView151), RadioBtn1511, RadioBtn1512,
                RadioBtn1513);
        radioGroup1521 = new JeRadioGroup(getString(R.string.je_textView152), RadioBtn1521, RadioBtn1522,
                RadioBtn1523, RadioBtn1524);
        radioGroup1531 = new JeRadioGroup(getString(R.string.je_textView153), RadioBtn1531, RadioBtn1532,
                RadioBtn1533, RadioBtn1534);
        radioGroup1541 = new JeRadioGroup(getString(R.string.je_textView154), RadioBtn1541, RadioBtn1542,
                RadioBtn1543, RadioBtn1544);
        radioGroup2111 = new JeRadioGroup(getString(R.string.je_textView2111), RadioBtn2111, RadioBtn2112,
                RadioBtn2113);
        radioGroup211241 = new JeRadioGroup(getString(R.string.je_textView21124), RadioBtn211241, RadioBtn211242,
                RadioBtn211243, RadioBtn211244, RadioBtn211245, RadioBtn211246, RadioBtn211247,
                RadioBtn211248, RadioBtn211249);
        radioGroup22111 = new JeRadioGroup(getString(R.string.je_textView2211), RadioBtn22111,
                RadioBtn22112, RadioBtn22113);
        radioGroup23111 = new JeRadioGroup(getString(R.string.je_textView2311), RadioBtn23111,
                RadioBtn23112, RadioBtn23113);
        radioGroup23311 = new JeRadioGroup(getString(R.string.je_textView2331), RadioBtn23311,
                RadioBtn23312, RadioBtn23313, RadioBtn23314);
    }
    private void setupCheckBoxGroups() {
        checkBoxGroup1121 = new JeCheckBoxGroup(getString(R.string.je_textView121), checkBox1121,
                checkBox1122, checkBox1123, checkBox1124, checkBox1125, checkBox1126);
        checkBoxGroup1131 = new JeCheckBoxGroup(getString(R.string.je_textView113), checkBox1131,
                checkBox1132, checkBox1133, checkBox1134, checkBox1135, checkBox1136,
                checkBox1137);
        checkBoxGroup1141 = new JeCheckBoxGroup(getString(R.string.je_textView114), checkBox1141,
                checkBox1142);
        checkBoxGroup1171 = new JeCheckBoxGroup(getString(R.string.je_textView117), checkBox1171,
                checkBox1172, checkBox1173, checkBox1174, checkBox1175, checkBox1176,
                checkBox1177, checkBox1178, checkBox1179);
        checkBoxGroup1221 = new JeCheckBoxGroup(getString(R.string.je_textView122), checkBox1221,
                checkBox1222, checkBox1223);
        checkBoxGroup1231 = new JeCheckBoxGroup(getString(R.string.je_textView123), checkBox1231,
                checkBox1232, checkBox1233, checkBox1234);
        checkBoxGroup22211 = new JeCheckBoxGroup(getString(R.string.je_textView2221), checkBox22211,
                checkBox22212, checkBox22213, checkBox22214, checkBox22215, checkBox22216,
                checkBox22217, checkBox22218, checkBox22219, checkBox222110);
        checkBoxGroup23211 = new JeCheckBoxGroup(getString(R.string.je_textView2321), checkBox23211,
                checkBox23212, checkBox23213, checkBox23214, checkBox23215, checkBox23216,
                checkBox23217, checkBox23218, checkBox23219, checkBox232110, checkBox232111,
                checkBox232112);
    }
    // endregion

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
