package com.lcqbug.pin.pin.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lcqbug.pin.pin.R;
import com.lcqbug.pin.pin.fragment.BaseFragment;
import com.shizhefei.view.indicator.FixedIndicatorView;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.viewpager.SViewPager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Administrator on 2016/11/1 0001.
 */
@EFragment(R.layout.fragment_server)
public class ServerFragment extends BaseFragment {
    @ViewById(R.id.viewPager)
    SViewPager viewPager;

    @ViewById(R.id.indicator)
    FixedIndicatorView indicator;

    IndicatorViewPager indicatorViewPager;

    @AfterViews
    protected void build() {
        super.build();

//        setTitle(R.string.telemetry_result_title);
//        setSubTitle(FinalString.MODEL_NAME.get(PINSCtrlApp_.getInstance_(context).g_nModel));
        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
//        indicatorViewPager.setAdapter(new MyAdapter(context.getSupportFragmentManager()));

        justFor();
    }

    @Override
    public void onResume() {
        super.onResume();
//        ((BaseActivity) context).setTitle("信息");
    }

    @UiThread(delay = 300)
    void justFor() {
        indicatorViewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        viewPager.setCanScroll(false);
        viewPager.setOffscreenPageLimit(2);
    }

    private class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
        private int[] tabNames = {R.string.findcar, R.string.findperson};

        private int[] tabIcons = {R.drawable.findcar_selector, R.drawable.findp_selector};

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return tabNames.length;
        }


        /**
         * 放左边的
         *
         * @param position
         * @param convertView
         * @param container
         * @return
         */
        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.indicator_test_title, container, false);
            }
            TextView textView = (TextView) convertView.findViewById(R.id.textview);
            textView.setText(tabNames[position]);
            textView.setCompoundDrawablesWithIntrinsicBounds(tabIcons[position], 0, 0, 0);
            textView.setCompoundDrawablePadding(10);
            return convertView;
        }

        @Override
        public Fragment getFragmentForPage(int position) {
            switch (position) {
                case 0:
                    return FragmentFactory.buildFindCarFragment();
                case 1:
                    return FragmentFactory.buildFindPeopleFragment();


                default:
                    return new Fragment();
            }
        }
    }
}
