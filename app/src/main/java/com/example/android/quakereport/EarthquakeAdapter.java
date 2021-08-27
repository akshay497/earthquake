package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";


    public EarthquakeAdapter(@NonNull Context context, @NonNull List<Earthquake> objects) {
        super(context, 0, objects);
    }


    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    @NonNull
    @Override

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemview=convertView;
        if(listitemview == null) {
            listitemview = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_listview, parent, false);
        }
        Earthquake currentEarthquake=getItem(position);

        TextView mmagnitudeView=(TextView)listitemview.findViewById(R.id.magnitude);
        mmagnitudeView.setText(currentEarthquake.getMagnitude());

        String originalLocation = currentEarthquake.getLocation();
        String primaryLocation;
        String locationOffset;
        if(originalLocation.contains(LOCATION_SEPARATOR))
        {
            String array[]=originalLocation.split(LOCATION_SEPARATOR);
            locationOffset=array[0] +LOCATION_SEPARATOR;
            primaryLocation=array[1];
        }
        else
        {
            locationOffset=getContext().getString(R.string.near_the);
            primaryLocation=originalLocation;
        }
        TextView primaryLocations=(TextView)listitemview.findViewById(R.id.primary_location) ;
        primaryLocations.setText(primaryLocation);
        TextView Locationoffset=(TextView)listitemview.findViewById(R.id.location_offset) ;
        Locationoffset.setText(locationOffset);




        Date dateObject = new Date(currentEarthquake.getDate());

        String formattedDate = formatDate(dateObject);
        TextView mdateView=(TextView)listitemview.findViewById(R.id.date);
        mdateView.setText(formattedDate);

        TextView mtime=(TextView)listitemview.findViewById(R.id.time);
        String formattedtime=formatTime(dateObject);
        mtime.setText(formattedtime);




        return listitemview;


    }
}
