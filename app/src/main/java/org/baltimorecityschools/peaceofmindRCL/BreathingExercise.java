package org.baltimorecityschools.peaceofmindRCL;

import java.util.ArrayList;
import java.util.List;

public class BreathingExercise {


    public static List<String> getExercises(String mood) {

        List<String> exercises = new ArrayList<>();

        if ("upset".equals(mood)) {
            exercises.add("upset breathing");
            exercises.add("Deep inhale + slow exhale");

        } else if ("angry".equals(mood)) {
            exercises.add("angry breathing");
            exercises.add("Box breathing");

        } else if ("happy".equals(mood)) {
            exercises.add("Light breathing");

        } else {
            exercises.add("Basic breathing");
        }

        return exercises;
    }
}

