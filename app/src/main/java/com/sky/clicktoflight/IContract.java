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

    interface IView{

        void setRecycleview(List<FlightDataBean> flightDataBeansList);

        String setAirportName(String icaoAirport);
        interface IViewAdapter{

        }
    }
    interface IModel{

    }
}
