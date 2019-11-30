package com.example.gugymformation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class HoursActivity extends AppCompatActivity {
    final String TAG = "HoursActivityTag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hours);

        ArrayList<String> locations = new ArrayList<>();
        locations.add("Gym");
        locations.add("Pool");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                locations);
        Spinner spinner = findViewById(R.id.choiceSpinner);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setHours();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // do nothing
            }
        });

    }

    private void setHours(){
        Spinner spinner = findViewById(R.id.choiceSpinner);
        TextView hoursView = findViewById(R.id.hoursTextView);
        String selection = spinner.getSelectedItem().toString();
        switch (selection){
            case "Gym":
                String gymHours = "";
                gymHours += "Monday - Thursday...: 6am - 11pm\n";
                gymHours += "Friday..............: 6am - 10pm\n";
                gymHours += "Saturday............: 9am - 6pm\n";
                gymHours += "Sunday..............: 9am - 10pm\n";
                hoursView.setText(gymHours);
                break;
            case "Pool":
                String hours = "";
                hours += "Monday - Thursday...: 6 - 8am, 11am - 10pm\n";
                hours += "Friday..............: 6 - 8am, 11am - 9pm\n";
                hours += "Saturday............: 11am - 5pm\n";
                hours += "Sunday..............: 11am - 9pm\n";
                hoursView.setText(hours);
                break;
            default:
                break;
        };
    }
}