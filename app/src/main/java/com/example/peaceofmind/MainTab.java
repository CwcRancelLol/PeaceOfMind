package com.example.peaceofmind;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Random;

public class MainTab extends Fragment {

        Button beginBTN, journalBTN;

        ImageButton button4;

        TextView quoteTV;

        ImageView gif;

        boolean muted = false;

        String currentQuote;

        private String getRandomQuote(){
            String[] quotes = {
                    "“Man cannot remake himself without suffering, for he is both the marble and the sculptor.” — Alexis Carrel",
                    "“No tree, it is said, can grow to heaven unless its roots reach down to hell.” — Carl Jung",
                    "“Those who wish for flowers must not be afraid of the rain.”",
                    "“A smooth sea never made a skilled sailor.” — Franklin D. Roosevelt",
                    "“It never gets easier. You just get stronger.”",
                    "“You don’t drown by falling in the water; you drown by staying there.”",
                    "“One day or day one. You decide.”"
            };

            Random random = new Random();
            return quotes[random.nextInt(quotes.length)];
        }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_main_tab, container, false);

        beginBTN = (Button) view.findViewById(R.id.beginBTN);
        button4 = (ImageButton) view.findViewById(R.id.button4);
        journalBTN = (Button) view.findViewById(R.id.journalBTN);
        quoteTV = (TextView) view.findViewById(R.id.quoteTV);
        gif = (ImageView)  view.findViewById(R.id.gif);
        Glide.with(this).load(R.drawable.sky_gif).into(gif);
        currentQuote = getRandomQuote();
        quoteTV.setText(currentQuote);





        beginBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {

                beginBTN.animate()
                        .scaleX(0.7f)
                        .scaleY(0.7f)
                        .setDuration(100)
                        .withEndAction(() -> {
                            beginBTN.animate()
                                    .scaleX(1f)
                                    .scaleY(1f)
                                    .setDuration(30)
                                    .withEndAction(() -> {
                                Intent leaveIntent = new Intent(requireContext(), EmojiActivity.class);
                                startActivity(leaveIntent);

                            })
                            .start();

                        })
                        .start();
            }


        });

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {


                button4.animate()
                        .scaleX(0.9f)
                        .scaleY(0.9f)
                        .setDuration(100)
                        .withEndAction(() -> {
                            beginBTN.animate()
                                    .scaleX(1f)
                                    .scaleY(1f)
                                    .setDuration(30)
                                    .withEndAction(() -> {
                                        if (Music.instance != null) {
                                            muted = !muted;
                                            Music.instance.setMuted(muted);
                                            if (muted) {
                                                button4.setImageResource(R.drawable.mute);
                                            } else {
                                                button4.setImageResource(R.drawable.unmuted);
                                            }
                                        }


                                    })
                                    .start();

                        })
                        .start();
            }


        });

        journalBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                journalBTN.animate()
                        .scaleX(0.7f)
                        .scaleY(0.7f)
                        .setDuration(100)
                        .withEndAction(() -> {
                            journalBTN.animate()
                                    .scaleX(1f)
                                    .scaleY(1f)
                                    .setDuration(30)
                                    .withEndAction(() -> {
                                        Intent leaveIntent = new Intent(requireContext(), JournalFreeWrite.class);
                                        startActivity(leaveIntent);

                                    })
                                    .start();

                        })
                        .start();


            }

        });
        return view;
    }
}