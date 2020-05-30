package com.sky.clicktoflight;

import android.content.Context;
import android.view.View;

import com.sky.clicktoflight.Bean.BookDataBean;
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
        void register(String uid, String uPwd, String uImage);
    }

    interface IPresenterLogin{
        void login(String uid, String uPwd);
    }
    interface IPresenterPayOrder {

        void getPayOrderList();

//        void getPaidOrderList();
    }

    interface IPresenterPaidOrder {


        void getPaidOrderList();
    }

    interface IPresenterAddOrder{

        void setOrder();
    }
    interface IView{

        void setRecycleview(List<FlightDataBean> flightDataBeansList);

        String setAirportName(String icaoAirport);
    }

    interface IViewSearch{
        void setRecyclerview(List<FlightDataBean> flightDataBeanList);
    }

    interface IViewReg{
        void finishActivity();
    }

    interface IViewLogin{
        void saveUserData(String response);
    }

    interface IViewPayOrder{
        void setRecyclerView(List<BookDataBean> bookDataBeanList);
    }

    interface IViewPaidOrder{
        void setRecyclerView(List<BookDataBean> bookDataBeanList);
    }
    interface IViewAddOrder{
        void getResult(int result);
    }


    interface IModel{

    }
}
