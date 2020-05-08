package com.sky.clicktoflight.Presenter;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sky.clicktoflight.Bean.FlightDataBean;
import com.sky.clicktoflight.IContract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class PresenterImpl implements IContract.IPresenter {
    private final IContract.IView view;

    private Handler mHandler;
    private FlightDataBean mFlightDataBean;
    private List<FlightDataBean> mList;

    public PresenterImpl(IContract.IView view) {
        this.view = view;
    }

    @SuppressLint("HandlerLeak")
    @Override
    public void getFlightDataList() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    requestData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        mHandler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what){
                    case 1:

                        mList = (List<FlightDataBean>) msg.obj;
                        view.setRecycleview(mList);
                        break;
                }

            }
        };
    }

    private void requestData() throws IOException {
        String parpreUrl = "http://47.101.190.152:8080/appServer/findFlight";
        URL url = new URL(parpreUrl);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200){
            httpURLConnection.setConnectTimeout(2000);
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line;
            List<FlightDataBean> list = null;
            if ((line = bufferedReader.readLine()) != null) {
                Gson gson = new Gson();
                list = gson.fromJson(line, new TypeToken<List<FlightDataBean>>() {}.getType());

            }
            Message message = mHandler.obtainMessage();
            message.what = 1;
            message.obj = list;
            mHandler.sendMessage(message);
            bufferedReader.close();
        }
    }
}
