package com.sky.clicktoflight.View;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sky.clicktoflight.R;
import com.sky.clicktoflight.SearchActivity;
import com.sky.clicktoflight.utils.ImmersionBarUtils;

public class HomeFragment extends Fragment {

    private TextView tv_search;
    private Drawable drawable_search;
    private ImmersionBarUtils immersionBarUtils;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        immersionBarUtils = new ImmersionBarUtils();
        immersionBarUtils.ImmersionBarUtil(getActivity(),R.id.view_bar);

        tv_search = view.findViewById(R.id.tv_search);
        drawable_search = view.getResources().getDrawable(R.drawable.ic_search_dark_gray_24dp);


        drawable_search.setBounds(17, 3, 67, 55);
        tv_search.setCompoundDrawables(drawable_search, null, null ,null);

        tv_search.setOnClickListener(searchListener);
    }

    private View.OnClickListener searchListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent search_intent = new Intent(view.getContext(), SearchActivity.class);
            startActivity(search_intent);
        }
    };
}
