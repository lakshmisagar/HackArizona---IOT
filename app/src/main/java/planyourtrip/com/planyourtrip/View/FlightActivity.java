package planyourtrip.com.planyourtrip.View;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.text.DateFormat;
import java.util.Calendar;

import planyourtrip.com.planyourtrip.Model.AirportDetails;
import planyourtrip.com.planyourtrip.Network.DataProvider;
import planyourtrip.com.planyourtrip.R;

/**
 * Created by Lakshmisagar on 1/14/2017.
 */

public class FlightActivity extends AppCompatActivity implements AnimationListener, View.OnClickListener, DatePickerDialog.OnDateSetListener {
    Animation slideLeft, slideRight, slideTop, slideBottom;
    RelativeLayout src,dst;
    TextView Seldate;
    AppCompatSeekBar search;

    EditText srcInput;
    EditText destInput;
    String departureDate;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);
        src = (RelativeLayout) findViewById(R.id.src);
        dst = (RelativeLayout) findViewById(R.id.dst);
        Seldate = (TextView) findViewById(R.id.selcted_date);
        search = (AppCompatSeekBar) findViewById(R.id.search);
        search.setMax(10);
        search.setProgress(1);
        search.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //add here your implementation
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //add here your implementation
            }
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                if(progress==8){
                    Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(i);
                }
            }
        });

        srcInput = (EditText) findViewById(R.id.source);
        destInput = (EditText) findViewById(R.id.destination);
        slideLeft = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.anim_slide_left);
        slideLeft.setAnimationListener(this);

        slideRight = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.anim_slide_right);
        slideRight.setAnimationListener(this);

        slideTop = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.anim_slide_up);
        slideTop.setAnimationListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        src.startAnimation(slideLeft);
        dst.startAnimation(slideRight);
        Seldate.startAnimation(slideTop);
    }

    public void showDatePickerDialog(View v) {
        //DialogFragment newFragment = new DatePickerFragment();
        //newFragment.show(getSupportFragmentManager(), "datePicker");
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog pickerDialog = new DatePickerDialog(this, this, year, month, day);
        pickerDialog.show();
    }
    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public void onClick(View view) {
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };

        Response.Listener<AirportDetails[]> listener = new Response.Listener<AirportDetails[]>() {
            @Override
            public void onResponse(AirportDetails[] response) {
                Log.d("Response", "Flights Received");
            }
        };
        DataProvider.getInstance(this).getAirports("Bo", errorListener, listener);

    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
        departureDate = String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(date);
    }
}
