package com.sky.clicktoflight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.sky.clicktoflight.Bean.FlightDataBean;
import com.sky.clicktoflight.DIY.AwesomeTextView;
import com.sky.clicktoflight.Model.DAO.AirportDaoImpl;
import com.sky.clicktoflight.utils.ImmersionBarUtils;

import java.io.Serializable;

public class FlightInfoActivity extends AppCompatActivity {

    private ImmersionBarUtils immersionBarUtils;
    private TextView mTvDepTime;
    private TextView mTvFlightTime;
    private TextView mTvArrTime;
    private TextView mTvDepAirport;
    private TextView mTvArrAirport;
    private TextView mTvFlightNum;
    private AwesomeTextView mTvDepValue;
    private AwesomeTextView mTvArrValue;
    private TextView mTvPlaneModelNum;
    private TextView mTvOnTimeNum;
    private TextView mTvPriceNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_info);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        FlightDataBean flightData = (FlightDataBean) intent.getSerializableExtra("flightData");
        String arrAirport = flightData.getArrAirport();
        String depAirport = flightData.getDepAirport();
        AirportDaoImpl dao = new AirportDaoImpl(this);
        String arrAirportName = dao.airportQuery(arrAirport);
        String depAirportName = dao.airportQuery(depAirport);
        mTvDepValue.setText(depAirportName);
        mTvArrValue.setText(arrAirportName);
        mTvArrAirport.setText(arrAirport);
        mTvArrTime.setText(flightData.getArrTime());
        mTvDepAirport.setText(depAirport);
        mTvDepTime.setText(flightData.getDepTime());
        mTvFlightNum.setText(flightData.getFlightCompany() + flightData.getFlightNum());
        String flightTime =flightData.getFlightTime() + " Hours";
        mTvFlightTime.setText(flightTime);
        mTvOnTimeNum.setText(flightData.getOnTime());
        mTvPlaneModelNum.setText(flightData.getPlaneModel());
        mTvPriceNum.setText("¥" + flightData.getPrice());

    }

    private void initView() {
        immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtilActivity(this,R.id.view_bar);
        mTvDepTime = findViewById(R.id.tv_dep_time);
        mTvFlightTime = findViewById(R.id.tv_flight_time);
        mTvArrTime = findViewById(R.id.tv_arr_time);
        mTvDepAirport = findViewById(R.id.tv_dep_airport);
        mTvArrAirport = findViewById(R.id.tv_arr_airport);
        mTvFlightNum = findViewById(R.id.tv_flight_num);
        mTvDepValue = findViewById(R.id.tv_dep_value);
        mTvArrValue = findViewById(R.id.tv_arr_value);
        mTvPlaneModelNum = findViewById(R.id.tv_plane_model_num);
        mTvOnTimeNum = findViewById(R.id.tv_on_time_num);
        mTvPriceNum = findViewById(R.id.tv_price_num);

    }
}
