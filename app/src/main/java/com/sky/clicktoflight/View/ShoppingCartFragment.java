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

public class ShoppingCartFragment extends Fragment {

    private View view;
    private RecyclerView mRvShopping;
    private String arrAirport;
    private String depAirport;
    private String arrTime;
    private String depTime;
    private String flightNum;
    private String price;
    private String seat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        initView();
        if (Constants.LOGIN_STATUS){
            getSp();
            setRecyclerView();
        }
        return view;
    }

    private void getSp() {
        // TODO：改成数据库操作
        SharedPreferences sp = view.getContext().getSharedPreferences(Constants.USER_NAME+ "Book", Context.MODE_PRIVATE);
        arrAirport = sp.getString("arrAirport", "");
        depAirport = sp.getString("depAirport", "");
        arrTime = sp.getString("arrTime", "");
        depTime = sp.getString("depTime", "");
        flightNum = sp.getString("flightNum", "");
        price = sp.getString("price", "");
        seat = sp.getString("seat", "");

    }

    private void setRecyclerView() {
        mRvShopping = view.findViewById(R.id.rv_order);
        mRvShopping.setLayoutManager(new LinearLayoutManager(view.getContext()));
        // 得到数据
    }

    private void initView() {
        ImmersionBarUtils immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtilFragment(this,R.id.view_bar);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!Constants.LOGIN_STATUS){
            CheckLoginStatus checkLoginStatus = new CheckLoginStatus(getActivity());
            // 检查是否登录 并设置常量
            checkLoginStatus.getSharedPreferences();
        }
    }
}
