package org.baltimorecityschools.peaceofmindRCL;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.media.MediaPlayer;

public class Music extends Service{

    MediaPlayer mediaPlayer;
    boolean isMuted = false;

    public static Music instance;


    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.paradisekiller);
        mediaPlayer.setLooping(true);
        mediaPlayer.setVolume(0.25f, 0.25f);
        instance = this;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }

        return START_STICKY;
    }

    public void setMuted(boolean mute) {
        isMuted = mute;

        if (mediaPlayer != null) {
            if (mute) {
                mediaPlayer.setVolume(0f, 0f);
            } else {
                mediaPlayer.setVolume(0.25f, 0.25f);
            }
        }
    }

    public boolean isMuted() {
        return isMuted;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}


