package com.example.peaceofmind;

import android.widget.Button;
import java.util.Random;
import java.io.Serializable;
import java.util.UUID;


public class Session implements Serializable {

    private String mood;

    private String id;

    private int mood2;

    private String journalPrompt;

    private String journalEntry;

    private String date;

    private int exercisesDone;


    public Session(String date) {
        this.id = UUID.randomUUID().toString();
        this.date = date;
    }


    private static final String[] prompts = {
            "What made you feel good today?",
            "What challenged you today?",
            "What are you grateful for?",
            "Describe your mood and why you feel this way.",
            "What is something you learned today?"
    };

    public static String getRandomPrompt() {
        Random rand = new Random();
        return prompts[rand.nextInt(prompts.length)];
    }




    public String getMood() {
        return mood;
    }

    public int getMood2() {
        return mood2;
    }

    public String getJournalEntry() {
        return journalEntry;
    }


    public String getJournalPrompt() {
        return journalPrompt;
    }

    public String getDate() {
        return date;
    }

    public int getExercisesDone() {
        return exercisesDone;
    }

    public String getId() {
        return id;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public void setMood2(int mood2) {
        this.mood2 = mood2;
    }

    public void setJournalPrompt(String journalPrompt) {
        this.journalPrompt = journalPrompt;
    }

    public void setJournalEntry(String journalEntry) {
        this.journalEntry = journalEntry;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setExercisesDone(int exercisesDone) {
        this.exercisesDone = exercisesDone;
    }
}
