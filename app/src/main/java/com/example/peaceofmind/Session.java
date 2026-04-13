package com.example.peaceofmind;

import android.widget.Button;

public class Session {

    private String mood;

    private String journalPrompt;

    private String journalEntry;

    private String date;

    private int exercisesDone;


    public Session(String date, String mood, String journalPrompt, String journalEntry, int exercisesDone) {

        this.date = date;
        this.mood = mood;
        this.journalPrompt = journalPrompt;
        this.journalEntry = journalEntry;
        this.exercisesDone = exercisesDone;


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




}
