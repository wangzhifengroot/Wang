package com.example.net;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetUtils {
    private static NetUtils mNetUtils;
    private NetWorkStateReceiver mNetWorkStateReceiver;

    private NetUtils() {

    }

    public static NetUtils getInstance() {
        if (mNetUtils == null) {
            mNetUtils = new NetUtils();
        }
        return mNetUtils;
    }

    public boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    public void registerNetWorkState(Context context ,INetworkStateChanges iNetworkStateChanges) {
        if (mNetWorkStateReceiver == null) {
            mNetWorkStateReceiver = new NetWorkStateReceiver();
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        context.registerReceiver(mNetWorkStateReceiver, filter);
    }

    public void destroy(Context context) {
        context.unregisterReceiver(mNetWorkStateReceiver);
    }


}
