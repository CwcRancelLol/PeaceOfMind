package org.baltimorecityschools.peaceofmindRCL;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JournalFreeWrite extends AppCompatActivity {

    Button button7, button8, button9, button10,button11;

    Boolean idk1, idk2, idk3, idk4;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_free_write);


        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        String currentPrompt;

        idk1 = false;
        idk2 = false;
        idk3 = false;
        idk4 = false;


        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                idk1 = true;

                button7.animate()
                        .scaleX(0.7f)
                        .scaleY(0.7f)
                        .setDuration(100)
                        .withEndAction(() -> {
                            button7.animate()
                                    .scaleX(1f)
                                    .scaleY(1f)
                                    .setDuration(30)
                                    .withEndAction(() -> {
                                        Intent intent = new Intent(JournalFreeWrite.this, ActualJournalFreeWrite.class);
                                        intent.putExtra("past", idk1);
                                        startActivity(intent);
                                        finish();

                                    })
                                    .start();

                        })
                        .start();


            }

        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                idk2 = true;

                button8.animate()
                        .scaleX(0.7f)
                        .scaleY(0.7f)
                        .setDuration(100)
                        .withEndAction(() -> {
                            button8.animate()
                                    .scaleX(1f)
                                    .scaleY(1f)
                                    .setDuration(30)
                                    .withEndAction(() -> {
                                        Intent intent = new Intent(JournalFreeWrite.this, ActualJournalFreeWrite.class);
                                        intent.putExtra("relationship", idk2);
                                        startActivity(intent);
                                        finish();

                                    })
                                    .start();

                        })
                        .start();


            }

        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                idk3 = true;

                button9.animate()
                        .scaleX(0.7f)
                        .scaleY(0.7f)
                        .setDuration(100)
                        .withEndAction(() -> {
                            button9.animate()
                                    .scaleX(1f)
                                    .scaleY(1f)
                                    .setDuration(30)
                                    .withEndAction(() -> {
                                        Intent intent = new Intent(JournalFreeWrite.this, ActualJournalFreeWrite.class);
                                        intent.putExtra("friendship", idk3);
                                        startActivity(intent);
                                        finish();

                                    })
                                    .start();

                        })
                        .start();


            }

        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                idk4 = true;

                button10.animate()
                        .scaleX(0.7f)
                        .scaleY(0.7f)
                        .setDuration(100)
                        .withEndAction(() -> {
                            button10.animate()
                                    .scaleX(1f)
                                    .scaleY(1f)
                                    .setDuration(30)
                                    .withEndAction(() -> {
                                        Intent intent = new Intent(JournalFreeWrite.this, ActualJournalFreeWrite.class);
                                        intent.putExtra("fatherhood", idk4);
                                        startActivity(intent);
                                        finish();

                                    })
                                    .start();

                        })
                        .start();


            }

        });

        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button11.animate()
                        .scaleX(0.7f)
                        .scaleY(0.7f)
                        .setDuration(100)
                        .withEndAction(() -> {
                            button11.animate()
                                    .scaleX(1f)
                                    .scaleY(1f)
                                    .setDuration(30)
                                    .withEndAction(() -> {
                                        Intent intent = new Intent(JournalFreeWrite.this, MainHub.class);
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