package com.zhy.weinews.util;

import android.content.Context;
import android.widget.Toast;

import com.zhy.weinews.app.App;


/**
 * Created by codeest on 2016/8/4.
 */
public class ToastUtil {

    static ToastUtil td;

    public static void show(int resId) {
        show(App.getInstance().getString(resId));
    }

    public static void show(String msg) {
        if (td == null) {
            td = new ToastUtil(App.getInstance());
        }
        td.setText(msg);
        td.create().show();
    }

    public static void shortShow(String msg) {
        if (td == null) {
            td = new ToastUtil(App.getInstance());
        }
        td.setText(msg);
        td.createShort().show();
    }


    Context context;
    Toast toast;
    String msg;

    public ToastUtil(Context context) {
        this.context = context;
    }

    public Toast create() {
        return Toast.makeText(context,msg,Toast.LENGTH_LONG);
    }

    public Toast createShort() {
        return Toast.makeText(context,msg,Toast.LENGTH_SHORT);
    }

    public void show() {
        if (toast != null) {
            toast.show();
        }
    }

    public void setText(String text) {
        msg = text;
    }
}
