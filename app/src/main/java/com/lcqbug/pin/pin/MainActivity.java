package com.lcqbug.pin.pin;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lcqbug.pin.pin.iterface.UIcallback;
import com.lcqbug.pin.pin.util.DialogUtil;
import com.lcqbug.pin.pin.util.Util;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textView = (TextView) findViewById(R.id.tv);
         tv1 = (TextView) findViewById(R.id.tv1);
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
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_dialog, null, false);
                TextView tv_msg = (TextView) view.findViewById(R.id.tv_msg);
                tv_msg.setText("内容 自定义");
                Button btn_ok = (Button) view.findViewById(R.id.btn_ok);
                Button btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
                btn_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Util.showToast(MainActivity.this,"click ok!");
                    }
                });
                btn_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Util.showToast(MainActivity.this,"click cancel!");

                    }
                });
                DialogUtil.showDialogCustomByView(MainActivity.this,view);
            }
        });
    }
}
