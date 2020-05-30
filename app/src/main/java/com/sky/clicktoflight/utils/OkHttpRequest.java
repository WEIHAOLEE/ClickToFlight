package com.sky.clicktoflight.utils;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sky.clicktoflight.Bean.BookDataBean;
import com.sky.clicktoflight.Constants;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpRequest {
    private static final String TAG = OkHttpRequest.class.getName();
    private static Handler mHandler;

    @SuppressLint("HandlerLeak")
    public static void okHttpRequest(String requestType, final Callbacks callbacks) {

        mHandler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what){
                    case 1:
                        callbacks.ResponseList((List<BookDataBean>) msg.obj);
                }
            }
        };
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
                Gson gson = new Gson();
                List<BookDataBean> list = null;
                list = gson.fromJson(string,new TypeToken<List<BookDataBean>>(){}.getType());
                Log.d(TAG,"response --> " + list);
                Message message = mHandler.obtainMessage();
                message.what = 1;
                message.obj = list;
                mHandler.sendMessage(message);
            }
        });
    }
    // callback
    public interface Callbacks{
        void ResponseList(List<BookDataBean> list);
    }

}
