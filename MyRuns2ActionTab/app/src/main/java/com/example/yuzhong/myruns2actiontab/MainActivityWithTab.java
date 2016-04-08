package com.example.yuzhong.myruns2actiontab;

import android.app.Activity;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yuzhong.myruns2actiontab.view.SlidingTabLayout;

import java.util.ArrayList;

public class MainActivityWithTab extends Activity {
    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    private ArrayList<Fragment> mFragments;
    private TabsAdapter mTabsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_with_tab);

        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.three_tabs);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        mFragments = new ArrayList<>();
        mFragments.add(new StartFragment());
        mFragments.add(new HistoryFragment());
        mFragments.add(new SettingsFragment());

        mTabsAdapter = new TabsAdapter(getFragmentManager(), mFragments);
        mViewPager.setAdapter(mTabsAdapter);

        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(mViewPager);
    }
}
