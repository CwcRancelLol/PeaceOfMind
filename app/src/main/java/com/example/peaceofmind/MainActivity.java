package com.example.peaceofmind;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    Button beginBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        beginBTN = (Button)findViewById(R.id.beginBTN);




    }

    beginBTN.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View v){

        Intent leaveIntent = new Intent(MainActivity.this, activity_emoji.class);
        startActivity(leaveIntent);

    }


    });
}