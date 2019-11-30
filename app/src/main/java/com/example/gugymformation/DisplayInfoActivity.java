package com.example.gugymformation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayInfoActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {
    String[] bicepTricep = {"Bicep Workout", "Tricep Workout"};
    String[] chest = {"Workout 1", "Workout 2"};
    String[] back = {"Workout 1", "Workout 2"};
    String[] legs = {"Workout 1", "Workout 2"};
    String[] shoulders = {"Workout 1", "Workout 2"};
    String[] cardio = {"Running", "Cycling", "Swimming"};
    char position = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);

        Intent intent = getIntent();
        if (intent != null) {
            position = intent.getCharExtra("typeOfWorkout", ' ');
        }

        TextView textView = (TextView) findViewById(R.id.displayInfoName);
        ImageView imageView = (ImageView) findViewById(R.id.displayInfoImage);
        ImageView imageView2 = (ImageView) findViewById(R.id.displayInfoDetails);

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.displayInfoSpinner);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter bicepTricepAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, bicepTricep);
        bicepTricepAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter backAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, back);
        backAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter chestAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, chest);
        chestAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter legsAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, legs);
        legsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter shouldersAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, shoulders);
        shouldersAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter cardioAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, cardio);
        cardioAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        switch (position) {
            case '0':
                spin.setAdapter(bicepTricepAdapter);
                textView.setText("Bicep and Triceps");
                imageView.setImageResource(R.drawable.bicep_gym);
                imageView2.setImageResource(R.drawable.bicep_picture);
                break;
            case '1':
                spin.setAdapter(backAdapter);
                textView.setText("Back");
                break;
            case '2':
                spin.setAdapter(chestAdapter);
                textView.setText("Chest");
                imageView.setImageResource(R.drawable.chest_gym);
                break;
            case '3':
                spin.setAdapter(legsAdapter);
                textView.setText("Legs");
                break;
            case '4':
                spin.setAdapter(shouldersAdapter);
                textView.setText("Shoulders");
                break;
            case '5':
                spin.setAdapter(cardioAdapter);
                textView.setText("Cardio");
                imageView.setImageResource(R.drawable.running_gym);
                break;
            default:
                break;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }
}
