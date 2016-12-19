package modal;

import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

import static modal.Section.DOUBLE_BREAK_LINE;

/**
 * Created by JEROME on 2016/12/3.
 */

public class JeRadioGroup extends DataItem {
    public List<RadioButton> btnArray;

    public JeRadioGroup(String key, RadioButton... buttons) {
        super(key, "");
        List<RadioButton> buttonArray = new ArrayList<RadioButton>();
        for (RadioButton button : buttons) {
            buttonArray.add(button);
        }
        btnArray = buttonArray;
    }

    public String print() {
        String result = "";
        if (this.isGone == false) {
            result = key + ":" + BREAK_LINE + JETAB + getRadioValue() + BREAK_LINE;
        }
        return result;
    }

    private String getRadioValue() {
        String result = "";

        for (RadioButton button : btnArray) {
            if (button.isChecked() == true) {
                result = result + button.getText().toString() + DOUBLE_BREAK_LINE;
                break;
            }
        }
        return result;
    }

    public void didSelectRadio(RadioButton button) {
        for (RadioButton innerButton : btnArray) {
            if (button.getText().toString() == innerButton.getText().toString()) {
                innerButton.setChecked(true);
            } else {
                innerButton.setChecked(false);
            }
        }
    }
}
