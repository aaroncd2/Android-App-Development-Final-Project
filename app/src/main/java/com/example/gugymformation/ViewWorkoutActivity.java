package com.example.gugymformation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewWorkoutActivity extends AppCompatActivity {
    ExerciseOpenHelper openHelper = new ExerciseOpenHelper(this);
    String TAG = "ViewWorkoutActivityTag: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workout);
        openHelper.populateTable();

        Intent intent = getIntent();
        Log.d(TAG, "Before intent");
        final ArrayList<String> exerciseStrings = (ArrayList<String>) intent.getSerializableExtra("Exercises");
        Log.d(TAG, "After intent");
        final ArrayList<Integer> exerciseImages = buildExercises(exerciseStrings);
        Log.d(TAG, "After build exercises");

        ListView listView = findViewById(R.id.exercisesList);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.activity_list_item,
                android.R.id.text1, exerciseStrings){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                String type = exerciseStrings.get(position);
                int icon = exerciseImages.get(position);

                TextView tv1 = (TextView) view.findViewById(android.R.id.text1);
                tv1.setTextSize(24);
                tv1.setText(type);
                ImageView iv = (ImageView) view.findViewById(android.R.id.icon);
                iv.setImageResource(icon);
                return view;
            }
        };
        listView.setAdapter(arrayAdapter);

        Button back = findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private ArrayList<Integer> buildExercises(ArrayList<String> strings){
        ArrayList<Integer> exercises = new ArrayList<>();
        for(int i = 0; i < strings.size(); i++){
            Log.d(TAG, strings.get(i));
        }
        for(int i = 0; i < strings.size(); i++){
            Log.d(TAG, strings.get(i) +"|");
            Cursor cursor = openHelper.getExerciseCursor(strings.get(i));
            int index = cursor.getColumnIndex("imageResource");
            Log.d(TAG, index+"");
            cursor.moveToFirst();
            int image = cursor.getInt(index);
            exercises.add(image);
        }
        return exercises;
    }
}
