package com.sky.clicktoflight.View.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sky.clicktoflight.Bean.BookDataBean;
import com.sky.clicktoflight.R;

import java.util.List;

public class PayOrderRecyclerViewAdapter extends RecyclerView.Adapter<PayOrderRecyclerViewAdapter.InnerHodler> {

    private final List<BookDataBean> mBookData;

    public PayOrderRecyclerViewAdapter(List<BookDataBean> mBookData) {
        this.mBookData = mBookData;
    }

    @NonNull
    @Override
    public InnerHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pay_order_view, parent, false);
        return new InnerHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHodler holder, int position) {
        holder.setData(mBookData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mBookData != null) {
            return mBookData.size();
        }
        return 0;
    }

    public class InnerHodler extends RecyclerView.ViewHolder {

        private final TextView mTvFlightNum;
        private final TextView mTvSeat;
        private final TextView mTvBookId;
        private final Button mBtBuy;
        private final Button mBtCancel;

        public InnerHodler(@NonNull View itemView) {
            super(itemView);
            mTvFlightNum = itemView.findViewById(R.id.tv_flight_num);
            mTvSeat = itemView.findViewById(R.id.tv_seat);
            mTvBookId = itemView.findViewById(R.id.tv_book_id);
            mBtBuy = itemView.findViewById(R.id.bt_buy);
            mBtCancel = itemView.findViewById(R.id.bt_cancel);
        }

        public void  setData(BookDataBean bookData){
            String BID = "BID: " + bookData.getBID();
            String FlightNum = bookData.getFlightCompany() + bookData.getFlightNumber();
            String Seat = "Seat: " + bookData.getSeat();
            mTvBookId.setText(BID);
            mTvFlightNum.setText(FlightNum);
            mTvSeat.setText(Seat);
        }
    }
}
