package com.csseniordesign.hitchhome;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;

public class HomeActivity extends ActionBarActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignBtnEventHandlersHomePage();

        /*toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().hide();*/
    }

    public void assignBtnEventHandlersHomePage() {
        BootstrapCircleThumbnail searchButton = (BootstrapCircleThumbnail) findViewById(R.id.searchRide);
        BootstrapCircleThumbnail driverButton = (BootstrapCircleThumbnail) findViewById(R.id.createRide);
        BootstrapCircleThumbnail accdetailsButton = (BootstrapCircleThumbnail) findViewById(R.id.accountDetails);
        //ImageButton myRidesButton = (ImageButton) findViewById(R.id.btnActiveRide);

        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent searchIntent = new Intent(HomeActivity.this, SearchRide.class);
                startActivity(searchIntent);
            }
        });


        driverButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //perform action
                //Hide buttons
                Intent createRideIntent = new Intent(HomeActivity.this, Driver.class);
                startActivity(createRideIntent);
                //Show login text fields

            }
        });
        accdetailsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //perform action
                Intent acctDetailsIntent = new Intent(HomeActivity.this, AccountDetails.class);
                startActivity(acctDetailsIntent);

            }
        });
        /*myRidesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //perform action
                //Hide buttons
                Intent myRidesIntent = new Intent(HomeActivity.this, MyRides.class);
                startActivity(myRidesIntent);
                //Show login text fields
            }
        });*/

    }

}
