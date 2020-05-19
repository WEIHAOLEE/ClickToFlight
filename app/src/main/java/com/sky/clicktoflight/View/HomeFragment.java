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
import com.sky.clicktoflight.Bean.FlightDataBean;
import com.sky.clicktoflight.IContract;
import com.sky.clicktoflight.Presenter.PresenterImpl;
import com.sky.clicktoflight.R;
import com.sky.clicktoflight.SearchActivity;
import com.sky.clicktoflight.View.adapter.FlightListRecycleviewAdapter;
import com.sky.clicktoflight.View.adapter.ImageBannerAdapter;
import com.sky.clicktoflight.utils.ImmersionBarUtils;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;

import java.util.List;

public class HomeFragment extends ImmersionFragment implements IContract.IView {

    private TextView tv_search;
    private Drawable drawable_search;
    private ImmersionBarUtils immersionBarUtils;
    private RecyclerView mRvFlightList;
    private List<FlightDataBean> mFlightDataList;
    private PresenterImpl presenter;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        initView(mView);
        useBanner(mView);
        //调用p层得到数据
        presenter = new PresenterImpl(this);
        presenter.getFlightDataList();
        return mView;
    }


    @Override
    public void setRecycleview(List<FlightDataBean> flightDataBeansList) {
        mRvFlightList = mView.findViewById(R.id.rv_flight_list);
        mRvFlightList.setLayoutManager(new LinearLayoutManager(mView.getContext()));
        FlightListRecycleviewAdapter adapter = new FlightListRecycleviewAdapter(flightDataBeansList,mView.getContext());
        mRvFlightList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public String setAirportName(String icaoAirport) {

        return presenter.airportGet(mView.getContext(),icaoAirport);
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
