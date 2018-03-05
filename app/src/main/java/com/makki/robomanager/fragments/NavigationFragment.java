package com.makki.robomanager.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makki.robomanager.R;

/**
 * @author Max.Popovych on 05.03.18.
 */

public class NavigationFragment extends Fragment {

    public static NavigationFragment newInstance(){
        //TODO: --Use this to set arguments for the fragment
        //Bundle args = new Bundle();
        //args.putInt("someValue", value);
        //NavigationFragment fragment = new NavigationFragment();
        //fragment.setArguments(bundle);

        return new NavigationFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation, container, false);
    }
}
