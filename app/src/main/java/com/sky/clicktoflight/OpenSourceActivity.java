package com.sky.clicktoflight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sky.clicktoflight.utils.ImmersionBarUtils;

public class OpenSourceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_source);
        ImmersionBarUtils immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtilActivity(this,R.id.view_bar);

    }
}
