package com.sky.clicktoflight;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MeFragment extends Fragment {
    private String content;

    public MeFragment(String content) {
        this.content = content;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        TextView tv_fm = view.findViewById(R.id.tv_fm);
        tv_fm.setText(content);
//        return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }
}
