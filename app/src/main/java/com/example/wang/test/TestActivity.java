package com.example.wang.test;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


import com.example.wang.R;


public class TestActivity extends Activity {
    //  @BindView(R.id.net)
    private TextView net;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        net.setText("BindView setText net");
        // BindViewManager.bind(this);
    }
}
