package com.example.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.java.R;

public class CustomDialog extends Dialog {

    private int mLauout;
    private View mView;
    private Window mWindow;

    public CustomDialog(@NonNull Context context) {
        super(context);
        init(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        init(context);
    }

    protected CustomDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        if (mLauout == 0) {
            mView=  layoutInflater.inflate(R.layout.custom_dialog, null);
        } else {
            mView = layoutInflater.inflate(mLauout, null);
        }
        mWindow = getWindow();
        mWindow.setGravity(Gravity.CENTER);
        setContentView(mView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        initView(mView);
        setCanceledOnTouchOutside(true);//点击外部Dialog消失

    }

    private void initView(View view){
        TextView title = view.findViewById(R.id.title);
    }

    public void show(){
       super.show();
    }

}
