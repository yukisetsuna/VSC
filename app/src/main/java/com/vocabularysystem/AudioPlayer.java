package com.vocabularysystem;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {

    public static MediaPlayer mediaPlayer;

    public static boolean isplayingAudio = false;

    public static void playAudio(Context c, int id) {
        mediaPlayer = MediaPlayer.create(c, id);
        mediaPlayer.setLooping(true);
        if (!mediaPlayer.isPlaying()) {
            isplayingAudio = true;
            mediaPlayer.start();
        }
    }

    public static void stopAudio() {
        isplayingAudio = false;
        mediaPlayer.stop();
    }

}