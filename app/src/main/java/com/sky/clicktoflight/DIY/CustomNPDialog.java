package com.sky.clicktoflight.DIY;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;

import com.sky.clicktoflight.R;


public class CustomNPDialog extends Dialog {

    private NumberPicker mNpSeatNum;
    private NumberPicker mNpseatWord;
    private int seatNumMax;
    private int seatNumMin;
    private String[] seatWords;
    private Button mBtConfirm;
    private OnInputFinishedListener mListener;

    public CustomNPDialog(Context context, int seatNumMax, int seatNumMin, String[] seatWords, OnInputFinishedListener mListener) {
        super(context);
        this.seatNumMax = seatNumMax;
        this.seatNumMin = seatNumMin;
        this.seatWords = seatWords;
        this.mListener = mListener;
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

        }
    };

    private NumberPicker.OnScrollListener onScrollListener = new NumberPicker.OnScrollListener() {
        @Override
        public void onScrollStateChange(NumberPicker view, int scrollState) {

        }
    };


}
