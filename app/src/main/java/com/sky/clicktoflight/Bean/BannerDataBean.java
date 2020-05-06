package com.sky.clicktoflight.Bean;

import com.sky.clicktoflight.R;

import java.util.ArrayList;
import java.util.List;

public class BannerDataBean {

    private Integer imageRes;
    private String imageTitle;

    public Integer getImageRes() {
        return imageRes;
    }

    public void setImageRes(Integer imageRes) {
        this.imageRes = imageRes;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public BannerDataBean(Integer imageRes, String imageTitle) {
        this.imageRes = imageRes;
        this.imageTitle = imageTitle;
    }

    public static List<BannerDataBean> getImageData(){
        List<BannerDataBean> list = new ArrayList<>();
        list.add(new BannerDataBean(R.mipmap.pic1,"pic1"));
        list.add(new BannerDataBean(R.mipmap.pic2,"pic2"));
        return list;
    }
}
