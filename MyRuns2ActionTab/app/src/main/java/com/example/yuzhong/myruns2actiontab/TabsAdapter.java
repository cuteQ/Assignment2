package com.example.yuzhong.myruns2actiontab;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Yuzhong on 2016/4/7.
 */
public class TabsAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> fragments;

    public static final int START = 0;
    public static final int HISTORY = 1;
    public static final int SETTINGS = 2;
    public static final String UI_TAB_START = "START";
    public static final String UI_TAB_HISTORY = "HISTORY";
    public static final String UI_TAB_SETTINGS = "SETTINGS";

    public TabsAdapter(FragmentManager fm, ArrayList<Fragment> fragments){
        super(fm);
        this.fragments = fragments;
    }

    public Fragment getItem(int pos){
        return fragments.get(pos);
    }

    public CharSequence getPageTitle(int position) {
        switch (position) {
            case START:
                return UI_TAB_START;
            case HISTORY:
                return UI_TAB_HISTORY;
            case SETTINGS:
                return UI_TAB_SETTINGS;
            default:
                break;
        }
        return null;
    }

    public int getCount() {
        return fragments.size();
    }
}
