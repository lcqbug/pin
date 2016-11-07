package com.lcqbug.pin.pin.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.lcqbug.pin.pin.R;
import com.umeng.analytics.MobclickAgent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public abstract class BaseFragment extends Fragment {

    protected Activity context;
    protected LayoutInflater layoutInflater;
    Toolbar toolbar;
    protected TextView titleTv;
    protected TextView subTitleTv;

    protected void build() {
        toolbar = (Toolbar) context.findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        titleTv = (TextView) toolbar.findViewById(R.id.toolbar_title);
        subTitleTv = (TextView) toolbar.findViewById(R.id.toolbar_subtitle);
//        setStatusBarStyle();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        layoutInflater = LayoutInflater.from(context);
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(getClass().getSimpleName()); //统计页面，"MainScreen"为页面名称，可自定义
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(getClass().getSimpleName());
    }

    @Override
    public void onDestroy() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        super.onDestroy();
    }
}
