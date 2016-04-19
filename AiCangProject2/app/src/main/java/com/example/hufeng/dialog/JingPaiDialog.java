package com.example.hufeng.dialog;

import android.app.Dialog;
import android.content.Context;

/**
 * Created by hufeng on 2016/4/19.
 */
public class JingPaiDialog  extends Dialog{
    public JingPaiDialog(Context context) {
        super(context);
    }

    public JingPaiDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected JingPaiDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


}
