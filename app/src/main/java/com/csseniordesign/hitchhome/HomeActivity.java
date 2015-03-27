package com.csseniordesign.hitchhome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class HomeActivity extends ActionBarActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignBtnEventHandlersHomePage();

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
    }

    public void assignBtnEventHandlersHomePage() {
        ImageButton searchButton = (ImageButton) findViewById(R.id.btnRideSearch);
        ImageButton driverButton = (ImageButton) findViewById(R.id.btnDriver);
        ImageButton accdetailsButton = (ImageButton) findViewById(R.id.btnAccountDetails);
        ImageButton placholderButton = (ImageButton) findViewById(R.id.btnActiveRide);

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
                Intent createRideIntent = new Intent(HomeActivity.this, MyRides.class);
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
        placholderButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //perform action
                //Hide buttons

                //Show login text fields

            }
        });

    }

}
