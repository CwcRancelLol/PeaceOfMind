package org.baltimorecityschools.peaceofmindRCL;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button beginBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SessionStorage.load(this);
        setContentView(R.layout.activity_main);
        beginBTN = (Button) findViewById(R.id.beginBTN);

        Intent intent = new Intent(this, Music.class);
        startService(intent);


        beginBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                beginBTN.animate()
                        .scaleX(0.7f)
                        .scaleY(0.7f)
                        .setDuration(100)
                        .withEndAction(() -> {
                            beginBTN.animate()
                                    .scaleX(0.9f)
                                    .scaleY(0.9f)
                                    .setDuration(30)
                                    .withEndAction(() -> {
                                        Intent leaveIntent = new Intent(MainActivity.this, MainHub.class);
                                        startActivity(leaveIntent);
                                        finish();

                                    })
                                    .start();

                        })
                        .start();


            }

        });

    }





}