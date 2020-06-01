package com.sky.clicktoflight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sky.clicktoflight.View.HomeFragment;
import com.sky.clicktoflight.View.MeFragment;
import com.sky.clicktoflight.View.NotificationsFragment;
import com.sky.clicktoflight.utils.CheckLoginStatus;
import com.sky.clicktoflight.utils.ImmersionBarUtils;

public class MainActivity extends AppCompatActivity {




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
//                    homeFragment = new HomeFragment();
//                    transaction.add(R.id.fragment_content,homeFragment);
                    transaction.show(homeFragment);
                    transaction.commit();
                    return true;
                case R.id.navigation_notifications:
                    if (notificationsFragment == null){
                        notificationsFragment = new NotificationsFragment();
                        transaction.add(R.id.fragment_content,notificationsFragment);
                    }
                    transaction.show(notificationsFragment);
                    transaction.commit();
                    return true;
                case R.id.navigation_me:
                    if (meFragment == null){
                        meFragment = new MeFragment();
                        transaction.add(R.id.fragment_content,meFragment);
                    }
                    transaction.show(meFragment);
                    transaction.commit();
//                    fManager.beginTransaction().add(R.id.fragment_content,meFragment);
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content,meFragment).show(meFragment).commit();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.mainview,fragment1).show(fragment1).commit();
                    return true;
            }
            return false;
        }
    };

    private HomeFragment homeFragment;
    private NotificationsFragment notificationsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        tb_1 = findViewById(R.id.tb_1);
//        setSupportActionBar(tb_1);
//

        ImmersionBarUtils immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtilActivity(this,R.id.view_bar);

//        getWindow().setNavigationBarColor(Color.TRANSPARENT);
        BottomNavigationView navView = findViewById(R.id.bottomNavigationView);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setDefaultFragment();

        CheckLoginStatus checkLoginStatus = new CheckLoginStatus(this);
        // 检查是否登录 并设置常量
        checkLoginStatus.getSharedPreferences();

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
        if (notificationsFragment != null) {
            transaction.hide(notificationsFragment);
        }
//        if (mUserPageFragment != null){
//            transaction.hide(mUserPageFragment);
//        }
    }
}
