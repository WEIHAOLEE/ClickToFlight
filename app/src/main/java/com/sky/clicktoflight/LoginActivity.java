package com.sky.clicktoflight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sky.clicktoflight.Presenter.PresenterLoginImpl;
import com.sky.clicktoflight.utils.ImmersionBarUtils;
import com.sky.clicktoflight.utils.MyMD5Util;

public class LoginActivity extends AppCompatActivity {

    private Button mBtRegister;
    private Button mBtLogin;
    private EditText mEtUid;
    private EditText mEtUpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        ImmersionBarUtils immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtilActivity(this,R.id.view_bar);
        mEtUid = findViewById(R.id.et_id);
        mEtUpwd = findViewById(R.id.et_pwd);
        mBtLogin = findViewById(R.id.bt_login);
        mBtRegister = findViewById(R.id.bt_register);
        mBtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 需要有个判断
                String uId = mEtUid.getText().toString().trim();
                String pwd = mEtUpwd.getText().toString().trim();

                String uPwd = MyMD5Util.encrypt(pwd);
                PresenterLoginImpl presenterLogin = new PresenterLoginImpl();
                presenterLogin.login(uId,uPwd);
            }
        });
        mBtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
