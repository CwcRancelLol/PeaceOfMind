package com.example.peaceofmind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SessionDetailActivity extends AppCompatActivity {


    Button backBTN;

    ImageView emojiIV;

    TextView journalPrompt, journalEntry, DateTV, exercisesTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_detail);
        backBTN = (Button) findViewById(R.id.backBTN);
        journalPrompt = (TextView) findViewById(R.id.journalPrompt);
        journalEntry = (TextView) findViewById(R.id.journalEntry);
        DateTV = (TextView) findViewById(R.id.DateTV);
        emojiIV = (ImageView) findViewById(R.id.emojiIV);
        exercisesTV = (TextView) findViewById(R.id.exercisesTV);

        backBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {

                //Add this back later

                backBTN.animate()
                        .scaleX(0.7f)
                        .scaleY(0.7f)
                        .setDuration(100)
                        .withEndAction(() -> {
                            backBTN.animate()
                                    .scaleX(1f)
                                    .scaleY(1f)
                                    .setDuration(30)
                                    .withEndAction(() -> {
                                        Intent leaveIntent = new Intent(SessionDetailActivity.this, MainHub.class);
                                        startActivity(leaveIntent);
                                        finish();

                                    })
                                    .start();

                        })
                        .start();
            }


        });



        Intent intent = getIntent();

        Session session = (Session) intent.getSerializableExtra("session");

        exercisesTV.setText("Exercises Done: "+session.getExercisesDone());
        emojiIV.setImageResource(session.getMood2());
        DateTV.setText(" "+session.getDate());
        journalPrompt.setText("Journal Prompt: "+session.getJournalPrompt());
        journalEntry.setText("Journal Entry: "+session.getJournalEntry());

//        String prompt = intent.getStringExtra("prompt");
//        String entry = intent.getStringExtra("entry");
//        journalPrompt.setText(prompt);
//        journalEntry.setText(entry);






    }
}