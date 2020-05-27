package com.sky.clicktoflight.DIY;

import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;

import com.gyf.immersionbar.ImmersionBar;
import com.sky.clicktoflight.R;


public class CustomNPDialog extends Dialog {

    private NumberPicker mNpSeatNum;
    private NumberPicker mNpseatWord;
    private int seatNumMax;
    private int seatNumMin;
    private String[] seatWords;
    private Button mBtConfirm;
    private OnInputFinishedListener mListener;
    private Context context;
    private Vibrator myVibrator;

    public CustomNPDialog(Context context, int seatNumMax, int seatNumMin, String[] seatWords, OnInputFinishedListener mListener) {
        super(context);
        this.seatNumMax = seatNumMax;
        this.seatNumMin = seatNumMin;
        this.seatWords = seatWords;
        this.mListener = mListener;
        this.context = context;
    }


    public interface OnInputFinishedListener{
        void inputeFinished(String seat);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_np);
        initView();
        DialogSetting();
        setPickerValue();
        setButtonListener();
    }

    private void DialogSetting() {
        Window window = this.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        window.setNavigationBarColor(Color.WHITE);
    }

    private void setButtonListener() {
        mBtConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int seatNum = mNpSeatNum.getValue();
                int wordValue = mNpseatWord.getValue();
                String seatWord = seatWords[wordValue];
                mListener.inputeFinished(seatNum + seatWord);
                dismiss();
            }
        });
    }

    private void initView() {
        mNpSeatNum = findViewById(R.id.np_seat_num);
        mNpseatWord = findViewById(R.id.np_seat_word);
        mBtConfirm = findViewById(R.id.bt_dialog_confirm);
        myVibrator = (Vibrator) context.getSystemService(Service.VIBRATOR_SERVICE);
    }

    private void setPickerValue() {
        mNpSeatNum.setFormatter(formatter);
        mNpSeatNum.setOnValueChangedListener(onValueChangeListener);
        mNpSeatNum.setOnScrollListener(onScrollListener);

        mNpSeatNum.setMaxValue(seatNumMax);
        mNpSeatNum.setMinValue(seatNumMin);
        mNpSeatNum.setValue(seatNumMin);
        mNpSeatNum.setDescendantFocusability(DatePicker.FOCUS_BLOCK_DESCENDANTS); // 设置不可编辑
        mNpSeatNum.setWrapSelectorWheel(false); //设置不可滚动


        mNpseatWord.setOnValueChangedListener(onValueChangeListener);
        mNpseatWord.setDisplayedValues(seatWords);
        mNpseatWord.setMinValue(0);
        mNpseatWord.setMaxValue(seatWords.length - 1);
        mNpseatWord.setValue(0);
        mNpseatWord.setDescendantFocusability(DatePicker.FOCUS_BLOCK_DESCENDANTS); // 设置不可编辑
        mNpseatWord.setWrapSelectorWheel(false); //设置不可滚动
    }


    private NumberPicker.Formatter formatter = new NumberPicker.Formatter() {
        @Override
        public String format(int value) {
            String tmpStr = String.valueOf(value);
            if (value < 10) {
                tmpStr = "0" + tmpStr;
            }
            return tmpStr;
        }
    };

    private NumberPicker.OnValueChangeListener onValueChangeListener = new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            Log.i("test", "onValueChange: 原来的值 " + oldVal + "--新值: "
                    + newVal);
            myVibrator.vibrate(new Long(4));
        }
    };

    private NumberPicker.OnScrollListener onScrollListener = new NumberPicker.OnScrollListener() {
        @Override
        public void onScrollStateChange(NumberPicker view, int scrollState) {
            switch (scrollState){
                case NumberPicker.OnScrollListener.SCROLL_STATE_IDLE:
                    //停止滑动 取消震动 好像不需要了
                    myVibrator.cancel();
            }
        }
    };



}
