package com.makki.robomanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.makki.robomanager.fragments.NavigationFragment;

/**
 * @author Max.Popovych on 05.03.18.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, NavigationFragment.newInstance())
                .commit();
    }
}
