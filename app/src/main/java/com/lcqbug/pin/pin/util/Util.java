package com.lcqbug.pin.pin.util;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.lcqbug.pin.pin.MainApplication;

/**
 * Created by andy on 2016/10/11 0011.
 */
public class Util {
    private static Toast toast;

    public static void showToast(Context context, String content) {
        if (toast == null) {
            toast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }
    public static Application getApplication() {
        return MainApplication.getInstance();
    }

}
