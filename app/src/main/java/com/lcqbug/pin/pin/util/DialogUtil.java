package com.lcqbug.pin.pin.util;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lcqbug.pin.pin.MainActivity;
import com.lcqbug.pin.pin.R;
import com.lcqbug.pin.pin.iterface.UIcallback;

/**
 * Created by andy on 2016/10/11 0011.
 * 其中包括 快速 弹出一个 原生dialog(v7 包,要不低版本中的 样式太丑,辣眼睛)
 * 自定义一个布局
 */
public class DialogUtil {

    /**
     * 挺方便的调用系统 alertdialog 的工具类
     *
     * @param context
     * @param title
     * @param msg
     * @param ok
     * @param cancel
     * @param uIcallback
     */
    public static void showDialog(Context context, String title, String msg, String ok, String cancel, final UIcallback uIcallback) {

//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(msg)
                .setPositiveButton(ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //// TODO: 2016/10/11 0011
                        uIcallback.clickok();
                    }
                })
                .setNegativeButton(cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //// TODO: 2016/10/11 0011
                        uIcallback.clickcancel();
                    }
                })
                .show();
    }

    /**
     * 外界传入一个 layout id, 其中它的 id 必须都是 规定好的
     * @param context
     * @param viewid
     * @param uIcallback
     */
    public static void showDialogCustomByid(Context context, int viewid, final UIcallback uIcallback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = LayoutInflater.from(context).inflate(viewid,null,false);
        Button btn_ok = (Button) view.findViewById(R.id.btn_ok);
        Button btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
        TextView msg = (TextView) view.findViewById(R.id.tv_msg);
        msg.setText("---------自己修改这个方法--------");
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uIcallback.clickok();
                alertDialog.dismiss();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uIcallback.clickcancel();
                alertDialog.dismiss();
            }
        });

        alertDialog.show();

}

    /**
     * 外界传入一个 泵好的布局view, view中的id,也是写好的
     * @param context
     * @param inflate
     * @param uIcallback
     */
    public static void showDialogCustomByView(final Context context,View inflate, final UIcallback uIcallback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        TextView tv_msg = (TextView) inflate.findViewById(R.id.tv_msg);
        tv_msg.setText("内容 自定义");
        Button btn_ok = (Button) inflate.findViewById(R.id.btn_ok);
        Button btn_cancel = (Button) inflate.findViewById(R.id.btn_cancel);

        builder.setView(inflate);
        builder.setPositiveButton("----", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Util.showToast(context, "shishi jiu shihi");
            }
        });
        final AlertDialog alertDialog = builder.create();

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.showToast(context, "click ok!");
                uIcallback.clickok();
                alertDialog.dismiss();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.showToast(context, "click cancel!");
                uIcallback.clickcancel();
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }

}
