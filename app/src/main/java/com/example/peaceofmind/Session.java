package com.example.peaceofmind;

import android.widget.Button;
import java.util.Random;


public class Session {

    private String mood;

    private String journalPrompt;

    private String journalEntry;

    private String date;

    private int exercisesDone;


    public Session(String date) {

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

    public void setMood(String mood) {
        this.mood = mood;
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

    public void setExercisesDone(int exercisesDone) {
        this.exercisesDone = exercisesDone;
    }
}
