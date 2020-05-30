package com.sky.clicktoflight.Presenter;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.sky.clicktoflight.Bean.BookDataBean;
import com.sky.clicktoflight.Constants;
import com.sky.clicktoflight.IContract;
import com.sky.clicktoflight.utils.OkHttpRequest;

import java.util.List;

import okhttp3.FormBody;
import okhttp3.RequestBody;

public class PresenterPayOrderImpl implements IContract.IPresenterPayOrder {


    private static final String TAG = PresenterPayOrderImpl.class.getName();
    private final IContract.IViewPayOrder view;
    private Handler mHandler;

    public PresenterPayOrderImpl(IContract.IViewPayOrder view) {
        this.view = view;
    }

    @SuppressLint("HandlerLeak")
    @Override
    public void getPayOrderList() {
        getRequest();


    }

    private void getRequest() {
        RequestBody body = new FormBody.Builder()
                .add("uid", String.valueOf(Constants.USER_ID))
                .build();
        OkHttpRequest.okHttpRequest("pay", new OkHttpRequest.Callbacks() {
            @Override
            public void ResponseList(List<BookDataBean> list) {
//                Message message = mHandler.obtainMessage();
//                message.what = 1;
//                message.obj = list;
                view.setRecyclerView(list);
            }
        },body);
    }


//    @Override
//    public void getPaidOrderList() {
//        OkHttpRequest.okHttpRequest("paid");
//    }


}
