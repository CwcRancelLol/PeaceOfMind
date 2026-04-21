package com.example.peaceofmind;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainTab extends Fragment {

        Button beginBTN, journalBTN;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_main_tab, container, false);

        beginBTN = (Button) view.findViewById(R.id.beginBTN);
        journalBTN = (Button) view.findViewById(R.id.journalBTN);




        beginBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                //Add this back later
                Intent leaveIntent = new Intent(requireContext(), EmojiActivity.class);
                startActivity(leaveIntent);

            }

        });

        journalBTN.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                //Add this back later
                Intent leaveIntent = new Intent(requireContext(), JournalEntry.class);
                startActivity(leaveIntent);

            }

        });







        return view;
    }
}