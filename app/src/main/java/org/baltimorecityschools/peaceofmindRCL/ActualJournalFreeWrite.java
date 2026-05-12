package org.baltimorecityschools.peaceofmindRCL;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ActualJournalFreeWrite extends AppCompatActivity {


    private String getPastPrompt7() {
        String[] prompts = {
                "What did you like about your childhood? ",
                "What didn’t you like about your childhood?",
                "What traits do you hope you inherited from your parents? What do you hope you didn't?",
                "Describe your upbringing in five words",
                "Think about the significant romantic relationships in your life. What do the people you’ve dated have in common? How do they differ? What are the common themes within those relationships?"

        };

        Random random = new Random();
        return prompts[random.nextInt(prompts.length)];
    }

    private String getRelationshipPrompt8() {
        String[] prompts = {

                "What are the positives about your current relationship?",
                "What are things you would change about your relationship?",
                "What barriers, if any, keep you from changing the parts of your relationship you’re struggling with?",
                "What’s one thing you wish you could say to your partner? How could you find a way to say it (constructively)?",
                "How satisfied do you feel in your current relationship, on a scale of 1 to 10? What do you think your partner would rate your relationship?"

        };

        Random random = new Random();
        return prompts[random.nextInt(prompts.length)];
    }

    private String getFriendshipPrompt9() {
        String[] prompts = {

                "Who is your best friend? What do they add to your life?",
                "What role has friendship played in your life?",
                "Do you see your friends enough? What steps can you take to see your friends more frequently?"

        };

        Random random = new Random();
        return prompts[random.nextInt(prompts.length)];
    }


    private String getFatherhoodPrompt10() {
        String[] prompts = {
                "What did you think being a dad would be like? How is it the same and different than you expected?",
                "What’s your favorite part about being a father?",
                "What’s the hardest part about being a father?",
                "Describe your relationship with your child/children. How do you connect with them? What do you like about them?",
                "How is your relationship with your kid(s) different from the relationship you had with your dad?",
                "What was your father like? Do you want to be the same as him, or different?"

        };

        Random random = new Random();
        return prompts[random.nextInt(prompts.length)];
    }

    TextView journalPromptTV;
    Button doneBTN;
    String currentPrompt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_journal_free_write);
        journalPromptTV = (TextView) findViewById(R.id.journalPromptTV);
        doneBTN = (Button) findViewById(R.id.doneBTN);


        boolean past = getIntent().getBooleanExtra("past", false);
        boolean relationship = getIntent().getBooleanExtra("relationship", false);
        boolean friendship = getIntent().getBooleanExtra("friendship", false);
        boolean fatherhood = getIntent().getBooleanExtra("fatherhood", false);


        if (past) {
            currentPrompt = getPastPrompt7();
            journalPromptTV.setText(currentPrompt);
        }
        if (relationship) {
            currentPrompt = getRelationshipPrompt8();
            journalPromptTV.setText(currentPrompt);
        }

        if (friendship) {
            currentPrompt = getFriendshipPrompt9();
            journalPromptTV.setText(currentPrompt);
        }

        if (fatherhood) {
            currentPrompt = getFatherhoodPrompt10();
            journalPromptTV.setText(currentPrompt);
        }



        doneBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                doneBTN.animate()
                        .scaleX(0.7f)
                        .scaleY(0.7f)
                        .setDuration(100)
                        .withEndAction(() -> {
                            doneBTN.animate()
                                    .scaleX(1f)
                                    .scaleY(1f)
                                    .setDuration(30)
                                    .withEndAction(() -> {
                                        Intent intent = new Intent(ActualJournalFreeWrite.this, MainHub.class);
                                        startActivity(intent);
                                        finish();

                                    })
                                    .start();

                        })
                        .start();


            }
        });
    }


}





