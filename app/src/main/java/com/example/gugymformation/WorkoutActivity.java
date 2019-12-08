package com.example.gugymformation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class WorkoutActivity extends AppCompatActivity {
    final WorkoutOpenHelper openHelper = new WorkoutOpenHelper(this);
    CursorAdapter cursorAdapter;
    String TAG = "WorkoutActivityTag: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        Button newWorkoutButton = (Button) findViewById(R.id.addNewButton);
        newWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkoutActivity.this, CreateNewActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        cursorAdapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                openHelper.getAllWorkoutsCursor(),
                // parallel arrays... first is names of columns to get data FROM
                new String[] {WorkoutOpenHelper.NAME},
                // ids of textviews to put data IN
                new int[] {android.R.id.text1},
                0
        );

        ListView workouts = (ListView) findViewById(R.id.workoutList);
        workouts.setAdapter(cursorAdapter);

        workouts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "before getting item:");
                SQLiteCursor cursor = (SQLiteCursor) parent.getItemAtPosition(position);
                ArrayList<String> exerciseNames = parseExercisesString(cursor);
                Intent intent = new Intent(WorkoutActivity.this, ViewWorkoutActivity.class);
                intent.putExtra("Exercises", exerciseNames);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            String title = data.getStringExtra("Title");
            ArrayList<Exercise> exercises = (ArrayList<Exercise>) data.getSerializableExtra("Exercises");
            String exercisesString = buildExercisesEntry(exercises);
            openHelper.insertWorkout(title, exercisesString);
            Cursor cursor = openHelper.getAllWorkoutsCursor();
            cursorAdapter.changeCursor(cursor);
        }
    }

    private String buildExercisesEntry(ArrayList<Exercise> exercises){
        String exerciseString = "";
        for(int i = 0; i < exercises.size(); i++){
            exerciseString += exercises.get(i).getName() + "-";
        }
        exerciseString += "'";
        return exerciseString;
    }

    private ArrayList<String> parseExercisesString(SQLiteCursor cursor){
        Log.d(TAG, "inParseExercises");
        ArrayList<String> exercises = new ArrayList<>();
        String exerciseString = cursor.getString(cursor.getColumnIndex("exercises"));
        String[] temp = exerciseString.split("-");
        for(int i = 0; i < temp.length; i++){
            exercises.add(temp[i]);
        }
        return exercises;
    }
}
