package planyourtrip.com.planyourtrip.Network;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

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

    public void getFlights(){
        String  getFlightsUri = CustomUri.FlightsUri.getExtensiveQueryUrl().toString();
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Response", "Recieved error");
            }
        };

        Response.Listener<FlightResponse> listener = new Response.Listener<FlightResponse>() {
            @Override
            public void onResponse(FlightResponse response) {
                Log.d("Response", "Recieved response");
            }
        };
        GsonRequest<FlightResponse> getFlightsRequest = new GsonRequest<>(Request.Method.GET, FlightResponse.class, getFlightsUri,  errorListener, listener);
        getRequestQueue().add(getFlightsRequest);
    }
    private RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context);
        }
        return requestQueue;
    }
}
