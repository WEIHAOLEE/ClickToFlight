package com.sky.clicktoflight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.gyf.immersionbar.ImmersionBar;
import com.sky.clicktoflight.utils.ImmersionBarUtils;

public class MainActivity extends AppCompatActivity {


    private Toolbar tb_1;
    private TextView mTextMessage;
    private TextView tv_search;
    private Drawable drawable_search;
    private ImmersionBarUtils immersionBarUtils;


    // fragement
    private MeFragment meFragment;
    private FragmentManager fManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
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
//                    fManager.beginTransaction().add(R.id.fragment_content,meFragment);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content,meFragment).show(meFragment).commit();
//                    getSupportFragmentManager().beginTransaction().replace(R.id.mainview,fragment1).show(fragment1).commit();
                    return true;
                case R.id.navigation_shopping_cart:
                    mTextMessage.setText(R.string.title_shopping_cart);
                    return true;
            }
            return false;
        }
    };

    private View.OnClickListener searchListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent search_intent = new Intent(getApplicationContext(),SearchActivity.class);
            startActivity(search_intent);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        tb_1 = findViewById(R.id.tb_1);
//        setSupportActionBar(tb_1);
//


        immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtil(this,R.id.view_bar);

        BottomNavigationView navView = findViewById(R.id.bottomNavigationView);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        tv_search = findViewById(R.id.tv_search);
        drawable_search = getResources().getDrawable(R.drawable.ic_search_dark_gray_24dp);


        drawable_search.setBounds(17, 3, 67, 55);
        tv_search.setCompoundDrawables(drawable_search, null, null ,null);

        tv_search.setOnClickListener(searchListener);


    }

}
