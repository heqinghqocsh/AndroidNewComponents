package com.study.hq.androidnewcomponents.tab_layout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.study.hq.androidnewcomponents.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2016/9/20.
 *
 * @description
 */
public class TabLayoutActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MyPagerAdapter myPagerAdapter;

    private List<Fragment> fragmentList;
    private List<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_activity_layout);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);//设置可滚动

        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        mTabLayout.setupWithViewPager(mViewPager);

        fragmentList = new ArrayList<>();
        titles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            titles.add("第" + (i + 1) + "个");
            TabFragment fragment = new TabFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title",titles.get(i));
            fragment.setArguments(bundle);
            fragmentList.add(fragment);
        }

        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        myPagerAdapter.fragmentTitle = titles;
        myPagerAdapter.fragmentList = fragmentList;

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                int position = tab.getPosition();
//                mViewPager.setCurrentItem(position,true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mViewPager.setAdapter(myPagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }


    private static final class MyPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList;
        private List<String> fragmentTitle;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = fragmentList.get(position % fragmentList.size());
            return fragment;
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }

    }

}
