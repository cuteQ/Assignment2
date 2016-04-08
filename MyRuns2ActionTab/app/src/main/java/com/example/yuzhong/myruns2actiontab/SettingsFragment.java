package com.example.yuzhong.myruns2actiontab;

import android.app.Fragment;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Yuzhong on 2016/4/7.
 */
public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}

