package org.baltimorecityschools.peaceofmindRCL;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ExerciseActivity extends AppCompatActivity {

    TextView moodTitle, ex1, ex2, ex3;

    Button nextBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        ex1 = (TextView) findViewById(R.id.ex1);
        ex2 = (TextView) findViewById(R.id.ex2);
        ex3 = (TextView) findViewById(R.id.ex3);
        moodTitle = (TextView) findViewById(R.id.moodTitle);
        nextBTN = (Button) findViewById(R.id.nextBTN);

        ex1.setOnClickListener(v -> openExercise(ex1.getText().toString()));
        ex2.setOnClickListener(v -> openExercise(ex2.getText().toString()));
        ex3.setOnClickListener(v -> openExercise(ex3.getText().toString()));

        nextBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                nextBTN.animate()
                        .scaleX(0.7f)
                        .scaleY(0.7f)
                        .setDuration(100)
                        .withEndAction(() -> {
                            nextBTN.animate()
                                    .scaleX(1f)
                                    .scaleY(1f)
                                    .setDuration(30)
                                    .withEndAction(() -> {
                                        String sessionId = getIntent().getStringExtra("session_id");
                                        Intent intent = new Intent(ExerciseActivity.this, JournalEntry.class);
                                        intent.putExtra("session_id", sessionId);
                                        startActivity(intent);
                                        finish();

                                    })
                                    .start();

                        })
                        .start();


            }



        });

        String sessionId = getIntent().getStringExtra("session_id");
        Session session = SessionStorage.getSessionById(sessionId);

        if (session == null) return;

        String mood = session.getMood();

        List<String> exercises = BreathingExercise.getExercises(mood);

        if (exercises.size() > 0) {
            ex1.setText(exercises.get(0));
        }
        if (exercises.size() > 1) {
            ex2.setText(exercises.get(1));
        }
        if (exercises.size() > 2) {
            ex3.setText(exercises.get(2));


        }


    }
    private void openExercise(String exerciseName) {
        Intent intent = new Intent(ExerciseActivity.this, BreathingExerciseActivity.class);
        String sessionId = getIntent().getStringExtra("session_id");
        intent.putExtra("session_id", sessionId);
        intent.putExtra("exercise", exerciseName);
        startActivity(intent);
    }
}

