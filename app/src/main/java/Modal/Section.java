package Modal;

import android.util.Log;

import java.util.List;
import java.util.ListIterator;

import static Modal.DataItem.BREAK_LINE;

/**
 * Created by JEROME on 2016/12/2.
 */

public class Section {
    public String name = "";
    public List<DataItem> itemArray;
    public static final String DOUBLE_BREAK_LINE = "\n\n";
    public static final String TAG = "Section";

    public Section(List<DataItem> itemArray, String name) {
        this.itemArray = itemArray;
        this.name = name;
    }

    public String print() {
        String result = name + "\n~~~~~~~~~~~~~~~\n";
        ListIterator iter = itemArray.listIterator();

        for (DataItem item : itemArray) {
            result = result + item.print() + DOUBLE_BREAK_LINE;
        }
        // 最後再remove掉三個換行即可
        int length = DOUBLE_BREAK_LINE.length();
        result = result.substring(0, result.length() - length);
        Log.v(TAG, "section result:" + result);
        return result;
    }
}
