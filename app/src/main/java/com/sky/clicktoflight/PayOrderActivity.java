package com.sky.clicktoflight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;

import com.sky.clicktoflight.Bean.BookDataBean;
import com.sky.clicktoflight.Presenter.PresenterPayOrderImpl;
import com.sky.clicktoflight.Presenter.PresenterUpdateOrder;
import com.sky.clicktoflight.View.adapter.PayOrderRecyclerViewAdapter;
import com.sky.clicktoflight.utils.ImmersionBarUtils;

import java.util.List;

public class PayOrderActivity extends AppCompatActivity implements IContract.IViewPayOrder {

    private RecyclerView mRcPayOrder;
    private PresenterPayOrderImpl presenterOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_order);
        initView();
        presenterOrder = new PresenterPayOrderImpl(this);
        presenterOrder.getPayOrderList();

    }

    private void initView() {
        ImmersionBarUtils immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtilActivity(this,R.id.view_bar);
    }

    @Override
    public void setRecyclerView(final List<BookDataBean> bookDataBeanList) {
        mRcPayOrder = findViewById(R.id.rv_order);
        mRcPayOrder.setLayoutManager(new LinearLayoutManager(this));
        PayOrderRecyclerViewAdapter adapter = new PayOrderRecyclerViewAdapter(bookDataBeanList);
        mRcPayOrder.setAdapter(adapter);
        adapter.setOnClickListener(new PayOrderRecyclerViewAdapter.OnClickListner() {
            @Override
            public void onClick(int position, View v) {

                switch (v.getId()){
                    case R.id.bt_buy:
                        int bid = bookDataBeanList.get(position).getBID();
                        presenterOrder.update(bid);
                        break;
                    case R.id.bt_cancel:
                        int bid1 = bookDataBeanList.get(position).getBID();
                        presenterOrder.delete(bid1);
                        break;
                }
            }
        });


    }

    @Override
    public void getResult(int result) {
        if (result == 1){
            finish();
        }
    }
}
