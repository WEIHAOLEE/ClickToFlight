package com.sky.clicktoflight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sky.clicktoflight.utils.ImmersionBarUtils;

public class PayOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_order);
        initView();
    }

    private void initView() {
        ImmersionBarUtils immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtilActivity(this,R.id.view_bar);
    }
}
