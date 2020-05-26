package com.sky.clicktoflight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.sky.clicktoflight.Bean.FlightDataBean;
import com.sky.clicktoflight.DIY.AwesomeTextView;
import com.sky.clicktoflight.DIY.CustomNPDialog;
import com.sky.clicktoflight.Model.DAO.AirportDaoImpl;
import com.sky.clicktoflight.utils.ImmersionBarUtils;

public class FlightInfoActivity extends AppCompatActivity implements View.OnClickListener {

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
    private ScrollView mScrollView;
    private Button mBtChooseSeat;

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
        mScrollView = findViewById(R.id.scroll_view);
        mBtChooseSeat = findViewById(R.id.bt_choose_seat);
        mBtChooseSeat.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_choose_seat:
                String[] seatWords = {"A","B","C","D","E","F"};
                // 此处不能依赖getapplicationcontext 需要写this
                CustomNPDialog dialog = new CustomNPDialog(this, 68, 0, seatWords, new CustomNPDialog.OnInputFinishedListener() {
                    @Override
                    public void inputeFinished(String seat) {
                        Toast.makeText(getApplicationContext(),seat,Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
        }
    }
}
