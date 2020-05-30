package com.sky.clicktoflight.View.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sky.clicktoflight.Bean.BookDataBean;
import com.sky.clicktoflight.R;

import java.util.List;

public class PaidOrderRecyclerViewAdapter extends RecyclerView.Adapter<PaidOrderRecyclerViewAdapter.InnerHolder> {
    private final List<BookDataBean> mBookData;

    public PaidOrderRecyclerViewAdapter(List<BookDataBean> mBookData) {
        this.mBookData = mBookData;
    }


    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_paid_order_view, parent, false);
        // 这么写无法居中对齐
//        View view = View.inflate(parent.getContext(), R.layout.item_paid_order_view, null);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        holder.setData(mBookData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mBookData != null) {
            return mBookData.size();
        }
        return 0;
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private final TextView mTvFlightNum;
        private final TextView mTvSeat;
        private final TextView mTvBookId;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            mTvFlightNum = itemView.findViewById(R.id.tv_flight_num);
            mTvSeat = itemView.findViewById(R.id.tv_seat);
            mTvBookId = itemView.findViewById(R.id.tv_book_id);
        }
        public void  setData(BookDataBean bookData) {
            String BID = "BID: " + bookData.getBID();
            String FlightNum = bookData.getFlightCompany() + bookData.getFlightNumber();
            String Seat = "Seat: " + bookData.getSeat();
            mTvBookId.setText(BID);
            mTvFlightNum.setText(FlightNum);
            mTvSeat.setText(Seat);
        }
    }
}
