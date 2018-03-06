package com.makki.robomanager.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.makki.robomanager.R;

/**
 * @author Max.Popovych on 05.03.18.
 */

public class NavigationFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    public static NavigationFragment newInstance(){
        //TODO: --Use this to set arguments for the fragment
        //Bundle args = new Bundle();
        //args.putInt("someValue", value);
        //NavigationFragment fragment = new NavigationFragment();
        //fragment.setArguments(bundle);

        return new NavigationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_navigation, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment map = ((SupportMapFragment)getChildFragmentManager()
                .findFragmentById(R.id.map_container));
        map.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.e("TT", "SUCCESS?");
    }
}
