package com.example.peaceofmind;

import static com.example.peaceofmind.Session.getRandomPrompt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class JournalEntry extends AppCompatActivity {


    TextView promptTV;

    EditText responseET;

    Button saveBTN;

    Session currentSession;

    String currentPrompt;


    private String getRandomPrompt() {
        String[] prompts = {
                "How are you feeling today?",
                "What made you smile today?",
                "What is something you're grateful for?",
                "What’s been on your mind lately?"
        };

        Random random = new Random();
        return prompts[random.nextInt(prompts.length)];
    }








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_entry);

        promptTV = (TextView) findViewById(R.id.promptTV);
        responseET = (EditText) findViewById(R.id.responseET);
        saveBTN = (Button) findViewById(R.id.saveBTN);

        String todayDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                .format(new Date());

        //SessionManager.startSessionIfNeeded(todayDate);

        //currentSession = SessionManager.getCurrentSession();

        // Get random prompt
        currentPrompt = getRandomPrompt();
        promptTV.setText(currentPrompt);

        saveBTN.setOnClickListener(v -> saveEntry());
    }

    private void saveEntry() {
        String entryText = responseET.getText().toString();

        if (entryText.isEmpty()) {
            Toast.makeText(this, "Please write something", Toast.LENGTH_SHORT).show();
            return;
        }

        //currentSession.setJournalPrompt(currentPrompt);
        //currentSession.setJournalEntry(entryText);

        Intent intent = new Intent(JournalEntry.this, MainHub.class);
        startActivity(intent);
        finish();

    }


}