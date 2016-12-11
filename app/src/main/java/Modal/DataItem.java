package Modal;

/**
 * Created by JEROME on 2016/12/2.
 */

public class DataItem {
    String key;
    String value;
    Boolean isGone; // 若為真的話就不輸出
    public static final String BREAK_LINE = "\n";
    public static final String JETAB = "\t";

    public DataItem(String key, String value) {
        this.key = key;
        this.value = value;
        this.isGone = false;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public void setIsGone() {
        this.isGone = true;
    }
    public void setNotGone() {
        this.isGone = false;
    }
    public String print() {
        String result = "";
        if (this.isGone == false) {
            result = key + ":" + BREAK_LINE + JETAB + value + BREAK_LINE;
        }
        return result;
    }
}
