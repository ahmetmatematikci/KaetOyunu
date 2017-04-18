package com.example.a.atkuttasdelenkitap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EkranDondurmeBellek extends AppCompatActivity {
    TextView tv;
    Button btn;
    int say;



    @Override
    protected void onCreate(Bundle s) {
        super.onCreate(s);
        setContentView(R.layout.activity_ekran_dondurme_bellek);
        tv = (TextView)findViewById(R.id.bellektxt);
        btn = (Button)findViewById(R.id.bellekbuton);


        if (s!=null) {
            say = s.getInt("sayac");
            tv.setText("Sayaç: " + say);
        } else {
            say = 0;
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                say++;
                tv.setText("Sayac: " + say);
            }
        });



        }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("sayac", say);
    }
}

