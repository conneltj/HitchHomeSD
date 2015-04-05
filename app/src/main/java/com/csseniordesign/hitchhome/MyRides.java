package com.csseniordesign.hitchhome;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

/**
 * Created by conne_000 on 3/6/2015.
 */
public class MyRides extends ActionBarActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_rides);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("My Rides");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        //Improves performance since it doesn't change content
        recyclerView.setHasFixedSize(true);

        //Using linear layout
        RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(myLayoutManager);

        //Data to be displayed in adapter
        ArrayList<RideItem> ridesList = new ArrayList<RideItem>();

        ridesList.add(new RideItem(1, "Columbus", "$5.00", "April 11th, 2015","2:30 pm"));
        ridesList.add(new RideItem(2, "Toledo", "$3.50", "April 11th, 2015","1:00 pm"));
        ridesList.add(new RideItem(3, "Akron", "$6.00", "April 12th, 2015","11:30 am"));
        ridesList.add(new RideItem(4, "Canton", "$3.00", "April 12th, 2015","6:00 pm"));
        ridesList.add(new RideItem(5, "Cleveland", "$7.00", "April 13th, 2015","8:45 am"));

        //Create adapter
        RecyclerView.Adapter adapter = new MyCustomAdapter(MyRides.this, ridesList);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Adds item to action bar if present
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem editBtn = menu.findItem(R.id.action_edit);
        editBtn.setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handles actionbar clicks
        int id = item.getItemId();

        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}

