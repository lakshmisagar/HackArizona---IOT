package planyourtrip.com.planyourtrip.View;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.gms.ads.mediation.OnContextChangedListener;

import java.text.DateFormat;
import java.util.Calendar;

import planyourtrip.com.planyourtrip.Model.AirportDetails;
import planyourtrip.com.planyourtrip.Network.DataProvider;
import planyourtrip.com.planyourtrip.R;

/**
 * Created by Lakshmisagar on 1/14/2017.
 */

public class FlightActivity extends AppCompatActivity implements AnimationListener, View.OnClickListener, DatePickerDialog.OnDateSetListener{
    Animation slideLeft, slideRight, slideTop, slideBottom;
    RelativeLayout src,dst;
    TextView Seldate;
    Button search;

    EditText srcInput;
    EditText destInput;
    String departureDate;
    AirportsAdapter airportsAdapter;
    ListView srcListView;
    ListView destListView;

    String srcAirportCode;
    String destAirportCode;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);
        src = (RelativeLayout) findViewById(R.id.src);
        dst = (RelativeLayout) findViewById(R.id.dst);
        Seldate = (TextView) findViewById(R.id.selcted_date);
        search = (Button) findViewById(R.id.search);
        search.setOnClickListener(this);
        srcListView = (ListView) findViewById(R.id.srcAirportsList);
        destListView = (ListView) findViewById(R.id.destAirportsList);
        srcInput = (EditText) findViewById(R.id.source);
        srcInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() < 1){
                    srcListView.setVisibility(View.GONE);

                }
                Response.ErrorListener errorListener = new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                };

                Response.Listener<AirportDetails[]> listener = new Response.Listener<AirportDetails[]>() {
                    @Override
                    public void onResponse(final AirportDetails[] response) {
                        Log.d("Response", "Flights Received");
                        if(airportsAdapter == null){
                            airportsAdapter = new AirportsAdapter(getApplicationContext(), R.layout.airport_list_item, response);
                        } else {
                            airportsAdapter.setAirports(response);
                        }
                        srcListView.setVisibility(View.VISIBLE);
                        srcListView.setFocusable(true);
                        srcListView.bringToFront();
                        srcListView.setAdapter(airportsAdapter);
                        srcListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                                srcAirportCode = response[position].getValue();
                                srcInput.setText(srcAirportCode);
                                srcListView.setVisibility(View.GONE);
                            }
                        });
                    }
                };

                DataProvider.getInstance(getApplicationContext()).getAirports(charSequence.toString(), errorListener, listener);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        destInput = (EditText) findViewById(R.id.destination);
        destInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() < 1){
                    destListView.setVisibility(View.GONE);

                }

                Response.ErrorListener errorListener = new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                };

                Response.Listener<AirportDetails[]> listener = new Response.Listener<AirportDetails[]>() {
                    @Override
                    public void onResponse(final AirportDetails[] response) {
                        Log.d("Response", "Flights Received");
                        if(airportsAdapter == null){
                            airportsAdapter = new AirportsAdapter(getApplicationContext(), R.layout.airport_list_item, response);
                        } else {
                            airportsAdapter.setAirports(response);
                        }
                        destListView.setVisibility(View.VISIBLE);
                        destListView.setFocusable(true);
                        destListView.bringToFront();

                        destListView.setAdapter(airportsAdapter);
                        destListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                                destAirportCode = response[pos].getValue();
                                destInput.setText(destAirportCode);
                                destListView.setVisibility(View.GONE);
                            }
                        });
                    }
                };

                DataProvider.getInstance(getApplicationContext()).getAirports(charSequence.toString(), errorListener, listener);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
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

    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int date) {
        departureDate = String.valueOf(year)+"-"+String.valueOf(month)+"-"+String.valueOf(date);

    }

}
