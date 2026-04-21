package com.example.peaceofmind;

import java.util.ArrayList;
import java.util.List;

public class BreathingExercise {


    public static List<String> getExercises(String mood) {

        List<String> exercises = new ArrayList<>();

        if (mood.equals("upset")) {
            exercises.add("4-4-4 breathing");
            exercises.add("Deep inhale + slow exhale");

        } else if (mood.equals("angry")) {
            exercises.add("4-7-8 breathing");
            exercises.add("Box breathing");

        } else if (mood.equals("happy")) {
            exercises.add("Light breathing");

        } else {
            exercises.add("Basic breathing");
        }

        return exercises;
    }
}

