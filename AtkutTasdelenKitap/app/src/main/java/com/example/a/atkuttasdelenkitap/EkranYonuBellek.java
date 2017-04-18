package com.example.a.atkuttasdelenkitap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EkranYonuBellek extends AppCompatActivity {
    private int count;


    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        if (s != null && s.containsKey("devir")) {
            count = s.getInt("devir");
            s.putInt("devir", ++count);
        } else {
            count = 1;
        }
        this.setTitle("Dönüş sayısı " + count);


       // setContentView(R.layout.activity_ekran_yonu_bellek);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("devir", count);
        super.onSaveInstanceState(outState);
    }
}
