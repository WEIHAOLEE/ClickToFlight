package com.sky.clicktoflight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.gyf.immersionbar.ImmersionBar;
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
    private CustomNPDialog dialog;
    private String chooseSeat;
    private TextView mTvSeatValue;
    private String mArrAirportName;
    private String mDepAirportName;
    private String mArrAirport;
    private String mDepAirport;
    private String mArrTime;
    private String mDepTime;
    private String mFlightNum;
    private String mFlightTime;
    private String mOnTime;
    private String mPlaneModel;
    private String mprice;
    private FlightDataBean flightData;
    private Button mBtConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_info);
        initView();
        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        flightData = (FlightDataBean) intent.getSerializableExtra("flightData");
        mArrAirport = flightData.getArrAirport();
        mDepAirport = flightData.getDepAirport();
        mArrTime = flightData.getArrTime();
        mDepTime = flightData.getDepTime();
        mFlightNum = flightData.getFlightCompany() + flightData.getFlightNum();
        mFlightTime = flightData.getFlightTime() + " Hours";
        mOnTime = flightData.getOnTime();
        mPlaneModel = flightData.getPlaneModel();
        mprice = "¥" + flightData.getPrice();
        AirportDaoImpl dao = new AirportDaoImpl(this);
        mArrAirportName = dao.airportQuery(mArrAirport);
        mDepAirportName = dao.airportQuery(mDepAirport);



        mTvDepValue.setText(mDepAirportName);
        mTvArrValue.setText(mArrAirportName);
        mTvArrAirport.setText(mArrAirport);
        mTvArrTime.setText(mArrTime);
        mTvDepAirport.setText(mDepAirport);
        mTvDepTime.setText(mDepTime);
        mTvFlightNum.setText(mFlightNum);
        mTvFlightTime.setText(mFlightTime);
        mTvOnTimeNum.setText(mOnTime);
        mTvPlaneModelNum.setText(mPlaneModel);
        mTvPriceNum.setText(mprice);

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
        mBtConfirm = findViewById(R.id.bt_confirm);
        mBtChooseSeat.setOnClickListener(this);
        mBtConfirm.setOnClickListener(this);
        mTvSeatValue = findViewById(R.id.tv_seat_value);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_choose_seat:
                String[] seatWords = {"A","B","C","D","E","F"};
                // 此处不能依赖getapplicationcontext 需要写this

                dialog = new CustomNPDialog(this, 68, 0, seatWords, new CustomNPDialog.OnInputFinishedListener() {
                    @Override
                    public void inputeFinished(String seat) {
                        Toast.makeText(getApplicationContext(),seat,Toast.LENGTH_SHORT).show();
                        chooseSeat = seat;
                        mTvSeatValue.setText(chooseSeat);
                    }
                });
                dialog.show();
                ImmersionBar.with(this, dialog).init();
                break;
            case R.id.bt_confirm:
                Intent intent = new Intent(getApplicationContext(),ConfirmActivity.class);
                intent.putExtra("arrAirport",mArrAirport);
                intent.putExtra("depAirport",mDepAirport);
                intent.putExtra("arrTime",mArrTime);
                intent.putExtra("depTime",mDepTime);
                intent.putExtra("flightNum",mFlightNum);
                intent.putExtra("flightTime",mFlightTime);
                intent.putExtra("onTime",mOnTime);
                intent.putExtra("planeModel",mPlaneModel);
                intent.putExtra("price",String.valueOf(flightData.getPrice()));
                intent.putExtra("seat",chooseSeat);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        ImmersionBar.with(this,dialog);
        super.onDestroy();
    }
}
