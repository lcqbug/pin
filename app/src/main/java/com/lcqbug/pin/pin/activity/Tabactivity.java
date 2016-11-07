package com.lcqbug.pin.pin.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lcqbug.pin.pin.R;
import com.lcqbug.pin.pin.util.LogUtils;
import com.shizhefei.view.indicator.FixedIndicatorView;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.viewpager.SViewPager;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 *
 */
@EActivity(R.layout.activity_tab)
public class Tabactivity extends BaseActivity {

    @ViewById(R.id.viewPager)
    SViewPager viewPager;

    @ViewById(R.id.indicator)
    FixedIndicatorView indicator;

    IndicatorViewPager indicatorViewPager;

    private int[] tabNames = {R.string.service, R.string.notice, R.string.about, };

    @AfterViews
    protected void build() {
//        super.build();
//        setTitle("欢迎使用");
//        setSubTitle(FinalString.MODEL_NAME.get(PINSCtrlApp_.getInstance_(context).g_nModel));
//        setSubTitle("最新消息..");
        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        justFor();
    }

    /**
     * 这个界面 是首先显示出来的,所以就不要延迟了..
     */
    void justFor() {

            indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
//            indicatorViewPager.setCurrentItem(4,true);
//            setTitle("信息");

//        indicatorViewPager.setOnIndicatorPageChangeListener(new IndicatorViewPager.OnIndicatorPageChangeListener() {
//            @Override
//            public void onIndicatorPageChange(int preItem, int currentItem) {
//                setTitle(tabNames[currentItem]);
//            }
//        });

        viewPager.setCanScroll(false);
        viewPager.setOffscreenPageLimit(5);
//        indicator.setOnItemSelectListener(new Indicator.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(View selectItemView, int select, int preSelect) {
//                setTitle(tabNames[select]);
//            }
//        });
    }


    private class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {

        private int[] tabIcons = {R.drawable.server_selector, R.drawable.notice_selector, R.drawable.other_selector,
                };

        public MyAdapter(FragmentManager fragmentManager)
        {
            super(fragmentManager);
        }



        @Override
        public int getCount() {
            return tabNames.length;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.indicator_navigate, container, false);
            }
            TextView textView = (TextView) convertView.findViewById(R.id.textview);
            textView.setText(tabNames[position]);
            textView.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[position], 0, 0);
            return convertView;
        }


        @Override
        public Fragment getFragmentForPage(int position) {
            switch (position) {

                case 0:
                    return FragmentFactory.buildServerFragment();//只有一个
                case 1:
                    return FragmentFactory.buildNoticeFragment();
                case 2:
//                    return ProtocolFactory.buildTestF();
                    return FragmentFactory.buildOtherFragment();

                default:
                    return new Fragment();
            }
        }
    }

    @Override
    protected void onDestroy() {
        LogUtils.e("-----------tab 被销毁了---------------");
        super.onDestroy();
    }

    /**
     * 就相当于
     *
     * @param intent
     */

    @Override
    protected void onNewIntent(Intent intent) {
        justFor();
        LogUtils.e("-----------NavigateActivity onNewIntent执行了---------------");
        super.onNewIntent(intent);
    }
}
