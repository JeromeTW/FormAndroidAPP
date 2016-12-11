package Modal;

import android.widget.CheckBox;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

import static Modal.Section.THRIBLE_BREAK_LINE;

/**
 * Created by JEROME on 2016/12/11.
 */

public class JeCheckBoxGroup extends DataItem {
    public List<CheckBox> btnArray;

    public JeCheckBoxGroup(String key, CheckBox... buttons) {
        super(key, "");
        List<CheckBox> buttonArray = new ArrayList<CheckBox>();
        for (CheckBox button : buttons) {
            buttonArray.add(button);
        }
        btnArray = buttonArray;
    }

    public String print() {
        String result = key + ":" + BREAK_LINE + BREAK_LINE + getGroupValue() + BREAK_LINE;
        return result;
    }

    private String getGroupValue() {
        String result = "";
        for (CheckBox button : btnArray) {
            if (button.isChecked() == true) {
                result = result + button.getText().toString() + THRIBLE_BREAK_LINE;
            }
        }
        return result;
    }
}
