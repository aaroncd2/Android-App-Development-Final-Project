package com.example.gugymformation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class CreateNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new);

        final ArrayList<String> types = new ArrayList<>();
        types.add("Arms");
        types.add("Back");
        types.add("Cardio");
        types.add("Chest");
        types.add("Legs");
        types.add("Shoulders");
        final ArrayList<Integer> icons = new ArrayList<>();
        icons.add(R.drawable.bicep_icon);
        icons.add(R.drawable.back_icon);
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
                        toggleCardioVisibility(0);
                        toggleChestVisibility(0);
                        toggleLegsVisibility(0);
                        toggleShouldersVisibility(0);
                        break;
                    case "Back":
                        toggleArmsVisibility(0);
                        toggleBackVisibility(1);
                        toggleCardioVisibility(0);
                        toggleChestVisibility(0);
                        toggleLegsVisibility(0);
                        toggleShouldersVisibility(0);
                        break;
                    case "Cardio":
                        toggleArmsVisibility(0);
                        toggleBackVisibility(0);
                        toggleCardioVisibility(1);
                        toggleChestVisibility(0);
                        toggleLegsVisibility(0);
                        toggleShouldersVisibility(0);
                        break;
                    case "Chest":
                        toggleArmsVisibility(0);
                        toggleBackVisibility(0);
                        toggleCardioVisibility(0);
                        toggleChestVisibility(1);
                        toggleLegsVisibility(0);
                        toggleShouldersVisibility(0);
                        break;
                    case "Legs":
                        toggleArmsVisibility(0);
                        toggleBackVisibility(0);
                        toggleCardioVisibility(0);
                        toggleChestVisibility(0);
                        toggleLegsVisibility(1);
                        toggleShouldersVisibility(0);
                        break;
                    case "Shoulders":
                        toggleArmsVisibility(0);
                        toggleBackVisibility(0);
                        toggleCardioVisibility(0);
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
    }

    private void toggleArmsVisibility(int mode){
        if(mode == 1){ // set visible
            findViewById(R.id.bicepCurls).setVisibility(View.VISIBLE);
            findViewById(R.id.hammerCurls).setVisibility(View.VISIBLE);
            findViewById(R.id.seatedDumbbellPress).setVisibility(View.VISIBLE);
            findViewById(R.id.skullcrusher).setVisibility(View.VISIBLE);
            findViewById(R.id.tricepsPushdown).setVisibility(View.VISIBLE);
        } else { // set invisible
            findViewById(R.id.bicepCurls).setVisibility(View.GONE);
            findViewById(R.id.hammerCurls).setVisibility(View.GONE);
            findViewById(R.id.seatedDumbbellPress).setVisibility(View.GONE);
            findViewById(R.id.skullcrusher).setVisibility(View.GONE);
            findViewById(R.id.tricepsPushdown).setVisibility(View.GONE);
        }
    }

    private void toggleBackVisibility(int mode){
        if(mode == 1){ // set visible
            findViewById(R.id.barbellRow).setVisibility(View.VISIBLE);
            findViewById(R.id.back2).setVisibility(View.VISIBLE);
            findViewById(R.id.back3).setVisibility(View.VISIBLE);
            findViewById(R.id.back4).setVisibility(View.VISIBLE);
            findViewById(R.id.back5).setVisibility(View.VISIBLE);
        } else { // set invisible
            findViewById(R.id.barbellRow).setVisibility(View.GONE);
            findViewById(R.id.back2).setVisibility(View.GONE);
            findViewById(R.id.back3).setVisibility(View.GONE);
            findViewById(R.id.back4).setVisibility(View.GONE);
            findViewById(R.id.back5).setVisibility(View.GONE);
        }
    }

    private void toggleCardioVisibility(int mode){
        if(mode == 1){ // set visible
            findViewById(R.id.cardio1).setVisibility(View.VISIBLE);
            findViewById(R.id.cardio2).setVisibility(View.VISIBLE);
            findViewById(R.id.cardio3).setVisibility(View.VISIBLE);
        } else { // set invisible
            findViewById(R.id.cardio1).setVisibility(View.GONE);
            findViewById(R.id.cardio2).setVisibility(View.GONE);
            findViewById(R.id.cardio3).setVisibility(View.GONE);
        }
    }

    private void toggleChestVisibility(int mode){
        if(mode == 1){ // set visible
            findViewById(R.id.chest1).setVisibility(View.VISIBLE);
            findViewById(R.id.chest2).setVisibility(View.VISIBLE);
            findViewById(R.id.chest3).setVisibility(View.VISIBLE);
        } else { // set invisible
            findViewById(R.id.chest1).setVisibility(View.GONE);
            findViewById(R.id.chest2).setVisibility(View.GONE);
            findViewById(R.id.chest3).setVisibility(View.GONE);
        }
    }

    private void toggleLegsVisibility(int mode){
        if(mode == 1){ // set visible
            findViewById(R.id.legs1).setVisibility(View.VISIBLE);
            findViewById(R.id.legs2).setVisibility(View.VISIBLE);
            findViewById(R.id.legs3).setVisibility(View.VISIBLE);
        } else { // set invisible
            findViewById(R.id.legs1).setVisibility(View.GONE);
            findViewById(R.id.legs2).setVisibility(View.GONE);
            findViewById(R.id.legs3).setVisibility(View.GONE);
        }
    }

    private void toggleShouldersVisibility(int mode){
        if(mode == 1){ // set visible
            findViewById(R.id.shoulders1).setVisibility(View.VISIBLE);
            findViewById(R.id.shoulders2).setVisibility(View.VISIBLE);
            findViewById(R.id.shoulders3).setVisibility(View.VISIBLE);
        } else { // set invisible
            findViewById(R.id.shoulders1).setVisibility(View.GONE);
            findViewById(R.id.shoulders2).setVisibility(View.GONE);
            findViewById(R.id.shoulders3).setVisibility(View.GONE);
        }
    }
}
