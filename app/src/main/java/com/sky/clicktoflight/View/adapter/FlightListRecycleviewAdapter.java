package com.sky.clicktoflight.View.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sky.clicktoflight.Bean.FlightDataBean;
import com.sky.clicktoflight.R;

import java.util.List;

public class FlightListRecycleviewAdapter extends RecyclerView.Adapter<FlightListRecycleviewAdapter.InnerHodler> {

    private final List<FlightDataBean> mFlightData;

    public FlightListRecycleviewAdapter(List<FlightDataBean> mFlightData) {
        this.mFlightData = mFlightData;
    }

    @NonNull
    @Override
    public InnerHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_list_view, null);
        return new InnerHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHodler holder, int position) {
        holder.setData(mFlightData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mFlightData != null) {
            return mFlightData.size();
        }
        return 0;
    }

    public class InnerHodler extends RecyclerView.ViewHolder {

        private final TextView mTvArrTime;
        private final TextView mTvArrAirport;
        private final TextView mTvDepAirPort;
        private final TextView mTvDepTime;
        private final TextView mTvFlightNum;
        private final TextView mTvOnTime;
        private final TextView mTvPrice;

        public InnerHodler(@NonNull View itemView) {
            super(itemView);
//            TextView mTvFlightTime = itemView.findViewById(R.id.tv_flight_time);
            mTvArrTime = itemView.findViewById(R.id.tv_arr_time);
            mTvArrAirport = itemView.findViewById(R.id.tv_arr_airport);
            mTvDepAirPort = itemView.findViewById(R.id.tv_dep_airport);
            mTvDepTime = itemView.findViewById(R.id.tv_dep_time);
            mTvFlightNum = itemView.findViewById(R.id.tv_flight_num);
            mTvOnTime = itemView.findViewById(R.id.tv_on_time);
            mTvPrice = itemView.findViewById(R.id.tv_price);

        }

        public void setData(FlightDataBean dataBean){
            mTvArrAirport.setText(dataBean.getArrAirport());
            mTvArrTime.setText(dataBean.getArrTime());
            mTvDepAirPort.setText(dataBean.getDepAirport());
            mTvDepTime.setText(dataBean.getDepTime());
            String flightNum = dataBean.getFlightCompany() + dataBean.getFlightNum();
            mTvFlightNum.setText(flightNum);
            mTvOnTime.setText(dataBean.getOnTime());
            mTvPrice.setText(dataBean.getPrice());

        }
    }
}
