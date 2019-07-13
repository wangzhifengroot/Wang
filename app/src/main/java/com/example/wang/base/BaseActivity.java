package com.example.wang.base;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.wang.net.netstate.NetCallback;
import com.example.wang.net.netstate.NetManager;
import com.example.wang.utils.LogUtils;


public abstract class BaseActivity extends FragmentActivity implements NetCallback {
    protected Context mApplicationContext;
    protected final String TAG = getClass().getSimpleName();
    public FragmentManager mSupportFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtils.e("这是" + TAG + "Activity");
        onCreateFirstMethods();
        super.onCreate(savedInstanceState);
        defaultInit();
        init();

    }

    /**
     * 获取继承者的Presenter
     */
    public abstract BasePresenter getPresenter();

    protected void init() {

    }

    private void defaultInit() {
        mApplicationContext = getApplicationContext();
        mSupportFragmentManager = getSupportFragmentManager();
        NetManager.getInstance().init(this);
        NetManager.getInstance().monitorNet(this);
    }

    /**
     * 在onCreate第一个走的方法
     */
    protected void onCreateFirstMethods() {

    }

    /**
     * 初始化变量、presneter、adapter
     */
    protected abstract void initVariables();

    /**
     * 加载数据，本地或者服务器获取
     */
    protected void loadData() {
    }

    /**
     * 销毁Presenter
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        BasePresenter presenter = getPresenter();
        presenter.onDestroy();
        NetManager.getInstance().onDestroy();
    }

    @Override
    public void wifi(String wifiState) {

    }

    @Override
    public void noWifi(String wifiState) {

    }

    @Override
    public void mobile(String netWorkState) {

    }

    @Override
    public void noNet() {

    }
}
