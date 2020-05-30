package com.sky.clicktoflight.Presenter;

import android.util.Log;

import com.sky.clicktoflight.Bean.BookDataBean;
import com.sky.clicktoflight.Constants;
import com.sky.clicktoflight.IContract;
import com.sky.clicktoflight.utils.OkHttpRequest;
import com.sky.clicktoflight.utils.OkHttpUploadRequest;

import java.util.List;

import okhttp3.FormBody;
import okhttp3.RequestBody;

public class PresenterAddOrderImpl implements IContract.IPresenterAddOrder {

    private final IContract.IViewAddOrder view;
    private String flightNumber;
    private String flightCompany;
    private String seat;
    private String paymentStatus;

    public PresenterAddOrderImpl(IContract.IViewAddOrder view, String flightNumber, String flightCompany, String seat, String paymentStatus) {
        this.view = view;
        this.flightNumber = flightNumber;
        this.flightCompany = flightCompany;
        this.seat = seat;
        this.paymentStatus = paymentStatus;
    }


    @Override
    public void setOrder() {
        RequestBody body = new FormBody.Builder()
                .add("uid", String.valueOf(Constants.USER_ID))
                .add("flightNumber", flightNumber)
                .add("flightCompany", flightCompany)
                .add("seat", seat)
                .add("paymentStatus", paymentStatus)
                .build();
        OkHttpUploadRequest.okHttpRequest("book", new OkHttpUploadRequest.Callbacks() {
            @Override
            public void Response(String response) {
                Log.d("test", response);
                String replace = response.replaceAll("\r|\n", "");
                view.getResult(Integer.parseInt(replace));
            }
        },body);
    }
}
