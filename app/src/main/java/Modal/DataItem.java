package Modal;

/**
 * Created by JEROME on 2016/12/2.
 */

public class DataItem {
    String key;
    String value;
    public static final String BREAK_LINE = "\n";

    public DataItem(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public String print() {
        String result = key + ":" + BREAK_LINE + BREAK_LINE + value + BREAK_LINE;
        return result;
    }
}
