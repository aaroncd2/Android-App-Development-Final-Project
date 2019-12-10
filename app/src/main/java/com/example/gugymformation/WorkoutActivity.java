package com.example.gugymformation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class WorkoutActivity extends AppCompatActivity {
    static final int LOGIN_REQUEST_CODE = 1;
    public String titleFromResult;
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

        final ListView workouts = (ListView) findViewById(R.id.workoutList);
        workouts.setAdapter(cursorAdapter);
        workouts.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        workouts.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {
                int numChecked = workouts.getCheckedItemCount();
                actionMode.setTitle(numChecked + " selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                MenuInflater menuInflater = getMenuInflater();
                menuInflater.inflate(R.menu.cam_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.deleteMenuItem:
                    WorkoutOpenHelper openHelper = new WorkoutOpenHelper(WorkoutActivity.this);
                    SparseBooleanArray checkedItemPositions = workouts.getCheckedItemPositions();
                    for(int i = 0; i < checkedItemPositions.size(); i++)
                    {
                        if(checkedItemPositions.valueAt(i))
                        {
                            int id = (int) cursorAdapter.getItemId(checkedItemPositions.keyAt(i));
                            openHelper.deleteIndividualNote(id);
                        }
                    }
                    Cursor cursor = openHelper.getSelectAllWorkoutsCursor();
                    cursorAdapter.changeCursor(cursor);
                    actionMode.finish();
                    return true;
            }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {

            }
        });

        workouts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "before getting item:");
                SQLiteCursor cursor = (SQLiteCursor) parent.getItemAtPosition(position);
                ArrayList<String> exerciseNames = parseExercisesString(cursor);
                String nameTitle = parseName(cursor);
                Intent intent = new Intent(WorkoutActivity.this, ViewWorkoutActivity.class);
                intent.putExtra("Title", nameTitle);
                intent.putExtra("Exercises", exerciseNames);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            titleFromResult = data.getStringExtra("Title");
            ArrayList<Exercise> exercises = (ArrayList<Exercise>) data.getSerializableExtra("Exercises");
            String exercisesString = buildExercisesEntry(exercises);
            openHelper.insertWorkout(titleFromResult, exercisesString);
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

    private String parseName(SQLiteCursor cursor)
    {
        String title = cursor.getString(cursor.getColumnIndex("name"));
        return  title;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.deleteItem:
                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(WorkoutActivity.this);
                alertBuilder.setTitle("Delete All Notes")
                        .setMessage("Are you sure you want to delete all notes?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                openHelper.deleteAllNotes();
                                Cursor cursor = openHelper.getAllNotes();
                                cursorAdapter.changeCursor(cursor);
                            }
                        })
                        .setNegativeButton("NO", null)
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
