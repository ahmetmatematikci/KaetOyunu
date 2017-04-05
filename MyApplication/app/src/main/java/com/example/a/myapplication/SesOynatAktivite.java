package com.example.a.myapplication;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class SesOynatAktivite extends AppCompatActivity implements View.OnTouchListener {
    SoundPool sesHavuzu;
    int sesNr = -1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setOnTouchListener(this);

        setContentView(tv);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        sesHavuzu = new SoundPool(15,AudioManager.STREAM_MUSIC,0);

        try {
            AssetManager assetManager = getAssets();
            AssetFileDescriptor descriptor = assetManager.openFd("ses.mp3");
            sesNr = sesHavuzu.load(descriptor,1);

        }catch (IOException e) {
            tv.setText("ses yüklenemdi" + e.getMessage());
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_UP) {
            if (sesNr !=-1) {
                sesHavuzu.play(sesNr,1,1,0,0,1);
            }
        }
        return true;
    }
}
