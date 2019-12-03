package com.example.gugymformation;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class Workout {
    private String name;
    private ArrayList<Exercise> exercises;

    public Workout(String name){
        this.name = name;
        this.exercises = new ArrayList<>();
    }

    public Workout(String name, ArrayList<Exercise> exercises){
        this.name = name;
        this.exercises = exercises;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }
}
