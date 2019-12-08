package com.example.gugymformation;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ExerciseOpenHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "exerciseDatabase";
    static final int DATABASE_VERSION = 1;

    static final String TABLE_EXERCISE = "tableExercises";
    static final String ID = "_id"; // name id this way for use with adapters later
    static final String NAME = "name";
    static final String TYPE = "type";
    static final String IMAGE_RESOURCE = "imageResource";
    String TAG = "ExerciseOpenHelperTag";

    public ExerciseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create table
        String sqlCreate = "CREATE TABLE " + TABLE_EXERCISE + "(" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME + " TEXT, " +
                TYPE + " TEXT, " +
                IMAGE_RESOURCE + " INTEGER)";
        db.execSQL(sqlCreate);
    }

    public void populateTable(){
        SQLiteDatabase db = getWritableDatabase();
        String sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Bicep Curls', 'Arms', " + R.drawable.bicep_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Hammer Curls', 'Arms', " + R.drawable.bicep_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Seated Dumbbell Press', 'Arms', " + R.drawable.bicep_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Skullcrusher', 'Arms', " + R.drawable.bicep_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Triceps Pushdown', 'Arms', " + R.drawable.bicep_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Barbell Row', 'Back', " + R.drawable.back_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Chin Up', 'Back', " + R.drawable.back_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Deadlift', 'Back', " + R.drawable.back_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Indoor Track', 'Cardio', " + R.drawable.cardio_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Treadmill', 'Cardio', " + R.drawable.cardio_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Stationary Bike', 'Cardio', " + R.drawable.cardio_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Bench Press', 'Chest', " + R.drawable.chest_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Dumbbell Press', 'Chest', " + R.drawable.chest_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Incline Bench Press', 'Chest', " + R.drawable.chest_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Leg Press', 'Legs', " + R.drawable.legs_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Squats', 'Legs', " + R.drawable.legs_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Calf Raises', 'Legs', " + R.drawable.legs_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Shoulder Press', 'Shoulders', " + R.drawable.shoulder_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Barbell Row', 'Shoulders', " + R.drawable.shoulder_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Side Lateral Raise', 'Shoulders', " + R.drawable.shoulder_icon + ")";
        db.execSQL(sqlInsert);
    }

    public Cursor getExerciseCursor(String name) {
        String sqlSelect = "SELECT " + IMAGE_RESOURCE + " FROM " + TABLE_EXERCISE + " WHERE " + NAME + "='" + name + "'";
        Log.d(TAG, sqlSelect);
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sqlSelect, null);
        Log.d(TAG, "RETURNING CURSOR");
        return cursor;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // not needed
    }
}
