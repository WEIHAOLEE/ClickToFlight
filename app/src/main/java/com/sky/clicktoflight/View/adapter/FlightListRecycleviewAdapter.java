package com.sky.clicktoflight.View.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sky.clicktoflight.Bean.FlightDataBean;
import com.sky.clicktoflight.Model.DAO.AirportDaoImpl;
import com.sky.clicktoflight.R;

import java.util.List;

public class FlightListRecycleviewAdapter extends RecyclerView.Adapter<FlightListRecycleviewAdapter.InnerHodler> {

    private final List<FlightDataBean> mFlightData;
    private final Context viewContext;
    private OnClickListener mOnClickListener;
//    private final IContract.IView view;

    public FlightListRecycleviewAdapter(List<FlightDataBean> mFlightData, Context context) {
        this.mFlightData = mFlightData;
        this.viewContext = context;
    }

    public void setOnClickListener(OnClickListener onClickListener){
        this.mOnClickListener = onClickListener;
    }

    public interface OnClickListener{
        void onClick(int position);
    }

    @NonNull
    @Override
    public InnerHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_list_view, null);
        return new InnerHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHodler holder, final int position) {
        holder.setData(mFlightData.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickListener.onClick(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        if (mFlightData != null) {
            return mFlightData.size();
        }
        return 0;
    }

    public class InnerHodler extends RecyclerView.ViewHolder{

        private final TextView mTvArrTime;
        private final TextView mTvArrAirport;
        private final TextView mTvDepAirPort;
        private final TextView mTvDepTime;
        private final TextView mTvFlightNum;
        private final TextView mTvOnTime;
        private final TextView mTvPrice;
        private final TextView mTvFlightTime;

        public InnerHodler(@NonNull View itemView) {
            super(itemView);
            mTvFlightTime = itemView.findViewById(R.id.tv_flight_time);
            mTvArrTime = itemView.findViewById(R.id.tv_arr_time);
            mTvArrAirport = itemView.findViewById(R.id.tv_arr_airport);
            mTvDepAirPort = itemView.findViewById(R.id.tv_seat);
            mTvDepTime = itemView.findViewById(R.id.tv_dep_time);
            mTvFlightNum = itemView.findViewById(R.id.tv_flight_num);
            mTvOnTime = itemView.findViewById(R.id.tv_on_time);
            mTvPrice = itemView.findViewById(R.id.tv_price);

        }

        public void setData(FlightDataBean dataBean){
            // bad code logic
            String arrAirport = dataBean.getArrAirport();
            String depAirport = dataBean.getDepAirport();
            AirportDaoImpl dao = new AirportDaoImpl(viewContext);
            String depAirportName = dao.airportQuery(depAirport);
            String arrAirportName = dao.airportQuery(arrAirport);
//            String setArrAirportName = view.setAirportName(arrAirport);
            mTvArrAirport.setText(arrAirportName);
//            mTvArrAirport.setText(setArrAirportName);
            mTvArrTime.setText(dataBean.getArrTime());
            mTvDepAirPort.setText(depAirportName);
            mTvDepTime.setText(dataBean.getDepTime());
            String flightNum = dataBean.getFlightCompany() + dataBean.getFlightNum();
            mTvFlightNum.setText(flightNum);
            String onTime = "On Time: " + dataBean.getOnTime();
            mTvOnTime.setText(onTime);
            String price = "¥" + dataBean.getPrice();
            mTvPrice.setText(price);
            String flightTime = dataBean.getFlightTime() + " Hours";
            mTvFlightTime.setText(flightTime);

        }
    }
}
