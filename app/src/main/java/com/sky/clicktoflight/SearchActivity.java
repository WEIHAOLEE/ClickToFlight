package com.sky.clicktoflight;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.sky.clicktoflight.Bean.FlightDataBean;
import com.sky.clicktoflight.Presenter.PresenterSearchImpl;
import com.sky.clicktoflight.View.adapter.FlightListRecycleviewAdapter;
import com.sky.clicktoflight.utils.ImmersionBarUtils;

import java.io.Serializable;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements IContract.IViewSearch {


    private Drawable drawable_search;
    private EditText et_search;
    private ImmersionBarUtils immersionBarUtils;
    private RecyclerView mRvFlightList;
    private PresenterSearchImpl presenter;
    private InputMethodManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        presenter = new PresenterSearchImpl(this);
        initView();

    }

    private void initView() {
        immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtilActivity(this,R.id.view_bar);

        et_search = findViewById(R.id.et_search);
        drawable_search = getResources().getDrawable(R.drawable.ic_search_dark_gray_24dp);
        drawable_search.setBounds(17, 3, 67, 55);
        et_search.setCompoundDrawables(drawable_search, null, null ,null);
        // editText get focus and open the keyboard  获取焦点并调出键盘
        et_search.setFocusable(true);
        et_search.setFocusableInTouchMode(true);
        et_search.requestFocus();

        manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        et_search.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
                    if (manager.isActive()) {
//                        manager.hideSoftInputFromWindow(et_search.getApplicationWindowToken(),0);
                    }
                    String flightInfo = et_search.getText().toString().trim();
                    if (TextUtils.isEmpty(flightInfo)) {
                        Toast.makeText(getApplicationContext(),"Your input is empty, please re-enter",Toast.LENGTH_SHORT).show();
                    }else {
                        presenter.getFlightDataBy(flightInfo);
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void setRecyclerview(final List<FlightDataBean> flightDataBeanList) {
        mRvFlightList = findViewById(R.id.rv_flight_list);
        mRvFlightList.setLayoutManager(new LinearLayoutManager(this));
        FlightListRecycleviewAdapter adapter = new FlightListRecycleviewAdapter(flightDataBeanList,this);
        mRvFlightList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnClickListener(new FlightListRecycleviewAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getApplicationContext(),FlightInfoActivity.class);
                FlightDataBean flightDataBean = flightDataBeanList.get(position);
                intent.putExtra("flightData", (Serializable) flightDataBean);
                startActivity(intent);
            }
        });
    }
}
