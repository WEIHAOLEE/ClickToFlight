package com.sky.clicktoflight;

import android.content.Context;
import android.view.View;

import com.sky.clicktoflight.Bean.FlightDataBean;

import java.util.List;

public interface IContract {

    interface IPresenter{
        void getFlightDataList();

        String airportGet(Context context, String icao);


    }

    interface IPresenterSearch{
        void getFlightDataBy(String flightInfo);
    }

    interface IPresenterReg{
        void register(String uid, String uPwd);
    }

    interface IView{

        void setRecycleview(List<FlightDataBean> flightDataBeansList);

        String setAirportName(String icaoAirport);
    }

    interface IViewSearch{
        void setRecyclerview(List<FlightDataBean> flightDataBeanList);
    }
    interface IModel{

    }
}
