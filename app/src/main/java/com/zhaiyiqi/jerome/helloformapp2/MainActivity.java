package com.zhaiyiqi.jerome.helloformapp2;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import modal.CanScrollMouthDatePicker;
import modal.DataItem;
import modal.JeCheckBoxGroup;
import modal.JeRadioGroup;
import modal.Section;
import modal.TextPrinter;


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
    @BindView(R.id.textView4)
    TextView textView4;
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
    public final static String EXTRA_TEXT = "com.example.jerome.helloformapp.TEXT";
    public final static String EXTRA_CASE_NAME = "com.example.jerome.helloformapp.CASE_NAME";
    public final static String EXTRA_SHOULD_CLEAN_FORM = "shouldCleanForm";
    private static final int INTENT_TO_DISPLAY_ACTIVITY = 0;

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
    @BindView(R.id.checkBox1_5_2_1)
    CheckBox checkBox1521;
    @BindView(R.id.checkBox1_5_2_2)
    CheckBox checkBox1522;
    @BindView(R.id.checkBox1_5_2_3)
    CheckBox checkBox1523;
    @BindView(R.id.checkBox1_5_2_4)
    CheckBox checkBox1524;
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
    @BindView(R.id.textView2_1_1_2_4)
    TextView textView21124;
    @BindView(R.id.checkBox2_1_1_2_4_1)
    CheckBox checkBox211241;
    @BindView(R.id.checkBox2_1_1_2_4_2)
    CheckBox checkBox211242;
    @BindView(R.id.checkBox2_1_1_2_4_3)
    CheckBox checkBox211243;
    @BindView(R.id.checkBox2_1_1_2_4_4)
    CheckBox checkBox211244;
    @BindView(R.id.checkBox2_1_1_2_4_5)
    CheckBox checkBox211245;
    @BindView(R.id.checkBox2_1_1_2_4_6)
    CheckBox checkBox211246;
    @BindView(R.id.checkBox2_1_1_2_4_7)
    CheckBox checkBox211247;
    @BindView(R.id.checkBox2_1_1_2_4_8)
    CheckBox checkBox211248;
    @BindView(R.id.checkBox2_1_1_2_4_9)
    CheckBox checkBox211249;
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
    @BindView(R.id.subSection1_2)
    LinearLayout subSection12;
    @BindView(R.id.subSection1_4_2)
    LinearLayout subSection142;
    @BindView(R.id.subSection1_5_2_1)
    LinearLayout subSection1521;
    @BindView(R.id.subSection1_5_2)
    LinearLayout subSection152;
    @BindView(R.id.subSection1_5_1_3)
    LinearLayout subSection1513;
    @BindView(R.id.subSection1_5_1_4)
    LinearLayout subSection1514;
    @BindView(R.id.subSection2_1_1_2)
    LinearLayout subSection2112;
    @BindView(R.id.subSection2_2_2_1)
    LinearLayout subSection2221;
    @BindView(R.id.subSection2_3_2_1_1)
    LinearLayout subSection23211;
    @BindView(R.id.subSection2_3_3_1)
    LinearLayout subSection2331;
    @BindView(R.id.birthDatePicker)
    CanScrollMouthDatePicker birthDatePicker;
    @BindView(R.id.startDatePicker)
    CanScrollMouthDatePicker startDatePicker;
    @BindView(R.id.ageTextView)
    TextView ageTextView;

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
    private JeRadioGroup radioGroup1531;
    private JeRadioGroup radioGroup1541;
    private JeRadioGroup radioGroup2111;
    private JeRadioGroup radioGroup22111;
    private JeRadioGroup radioGroup23111;
    private JeRadioGroup radioGroup23311;

    private JeCheckBoxGroup checkBoxGroup1121;
    private JeCheckBoxGroup checkBoxGroup1131;
    private JeCheckBoxGroup checkBoxGroup1141;
    private JeCheckBoxGroup checkBoxGroup1521;
    private JeCheckBoxGroup checkBoxGroup1161;
    private JeCheckBoxGroup checkBoxGroup1171;
    private JeCheckBoxGroup checkBoxGroup1221;
    private JeCheckBoxGroup checkBoxGroup1231;
    private JeCheckBoxGroup checkBoxGroup211241;
    private JeCheckBoxGroup checkBoxGroup22211;
    private JeCheckBoxGroup checkBoxGroup23211;


    //region Events

    /**
     * @param button 多個控件 不同點擊事件
     */
    @OnClick({R.id.goodRadioBtn, R.id.normalRadioBtn, R.id.badRadioBtn})
    public void setDiffEvents1(RadioButton button) {
        performanceGroup.didSelectRadio(button);
    }

    @OnClick({R.id.RadioBtn1_1_5_1, R.id.RadioBtn1_1_5_2, R.id.RadioBtn1_1_5_3})
    public void setDiffEvents2(RadioButton button) {
        radioGroup1151.didSelectRadio(button);
    }

    @OnClick({R.id.RadioBtn1_1_8_1, R.id.RadioBtn1_1_8_2, R.id.RadioBtn1_1_8_3})
    public void setDiffEvents3(RadioButton button) {
        radioGroup1181.didSelectRadio(button);
        switch (button.getId()) {
            case R.id.RadioBtn1_1_8_1:
                subSection12.setVisibility(View.GONE);
                radioGroup1211.setIsGone();
                checkBoxGroup1121.setIsGone();
                checkBoxGroup1221.setIsGone();
                checkBoxGroup1231.setIsGone();
                break;
            default:
                subSection12.setVisibility(View.VISIBLE);
                radioGroup1211.setNotGone();
                checkBoxGroup1121.setNotGone();
                checkBoxGroup1221.setNotGone();
                checkBoxGroup1231.setNotGone();
                break;
        }
    }

    @OnClick({R.id.RadioBtn1_2_1_2, R.id.RadioBtn1_2_1_3})
    public void setDiffEvents4(RadioButton button) {
        radioGroup1211.didSelectRadio(button);
    }

    @OnClick({R.id.RadioBtn1_3_1_1, R.id.RadioBtn1_3_1_2})
    public void setDiffEvents5(RadioButton button) {
        radioGroup1311.didSelectRadio(button);
    }

    @OnClick({R.id.RadioBtn1_4_1_1, R.id.RadioBtn1_4_1_2, R.id.RadioBtn1_4_1_3})
    public void setDiffEvents6(RadioButton button) {
        radioGroup1411.didSelectRadio(button);
        switch (button.getId()) {
            case R.id.RadioBtn1_4_1_1:
                subSection142.setVisibility(View.GONE);
                radioGroup1421.setIsGone();
                break;
            default:
                subSection142.setVisibility(View.VISIBLE);
                radioGroup1421.setNotGone();
                break;
        }
    }

    @OnClick({R.id.RadioBtn1_4_2_1, R.id.RadioBtn1_4_2_2, R.id.RadioBtn1_4_2_3})
    public void setDiffEvents7(RadioButton button) {
        radioGroup1421.didSelectRadio(button);
    }

    @OnClick({R.id.RadioBtn1_5_1_1, R.id.RadioBtn1_5_1_2, R.id.RadioBtn1_5_1_3})
    public void setDiffEvents8(RadioButton button) {
        radioGroup1511.didSelectRadio(button);
        switch (button.getId()) {
            case R.id.RadioBtn1_5_1_1:
                subSection152.setVisibility(View.GONE);
                subSection1513.setVisibility(View.GONE);
                subSection1514.setVisibility(View.GONE);
                checkBoxGroup1521.setIsGone();
                radioGroup1531.setIsGone();
                radioGroup1541.setIsGone();
                break;
            default:
                subSection152.setVisibility(View.VISIBLE);
                subSection1513.setVisibility(View.VISIBLE);
                subSection1514.setVisibility(View.VISIBLE);
                checkBoxGroup1521.setNotGone();
                radioGroup1531.setNotGone();
                radioGroup1541.setNotGone();
                break;
        }
    }
    @OnClick({R.id.checkBox1_5_2_3})
    public void setDiffEvents9(CheckBox button) {
        if (button.isChecked() == true) {
            subSection1513.setVisibility(View.VISIBLE);
            radioGroup1531.setNotGone();
        } else {
            subSection1513.setVisibility(View.GONE);
            radioGroup1531.setIsGone();
        }
    }
    @OnClick({R.id.checkBox1_5_2_4})
    public void setDiffEvents91(CheckBox button) {
        if (button.isChecked() == true) {
            subSection1514.setVisibility(View.VISIBLE);
            radioGroup1541.setNotGone();
        } else {
            subSection1514.setVisibility(View.GONE);
            radioGroup1541.setIsGone();
        }
    }

    @OnClick({R.id.RadioBtn1_5_3_1, R.id.RadioBtn1_5_3_2, R.id.RadioBtn1_5_3_3, R.id
            .RadioBtn1_5_3_4})
    public void setDiffEvents10(RadioButton button) {
        radioGroup1531.didSelectRadio(button);
    }

    @OnClick({R.id.RadioBtn1_5_4_1, R.id.RadioBtn1_5_4_2, R.id.RadioBtn1_5_4_3, R.id
            .RadioBtn1_5_4_4})
    public void setDiffEvents11(RadioButton button) {
        radioGroup1541.didSelectRadio(button);
    }

    @OnClick({R.id.RadioBtn2_1_1_1, R.id.RadioBtn2_1_1_2, R.id.RadioBtn2_1_1_3})
    public void setDiffEvents12(RadioButton button) {
        radioGroup2111.didSelectRadio(button);
        switch (button.getId()) {
            case R.id.RadioBtn2_1_1_1:
                subSection2112.setVisibility(View.GONE);
                radioGroup2111.setIsGone();
                break;
            default:
                subSection2112.setVisibility(View.VISIBLE);
                radioGroup2111.setNotGone();
                break;
        }
    }

    @OnClick({R.id.RadioBtn2_2_1_1_1, R.id.RadioBtn2_2_1_1_2, R.id.RadioBtn2_2_1_1_3})
    public void setDiffEvents14(RadioButton button) {
        radioGroup22111.didSelectRadio(button);
        switch (button.getId()) {
            case R.id.RadioBtn2_2_1_1_1:
                subSection2221.setVisibility(View.GONE);
                checkBoxGroup22211.setIsGone();
                break;
            default:
                subSection2221.setVisibility(View.VISIBLE);
                checkBoxGroup22211.setNotGone();
                break;
        }
    }

    @OnClick({R.id.RadioBtn2_3_1_1_1, R.id.RadioBtn2_3_1_1_2, R.id.RadioBtn2_3_1_1_3})
    public void setDiffEvents15(RadioButton button) {
        radioGroup23111.didSelectRadio(button);
        switch (button.getId()) {
            case R.id.RadioBtn2_3_1_1_1:
                subSection23211.setVisibility(View.GONE);
                subSection2331.setVisibility(View.GONE);
                checkBoxGroup23211.setIsGone();
                radioGroup23311.setIsGone();
                break;
            default:
                subSection23211.setVisibility(View.VISIBLE);
                subSection2331.setVisibility(View.VISIBLE);
                checkBoxGroup23211.setNotGone();
                radioGroup23311.setNotGone();
                break;
        }
    }

    @OnClick({R.id.RadioBtn2_3_3_1_1, R.id.RadioBtn2_3_3_1_2, R.id.RadioBtn2_3_3_1_3,
            R.id.RadioBtn2_3_3_1_4})
    public void setDiffEvents16(RadioButton button) {
        radioGroup23311.didSelectRadio(button);
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
        // 清空
        textPrinter.cleanUp();

        // 個人基本資料 section
        String nameString = nameEditText.getText().toString();
        // 月份從0開始算，所以要加一
        String birthdayString = getDateString(birthDatePicker);
        String genderString = maleRadioBtn.isChecked() ? "male" : "female";
        String acceptString = getDateString(startDatePicker);
        String description1thString = descriptionEditText.getText().toString();

        List<DataItem> itemArray = new ArrayList<DataItem>();
        itemArray.add(new DataItem(getString(R.string.je_xingming), nameString));
        itemArray.add(new DataItem(getString(R.string.je_xingbie), genderString));
        itemArray.add(new DataItem(getString(R.string.je_chushengriqi), birthdayString));
        itemArray.add(new DataItem(getString(R.string.je_shouanriqi), acceptString));
        itemArray.add(new DataItem(getString(R.string.je_zhuji), description1thString));


        Section nameSection = new Section(itemArray, getString(R.string.je_geanjibenziliao));
        textPrinter.sectionArray.add(nameSection);

        // 1 section
        List<DataItem> itemArray2 = new ArrayList<DataItem>();
        itemArray2.add(new DataItem(getString(R.string.je_kouqianggouzaoyuwendingdu), editText.getText()
                .toString()));
        itemArray2.add(checkBoxGroup1121);
        itemArray2.add(checkBoxGroup1131);
        itemArray2.add(checkBoxGroup1141);
        itemArray2.add(radioGroup1151);
        itemArray2.add(checkBoxGroup1161);
        itemArray2.add(checkBoxGroup1171);
        itemArray2.add(radioGroup1181);
        itemArray2.add(radioGroup1211);
        itemArray2.add(checkBoxGroup1221);
        itemArray2.add(checkBoxGroup1231);
        itemArray2.add(radioGroup1311);
        itemArray2.add(radioGroup1411);
        itemArray2.add(radioGroup1421);
        itemArray2.add(radioGroup1511);
        itemArray2.add(checkBoxGroup1521);
        itemArray2.add(radioGroup1531);
        itemArray2.add(radioGroup1541);

        Section kouqiangdongzuoSection = new Section(itemArray2, getString(R.string
                .je_1_1koukangdongzuo));
        textPrinter.sectionArray.add(kouqiangdongzuoSection);

        // 2 section
        List<DataItem> itemArray3 = new ArrayList<DataItem>();
        itemArray3.add(radioGroup2111);
        itemArray3.add(checkBoxGroup211241);
        itemArray3.add(radioGroup22111);
        itemArray3.add(checkBoxGroup22211);
        itemArray3.add(radioGroup23111);
        itemArray3.add(checkBoxGroup23211);
        itemArray3.add(radioGroup23311);

        Section kouyulijieSection = new Section(itemArray3, getString(R.string
                .je_textView211));
        textPrinter.sectionArray.add(kouyulijieSection);

        String result = textPrinter.print();
        // Log.v(TAG, result);

        Intent intent = new Intent(this, DisplayTextActivity.class);
        intent.putExtra(EXTRA_TEXT, result);
        intent.putExtra(EXTRA_CASE_NAME, nameString);
        startActivityForResult(intent, INTENT_TO_DISPLAY_ACTIVITY);
    }

    // endregion
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
        birthDatePicker.getCalendarView().setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // Log.d("tag", "finally found the listener, the date is: year " + year + ", month " + month + ", dayOfMonth " + dayOfMonth);
                int birthMonths = year * 12 + month;    // 從西元年開始到出生月，計算總共月數
                Time now = new Time();
                now.setToNow();
                int nowMonths = now.year * 12 + now.month;  // 從西元年開始到今日月，計算總共月數
                int ageMonths = nowMonths - birthMonths;    // 個案年齡月數
                if (ageMonths >= 0) {
                    ageTextView.setText("年齡： " + ageMonths / 12 + "歲" + ageMonths % 12 + "個月" );
                } else {
                    ageTextView.setText("還未出生吧^-^");
                }
            }
        });
//        Log.v(TAG, getCertificateSHA1Fingerprint());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.submitMenuBtn:
                submit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case INTENT_TO_DISPLAY_ACTIVITY:
                if (data != null) { // 如果不是從重新填寫資料按鈕回來的話，data為null
                    if (data.getExtras().getBoolean(EXTRA_SHOULD_CLEAN_FORM) == true) {
                        cleanForm();
                    }
                }
        }
    }

    // region Create String
    private String getDateString(DatePicker datePicker) {
        return datePicker.getYear() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker
                .getDayOfMonth();
    }

    private void setupRadioGroups() {
        performanceGroup = new JeRadioGroup(getString(R.string.je_peihedu), goodRadioBtn, normalRadioBtn,
                badRadioBtn);
        radioGroup1151 = new JeRadioGroup(getString(R.string.je_textView115), RadioBtn1151, RadioBtn1152,
                RadioBtn1153);
        radioGroup1181 = new JeRadioGroup(getString(R.string.je_textView118), RadioBtn1181, RadioBtn1182,
                RadioBtn1183);
        radioGroup1211 = new JeRadioGroup(getString(R.string.je_textView121), RadioBtn1212,
                RadioBtn1213);
        radioGroup1311 = new JeRadioGroup(getString(R.string.je_textView1311), RadioBtn1311,
                RadioBtn1312);
        radioGroup1411 = new JeRadioGroup(getString(R.string.je_textView141), RadioBtn1411, RadioBtn1412,
                RadioBtn1413);
        radioGroup1421 = new JeRadioGroup(getString(R.string.je_textView1421), RadioBtn1421, RadioBtn1422,
                RadioBtn1423);
        radioGroup1511 = new JeRadioGroup(getString(R.string.je_textView151), RadioBtn1511, RadioBtn1512,
                RadioBtn1513);
        radioGroup1531 = new JeRadioGroup(getString(R.string.je_textView153), RadioBtn1531, RadioBtn1532,
                RadioBtn1533, RadioBtn1534);
        radioGroup1541 = new JeRadioGroup(getString(R.string.je_textView154), RadioBtn1541, RadioBtn1542,
                RadioBtn1543, RadioBtn1544);
        radioGroup2111 = new JeRadioGroup(getString(R.string.je_textView2111), RadioBtn2111, RadioBtn2112,
                RadioBtn2113);
        radioGroup22111 = new JeRadioGroup(getString(R.string.je_textView2211), RadioBtn22111,
                RadioBtn22112, RadioBtn22113);
        radioGroup23111 = new JeRadioGroup(getString(R.string.je_textView2311), RadioBtn23111,
                RadioBtn23112, RadioBtn23113);
        radioGroup23311 = new JeRadioGroup(getString(R.string.je_textView2331), RadioBtn23311,
                RadioBtn23312, RadioBtn23313, RadioBtn23314);

        // 已啟動後1-5-1-3 、 1-5-1-4是看不見的
        subSection1513.setVisibility(View.GONE);
        subSection1514.setVisibility(View.GONE);
        radioGroup1531.setIsGone();
        radioGroup1541.setIsGone();
    }

    private void setupCheckBoxGroups() {
        checkBoxGroup1121 = new JeCheckBoxGroup(getString(R.string.je_textView121), checkBox1121,
                checkBox1122, checkBox1123, checkBox1124, checkBox1125, checkBox1126);
        checkBoxGroup1131 = new JeCheckBoxGroup(getString(R.string.je_textView113), checkBox1131,
                checkBox1132, checkBox1133, checkBox1134, checkBox1135, checkBox1136,
                checkBox1137);
        checkBoxGroup1141 = new JeCheckBoxGroup(getString(R.string.je_textView114), checkBox1141,
                checkBox1142);
        checkBoxGroup1521 = new JeCheckBoxGroup(getString(R.string.je_textView152), checkBox1521,
                checkBox1522, checkBox1523, checkBox1524);
        checkBoxGroup1161 = new JeCheckBoxGroup(getString(R.string.je_textView116), checkBox1161,
                checkBox1162, checkBox1163, checkBox1164, checkBox1165, checkBox1166);
        checkBoxGroup1171 = new JeCheckBoxGroup(getString(R.string.je_textView117), checkBox1171,
                checkBox1172, checkBox1173, checkBox1174, checkBox1175, checkBox1176,
                checkBox1177, checkBox1178, checkBox1179);
        checkBoxGroup1221 = new JeCheckBoxGroup(getString(R.string.je_textView122), checkBox1221,
                checkBox1222, checkBox1223);
        checkBoxGroup1231 = new JeCheckBoxGroup(getString(R.string.je_textView123), checkBox1231,
                checkBox1232, checkBox1233, checkBox1234);
        checkBoxGroup211241 = new JeCheckBoxGroup(getString(R.string.je_textView21124), checkBox211241, checkBox211242,
                checkBox211243, checkBox211244, checkBox211245, checkBox211246, checkBox211247,
                checkBox211248, checkBox211249);
        checkBoxGroup22211 = new JeCheckBoxGroup(getString(R.string.je_textView2221), checkBox22211,
                checkBox22212, checkBox22213, checkBox22214, checkBox22215, checkBox22216,
                checkBox22217, checkBox22218, checkBox22219, checkBox222110);
        checkBoxGroup23211 = new JeCheckBoxGroup(getString(R.string.je_textView2321), checkBox23211,
                checkBox23212, checkBox23213, checkBox23214, checkBox23215, checkBox23216,
                checkBox23217, checkBox23218, checkBox23219, checkBox232110, checkBox232111,
                checkBox232112);
    }

    // endregion
    private void cleanForm() {  // 用sublime的正則表達式完成的
        nameEditText.getText().clear();
        maleRadioBtn.setChecked(true);
        femaleRadioBtn.setChecked(false);
        goodRadioBtn.setChecked(false);
        normalRadioBtn.setChecked(false);
        badRadioBtn.setChecked(false);
        descriptionEditText.getText().clear();
        editText.getText().clear();
        checkBox1121.setChecked(false);
        checkBox1122.setChecked(false);
        checkBox1123.setChecked(false);
        checkBox1124.setChecked(false);
        checkBox1125.setChecked(false);
        checkBox1126.setChecked(false);
        checkBox1131.setChecked(false);
        checkBox1132.setChecked(false);
        checkBox1133.setChecked(false);
        checkBox1134.setChecked(false);
        checkBox1135.setChecked(false);
        checkBox1136.setChecked(false);
        checkBox1137.setChecked(false);
        checkBox1141.setChecked(false);
        checkBox1142.setChecked(false);
        RadioBtn1151.setChecked(false);
        RadioBtn1152.setChecked(false);
        RadioBtn1153.setChecked(false);
        checkBox1161.setChecked(false);
        checkBox1162.setChecked(false);
        checkBox1163.setChecked(false);
        checkBox1164.setChecked(false);
        checkBox1165.setChecked(false);
        checkBox1166.setChecked(false);
        checkBox1171.setChecked(false);
        checkBox1172.setChecked(false);
        checkBox1173.setChecked(false);
        checkBox1174.setChecked(false);
        checkBox1175.setChecked(false);
        checkBox1176.setChecked(false);
        checkBox1177.setChecked(false);
        checkBox1178.setChecked(false);
        checkBox1179.setChecked(false);
        RadioBtn1181.setChecked(false);
        RadioBtn1182.setChecked(false);
        RadioBtn1183.setChecked(false);
        RadioBtn1212.setChecked(false);
        RadioBtn1213.setChecked(false);
        checkBox1221.setChecked(false);
        checkBox1222.setChecked(false);
        checkBox1223.setChecked(false);
        checkBox1231.setChecked(false);
        checkBox1232.setChecked(false);
        checkBox1233.setChecked(false);
        checkBox1234.setChecked(false);
        RadioBtn1311.setChecked(false);
        RadioBtn1312.setChecked(false);
        RadioBtn1411.setChecked(false);
        RadioBtn1412.setChecked(false);
        RadioBtn1413.setChecked(false);
        RadioBtn1421.setChecked(false);
        RadioBtn1422.setChecked(false);
        RadioBtn1423.setChecked(false);
        RadioBtn1511.setChecked(false);
        RadioBtn1512.setChecked(false);
        RadioBtn1513.setChecked(false);
        checkBox1521.setChecked(false);
        checkBox1522.setChecked(false);
        checkBox1523.setChecked(false);
        checkBox1524.setChecked(false);
        RadioBtn1531.setChecked(false);
        RadioBtn1532.setChecked(false);
        RadioBtn1533.setChecked(false);
        RadioBtn1534.setChecked(false);
        RadioBtn1541.setChecked(false);
        RadioBtn1542.setChecked(false);
        RadioBtn1543.setChecked(false);
        RadioBtn1544.setChecked(false);
        RadioBtn2111.setChecked(false);
        RadioBtn2112.setChecked(false);
        RadioBtn2113.setChecked(false);
        checkBox211241.setChecked(false);
        checkBox211242.setChecked(false);
        checkBox211243.setChecked(false);
        checkBox211244.setChecked(false);
        checkBox211245.setChecked(false);
        checkBox211246.setChecked(false);
        checkBox211247.setChecked(false);
        checkBox211248.setChecked(false);
        checkBox211249.setChecked(false);
        RadioBtn22111.setChecked(false);
        RadioBtn22112.setChecked(false);
        RadioBtn22113.setChecked(false);
        checkBox22211.setChecked(false);
        checkBox22212.setChecked(false);
        checkBox22213.setChecked(false);
        checkBox22214.setChecked(false);
        checkBox22215.setChecked(false);
        checkBox22216.setChecked(false);
        checkBox22217.setChecked(false);
        checkBox22218.setChecked(false);
        checkBox22219.setChecked(false);
        checkBox222110.setChecked(false);
        RadioBtn23111.setChecked(false);
        RadioBtn23112.setChecked(false);
        RadioBtn23113.setChecked(false);
        checkBox23211.setChecked(false);
        checkBox23212.setChecked(false);
        checkBox23213.setChecked(false);
        checkBox23214.setChecked(false);
        checkBox23215.setChecked(false);
        checkBox23216.setChecked(false);
        checkBox23217.setChecked(false);
        checkBox23218.setChecked(false);
        checkBox23219.setChecked(false);
        checkBox232110.setChecked(false);
        checkBox232111.setChecked(false);
        checkBox232112.setChecked(false);
        RadioBtn23311.setChecked(false);
        RadioBtn23312.setChecked(false);
        RadioBtn23313.setChecked(false);
        RadioBtn23314.setChecked(false);
        ageTextView.setText(R.string.ageTitle);
    }

    private String getCertificateSHA1Fingerprint() {
        PackageManager pm = this.getPackageManager();
        String packageName = this.getPackageName();
        int flags = PackageManager.GET_SIGNATURES;
        PackageInfo packageInfo = null;
        try {
            packageInfo = pm.getPackageInfo(packageName, flags);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Signature[] signatures = packageInfo.signatures;
        byte[] cert = signatures[0].toByteArray();
        InputStream input = new ByteArrayInputStream(cert);
        CertificateFactory cf = null;
        try {
            cf = CertificateFactory.getInstance("X509");
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        X509Certificate c = null;
        try {
            c = (X509Certificate) cf.generateCertificate(input);
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        String hexString = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] publicKey = md.digest(c.getEncoded());
            hexString = byte2HexFormatted(publicKey);
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (CertificateEncodingException e) {
            e.printStackTrace();
        }
        return hexString;
    }

    public static String byte2HexFormatted(byte[] arr) {
        StringBuilder str = new StringBuilder(arr.length * 2);
        for (int i = 0; i < arr.length; i++) {
            String h = Integer.toHexString(arr[i]);
            int l = h.length();
            if (l == 1) h = "0" + h;
            if (l > 2) h = h.substring(l - 2, l);
            str.append(h.toUpperCase());
            if (i < (arr.length - 1)) str.append(':');
        }
        return str.toString();
    }
}
