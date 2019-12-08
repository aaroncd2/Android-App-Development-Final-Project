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
    String[] chest = {"Chest Workouts"};
    String[] back = {"Back Workouts"};
    String[] legs = {"Leg Workouts"};
    String[] shoulders = {"Shoulder Workouts"};
    String[] cardio = {"Running", "Basketball", "Swimming"};

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
                break;
            case '1':
                spin.setAdapter(backAdapter);
                textView.setText("Back");
                imageView.setImageResource(R.drawable.chest_gym);
                break;
            case '2':
                spin.setAdapter(chestAdapter);
                textView.setText("Chest");
                imageView.setImageResource(R.drawable.chest_gym);
                break;
            case '3':
                spin.setAdapter(legsAdapter);
                textView.setText("Legs");
                imageView.setImageResource(R.drawable.legs_gym);
                break;
            case '4':
                spin.setAdapter(shouldersAdapter);
                textView.setText("Shoulders");
                imageView.setImageResource(R.drawable.bicep_gym);
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
        onSelectedSpinner();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }

    public void onSelectedSpinner(){
        ImageView imagePictureView = (ImageView) findViewById(R.id.displayInfoDetails);
        Spinner spinner = (Spinner) findViewById(R.id.displayInfoSpinner);
        String selection = spinner.getSelectedItem().toString();
        switch (selection){
            case "Bicep Workout":
                imagePictureView.setImageResource(R.drawable.bicep_workouts);
                break;
            case "Tricep Workout":
                imagePictureView.setImageResource(R.drawable.tricep_workouts);
                break;
            case "Chest Workouts":
                imagePictureView.setImageResource(R.drawable.chest_workouts);
                break;
            case "Back Workouts":
                imagePictureView.setImageResource(R.drawable.back_workouts);
                break;
            case "Leg Workouts":
                imagePictureView.setImageResource(R.drawable.leg_workouts);
                break;
            case "Shoulder Workouts":
                imagePictureView.setImageResource(R.drawable.shoulder_workouts);
                break;
            case "Running":
                imagePictureView.setImageResource(R.drawable.running_workouts);
                break;
            case "Basketball":
                imagePictureView.setImageResource(R.drawable.basketball_workouts);
                break;
            case"Swimming":
                imagePictureView.setImageResource(R.drawable.swimming_workouts);
                break;
            default:
                break;
        };
    }
}
