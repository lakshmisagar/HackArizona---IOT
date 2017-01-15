package planyourtrip.com.planyourtrip.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import planyourtrip.com.planyourtrip.Model.AirportDetails;
import planyourtrip.com.planyourtrip.Model.Airports;
import planyourtrip.com.planyourtrip.R;

/**
 * Created by "nithesh" on 1/14/2017.
 */

public class AirportsAdapter extends BaseAdapter {

    Context context;
    AirportDetails[] airports;
    int layoutResourceId;
    public AirportsAdapter(Context context, int resource, AirportDetails[] objects) {
        this.context = context;
        airports = objects;
        layoutResourceId = resource;
    }

    public void setAirports(AirportDetails[] airports){
        this.airports = airports;
    }
    @Override
    public int getCount() {
        return airports.length;
    }

    @Override
    public Object getItem(int i) {
        return airports[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layoutResourceId, parent, false);
        }
        TextView airportText = (TextView) convertView.findViewById(R.id.airport_item);
        airportText.setText(airports[position].getLabel());
        return convertView;
    }
}
