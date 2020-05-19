package com.sky.clicktoflight.DIY;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

public class AwesomeTextView extends AppCompatTextView {

    public AwesomeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AwesomeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AwesomeTextView(Context context) {
        super(context);
    }

    @Override
    public boolean isSelected() {
        return true;
    }

    @Override
    public boolean isFocused() {
        return true;
    }

}
