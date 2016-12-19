package modal;

import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;


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
        String result = "";
        if (this.isGone == false) {
            result = key + ":" + BREAK_LINE + getGroupValue() + BREAK_LINE;
        }
        return result;
    }

    private String getGroupValue() {
        String result = "";
        for (CheckBox button : btnArray) {
            if (button.isChecked() == true) {
                result = result + JETAB + button.getText().toString() + BREAK_LINE;
            }
        }
        return result;
    }
}
