package com.lcqbug.pin.pin.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lcqbug.pin.pin.R;
import com.umeng.analytics.MobclickAgent;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
public abstract class BaseActivity extends AutoLayoutActivity {

    protected Activity context;
    protected LayoutInflater layoutInflater;

    protected ImageView backBtn;
    Toolbar toolbar;
    protected TextView titleTv;
    protected TextView subTitleTv;

    protected ImageView onoff;
    protected ImageView more;

    protected Handler baseHandler = new Handler(Looper.getMainLooper());

//    protected int userId = SharedPreferenceUtils.getInt(CommonConst.KEY_USER_ID);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;
        layoutInflater = LayoutInflater.from(context);
    }

    protected void build() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        titleTv = (TextView) toolbar.findViewById(R.id.toolbar_title);
        subTitleTv = (TextView) toolbar.findViewById(R.id.toolbar_subtitle);
        onoff = (ImageView) toolbar.findViewById(R.id.iv_onoff);
        more = (ImageView) toolbar.findViewById(R.id.iv_more);
        onoff.setVisibility(View.GONE);
        more.setVisibility(View.GONE);
        setStatusBarStyle();
    }

    public void setOnoffVisible(){
        onoff.setVisibility(View.VISIBLE);
    }
    public void setMoreVisible(){
        more.setVisibility(View.VISIBLE);
    }
    public  void setONOff(final Listener listener){

        onoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.clickonoff();
            }
        });
    }
    public  void setMore(final Listener listener){
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.clickmore();
            }
        });
    }

    public interface Listener{
        void clickonoff();
        void clickmore();


    }

    public void setTitle(CharSequence title) {
        titleTv.setText(title);
    }
    public void setMoreImageResource(int id) {
        more.setImageResource(id);
    }

    public void setONoffImageResource(int id) {
        onoff.setImageResource(id);
    }


    public void setTitle(int titleId) {
        titleTv.setText(titleId);
    }

    public void setSubTitle(CharSequence title) {
        subTitleTv.setText(title);
    }

    public void setSubTitle(int titleId) {
        subTitleTv.setText(titleId);
    }

    /**
     * 显示左上角的返回键
     */
    public void showBackBtn() {
        toolbar.setNavigationIcon(R.drawable.title_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * umeng
     */
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected void showToast(final int resId) {
        baseHandler.post(new Runnable() {
                             @Override
                             public void run() {
                                 Toast.makeText(context, resId,Toast.LENGTH_SHORT).show();
                             }
                         }
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void setStatusBarStyle() {
        //        Window window = getWindow();
//        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        ViewGroup mContentView = (ViewGroup) findViewById(Window.ID_ANDROID_CONTENT);
//        int statusBarHeight = getStatusBarHeight();
//        View mChildView = mContentView.getChildAt(0);
//        if (mChildView != null) {
//            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) mChildView.getLayoutParams();
//            if (lp != null && lp.topMargin < statusBarHeight && lp.height != statusBarHeight) {
//                ViewCompat.setFitsSystemWindows(mChildView, false);
//                lp.topMargin += statusBarHeight;
//                mChildView.setLayoutParams(lp);
//            }
//        }
//        View statusBarView = mContentView.getChildAt(0);
//        if (statusBarView != null && statusBarView.getLayoutParams() != null && statusBarView.getLayoutParams().height == statusBarHeight) {
//        } else {
//            statusBarView = new View(this);
//            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, statusBarHeight);
//            mContentView.addView(statusBarView, 0, lp);
//        }
//        statusBarView.setBackgroundColor(ContextCompat.getColor(this, R.color.green));

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            return;
        }
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        ViewGroup mContentView = (ViewGroup) findViewById(Window.ID_ANDROID_CONTENT);
        ViewGroup mContentParent = (ViewGroup) mContentView.getParent();
        View statusBarView = mContentParent.getChildAt(0);
        if (statusBarView != null && statusBarView.getLayoutParams() != null && statusBarView.getLayoutParams().height == getStatusBarHeight()) {
            statusBarView.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
            return;
        }
        statusBarView = new View(this);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                getStatusBarHeight());
        statusBarView.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        mContentParent.addView(statusBarView, 0, lp);
        View mChildView = mContentView.getChildAt(0);
        if (mChildView != null) {
            ViewCompat.setFitsSystemWindows(mChildView, false);
        }
    }

    private int getStatusBarHeight() {
        int resId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resId > 0) {
            return getResources().getDimensionPixelSize(resId);
        }
        return 0;
    }
}
