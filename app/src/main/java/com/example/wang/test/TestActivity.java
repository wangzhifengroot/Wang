package com.example.wang.test;


import android.os.Bundle;
import android.widget.TextView;

import com.example.wang.R;
import com.example.wang.base.BaseActivity;
import com.example.wang.base.BasePresenter;

public class TestActivity extends BaseActivity {

    private TextView net;
    private String TAG = "TestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initView() {
        net = (TextView) findViewById(R.id.net);
    }
}
