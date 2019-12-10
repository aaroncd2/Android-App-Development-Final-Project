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
                ", 'Isolation Bicep Curls', 'Arms', " + R.drawable.bicep_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Skullcrushers', 'Arms', " + R.drawable.bicep_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Triceps Dumbbell Rows', 'Arms', " + R.drawable.bicep_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Tricep Dumbbell Extension', 'Arms', " + R.drawable.bicep_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Deadlift', 'Back', " + R.drawable.back_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Dumbbell Deadlift', 'Back', " + R.drawable.back_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Dumbbel Back Rows', 'Back', " + R.drawable.back_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Pull ups', 'Back', " + R.drawable.back_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Mile Intervals', 'Running', " + R.drawable.cardio_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Timed Intervals', 'Running', " + R.drawable.cardio_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Outdoor Run', 'Running', " + R.drawable.cardio_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Lap Intervals', 'Swimming', " + R.drawable.cardio_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Distance Intervals', 'Swimming', " + R.drawable.cardio_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Speed Intervals', 'Swimming', " + R.drawable.cardio_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Stroke Intervals', 'Swimming', " + R.drawable.cardio_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Pickup Basketball', 'Basketball', " + R.drawable.cardio_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Shooting Session', 'Basketball', " + R.drawable.cardio_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Layup Drills', 'Basketball', " + R.drawable.cardio_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Dribble Work', 'Basketball', " + R.drawable.cardio_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Chest Bench', 'Chest', " + R.drawable.chest_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Chest Incline', 'Chest', " + R.drawable.chest_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Dumbbell Chest Bench', 'Chest', " + R.drawable.chest_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Dumbbell Chest Incline', 'Chest', " + R.drawable.chest_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Squat', 'Legs', " + R.drawable.legs_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Dumbbell Squat', 'Legs', " + R.drawable.legs_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Alternating Leg Squats', 'Legs', " + R.drawable.legs_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Hamstring Machine', 'Legs', " + R.drawable.legs_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Leg Press Machine', 'Legs', " + R.drawable.legs_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Dumbbell Shoulder Press', 'Shoulders', " + R.drawable.shoulder_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Upright Barbell Row', 'Shoulders', " + R.drawable.shoulder_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Side Lateral Raise', 'Shoulders', " + R.drawable.shoulder_icon + ")";
        db.execSQL(sqlInsert);
        sqlInsert = "INSERT INTO " + TABLE_EXERCISE + " VALUES(" + null +
                ", 'Side Cable Raise', 'Shoulders', " + R.drawable.shoulder_icon + ")";
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
