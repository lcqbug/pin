package com.lcqbug.pin.pin.activity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * Created by xuding on 2016/7/13.
 */
public class BaseDialogFragment extends android.app.DialogFragment {

    protected Activity context;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getActivity();
        Dialog dialog = getDialog();
        if(dialog!=null) {
            getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
            getDialog().setCanceledOnTouchOutside(false);
        }
    }

}
