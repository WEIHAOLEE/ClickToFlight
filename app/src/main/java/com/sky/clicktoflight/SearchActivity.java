package com.sky.clicktoflight;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;
import com.sky.clicktoflight.utils.ImmersionBarUtils;

public class SearchActivity extends AppCompatActivity {


    private Drawable drawable_search;
    private EditText et_search;
    private ImmersionBarUtils immersionBarUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtil(this,R.id.view_bar);

        et_search = findViewById(R.id.et_search);
        drawable_search = getResources().getDrawable(R.drawable.ic_search_dark_gray_24dp);


        drawable_search.setBounds(17, 3, 67, 55);
        et_search.setCompoundDrawables(drawable_search, null, null ,null);



        // editText get focus and open the keyboard  获取焦点并调出键盘 c
        et_search.setFocusable(true);
        et_search.setFocusableInTouchMode(true);
        et_search.requestFocus();

    }
}
