package com.example.wang.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.wang.utils.LogUtils;


public class BaseFragment extends Fragment {
    protected final String TAG = getClass().getSimpleName();
    private final FragmentActivity mActivity;

    public BaseFragment() {
        mActivity = getActivity();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.e("这是" + TAG + "Fragment");
    }

}
