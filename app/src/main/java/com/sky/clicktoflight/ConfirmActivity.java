package com.sky.clicktoflight;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sky.clicktoflight.BroadcastReceiver.AlarmReceiver;
import com.sky.clicktoflight.utils.ImmersionBarUtils;

public class ConfirmActivity extends AppCompatActivity {

    private static final String TAG = ConfirmActivity.class.getName();
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
    private Button mBtBook;
    private Button mBtReservation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        initView();
        initData();
        setOnClickListener();

    }

    private void setOnClickListener() {
        mBtReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获得alarmManager 服务对象
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                // new intent
                Intent intent = new Intent();
                intent.setAction(Constants.ACTION_RESEVATION_NOTIFICATION);
                intent.setComponent(new ComponentName("com.sky.clicktoflight","com.sky.clicktoflight.BroadcastReceiver.AlarmReceiver"));

                 // 设置pendingIntent 启动广播
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 1, intent, 0);
                Log.d(TAG,"设置intent");

                alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 3000, pendingIntent);
                Log.d(TAG, "设置alarmManager");
            }
        });
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

        mBtBook = findViewById(R.id.bt_book);
        mBtReservation = findViewById(R.id.bt_reservation);

    }


}
