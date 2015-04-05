package com.csseniordesign.hitchhome;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by conne_000 on 4/4/2015.
 */
public class RideItem {
    public String destination;
    public String price;
    public String dateOfTrip;
    public String tripTime;
    public int rideID;

    public RideItem(int inputRideID, String inputDestination, String inputPrice, String inputDate, String inputTime) {
        rideID = inputRideID;
        destination = inputDestination;
        price = inputPrice;
        dateOfTrip = inputDate;
        tripTime = inputTime;
    }
}

class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.ViewHolder> implements View.OnClickListener,
        View.OnLongClickListener{

    private ArrayList<RideItem> mDataset;
    private static Context sContext;

    // Adapter's Constructor
    public MyCustomAdapter(Context context, ArrayList<RideItem> myDataset) {
        mDataset = myDataset;
        sContext = context;
    }

    // Create new views. This is invoked by the layout manager.
    @Override
    public MyCustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // Create a new view by inflating the row item xml.
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ride_result, parent, false);

        // Set the view to the ViewHolder
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    // Replace the contents of a view. This is invoked by the layout manager.
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mRideDestination.setText(mDataset.get(position).destination);
        holder.mRidePrice.setText(mDataset.get(position).price);
        holder.mRideDate.setText(mDataset.get(position).dateOfTrip);
        holder.mRideTime.setText(mDataset.get(position).tripTime);

        // Get element from your dataset at this position and set the text for the specified element
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    // Implement OnClick listener. The clicked item text is displayed in a Toast message.
    @Override
    public void onClick(View view) {
        ViewHolder holder = (ViewHolder) view.getTag();
        if (view.getId() == holder.mRidePrice.getId()) {
            Toast.makeText(sContext, holder.mRidePrice.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    // Implement OnLongClick listener. Long Clicked items is removed from list.
    @Override
    public boolean onLongClick(View view) {
        ViewHolder holder = (ViewHolder) view.getTag();
        if (view.getId() == holder.mRidePrice.getId()) {
            mDataset.remove(holder.getPosition());

            // Call this method to refresh the list and display the "updated" list
            notifyDataSetChanged();

            Toast.makeText(sContext, "Item " + holder.mRidePrice.getText() + " has been removed from list",
                    Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    // Create the ViewHolder class to keep references to your views
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mRideDestination;
        public TextView mRidePrice;
        public TextView mRideDate;
        public TextView mRideTime;

        /**
         * Constructor
         * @param v The container view which holds the elements from the row item xml
         */
        public ViewHolder(View v) {
            super(v);

            mRideDestination = (TextView) v.findViewById(R.id.txtRideDestination);
            mRidePrice = (TextView) v.findViewById(R.id.txtRidePrice);
            mRideDate = (TextView) v.findViewById(R.id.txtRideDate);
            mRideTime = (TextView) v.findViewById(R.id.txtRideTime);
        }
    }
}
