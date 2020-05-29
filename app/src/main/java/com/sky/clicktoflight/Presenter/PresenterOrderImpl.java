package com.sky.clicktoflight.Presenter;

import android.util.Log;

import com.sky.clicktoflight.Constants;
import com.sky.clicktoflight.IContract;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class PresenterOrderImpl implements IContract.IPresenterOrder {


    private static final String TAG = PresenterOrderImpl.class.getName();

    @Override
    public void getPayOrderList() {
//        okHttpRequest();
    }

    @Override
    public void getPaidOrderList() {

    }

    private void okHttpRequest(String requestType) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(1000, TimeUnit.MILLISECONDS)
                .build();
        RequestBody body = new FormBody.Builder()
                .add("uid", String.valueOf(Constants.USER_ID))
                .build();
        Request request = new Request.Builder()
                .url("http://47.101.190.152:8080/appServer/" + requestType)
                .post(body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

        // client发送请求 异步请求 回调
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG,"onFailure --> " + e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                ResponseBody responseBody = response.body();
                String string = responseBody.string();
                Log.d(TAG,"response --> " + string);
            }
        });
    }
}
