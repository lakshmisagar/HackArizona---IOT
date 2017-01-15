package planyourtrip.com.planyourtrip.View;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

import planyourtrip.com.planyourtrip.R;

/**
 * Created by Lakshmisagar on 1/14/2017.
 */

public class FlightActivity extends AppCompatActivity implements AnimationListener {
    Animation slideLeft, slideRight, slideTop, slideBottom;
    RelativeLayout src,dst;
    TextView Seldate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);
        src = (RelativeLayout) findViewById(R.id.src);
        dst = (RelativeLayout) findViewById(R.id.dst);
        Seldate = (TextView) findViewById(R.id.selcted_date);

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
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
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
}
