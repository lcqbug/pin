package com.lcqbug.pin.pin;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lcqbug.pin.pin.activity.BaseActivity;
import com.lcqbug.pin.pin.activity.Tabactivity;
import com.lcqbug.pin.pin.activity.Tabactivity_;
import com.lcqbug.pin.pin.iterface.UIcallback;
import com.lcqbug.pin.pin.util.DialogUtil;
import com.lcqbug.pin.pin.util.LogUtils;
import com.lcqbug.pin.pin.util.Util;

public class MainActivity extends BaseActivity {
    TextView textView;
    TextView tv1;
    TextView tv2;
    Button btnJump;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textView = (TextView) findViewById(R.id.tv);
         tv1 = (TextView) findViewById(R.id.tv1);
         tv2 = (TextView) findViewById(R.id.tv2);
        btnJump = (Button) findViewById(R.id.btn_jump);
        btnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Tabactivity_.class));
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.showDialog(MainActivity.this, "", " ", "ok", "cancel", new UIcallback() {
                    @Override
                    public void clickok() {
                        Util.showToast(MainActivity.this,"点击了ok");
                    }

                    @Override
                    public void clickcancel() {
                        Util.showToast(MainActivity.this,"点击了cancel");
                    }
                });
            }
        });


        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_dialog, null, false);
                DialogUtil.showDialogCustomByView(MainActivity.this,inflate, new UIcallback() {
                    @Override
                    public void clickok() {
                        LogUtils.e("ok");
                    }

                    @Override
                    public void clickcancel() {
                        LogUtils.e("cancel");
                    }
                });
            }
        });


        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.showDialogCustomByid(MainActivity.this,R.layout.custom_dialog, new UIcallback() {
                    @Override
                    public void clickok() {
                        LogUtils.e("ok");
                        Util.showToast(MainActivity.this,"okokok");
                    }

                    @Override
                    public void clickcancel() {
                        LogUtils.e("cancel");
                        Util.showToast(MainActivity.this,"cancel cancel");
                    }
                });
            }
        });
    }
}
