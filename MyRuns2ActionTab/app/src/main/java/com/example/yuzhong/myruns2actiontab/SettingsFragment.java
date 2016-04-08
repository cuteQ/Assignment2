package com.example.yuzhong.myruns2actiontab;

import android.app.Fragment;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.util.Log;
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

        //get preference data!!!!
        PreferenceScreen preferenceScreen = (PreferenceScreen)getPreferenceScreen();
        EditTextPreference res = (EditTextPreference) preferenceScreen.findPreference("edittext_preference");
        Log.d("Yuzhong", res.getTitle() + "");
    }
}

