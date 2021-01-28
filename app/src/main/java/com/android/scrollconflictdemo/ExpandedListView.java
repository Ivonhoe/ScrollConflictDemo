package com.android.scrollconflictdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * @author : yifan
 * @e-mail : yangfan09359@hellobike.com
 * @date : 1/28/21
 */
public class ExpandedListView extends ListView {
    public ExpandedListView(Context context) {
        super(context);
    }

    public ExpandedListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ExpandedListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ExpandedListView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @SuppressLint("Range")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       int heightSpec = MeasureSpec.makeMeasureSpec(
               (Integer.MAX_VALUE) >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightSpec);
    }
}
