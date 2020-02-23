package com.example.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.java.R;

public class CustomDialog extends Dialog {

    private int mLauout;
    private Dialog mDialog;

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
            layoutInflater.inflate(R.layout.custom_dialog, null);
        } else {
            layoutInflater.inflate(mLauout, null);
        }
        mDialog = new CustomDialog(context, R.style.Theme_AppCompat_Dialog_Alert);

    }
}
