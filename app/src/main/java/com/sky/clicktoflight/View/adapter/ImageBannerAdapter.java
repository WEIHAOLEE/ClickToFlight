package com.sky.clicktoflight.View.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sky.clicktoflight.Bean.BannerDataBean;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

public class ImageBannerAdapter extends BannerAdapter<BannerDataBean, ImageBannerAdapter.BannerViewHolder> {
    public ImageBannerAdapter(List<BannerDataBean> datas) {
        super(datas);
    }

    @Override
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new BannerViewHolder(imageView);
    }



    @Override
    public void onBindView(BannerViewHolder holder, BannerDataBean data, int position, int size) {
        holder.imageView.setImageResource(data.getImageRes());
    }

    class BannerViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        public BannerViewHolder(@NonNull ImageView view) {
            super(view);
            this.imageView = view;
        }
    }
}
