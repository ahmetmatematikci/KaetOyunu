package com.example.a.myapplication;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

public class MuzikOynatAktivite extends Activity {
    MediaPlayer kahraman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        setContentView(tv);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        kahraman = new MediaPlayer();

        try {
            AssetManager assetManager = getAssets();
            AssetFileDescriptor descriptor = assetManager.openFd("ses.mp3");

            kahraman.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            kahraman.prepare();
            kahraman.setLooping(true);
        } catch (IOException e) {
            e.printStackTrace();
            kahraman = null;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (kahraman !=null) {
            kahraman.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (kahraman !=null) {
            kahraman.pause();
            if (isFinishing()) {
                kahraman.stop();
                kahraman.release();
            }
        }
    }
}
