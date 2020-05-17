package com.sky.clicktoflight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.sky.clicktoflight.utils.ImmersionBarUtils;

public class Testa extends AppCompatActivity {

    private RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_boading_pass);
        ImmersionBarUtils immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtilActivity(this,R.id.view_bar);
    }


}
