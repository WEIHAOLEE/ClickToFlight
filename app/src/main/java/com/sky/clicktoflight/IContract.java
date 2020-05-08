package com.sky.clicktoflight;

import android.view.View;

import com.sky.clicktoflight.Bean.FlightDataBean;

import java.util.List;

public interface IContract {

    interface IPresenter{
        void getFlightDataList();
    }

    interface IView{

        void setRecycleview(List<FlightDataBean> flightDataBeansList);
    }
    interface IModel{

    }
}
