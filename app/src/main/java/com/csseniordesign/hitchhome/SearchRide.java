package com.csseniordesign.hitchhome;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.software.shell.fab.ActionButton;

import java.util.ArrayList;

/**
 * Created by conne_000 on 3/6/2015.
 */
public class SearchRide extends ActionBarActivity implements AdapterView.OnItemClickListener {
    EditText myDate;
    ActionButton myFab;
    RecyclerView myRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_ride);

        doOnClickBindings();

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Search Ride");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.searchRecyclerView);
        //Improves performance since it doesn't change content
        recyclerView.setHasFixedSize(true);

        //Using linear layout
        RecyclerView.LayoutManager myLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(myLayoutManager);

        //Data to be displayed in adapter
        ArrayList<RideItem> ridesList = new ArrayList<RideItem>();

        AutoCompleteTextView autoCompView = (AutoCompleteTextView) findViewById(R.id.txtDestination);
        autoCompView.setAdapter(new CityStateAutoCompleteAdapter(this, R.layout.autocomplete_listitem));
        autoCompView.setThreshold(3);
        autoCompView.setOnItemClickListener(this);


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

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        String str = (String) adapterView.getItemAtPosition(position);
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();


    }

    protected void doOnClickBindings() {
        myDate = (EditText) findViewById(R.id.txtDate);
        myDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DatePickerFragment newFragment = new DatePickerFragment() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        //TODO --- Format date pretty :)
                        month = month + 1;
                        myDate.setText("" + month + "/" + day + "/" + year);
                    }
                };
                newFragment.show(getSupportFragmentManager(), "datePicker");
            }

        });

        myFab = (ActionButton) findViewById(R.id.abNewRide);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                animate();
            }
        });
    }

    private void animate() {
        RelativeLayout relLayout = (RelativeLayout) findViewById(R.id.RelativeLayoutSearchRide);
        //ScaleAnimation scale = new ScaleAnimation((float)1.0, (float)0.5, (float)1.0, (float)1.0);
        //scale.setFillAfter(true);
        //scale.setDuration(500);
        //relLayout.startAnimation(scale);
        relLayout.animate().translationY((float)-500);
        myFab.animate().translationY((float)-500);
    }



}