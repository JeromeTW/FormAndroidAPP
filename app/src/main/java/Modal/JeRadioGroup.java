package Modal;

import android.widget.RadioButton;

import java.util.List;

import static Modal.Section.THRIBLE_BREAK_LINE;

/**
 * Created by JEROME on 2016/12/3.
 */

public class JeRadioGroup extends DataItem {
    public List<RadioButton> btnArray;

    private JeRadioGroup(String key, String value) {
        super(key, value);
    }

    public JeRadioGroup(String key) {
        super(key, "");
    }

    public String print() {
        String radioValue = "";
        String result = key + ":" + BREAK_LINE + BREAK_LINE + getRadioValue() + BREAK_LINE;
        return result;
    }

    private String getRadioValue() {
        String result = "";

        for (RadioButton button : btnArray) {
            if (button.isChecked() == true) {
                result = result + button.getText().toString() + THRIBLE_BREAK_LINE;
                break;
            }
        }
        return result;
    }

    public void didSelectRadio(RadioButton button) {
        for (RadioButton innerButton : btnArray) {
            if (button.getText().toString() == innerButton.getText().toString()) {
                button.setChecked(true);
            } else {
                button.setChecked(false);
            }
        }
    }
}
