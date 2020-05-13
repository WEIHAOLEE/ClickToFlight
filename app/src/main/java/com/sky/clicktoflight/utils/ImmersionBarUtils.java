package com.sky.clicktoflight.utils;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.Fragment;

import com.gyf.immersionbar.ImmersionBar;

public class ImmersionBarUtils {

    public void ImmersionBarUtilFragment(Fragment fragment, int viewID) {
        ImmersionBar.with(fragment)
                .statusBarView(viewID)
                .statusBarDarkFont(true)
                .transparentNavigationBar()
                .init();
    }
    public void ImmersionBarUtilActivity(Activity activity, int viewID) {
        ImmersionBar.with(activity)
                .statusBarView(viewID)
                .statusBarDarkFont(true)
                .transparentNavigationBar()
                .init();
    }
}