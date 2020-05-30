package com.sky.clicktoflight.Presenter;

import com.sky.clicktoflight.Bean.BookDataBean;
import com.sky.clicktoflight.IContract;
import com.sky.clicktoflight.utils.OkHttpRequest;

import java.util.List;

public class PresenterPaidOrderImpl implements IContract.IPresenterPaidOrder {

    private final IContract.IViewPaidOrder view;

    public PresenterPaidOrderImpl(IContract.IViewPaidOrder view) {
        this.view = view;
    }

    @Override
    public void getPaidOrderList() {
        OkHttpRequest.okHttpRequest("paid", new OkHttpRequest.Callbacks() {
            @Override
            public void ResponseList(List<BookDataBean> list) {
                view.setRecyclerView(list);
            }
        });
    }
}
