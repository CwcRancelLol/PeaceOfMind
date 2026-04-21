package com.example.peaceofmind;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class ExerciseActivity extends AppCompatActivity {

    TextView moodTitle, ex1, ex2, ex3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        ex1 =(TextView) findViewById(R.id.ex1);
        ex2 =(TextView)findViewById(R.id.ex2);
        ex3 =(TextView)findViewById(R.id.ex3);
        moodTitle =(TextView)findViewById(R.id.moodTitle);

        ex1.setOnClickListener(v -> openExercise(ex1.getText().toString()));
        ex2.setOnClickListener(v -> openExercise(ex2.getText().toString()));
        ex3.setOnClickListener(v -> openExercise(ex3.getText().toString()));










        String mood = getIntent().getStringExtra("mood");
        List<String> exercises = BreathingExercise.getExercises(mood);

        if (exercises.size() > 0) ex1.setText(exercises.get(0));
        if (exercises.size() > 1) ex2.setText(exercises.get(1));
        if (exercises.size() > 2) ex3.setText(exercises.get(2));


        }

    private void openExercise(String exerciseName) {
        Intent intent = new Intent(ExerciseActivity.this, BreathingExerciseActivity.class);
        intent.putExtra("exercise", exerciseName);
        startActivity(intent);
    }
    }
