package com.example.gugymformation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class HoursActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hours);

        Calendar c = Calendar.getInstance();

        String sDate = c.get(Calendar.YEAR) + "-"
                + c.get(Calendar.MONTH)
                + "-" + c.get(Calendar.DAY_OF_MONTH)
                + " at " + c.get(Calendar.HOUR_OF_DAY)
                + ":" + c.get(Calendar.MINUTE);

        TextView gymStatusTextView = (TextView) findViewById(R.id.gymStatusTextView);
        TextView poolStatusTextView = (TextView) findViewById(R.id.poolStatusTextView);

        if(gymStatus(c))
        {
            gymStatusTextView.setText("GYM STATUS - OPEN");
        }
        else
        {
            gymStatusTextView.setText("GYM STATUS - CLOSED");
        }

    }

    public boolean gymStatus(Calendar c)
    {
        boolean status = false;
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        if(dayOfWeek >= 0 && dayOfWeek <= 5 && hour >= 6 && hour <= 22 && minute >= 0 && minute <= 60)
        {
            status = true;
        }
        else if(dayOfWeek >= 6 && dayOfWeek <= 7 && hour >= 6 && hour <= 22 && minute >= 0 && minute <= 60)
        {
            status = true;
        }
        return status;
    }
}
