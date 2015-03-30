package com.csseniordesign.hitchhome;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Tim on 3/23/2015.
 */
public class Driver extends ActionBarActivity implements AdapterView.OnItemClickListener{
    EditText myDate;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver);

        doOnClickBindings();

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Driver");

        AutoCompleteTextView autoCompDest = (AutoCompleteTextView) findViewById(R.id.driverDestination);
        autoCompDest.setAdapter(new CityStateAutoCompleteAdapter(this, R.layout.autocomplete_listitem));
        autoCompDest.setThreshold(3);
        //autoCompDest.getOnItemClickListener(this);
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
        myDate = (EditText) findViewById(R.id.txtDepartureDate);
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


            //Show signup textfields

        });
    }
}
