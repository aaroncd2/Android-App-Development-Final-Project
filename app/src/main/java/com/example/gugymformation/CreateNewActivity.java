package com.example.gugymformation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);

        final ArrayList<String> types = new ArrayList<>();
        types.add("Arms");
        types.add("Back");
        types.add("Running");
        types.add("Swimming");
        types.add("Basketball");
        types.add("Chest");
        types.add("Legs");
        types.add("Shoulders");
        final ArrayList<Integer> icons = new ArrayList<>();
        icons.add(R.drawable.bicep_icon);
        icons.add(R.drawable.back_icon);
        icons.add(R.drawable.cardio_icon);
        icons.add(R.drawable.cardio_icon);
        icons.add(R.drawable.cardio_icon);
        icons.add(R.drawable.chest_icon);
        icons.add(R.drawable.legs_icon);
        icons.add(R.drawable.shoulder_icon);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.activity_list_item,
                android.R.id.text1, types){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                String type = types.get(position);
                int icon = icons.get(position);

                TextView tv1 = (TextView) view.findViewById(android.R.id.text1);
                tv1.setTextSize(24);
                tv1.setText(type);
                ImageView iv = (ImageView) view.findViewById(android.R.id.icon);
                iv.setImageResource(icon);
                return view;
            }
        };
        final Spinner spinner = findViewById(R.id.typeSpinner);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = types.get(position);
                switch (selected){
                    case "Arms":
                        toggleArmsVisibility(1);
                        toggleBackVisibility(0);
                        toggleRunningVisibility(0);
                        toggleSwimmingVisibility(0);
                        toggleBasketballVisibility(0);
                        toggleChestVisibility(0);
                        toggleLegsVisibility(0);
                        toggleShouldersVisibility(0);
                        break;
                    case "Back":
                        toggleArmsVisibility(0);
                        toggleBackVisibility(1);
                        toggleRunningVisibility(0);
                        toggleSwimmingVisibility(0);
                        toggleBasketballVisibility(0);
                        toggleChestVisibility(0);
                        toggleLegsVisibility(0);
                        toggleShouldersVisibility(0);
                        break;
                    case "Running":
                        toggleArmsVisibility(0);
                        toggleBackVisibility(0);
                        toggleRunningVisibility(1);
                        toggleSwimmingVisibility(0);
                        toggleBasketballVisibility(0);
                        toggleChestVisibility(0);
                        toggleLegsVisibility(0);
                        toggleShouldersVisibility(0);
                        break;
                    case "Swimming":
                        toggleArmsVisibility(0);
                        toggleBackVisibility(0);
                        toggleRunningVisibility(0);
                        toggleSwimmingVisibility(1);
                        toggleBasketballVisibility(0);
                        toggleChestVisibility(0);
                        toggleLegsVisibility(0);
                        toggleShouldersVisibility(0);
                        break;
                    case "Basketball":
                        toggleArmsVisibility(0);
                        toggleBackVisibility(0);
                        toggleRunningVisibility(0);
                        toggleSwimmingVisibility(0);
                        toggleBasketballVisibility(1);
                        toggleChestVisibility(0);
                        toggleLegsVisibility(0);
                        toggleShouldersVisibility(0);
                        break;
                    case "Chest":
                        toggleArmsVisibility(0);
                        toggleBackVisibility(0);
                        toggleRunningVisibility(0);
                        toggleSwimmingVisibility(0);
                        toggleBasketballVisibility(0);
                        toggleChestVisibility(1);
                        toggleLegsVisibility(0);
                        toggleShouldersVisibility(0);
                        break;
                    case "Legs":
                        toggleArmsVisibility(0);
                        toggleBackVisibility(0);
                        toggleRunningVisibility(0);
                        toggleSwimmingVisibility(0);
                        toggleBasketballVisibility(0);
                        toggleChestVisibility(0);
                        toggleLegsVisibility(1);
                        toggleShouldersVisibility(0);
                        break;
                    case "Shoulders":
                        toggleArmsVisibility(0);
                        toggleBackVisibility(0);
                        toggleRunningVisibility(0);
                        toggleSwimmingVisibility(0);
                        toggleBasketballVisibility(0);
                        toggleChestVisibility(0);
                        toggleLegsVisibility(0);
                        toggleShouldersVisibility(1);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // does not happen
            }
        });

        Button doneButton = (Button) findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText titleEditText = (EditText) findViewById(R.id.titleEditText);
                String title = titleEditText.getText().toString();
                if(title.equals("")){
                    Toast.makeText(CreateNewActivity.this, "Please enter a title", Toast.LENGTH_SHORT).show();
                } else {
                    ArrayList<Exercise> exercises =  getSelectedExercises();
                    Intent intent = new Intent();
                    intent.putExtra("Title", title);
                    intent.putExtra("Exercises", exercises);
                    setResult(1, intent);
                    finish();
                }
            }
        });
    }

    private void toggleArmsVisibility(int mode){
        if(mode == 1){ // set visible
            findViewById(R.id.arms1).setVisibility(View.VISIBLE);
            findViewById(R.id.arms2).setVisibility(View.VISIBLE);
            findViewById(R.id.arms3).setVisibility(View.VISIBLE);
            findViewById(R.id.arms4).setVisibility(View.VISIBLE);
            findViewById(R.id.arms5).setVisibility(View.VISIBLE);
            findViewById(R.id.arms6).setVisibility(View.VISIBLE);
        } else { // set invisible
            findViewById(R.id.arms1).setVisibility(View.GONE);
            findViewById(R.id.arms2).setVisibility(View.GONE);
            findViewById(R.id.arms3).setVisibility(View.GONE);
            findViewById(R.id.arms4).setVisibility(View.GONE);
            findViewById(R.id.arms5).setVisibility(View.GONE);
            findViewById(R.id.arms6).setVisibility(View.GONE);
        }
    }

    private void toggleBackVisibility(int mode){
        if(mode == 1){ // set visible
            findViewById(R.id.back1).setVisibility(View.VISIBLE);
            findViewById(R.id.back2).setVisibility(View.VISIBLE);
            findViewById(R.id.back3).setVisibility(View.VISIBLE);
        } else { // set invisible
            findViewById(R.id.back1).setVisibility(View.GONE);
            findViewById(R.id.back2).setVisibility(View.GONE);
            findViewById(R.id.back3).setVisibility(View.GONE);
        }
    }

    private void toggleRunningVisibility(int mode){
        if(mode == 1){ // set visible
            findViewById(R.id.running1).setVisibility(View.VISIBLE);
            findViewById(R.id.running2).setVisibility(View.VISIBLE);
            findViewById(R.id.running3).setVisibility(View.VISIBLE);
        } else { // set invisible
            findViewById(R.id.running1).setVisibility(View.GONE);
            findViewById(R.id.running2).setVisibility(View.GONE);
            findViewById(R.id.running3).setVisibility(View.GONE);
        }
    }

    private void toggleSwimmingVisibility(int mode){
        if(mode == 1){ // set visible
            findViewById(R.id.swimming1).setVisibility(View.VISIBLE);
            findViewById(R.id.swimming2).setVisibility(View.VISIBLE);
            findViewById(R.id.swimming3).setVisibility(View.VISIBLE);
            findViewById(R.id.swimming4).setVisibility(View.VISIBLE);
        } else { // set invisible
            findViewById(R.id.swimming1).setVisibility(View.GONE);
            findViewById(R.id.swimming2).setVisibility(View.GONE);
            findViewById(R.id.swimming3).setVisibility(View.GONE);
            findViewById(R.id.swimming4).setVisibility(View.GONE);
        }
    }
    private void toggleBasketballVisibility(int mode){
        if(mode == 1){ // set visible
            findViewById(R.id.basketball1).setVisibility(View.VISIBLE);
            findViewById(R.id.basketball2).setVisibility(View.VISIBLE);
            findViewById(R.id.basketball3).setVisibility(View.VISIBLE);
            findViewById(R.id.basketball4).setVisibility(View.VISIBLE);
        } else { // set invisible
            findViewById(R.id.basketball1).setVisibility(View.GONE);
            findViewById(R.id.basketball2).setVisibility(View.GONE);
            findViewById(R.id.basketball3).setVisibility(View.GONE);
            findViewById(R.id.basketball4).setVisibility(View.GONE);
        }
    }

    private void toggleChestVisibility(int mode){
        if(mode == 1){ // set visible
            findViewById(R.id.chest1).setVisibility(View.VISIBLE);
            findViewById(R.id.chest2).setVisibility(View.VISIBLE);
            findViewById(R.id.chest3).setVisibility(View.VISIBLE);
            findViewById(R.id.chest4).setVisibility(View.VISIBLE);
        } else { // set invisible
            findViewById(R.id.chest1).setVisibility(View.GONE);
            findViewById(R.id.chest2).setVisibility(View.GONE);
            findViewById(R.id.chest3).setVisibility(View.GONE);
            findViewById(R.id.chest4).setVisibility(View.GONE);
        }
    }

    private void toggleLegsVisibility(int mode){
        if(mode == 1){ // set visible
            findViewById(R.id.legs1).setVisibility(View.VISIBLE);
            findViewById(R.id.legs2).setVisibility(View.VISIBLE);
            findViewById(R.id.legs3).setVisibility(View.VISIBLE);
            findViewById(R.id.legs4).setVisibility(View.VISIBLE);
            findViewById(R.id.legs5).setVisibility(View.VISIBLE);
        } else { // set invisible
            findViewById(R.id.legs1).setVisibility(View.GONE);
            findViewById(R.id.legs2).setVisibility(View.GONE);
            findViewById(R.id.legs3).setVisibility(View.GONE);
            findViewById(R.id.legs4).setVisibility(View.GONE);
            findViewById(R.id.legs5).setVisibility(View.GONE);
        }
    }

    private void toggleShouldersVisibility(int mode){
        if(mode == 1){ // set visible
            findViewById(R.id.shoulders1).setVisibility(View.VISIBLE);
            findViewById(R.id.shoulders2).setVisibility(View.VISIBLE);
            findViewById(R.id.shoulders3).setVisibility(View.VISIBLE);
            findViewById(R.id.shoulders4).setVisibility(View.VISIBLE);
        } else { // set invisible
            findViewById(R.id.shoulders1).setVisibility(View.GONE);
            findViewById(R.id.shoulders2).setVisibility(View.GONE);
            findViewById(R.id.shoulders3).setVisibility(View.GONE);
            findViewById(R.id.shoulders4).setVisibility(View.GONE);
        }
    }
    private ArrayList<Exercise> getSelectedExercises(){
        ArrayList<Exercise> exercises = new ArrayList<>();
        ArrayList<CheckBox> boxes = getAllCheckBoxes();
        for(int i = 0; i < boxes.size(); i++){
            if(boxes.get(i).isChecked()){
                String name = boxes.get(i).getText().toString();
                String type = "";
                int image;
                if(i >= 0 && i <= 5) {
                    type = "Arms";
                    image = R.drawable.bicep_icon;
                } else if(i >= 6 && i <= 9){
                    type = "Back";
                    image = R.drawable.back_icon;
                } else if(i >= 10 && i <= 12){
                    type = "Running";
                    image = R.drawable.cardio_icon;
                } else if(i >= 13 && i <= 16){
                    type = "Swimming";
                    image = R.drawable.cardio_icon;
                } else if(i >= 16 && i <= 19){
                    type = "Basketball";
                    image = R.drawable.cardio_icon;
                } else if(i >= 20 && i <= 23){
                    type = "Chest";
                    image = R.drawable.chest_icon;
                } else if(i >= 24 && i <= 28){
                    type = "Legs";
                    image = R.drawable.legs_icon;
                } else {
                    type = "Shoulders";
                    image = R.drawable.shoulder_icon;
                }
                exercises.add(new Exercise(name, type, image));
            }
        }

        return exercises;
    }

    private ArrayList<CheckBox> getAllCheckBoxes(){
        ArrayList<CheckBox> boxes = new ArrayList<>();
        boxes.add((CheckBox)findViewById(R.id.arms1));
        boxes.add((CheckBox)findViewById(R.id.arms2));
        boxes.add((CheckBox)findViewById(R.id.arms3));
        boxes.add((CheckBox)findViewById(R.id.arms4));
        boxes.add((CheckBox)findViewById(R.id.arms5));
        boxes.add((CheckBox)findViewById(R.id.arms5));
        boxes.add((CheckBox)findViewById(R.id.arms6));
        boxes.add((CheckBox)findViewById(R.id.back1));
        boxes.add((CheckBox)findViewById(R.id.back2));
        boxes.add((CheckBox)findViewById(R.id.back3));
        boxes.add((CheckBox)findViewById(R.id.back4));
        boxes.add((CheckBox)findViewById(R.id.running1));
        boxes.add((CheckBox)findViewById(R.id.running2));
        boxes.add((CheckBox)findViewById(R.id.running3));
        boxes.add((CheckBox)findViewById(R.id.swimming1));
        boxes.add((CheckBox)findViewById(R.id.swimming2));
        boxes.add((CheckBox)findViewById(R.id.swimming3));
        boxes.add((CheckBox)findViewById(R.id.swimming4));
        boxes.add((CheckBox)findViewById(R.id.basketball1));
        boxes.add((CheckBox)findViewById(R.id.basketball2));
        boxes.add((CheckBox)findViewById(R.id.basketball3));
        boxes.add((CheckBox)findViewById(R.id.basketball4));
        boxes.add((CheckBox)findViewById(R.id.chest1));
        boxes.add((CheckBox)findViewById(R.id.chest2));
        boxes.add((CheckBox)findViewById(R.id.chest3));
        boxes.add((CheckBox)findViewById(R.id.chest4));
        boxes.add((CheckBox)findViewById(R.id.legs1));
        boxes.add((CheckBox)findViewById(R.id.legs2));
        boxes.add((CheckBox)findViewById(R.id.legs3));
        boxes.add((CheckBox)findViewById(R.id.legs4));
        boxes.add((CheckBox)findViewById(R.id.legs5));
        boxes.add((CheckBox)findViewById(R.id.shoulders1));
        boxes.add((CheckBox)findViewById(R.id.shoulders2));
        boxes.add((CheckBox)findViewById(R.id.shoulders3));
        boxes.add((CheckBox)findViewById(R.id.shoulders4));
        return boxes;
    }
}
