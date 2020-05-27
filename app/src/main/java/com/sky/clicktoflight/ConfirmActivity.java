package com.sky.clicktoflight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sky.clicktoflight.utils.ImmersionBarUtils;

public class ConfirmActivity extends AppCompatActivity {

    private RelativeLayout rl;
    private TextView mTvArrTime;
    private TextView mTvDepTime;
    private TextView mTvArrAirport;
    private TextView mTvDepAirport;
    private TextView mTvFlighNum;
    private TextView mTvTotalPrice;
    private TextView mTvTicketPrice;
    private TextView mTvPassName;
    private String arrAirport;
    private String depAirport;
    private String arrTime;
    private String depTime;
    private String flightNum;
    private String price;
    private String seat;
    private int ticketPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        initView();
        initData();

    }

    private void initData() {
        Intent intent = getIntent();
        arrAirport = intent.getStringExtra("arrAirport");
        depAirport = intent.getStringExtra("depAirport");
        arrTime = intent.getStringExtra("arrTime");
        depTime = intent.getStringExtra("depTime");
        flightNum = intent.getStringExtra("flightNum");
        price = intent.getStringExtra("price");
        seat = intent.getStringExtra("seat");
        ticketPrice = Integer.parseInt(price) - 50;

        mTvArrAirport.setText(arrAirport);
        mTvArrTime.setText(arrTime);
        mTvDepAirport.setText(depAirport);
        mTvDepTime.setText(depTime);
        mTvFlighNum.setText(flightNum + " " + seat);
        mTvTotalPrice.setText(price);
        mTvTicketPrice.setText(String.valueOf(ticketPrice));
        mTvPassName.setText(Constants.USER_NAME);
    }

    private void initView() {
        ImmersionBarUtils immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtilActivity(this,R.id.view_bar);
        mTvArrTime = findViewById(R.id.tv_pass_arr_time_clock);
        mTvDepTime = findViewById(R.id.tv_pass_dep_time_clock);
        mTvArrAirport = findViewById(R.id.tv_pass_arr_airport);
        mTvDepAirport = findViewById(R.id.tv_pass_dep_airport);
        mTvFlighNum = findViewById(R.id.tv_pass_flight_num);
        mTvTotalPrice = findViewById(R.id.tv_pass_price_total_num);
        mTvTicketPrice = findViewById(R.id.tv_pass_ticket_price_num);
        mTvPassName = findViewById(R.id.tv_pass_name);

    }


}
