package planyourtrip.com.planyourtrip.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

    public void flightTap(final View view) {
        ImageButton button = (ImageButton)findViewById(R.id.flight);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        final Intent intent=new Intent(view.getContext(),FlightActivity.class);
        myAnim.setDuration(1000);
        button.startAnimation(myAnim);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                view.clearAnimation();
                startActivity(intent);
            }
        }, myAnim.getDuration());
        button.startAnimation(myAnim);
    }
    public void carTap(final View view) {
        ImageButton button = (ImageButton)findViewById(R.id.car);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        myAnim.setDuration(1000);
        button.startAnimation(myAnim);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                view.clearAnimation();
                //startActivity(intent);
            }
        }, myAnim.getDuration());
    }
    public void trainTap(final View view) {
        ImageButton button = (ImageButton)findViewById(R.id.train);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        myAnim.setDuration(1000);
        button.startAnimation(myAnim);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                view.clearAnimation();
                //startActivity(intent);
            }
        }, myAnim.getDuration());
    }
    public void hotelTap(final View view) {
        ImageButton button = (ImageButton)findViewById(R.id.hotel);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);
        myAnim.setDuration(1000);
        button.startAnimation(myAnim);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                view.clearAnimation();
                //startActivity(intent);
            }
        }, myAnim.getDuration());
    }
}
