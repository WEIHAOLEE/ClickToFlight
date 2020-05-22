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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class PresenterSearchImpl implements IContract.IPresenterSearch {

    private Handler mHandler;
    private List<FlightDataBean> mList;
    private final IContract.IViewSearch view;

    public PresenterSearchImpl(IContract.IViewSearch view) {
        this.view = view;
    }

    @SuppressLint("HandlerLeak")
    @Override
    public void getFlightDataBy(final String flightInfo) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                requestData(flightInfo);
            }
        }).start();

        mHandler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what){
                    case 1:
                        mList = (List<FlightDataBean>) msg.obj;
                        view.setRecyclerview(mList);
                        break;
                }
            }
        };
    }

    private void requestData(String flightInfo) {
        String prepareData = "http://47.101.190.152:8080/appServer/findFlightClass?flightInfo=" + flightInfo;
        try {
            URL url = new URL(prepareData);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                httpURLConnection.setConnectTimeout(2000);
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = null;
                List<FlightDataBean> list = null;
                if ((line = bufferedReader.readLine()) != null){
                    Gson gson = new Gson();
                    list = gson.fromJson(line,new TypeToken<List<FlightDataBean>>() {}.getType());
                }
                Message message = mHandler.obtainMessage();
                message.what = 1;
                message.obj = list;
                mHandler.sendMessage(message);
                bufferedReader.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
