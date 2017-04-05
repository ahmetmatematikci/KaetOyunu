package com.example.a.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class TusBasmaActivite extends AppCompatActivity implements View.OnKeyListener {
    String metin = "";
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv = new TextView(this);
        tv.setText("Bir tuşa basınız");
        tv.setOnKeyListener(this);
        tv.setFocusableInTouchMode(true);
        tv.requestFocus();
        setContentView(tv);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        metin = "";
        switch (event.getAction()) {
            case KeyEvent.ACTION_DOWN:
                metin = metin + " basili , ";
                break;
            case KeyEvent.ACTION_UP:
                metin = metin + "cekili, ";
                break;
        }

        metin = metin + event.getKeyCode();
        metin = metin + ", ";
        metin = metin + (char)event.getUnicodeChar();
        tv.setText(metin);
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK)
                   return false;
        else
            return true;
    }
}
