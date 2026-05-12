package org.baltimorecityschools.peaceofmindRCL;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HistoryTab extends Fragment {
    TextView sessionTV;
    RecyclerView recyclerView;
    session_RecyclerViewAdapter adapter;


    //this is probably for when i do file storage

    int[] emojiImages = {R.drawable.happyemoji, R.drawable.mediumface, R.drawable.angryface, R.drawable.upsetemoji};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_history_tab, container, false);
        SessionStorage.load(getContext());
        sessionTV = (TextView) view.findViewById(R.id.sessionTV);
        recyclerView = view.findViewById(R.id.recyclerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new session_RecyclerViewAdapter(SessionStorage.getSessions());
        recyclerView.setAdapter(adapter);




        return view;


    }

}