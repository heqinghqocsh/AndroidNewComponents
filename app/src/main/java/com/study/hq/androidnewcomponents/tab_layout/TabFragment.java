package com.study.hq.androidnewcomponents.tab_layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.study.hq.androidnewcomponents.R;


/**
 * Created on 2016/9/20.
 *
 * @description
 */
public class TabFragment extends Fragment{
    private TextView mTip;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_layout, null);
        mTip = (TextView)view.findViewById(R.id.tip);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        String title = getArguments().getString("title","");
        setTip(title);
    }

    public void setTip(String tip){
        mTip.setText(tip);
    }


}
