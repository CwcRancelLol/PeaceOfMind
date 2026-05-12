package org.baltimorecityschools.peaceofmindRCL;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;



import androidx.appcompat.app.AppCompatActivity;

public class JournalEntry extends AppCompatActivity {


    TextView promptTV;

    EditText responseET;

    Button saveBTN;


    String currentPrompt;


    private String getRandomPrompt() {
        String[] prompts = {
                "How are you feeling today?",
                "What made you smile today?",
                "What is something you're grateful for?",
                "What’s been on your mind lately?",
                "What am I holding onto that I need to release?",
                "When do I feel most like myself?",
                "What does my inner critic say, and how can I challenge it?",
                "What would I tell a friend feeling what I feel right now?",
                "What triggers stress or anxiety for me?",
                "What helps me feel grounded?",
                "What am I proud of myself for lately?",
                "What boundaries do I need to set?",
                "What has hurt me that I haven’t fully processed?",
                "What does healing look like for me?",
                "What do I need to forgive myself for?",
                "What patterns keep showing up in my relationships?",
                "When do I feel safest?"
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

        String id = getIntent().getStringExtra("session_id");

        Session currentSession = SessionStorage.getSessionById(id);

        currentSession.setJournalEntry(entryText);
        currentSession.setJournalPrompt(currentPrompt);

        ArrayList<Session> sessions = SessionStorage.getSessions();

        for (int i = 0; i < sessions.size(); i++) {

            Session s = sessions.get(i);

            if (s.getId() != null &&
                    currentSession.getId() != null &&
                    s.getId().equals(currentSession.getId())) {
                s.setJournalEntry(entryText);
                s.setJournalPrompt(currentPrompt);

                break;
            }
        }

        SessionStorage.save(this);
        Intent intent = new Intent(JournalEntry.this, MainHub.class);
        startActivity(intent);
        finish();

    }


}