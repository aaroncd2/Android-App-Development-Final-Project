package com.example.gugymformation;

import android.widget.ArrayAdapter;

import java.io.Serializable;
import java.util.ArrayList;

public class Workout implements Serializable {
    private int id;
    private String name;
    private ArrayList<Exercise> exercises;

    public Workout(String name){
        this.id = -1;
        this.name = name;
        this.exercises = new ArrayList<>();
    }

    public Workout(int id, String name, ArrayList<Exercise> exercises){
        this.id = id;
        this.name = name;
        this.exercises = exercises;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
