package com.example.peaceofmind;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class JournalEntry extends AppCompatActivity {


    TextView promptTV;

    EditText responseET;

    Button saveBTN;



    private static final String[] prompts = {
            "What made you feel good today?",
            "What challenged you today?",
            "What are you grateful for?",
            "Describe your mood and why you feel this way.",
            "What is something you learned today?"
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_entry);

        promptTV = (TextView) findViewById(R.id.promptTV);
        responseET = (EditText) findViewById(R.id.responseET);
        saveBTN = (Button) findViewById(R.id.saveBTN);














    }


}