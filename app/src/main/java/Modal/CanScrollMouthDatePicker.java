package modal;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.DatePicker;

/**
 * Created by JEROME on 2016/12/19.
 */

public class CanScrollMouthDatePicker extends DatePicker {
    public CanScrollMouthDatePicker(Context context) {
        super(context);
    }

    public CanScrollMouthDatePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CanScrollMouthDatePicker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CanScrollMouthDatePicker(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (ev.getActionMasked() == MotionEvent.ACTION_DOWN) {
            ViewParent p = getParent();
            if (p != null) {
                p.requestDisallowInterceptTouchEvent(true);
            }
        }
        return false;
    }
}
