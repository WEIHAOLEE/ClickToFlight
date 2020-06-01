package com.sky.clicktoflight.View;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sky.clicktoflight.Constants;
import com.sky.clicktoflight.R;
import com.sky.clicktoflight.utils.CheckLoginStatus;
import com.sky.clicktoflight.utils.ImmersionBarUtils;

public class NotificationsFragment extends Fragment {

    private View view;
    private RecyclerView mRvShopping;
    private String arrAirport;
    private String depAirport;
    private String arrTime;
    private String depTime;
    private String flightNum;
    private String price;
    private String seat;
    private ImmersionBarUtils immersionBarUtils;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_notification, container, false);
        initView();
        if (Constants.LOGIN_STATUS){

        }
        return view;
    }


    private void setRecyclerView() {
        mRvShopping = view.findViewById(R.id.rv_order);
        mRvShopping.setLayoutManager(new LinearLayoutManager(view.getContext()));
        // 得到数据
    }

    private void initView() {
        immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtilFragment(this,R.id.view_bar);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
