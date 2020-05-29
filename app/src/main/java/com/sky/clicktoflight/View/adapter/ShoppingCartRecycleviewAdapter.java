package com.sky.clicktoflight.View.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShoppingCartRecycleviewAdapter extends RecyclerView.Adapter<ShoppingCartRecycleviewAdapter.InnerHodler> {
    @NonNull
    @Override
    public InnerHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHodler holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class InnerHodler extends RecyclerView.ViewHolder {
        public InnerHodler(@NonNull View itemView) {
            super(itemView);
        }
    }
}
