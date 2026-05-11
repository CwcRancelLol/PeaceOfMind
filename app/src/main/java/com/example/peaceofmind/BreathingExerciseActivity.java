package com.example.peaceofmind;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class BreathingExerciseActivity extends AppCompatActivity {

    TextView breathText, countDownTV;
    View circle;

    Button endBTN;

    int inhaleTime = 4000;
    int exhaleTime = 4000;

    int holdTime = 4000;

    CountDownTimer currentTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing_exercise);

        breathText = (TextView) findViewById(R.id.breathText);
        countDownTV = (TextView) findViewById(R.id.countDownTV);
        circle = (View) findViewById(R.id.breathCircle);
        endBTN = (Button) findViewById(R.id.endBTN);

        String exercise = getIntent().getStringExtra("exercise");

        if (exercise != null) {
            breathText.setText(exercise);

            if (exercise.contains("upset")) {
                inhaleTime = 4000;
                exhaleTime = 4000;
            }
            else if (exercise.contains("angry")) {
                inhaleTime = 4000;
                exhaleTime = 8000;
            }
            else {
                inhaleTime = 3000;
                exhaleTime = 3000;
            }
        }

        startBreathingAnimation();

        endBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){


                String sessionId = getIntent().getStringExtra("session_id");
                Session session = SessionStorage.getSessionById(sessionId);

                ArrayList<Session> sessions = SessionStorage.getSessions();

                for (Session s : sessions) {
                    if (s.getId() != null && s.getId().equals(session.getId())) {

                        int newCount = s.getExercisesDone() + 1;
                        s.setExercisesDone(newCount);

                        break;
                    }
                }
                SessionStorage.save(BreathingExerciseActivity.this);

                Intent intent = new Intent(BreathingExerciseActivity.this, ExerciseActivity.class);
                intent.putExtra("session_id", session.getId());
                finish();

                startActivity(intent);
            }

        });
    }



    private void startBreathingAnimation() {

        Runnable breathingCycle = new Runnable() {
            @Override
            public void run() {
                breathText.setText("Inhale...");
                startCountDown(inhaleTime, "Inhale");
                circle.animate()
                        .scaleX(1.5f)
                        .scaleY(1.5f)
                        .setDuration(inhaleTime)
                        .withEndAction(() -> {

                            startCountDown(holdTime, "Hold");

                            circle.postDelayed(() -> {

                                startCountDown(exhaleTime, "Exhale");

                                circle.animate()
                                        .scaleX(1f)
                                        .scaleY(1f)
                                        .setDuration(exhaleTime)
                                        .withEndAction(this)
                                        .start();

                            }, holdTime);

                        })
                        .start();
            }
        };

        circle.post(breathingCycle);
    }


    private void startCountDown(int ms, String label) {

        if (currentTimer != null) {
            currentTimer.cancel();
        }

        currentTimer = new CountDownTimer(ms, 1000) {

            @Override
            public void onTick(long msUntilFinished) {

                int seconds = (int) Math.ceil(msUntilFinished / 1000.0);

                breathText.setText(label + " " );
                countDownTV.setText(seconds + " ");

            }

            @Override
            public void onFinish() {
                breathText.setText(label + " 0");
            }

        }.start();
    }
}

