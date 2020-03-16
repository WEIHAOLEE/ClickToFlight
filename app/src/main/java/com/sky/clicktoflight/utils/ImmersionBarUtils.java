package com.sky.clicktoflight.utils;

import android.app.Activity;
import android.content.Context;

import com.gyf.immersionbar.ImmersionBar;

public class ImmersionBarUtils {

    public void ImmersionBarUtil(Activity activity, int viewID) {
        ImmersionBar.with(activity)
                .statusBarView(viewID)
                .statusBarDarkFont(true)
                .init();
    }
}