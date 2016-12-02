package Modal;

import android.util.Log;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by JEROME on 2016/12/2.
 */

public class TextPrinter {
    public List<Section> sectionArray;
    public static final String SECTION_BREAK_LINE = "----------------------------------------\n";
    public static final String TAG = "TextPrinter";

    public TextPrinter(List<Section> sectionArray) {
        this.sectionArray = sectionArray;
    }

    public String print() {
        String result = "";
        ListIterator iter = sectionArray.listIterator();

        for (Section item : sectionArray) {
            result = result + item.print() + SECTION_BREAK_LINE;
        }
        // 最後再remove掉三個換行即可
        int length = SECTION_BREAK_LINE.length();
        result.substring(0, result.length() - length);
        Log.v(TAG, "section result:" + result);
        return result;
    }
}
