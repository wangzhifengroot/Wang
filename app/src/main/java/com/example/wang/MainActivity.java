package com.example.wang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wang.test.TestActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        test = (Button) findViewById(R.id.test);
        test.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test:
                startActivity(new Intent(this, TestActivity.class));
                break;
        }
    }
}
