package com.example.peaceofmind;
import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
public class SessionStorage {
    private static final String FILE_NAME = "sessions.json";  // or you can use another name

    // Save list of sessions to a file
    public static void saveSessions(Context context, List<Session> sessions) {
        Gson gson = new Gson();
        String json = gson.toJson(sessions);  // Convert the list to JSON

        try {
            FileOutputStream fos = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fos.write(json.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Load the list of sessions from the file
    public static List<Session> loadSessions(Context context) {
        List<Session> sessions = new ArrayList<>();
        Gson gson = new Gson();

        try {
            FileInputStream fis = context.openFileInput(FILE_NAME);
            InputStreamReader reader = new InputStreamReader(fis);

            sessions = gson.fromJson(reader, new TypeToken<List<Session>>(){}.getType());

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sessions;
    }
}
