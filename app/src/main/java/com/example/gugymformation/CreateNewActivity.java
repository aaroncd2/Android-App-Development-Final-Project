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
                        findViewById(R.id.bicepCurls).setVisibility(View.VISIBLE);
                        findViewById(R.id.barbellRow).setVisibility(View.GONE);
                        break;
                    case "Back":
                        findViewById(R.id.barbellRow).setVisibility(View.VISIBLE);
                        findViewById(R.id.bicepCurls).setVisibility(View.GONE);
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
}
