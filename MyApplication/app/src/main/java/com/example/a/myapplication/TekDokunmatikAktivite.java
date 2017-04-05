package com.example.a.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class TekDokunmatikAktivite extends Activity implements View.OnTouchListener {
    String metin = "";
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv = new TextView(this);
        tv.setText("Tek Parmak ile dokn yada sürükle");
        tv.setOnTouchListener(this);
        setContentView(tv);

        //setContentView(R.layout.activity_tek_dokunmatik_aktivite);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        metin ="";
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                metin = "bastın , ";
                break;
            case MotionEvent.ACTION_MOVE:
                metin = "sürükledin , ";
                break;
            case MotionEvent.ACTION_CANCEL:
                metin = "iptal , ";
                break;
            case MotionEvent.ACTION_UP:
                metin = "kaldırdın , ";
                break;
        }
        metin = metin + event.getX();
        metin = metin + ", ";
        metin = metin + event.getY();
        tv.setText(metin);
        return true;
    }
}
