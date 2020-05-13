package com.sky.clicktoflight;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sky.clicktoflight.View.HomeFragment;
import com.sky.clicktoflight.View.MeFragment;
import com.sky.clicktoflight.utils.ImmersionBarUtils;

public class MainActivity extends AppCompatActivity {


    private TextView mTextMessage;


    // fragement
    private MeFragment meFragment;
    private FragmentManager fManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            hideFragment(transaction);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
//                    homeFragment = new HomeFragment();
//                    transaction.add(R.id.fragment_content,homeFragment);
                    transaction.show(homeFragment);
                    transaction.commit();
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    getSupportFragmentManager().beginTransaction().hide(meFragment).commit();
                    return true;
                case R.id.navigation_me:
                    mTextMessage.setText(R.string.title_me);
                    meFragment = new MeFragment("👴成功了");
                    transaction.add(R.id.fragment_content,meFragment);
                    transaction.show(meFragment);
                    transaction.commit();
//                    fManager.beginTransaction().add(R.id.fragment_content,meFragment);
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content,meFragment).show(meFragment).commit();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.mainview,fragment1).show(fragment1).commit();
                    return true;
                case R.id.navigation_shopping_cart:
                    mTextMessage.setText(R.string.title_shopping_cart);
                    return true;
            }
            return false;
        }
    };

    private HomeFragment homeFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        tb_1 = findViewById(R.id.tb_1);
//        setSupportActionBar(tb_1);
//


//        getWindow().setNavigationBarColor(Color.TRANSPARENT);
        BottomNavigationView navView = findViewById(R.id.bottomNavigationView);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setDefaultFragment();

    }


    // 设置默认Fragment
    private void setDefaultFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        homeFragment = new HomeFragment();
        transaction.add(R.id.fragment_content,homeFragment);
        transaction.show(homeFragment);
        transaction.commit();
    }
    // 隐藏Fragment方法
    private void hideFragment(FragmentTransaction transaction) {
        if (meFragment != null) {
            transaction.hide(meFragment);
        }
        if (homeFragment != null){
            transaction.hide(homeFragment);
        }
//        if (mUserPageFragment != null){
//            transaction.hide(mUserPageFragment);
//        }
    }
}
