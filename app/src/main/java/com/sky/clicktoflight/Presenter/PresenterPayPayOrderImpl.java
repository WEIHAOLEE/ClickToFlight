package com.sky.clicktoflight.Presenter;

import com.sky.clicktoflight.Bean.BookDataBean;
import com.sky.clicktoflight.IContract;
import com.sky.clicktoflight.utils.OkHttpRequest;

import java.util.List;

public class PresenterPayPayOrderImpl implements IContract.IPresenterPayOrder {


    private static final String TAG = PresenterPayPayOrderImpl.class.getName();
    private final IContract.IViewPayOrder view;

    public PresenterPayPayOrderImpl(IContract.IViewPayOrder view) {
        this.view = view;
    }

    @Override
    public void getPayOrderList() {
        OkHttpRequest.okHttpRequest("pay", new OkHttpRequest.Callbacks() {
            @Override
            public void ResponseList(List<BookDataBean> list) {
                view.setRecyclerView(list);
            }
        });
    }


//    @Override
//    public void getPaidOrderList() {
//        OkHttpRequest.okHttpRequest("paid");
//    }


}
