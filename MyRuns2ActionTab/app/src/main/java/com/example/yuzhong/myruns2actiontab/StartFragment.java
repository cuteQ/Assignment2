package com.example.yuzhong.myruns2actiontab;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Yuzhong on 2016/4/7.
 */
public class StartFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        return  inflater.inflate(R.layout.start_fragment, container, false);
    }
}
