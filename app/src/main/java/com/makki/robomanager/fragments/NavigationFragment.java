package com.makki.robomanager.fragments;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.makki.robomanager.R;

/**
 * @author Max.Popovych on 05.03.18.
 */

public class NavigationFragment extends Fragment implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private LocationManager mLocation;
    private MarkerOptions mCurrentLoc;

    private static final MarkerOptions RZESZOW =
            new MarkerOptions().position(new LatLng(50.0409, 21.9993));

    public static NavigationFragment newInstance() {
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

        SupportMapFragment map = ((SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map_container));
        map.getMapAsync(this);

        mLocation = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        if (requestCode == 1) {
            mLocation.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1500, 0, NavigationFragment.this);
            mMap.setMyLocationEnabled(true);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.addMarker(RZESZOW);
    }

    @Override
    public void onLocationChanged(Location loc) {
        if (mCurrentLoc == null) {
            mCurrentLoc = new MarkerOptions().position(new LatLng(loc.getLatitude(), loc.getLongitude()));
        } else {
            mCurrentLoc.position(new LatLng(loc.getLatitude(), loc.getLongitude()));
        }

        if (mMap != null) {
            mMap.addMarker(mCurrentLoc);
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
