package com.example.wang.test;


import android.app.Activity;
import android.os.Bundle;

import com.example.wang.R;
import com.example.widget.CustomDialog;


public class TestActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        CustomDialog customDialog = new CustomDialog(this);
        customDialog.show();


    }
}
