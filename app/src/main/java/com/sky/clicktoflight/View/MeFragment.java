package com.sky.clicktoflight.View;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.sky.clicktoflight.AboutActivity;
import com.sky.clicktoflight.Constants;
import com.sky.clicktoflight.LoginActivity;
import com.sky.clicktoflight.PaidOrderActivity;
import com.sky.clicktoflight.PayOrderActivity;
import com.sky.clicktoflight.ProfileActivity;
import com.sky.clicktoflight.R;
import com.sky.clicktoflight.utils.CheckLoginStatus;
import com.sky.clicktoflight.utils.ImmersionBarUtils;

import de.hdodenhof.circleimageview.CircleImageView;

public class MeFragment extends Fragment {
    private String content;
    private View view;
    private CircleImageView mIvPhoto;
    private TextView mTvUsername;
    private TextView mTvUserId;
    private TextView mTvPayOrder;
    private TextView mTvPaidOrder;
    private TextView mTvAbout;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_me, container, false);

        initView();

//        return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    private void initView() {
        ImmersionBarUtils immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtilFragment(this,R.id.view_bar);
        mIvPhoto = view.findViewById(R.id.iv_pf_photo);
        mIvPhoto.setOnClickListener(profileOnClickListener);
        mTvUsername = view.findViewById(R.id.tv_username);
        mTvUsername.setOnClickListener(profileOnClickListener);
        mTvUserId = view.findViewById(R.id.tv_userid);
        mTvUserId.setOnClickListener(profileOnClickListener);
        mTvPayOrder = view.findViewById(R.id.tv_pay_order);
        mTvPaidOrder = view.findViewById(R.id.tv_paid_order);
        mTvPayOrder.setOnClickListener(orderOnclickListener);
        mTvPaidOrder.setOnClickListener(orderOnclickListener);
        mTvAbout = view.findViewById(R.id.tv_about);
        mTvAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), AboutActivity.class);
                startActivity(intent);
            }
        });


    }
    private View.OnClickListener orderOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_pay_order:
                    if (Constants.LOGIN_STATUS){
                        Intent intent = new Intent(view.getContext(), PayOrderActivity.class);
                        startActivity(intent);
                    }else {
                        Intent intent = new Intent(view.getContext(), LoginActivity.class);
                        startActivity(intent);
                    }
                    break;
                case R.id.tv_paid_order:
                    if (Constants.LOGIN_STATUS){
                        Intent intent = new Intent(view.getContext(), PaidOrderActivity.class);
                        startActivity(intent);
                    }else {
                        Intent intent = new Intent(view.getContext(), LoginActivity.class);
                        startActivity(intent);
                    }
                    break;
            }
        }
    };
    private View.OnClickListener profileOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO: 判断登录状态 未登录则跳转登录页面 登录则跳转到用户详情页？）
            if (Constants.LOGIN_STATUS){
                Log.d("Login ", "already login");
                Intent intent = new Intent(view.getContext(), ProfileActivity.class);
                startActivity(intent);
            }else {
                Intent intent = new Intent(view.getContext(), LoginActivity.class);
                startActivity(intent);
            }
        }
    };

    // 不应该放到fragment里

    // TODO: 读取sp 查看是否登有登录状态
    @Override
    public void onResume() {
        Log.d("MeFragment","onResume被调用了");
        if (!Constants.LOGIN_STATUS){
            CheckLoginStatus checkLoginStatus = new CheckLoginStatus(getActivity());
            // 检查是否登录 并设置常量
            checkLoginStatus.getSharedPreferences();
            // 如果还是等于空 那就清空信息
            if (!Constants.LOGIN_STATUS){
                mTvUserId.setText("UserID");
                mTvUsername.setText("UserName");
                mIvPhoto.setImageResource(R.drawable.profile_photo);
            }

        }
        if (Constants.LOGIN_STATUS){
            mTvUserId.setText(String.valueOf(Constants.USER_ID));
            mTvUsername.setText(Constants.USER_NAME);
            Glide.with(view).load(Constants.IMAGE_PATH).into(mIvPhoto);
        }
        super.onResume();
    }
}
