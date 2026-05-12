package org.baltimorecityschools.peaceofmindRCL;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class EmojiActivity extends AppCompatActivity {



    ImageButton happyBTN, angryBTN, upsetBTN, mediumBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emoji);

        happyBTN = (ImageButton) findViewById(R.id.happyBTN);
        angryBTN = (ImageButton) findViewById(R.id.angryBTN);
        upsetBTN = (ImageButton) findViewById(R.id.upsetBTN);
        mediumBTN = (ImageButton) findViewById(R.id.mediumBTN);





        happyBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                happyBTN.animate()
                        .scaleX(0.7f)
                        .scaleY(0.7f)
                        .setDuration(100)
                        .withEndAction(() -> {
                            happyBTN.animate()
                                    .scaleX(1f)
                                    .scaleY(1f)
                                    .setDuration(30)
                                    .withEndAction(() -> {
                                        openNext("happy", R.drawable.happyemoji);

                                    })
                                    .start();

                        })
                        .start();


            }



        });

        angryBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                angryBTN.animate()
                        .scaleX(0.7f)
                        .scaleY(0.7f)
                        .setDuration(100)
                        .withEndAction(() -> {
                            angryBTN.animate()
                                    .scaleX(1f)
                                    .scaleY(1f)
                                    .setDuration(30)
                                    .withEndAction(() -> {
                                        openNext("angry", R.drawable.angryface);

                                    })
                                    .start();

                        })
                        .start();

            }



        });
        upsetBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                upsetBTN.animate()
                        .scaleX(0.7f)
                        .scaleY(0.7f)
                        .setDuration(100)
                        .withEndAction(() -> {
                            upsetBTN.animate()
                                    .scaleX(1f)
                                    .scaleY(1f)
                                    .setDuration(30)
                                    .withEndAction(() -> {
                                        openNext("upset", R.drawable.upsetemoji);

                                    })
                                    .start();

                        })
                        .start();

            }



        });
        mediumBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                mediumBTN.animate()
                        .scaleX(0.7f)
                        .scaleY(0.7f)
                        .setDuration(100)
                        .withEndAction(() -> {
                            mediumBTN.animate()
                                    .scaleX(1f)
                                    .scaleY(1f)
                                    .setDuration(30)
                                    .withEndAction(() -> {
                                        openNext("medium", R.drawable.mediumface);

                                    })
                                    .start();

                        })
                        .start();


            }



        });


}

// Dont forget to set this up.................
    private void openNext(String selectedMood, int imageMood) {

        String currentDate = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());

        Session session = new Session(currentDate);
        session.setMood(selectedMood);
        session.setMood2(imageMood);

        SessionStorage.addSession(EmojiActivity.this, session);


        Intent intent = new Intent(EmojiActivity.this, ExerciseActivity.class);
        intent.putExtra("session_id", session.getId());
//        intent.putExtra("mood", selectedMood);
//        intent.putExtra("imageMood", imageMood);
        startActivity(intent);
    }
}