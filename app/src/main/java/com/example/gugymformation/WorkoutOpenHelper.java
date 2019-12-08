package com.example.gugymformation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
