package com.sky.clicktoflight.View;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gyf.immersionbar.components.ImmersionFragment;
import com.sky.clicktoflight.Bean.BannerDataBean;
import com.sky.clicktoflight.R;
import com.sky.clicktoflight.SearchActivity;
import com.sky.clicktoflight.View.adapter.ImageBannerAdapter;
import com.sky.clicktoflight.utils.ImmersionBarUtils;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

public class HomeFragment extends ImmersionFragment {

    private TextView tv_search;
    private Drawable drawable_search;
    private ImmersionBarUtils immersionBarUtils;
    private RecyclerView mRvFlightList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        useBanner(view);
        setRecycleview(view);
        return view;
    }

    private void setRecycleview(View view) {
        mRvFlightList = view.findViewById(R.id.rv_flight_list);
        mRvFlightList.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    private void initView(View view) {


        tv_search = view.findViewById(R.id.tv_search);
        drawable_search = view.getResources().getDrawable(R.drawable.ic_search_dark_gray_24dp);


        drawable_search.setBounds(17, 3, 67, 55);
        tv_search.setCompoundDrawables(drawable_search, null, null ,null);

        tv_search.setOnClickListener(searchListener);
    }

    private View.OnClickListener searchListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent search_intent = new Intent(view.getContext(), SearchActivity.class);
            startActivity(search_intent);
        }
    };

    @Override
    public void initImmersionBar() {
        immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtilFragment(this,R.id.view_bar);
    }

    public void useBanner(View view){
        Banner banner = view.findViewById(R.id.banner);
        banner.setAdapter(new ImageBannerAdapter(BannerDataBean.getImageData()));
        banner.setDelayTime(5000);
        banner.setBannerRound2(20);
        // indicator 指示器 就是轮播图下面那两个圆圆的东西
        banner.setIndicator(new CircleIndicator(view.getContext()));
        banner.setIndicatorSelectedColorRes(R.color.colorAccent);
        banner.setIndicatorNormalColorRes(R.color.indicatorNormal);
    }
}
