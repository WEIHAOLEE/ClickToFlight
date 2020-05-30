package com.sky.clicktoflight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sky.clicktoflight.Bean.BookDataBean;
import com.sky.clicktoflight.Presenter.PresenterPayPayOrderImpl;
import com.sky.clicktoflight.utils.ImmersionBarUtils;

import java.util.List;

public class PayOrderActivity extends AppCompatActivity implements IContract.IViewPayOrder {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_order);
        initView();
        PresenterPayPayOrderImpl presenterOrder = new PresenterPayPayOrderImpl(this);
        presenterOrder.getPayOrderList();

    }

    private void initView() {
        ImmersionBarUtils immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtilActivity(this,R.id.view_bar);
    }

    @Override
    public void setRecyclerView(List<BookDataBean> bookDataBeanList) {

    }
}
