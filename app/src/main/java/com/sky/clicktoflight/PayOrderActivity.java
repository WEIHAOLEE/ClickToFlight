package com.sky.clicktoflight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Looper;

import com.sky.clicktoflight.Bean.BookDataBean;
import com.sky.clicktoflight.Presenter.PresenterPayOrderImpl;
import com.sky.clicktoflight.View.adapter.PayOrderRecyclerViewAdapter;
import com.sky.clicktoflight.utils.ImmersionBarUtils;

import java.util.List;

public class PayOrderActivity extends AppCompatActivity implements IContract.IViewPayOrder {

    private RecyclerView mRcPayOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_order);
        initView();
        PresenterPayOrderImpl presenterOrder = new PresenterPayOrderImpl(this);
        presenterOrder.getPayOrderList();

    }

    private void initView() {
        ImmersionBarUtils immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtilActivity(this,R.id.view_bar);
    }

    @Override
    public void setRecyclerView(List<BookDataBean> bookDataBeanList) {
        mRcPayOrder = findViewById(R.id.rv_order);
        mRcPayOrder.setLayoutManager(new LinearLayoutManager(this));
        PayOrderRecyclerViewAdapter adapter = new PayOrderRecyclerViewAdapter(bookDataBeanList);
        mRcPayOrder.setAdapter(adapter);


    }
}
