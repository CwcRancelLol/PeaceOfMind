package com.example.peaceofmind;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EmojiActivity extends AppCompatActivity {

    Button happyBTN, angryBTN, upsetBTN, mediumBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emoji);

        happyBTN =(Button)findViewById(R.id.happyBTN);
        angryBTN =(Button)findViewById(R.id.angryBTN);
        upsetBTN =(Button)findViewById(R.id.upsetBTN);
        mediumBTN =(Button)findViewById(R.id.mediumBTN);

        happyBTN.setOnClickListener(v -> openNext("happy"));
        angryBTN.setOnClickListener(v -> openNext("angry"));
        upsetBTN.setOnClickListener(v -> openNext("upset"));
        mediumBTN.setOnClickListener(v -> openNext("medium"));


//
//
//        happyBTN.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick (View v){
//
//                //Add this back later
//                Intent intent = new Intent(EmojiActivity.this, BreathingExercise.class);
//                intent.putExtra("mood", );
//                startActivity(intent);
//            }
//
//        });



    }

    private void openNext(String selectedMood) {
        Intent intent = new Intent(EmojiActivity.this, ExerciseActivity.class);
        intent.putExtra("mood", selectedMood);
        startActivity(intent);
    }
}