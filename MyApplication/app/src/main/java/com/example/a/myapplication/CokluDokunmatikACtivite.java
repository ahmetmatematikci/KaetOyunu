package com.example.a.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class CokluDokunmatikACtivite extends AppCompatActivity implements View.OnTouchListener {

    String metin = "";
    TextView tv;
    float[] x = new float[10];
    float[] y = new float[10];

    boolean[] dokunuldu = new boolean[10];

    private void ekranGoruntusu() {
        metin = "";
        for (int i=0; i<10; i++) {
            metin = metin + dokunuldu[i];
            metin = metin + ", ";
            metin = metin + x[i];
            metin = metin + ", ";
            metin = metin + y[i];
            metin = metin + "\n";
        }

        tv.setText(metin);

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv = new TextView(this);
        tv.setText("Birden fazla parmak ile dokunuldu");
        tv.setOnTouchListener(this);
        setContentView(tv);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int aktivite = event.getAction() & MotionEvent.ACTION_MASK;
        int isaretIndexi = (event.getAction() & MotionEvent.ACTION_POINTER_ID_MASK) >> MotionEvent.ACTION_POINTER_ID_SHIFT;
        int isaretNumarasi = event.getPointerId(isaretIndexi);

        switch (aktivite){
            case MotionEvent.ACTION_DOWN:
            case  MotionEvent.ACTION_POINTER_DOWN:
                dokunuldu[isaretNumarasi] = true;
                x[isaretNumarasi] = (int)event.getX(isaretIndexi);
                y[isaretNumarasi] = (int)event.getY(isaretIndexi);
                break;

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:
                dokunuldu[isaretNumarasi] = false;
                x[isaretNumarasi] = (int)event.getX(isaretIndexi);
                y[isaretNumarasi] = (int)event.getY(isaretIndexi);
                break;

            case MotionEvent.ACTION_MOVE:
            int pointerCount = event.getPointerCount();
                for (int i =0; i< pointerCount; i++) {
                    isaretIndexi = i;
                    isaretNumarasi = event.getPointerId(isaretIndexi);
                    x[isaretNumarasi] = (int)event.getX(isaretIndexi);
                    y[isaretNumarasi] = (int)event.getY(isaretIndexi);

                }

                break;

        }
        ekranGoruntusu();

        return true;
    }
}
