package com.lcqbug.pin.pin.util;

import android.util.Log;

/**
 * Created by lcqbug on 2016/10/12 0012.
 * Log 工具
 * 要求能 显示出当前 包名 类名
 * 调试的时候显示  发布的时候不显示
 */
public class LogUtils {
    private static final boolean isDebug = true;

    private static String packageName = Util.getApplication().getPackageName();
    private static String tag = "lc----"+packageName;

    public static void e(String s){
       if (isDebug){
           Log.e(tag,s);
       }
    }
}
