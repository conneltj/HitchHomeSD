package com.csseniordesign.hitchhome;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Tim on 3/23/2015.
 */
public class Driver extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver);

        //toolbar = (Toolbar) findViewById(R.id.app_bar);
        //setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
