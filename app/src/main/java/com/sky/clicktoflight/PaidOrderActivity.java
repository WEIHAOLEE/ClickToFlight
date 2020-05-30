package com.sky.clicktoflight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sky.clicktoflight.Bean.BookDataBean;
import com.sky.clicktoflight.Presenter.PresenterPaidOrderImpl;
import com.sky.clicktoflight.Presenter.PresenterPayOrderImpl;
import com.sky.clicktoflight.View.adapter.PaidOrderRecyclerViewAdapter;
import com.sky.clicktoflight.utils.ImmersionBarUtils;

import java.util.List;

public class PaidOrderActivity extends AppCompatActivity implements IContract.IViewPaidOrder {

    private RecyclerView mRcPaidOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paid_order);
        initView();
        PresenterPaidOrderImpl presenterPaidOrder = new PresenterPaidOrderImpl(this);
        presenterPaidOrder.getPaidOrderList();
    }
    private void initView() {
        ImmersionBarUtils immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtilActivity(this,R.id.view_bar);
    }

    @Override
    public void setRecyclerView(List<BookDataBean> bookDataBeanList) {
        mRcPaidOrder = findViewById(R.id.rv_order);
        mRcPaidOrder.setLayoutManager(new LinearLayoutManager(this));
        PaidOrderRecyclerViewAdapter adapter = new PaidOrderRecyclerViewAdapter(bookDataBeanList);
        mRcPaidOrder.setAdapter(adapter);

    }
}
