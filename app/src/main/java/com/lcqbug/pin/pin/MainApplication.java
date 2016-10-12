package com.lcqbug.pin.pin;

import android.app.Application;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public class MainApplication extends Application {
    private static MainApplication INSTANCE;
    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        initSometing();
    }

    /**
     * 比如 数据库的初始化, 崩溃统计, imageloader 等等
     */
    private void initSometing() {
    }

    public static MainApplication getInstance() {
        return INSTANCE;
    }
}
