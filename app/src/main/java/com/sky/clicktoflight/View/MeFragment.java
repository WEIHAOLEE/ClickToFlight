package com.sky.clicktoflight.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sky.clicktoflight.LoginActivity;
import com.sky.clicktoflight.R;
import com.sky.clicktoflight.utils.ImmersionBarUtils;

public class MeFragment extends Fragment {
    private String content;
    private View view;
    private ImageView mIvPhoto;
    private TextView mTvUsername;
    private TextView mTvUserId;

    public MeFragment(String content) {
        this.content = content;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_me, container, false);

        initView();

//        return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    private void initView() {
        TextView tv_fm = view.findViewById(R.id.tv_fm);
        tv_fm.setText(content);
        ImmersionBarUtils immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtilFragment(this,R.id.view_bar);
        mIvPhoto = view.findViewById(R.id.iv_pf_photo);
        mIvPhoto.setOnClickListener(profileOnClickListener);
        mTvUsername = view.findViewById(R.id.tv_username);
        mTvUsername.setOnClickListener(profileOnClickListener);
        mTvUserId = view.findViewById(R.id.tv_userid);
        mTvUserId.setOnClickListener(profileOnClickListener);
    }
    private View.OnClickListener profileOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // TODO: 判断登录状态 未登录则跳转登录页面 登录则不操作）
            Intent intent = new Intent(view.getContext(), LoginActivity.class);
            startActivity(intent);
        }
    };
}
