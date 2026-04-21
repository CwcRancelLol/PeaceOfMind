package com.example.peaceofmind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BreathingExerciseActivity extends AppCompatActivity {

    TextView breathText;
    View circle;

    Button endBTN;

    int inhaleTime = 4000;
    int exhaleTime = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing_exercise);

        breathText = (TextView) findViewById(R.id.breathText);
        circle = (View) findViewById(R.id.breathCircle);
        endBTN = (Button) findViewById(R.id.endBTN);

        String exercise = getIntent().getStringExtra("exercise");

        if (exercise != null) {
            breathText.setText(exercise);

            if (exercise.contains("4-4-4")) {
                inhaleTime = 4000;
                exhaleTime = 4000;
            }
            else if (exercise.contains("4-7-8")) {
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

                //Add this back later
                Intent intent = new Intent(BreathingExerciseActivity.this, MainHub.class);
                startActivity(intent);
            }

        });
    }



    private void startBreathingAnimation() {

        Runnable breathingCycle = new Runnable() {
            @Override
            public void run() {
                breathText.setText("Inhale...");
                circle.animate()
                        .scaleX(1.5f)
                        .scaleY(1.5f)
                        .setDuration(inhaleTime)
                        .withEndAction(() -> {


                            breathText.setText("Exhale...");
                            circle.animate()
                                    .scaleX(1f)
                                    .scaleY(1f)
                                    .setDuration(exhaleTime)
                                    .withEndAction(this)
                                    .start();
                        })
                        .start();
            }
        };

        circle.post(breathingCycle);
    }
}

