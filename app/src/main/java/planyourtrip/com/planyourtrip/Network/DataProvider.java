package planyourtrip.com.planyourtrip.Network;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import java.util.List;

import planyourtrip.com.planyourtrip.Model.AirportDetails;
import planyourtrip.com.planyourtrip.Model.Airports;
import planyourtrip.com.planyourtrip.Model.FlightResponse;

/**
 * Created by "nithesh" on 1/14/2017.
 */
public class DataProvider {

    private static Context context;
    private RequestQueue requestQueue;

    private static DataProvider sInstance;

    public static DataProvider getInstance(Context context) {
        if(sInstance == null){
            sInstance = new DataProvider(context);;
        }

        return sInstance;
    }


    private DataProvider(Context context) {
        this.context = context;
    }

    public void getFlights(String originCityCode, String destCityCode, String departDate, String returnDate, int priceLimit, Response.ErrorListener errorListener, Response.Listener<FlightResponse> listener){
        String  getFlightsUri = CustomUri.FlightsUri.getExtensiveQueryUrl(originCityCode, destCityCode, departDate, returnDate, priceLimit).toString();
        GsonRequest<FlightResponse> getFlightsRequest = new GsonRequest<>(Request.Method.GET, FlightResponse.class, getFlightsUri,  errorListener, listener);
        getRequestQueue().add(getFlightsRequest);
    }

    public void getOutGoingFlights(String originCityCode, String startDate, String endDate, int priceLimit, boolean oneWay, Response.ErrorListener errorListener, Response.Listener<FlightResponse> listener){
        String getOutgoingFlightUri = CustomUri.FlightsUri.getInspirationQueryUrl(originCityCode, startDate, endDate, priceLimit, oneWay).toString();
        GsonRequest<FlightResponse> getOutFlights = new GsonRequest<>(Request.Method.GET, FlightResponse.class, getOutgoingFlightUri, errorListener, listener);
        getRequestQueue().add(getOutFlights);
    }

    public void getAirports(String searchTerm, Response.ErrorListener errorListener, Response.Listener<List<AirportDetails>> listener){
        String getAirports = CustomUri.FlightsUri.getAirports(searchTerm).toString();
        GsonRequest<Airports> getAirportsRequest = new GsonRequest<>(Request.Method.GET, Airports.class, getAirports, errorListener, listener);
        getRequestQueue().add(getAirportsRequest);
    }
    private RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }
}
