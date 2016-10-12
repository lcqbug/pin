package com.lcqbug.pin.pin.customview;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lcqbug.pin.pin.R;

/**
 * Created by Administrator on 2016/10/12 0012.
 */
public class CustomDialog extends AlertDialog {
    View view;
    Button btn_cancel,btn_ok;
    TextView title,msg; // 暂时没 title
    public CustomDialog(Context context) {
        super(context);
        view = LayoutInflater.from(context).inflate(R.layout.custom_dialog, null, false);
        btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
        btn_ok = (Button) view.findViewById(R.id.btn_ok);

        msg = (TextView) findViewById(R.id.tv_msg);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }

    @Override
    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public void setMsg(TextView msg) {
        this.msg = msg;
    }

    public void setMsg(String cont){
        msg.setText(cont);
    }

    public void setBtn_cancel(Button btn_cancel) {
        this.btn_cancel = btn_cancel;
    }

    public void setBtn_ok(Button btn_ok) {
        this.btn_ok = btn_ok;
    }

    public CustomDialog setOnOk(View.OnClickListener onClickListener) {
        btn_ok.setOnClickListener(onClickListener);
        return this;
    }
    public CustomDialog setOnCancle(View.OnClickListener onClickListener) {
        btn_cancel.setOnClickListener(onClickListener);
        return this;
    }

    /**
     * 万一是传值,取内容的--------中间应该是个 edittext...
     * @return
     */
    public String getMsg(){
        return msg.getText().toString().trim();
    }

    @Override
    public void show() {
        super.show();
    }
}
