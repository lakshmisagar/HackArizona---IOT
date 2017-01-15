package planyourtrip.com.planyourtrip.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.List;

import planyourtrip.com.planyourtrip.Model.AirportDetails;
import planyourtrip.com.planyourtrip.Model.Airports;
import planyourtrip.com.planyourtrip.Network.DataProvider;
import planyourtrip.com.planyourtrip.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void flightTap(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.flight);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };

        Response.Listener<List<AirportDetails>> listener = new Response.Listener<List<AirportDetails>>() {
            @Override
            public void onResponse(List<AirportDetails> response) {
                Log.d("Response", "Flights Received");
            }
        };
        DataProvider.getInstance(this).getAirports("Bo", errorListener, listener);
    }
    public void carTap(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.car);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }
    public void trainTap(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.train);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }
    public void hotelTap(View view) {
        ImageButton button = (ImageButton)findViewById(R.id.hotel);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        button.startAnimation(myAnim);
    }
}
