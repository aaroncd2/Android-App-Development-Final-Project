package com.example.gugymformation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class WorkoutOpenHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "workoutDatabase";
    static final int DATABASE_VERSION = 1;

    static final String TABLE_WORKOUTS = "tableWorkouts";
    static final String ID = "_id"; // name id this way for use with adapters later
    static final String NAME = "name";
    static final String EXERCISES = "exercises";

    public WorkoutOpenHelper(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create table
        String sqlCreate = "CREATE TABLE " + TABLE_WORKOUTS + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME + " TEXT, " +
                EXERCISES + " TEXT)";
        db.execSQL(sqlCreate);
    }

    public Cursor getAllWorkoutsCursor() {
        // SELECT * FROM tableContacts
        String sqlSelect = "SELECT * FROM " + TABLE_WORKOUTS;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sqlSelect, null);
        return cursor;
    }

    public void insertWorkout(String name, String exercises) {
        String sqlInsert = "INSERT INTO " + TABLE_WORKOUTS + " VALUES(null, '" +
                name + "', '" +
                exercises + ")";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sqlInsert);
        db.close();
    }

    public void deleteIndividualNote(int id)
    {
        String sqlUpdate = "DELETE FROM " + TABLE_WORKOUTS + " WHERE " + ID + " = " + id;
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sqlUpdate);
        db.close();
    }

    public void deleteAllNotes() {
        String sqlDelete = "DELETE FROM " + TABLE_WORKOUTS;
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sqlDelete);
        db.close();
    }

    public Cursor getAllNotes()
    {
        String sqlSelect = "SELECT * FROM " + TABLE_WORKOUTS;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sqlSelect, null);
        return cursor;
    }

    public Cursor getSelectAllWorkoutsCursor() {
        String sqlSelect = "SELECT * FROM " + TABLE_WORKOUTS;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sqlSelect, null);
        return cursor;
    }

    public List<Workout> getSelectAllNotesList() {
        List<Workout> workoutList = new ArrayList<>();

        Cursor cursor = getSelectAllWorkoutsCursor();
        while (cursor.moveToNext())
        {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            ArrayList<Exercise> exercise = new ArrayList<>();
            Workout workout = new Workout(id, name, exercise);
            workoutList.add(workout);
        }
        return workoutList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
