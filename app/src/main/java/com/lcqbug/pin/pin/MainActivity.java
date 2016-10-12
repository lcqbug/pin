package com.lcqbug.pin.pin;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lcqbug.pin.pin.customview.CustomDialog;
import com.lcqbug.pin.pin.iterface.UIcallback;
import com.lcqbug.pin.pin.util.DialogUtil;
import com.lcqbug.pin.pin.util.LogUtil;
import com.lcqbug.pin.pin.util.Util;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView tv1;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textView = (TextView) findViewById(R.id.tv);
         tv1 = (TextView) findViewById(R.id.tv1);
         tv2 = (TextView) findViewById(R.id.tv2);
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
                        LogUtil.e("ok");
                    }

                    @Override
                    public void clickcancel() {
                        LogUtil.e("cancel");
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
                        LogUtil.e("ok");
                        Util.showToast(MainActivity.this,"okokok");
                    }

                    @Override
                    public void clickcancel() {
                        LogUtil.e("cancel");
                        Util.showToast(MainActivity.this,"cancel cancel");
                    }
                });
            }
        });
    }
}
