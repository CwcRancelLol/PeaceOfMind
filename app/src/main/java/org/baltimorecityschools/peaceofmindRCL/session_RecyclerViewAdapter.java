package org.baltimorecityschools.peaceofmindRCL;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class session_RecyclerViewAdapter extends RecyclerView.Adapter<session_RecyclerViewAdapter.MyViewHolder> {
                                    //Context context; For data storage???
    //holds sessions
    private ArrayList<Session> sessions;

    public session_RecyclerViewAdapter(ArrayList<Session> sessions) {
        this.sessions = sessions;
    }

    @NonNull
    @Override
    public session_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This is where you inflate the layout (Giving the look to our rows)
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new session_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull session_RecyclerViewAdapter.MyViewHolder holder, int position) {
            // assigning values to the views we created in the recycler_view_row layout file
       // based on the position of the recycler view
        Session session = sessions.get(position);
        holder.sessionTV.setText(session.getDate());
        holder.imageView.setImageResource(session.getMood2());
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                Intent intent = new Intent(
                        v.getContext(),
                        SessionDetailActivity.class
                );

                intent.putExtra("session", session);
                v.getContext().startActivity(intent);

            }




        });
    }

    @Override
    public int getItemCount() {
        // the recycler view just wants to know the number of items you want displayed
        return sessions.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // grabbing the views from our recycler_view_row layout file
        // kinda like in the onCreate method

        ImageView imageView;
        TextView sessionTV;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            sessionTV = itemView.findViewById(R.id.sessionTV);
        }
    }
}