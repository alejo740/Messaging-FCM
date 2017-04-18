package com.edwin.cobos.appmessagingfcm.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.edwin.cobos.appmessagingfcm.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPlayServices();
    }

    @Override
    protected void onResume() {
        checkPlayServices();
        super.onResume();
    }

    private void checkPlayServices(){
        //GoogleApiAvailability.makeGooglePlayServicesAvailable();
    }
}
