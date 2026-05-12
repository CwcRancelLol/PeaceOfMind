package org.baltimorecityschools.peaceofmindRCL;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.UUID;

public class SessionStorage {



    private static ArrayList<Session> sessions = new ArrayList<>();

    public static void addSession(Context context, Session session) {
        sessions.add(session);
        save(context);
    }


    private static final String KEY = "sessions";

    public static void save(Context context) {

        SharedPreferences prefs =
                context.getSharedPreferences("app", Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String json = gson.toJson(sessions);

        prefs.edit().putString(KEY, json).apply();
    }

    public static void load(Context context) {

        SharedPreferences prefs = context.getSharedPreferences("app", Context.MODE_PRIVATE);

        String json = prefs.getString(KEY, null);

        if (json != null) {
            Gson gson = new Gson();

            Type type = new TypeToken<ArrayList<Session>>() {}.getType();

            sessions = gson.fromJson(json, type);
        }

        for (Session s : sessions){
            if (s.getId() == null){
                s.setId(UUID.randomUUID().toString());
            }
        }
    }



    public static Session getSessionById(String id) {
        for (Session s : sessions) {
            if (s.getId() != null && s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }




    public static ArrayList<Session> getSessions(){
        return sessions;
    }


}
