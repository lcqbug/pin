package com.lcqbug.pin.pin.activity;



import android.support.v4.app.Fragment;

import com.lcqbug.pin.pin.fragment.FindCarFragment;
import com.lcqbug.pin.pin.fragment.FindCarFragment_;
import com.lcqbug.pin.pin.fragment.FindPeopleFragment_;
import com.lcqbug.pin.pin.fragment.NoticeFragment_;
import com.lcqbug.pin.pin.fragment.OtherFragment_;

/**
 * 返回某某fragment
 */
public class FragmentFactory {


    /**
     * @return
     */
    public static Fragment buildFindCarFragment() {
        return FindCarFragment_.builder().build();
    }
    public static Fragment buildFindPeopleFragment() {
        return FindPeopleFragment_.builder().build();
    }

    public static Fragment buildServerFragment() {
        return ServerFragment_.builder().build();
    }
    public static Fragment buildNoticeFragment() {
        return NoticeFragment_.builder().build();
    }
    public static Fragment buildOtherFragment() {
        return OtherFragment_.builder().build();
    }

}
