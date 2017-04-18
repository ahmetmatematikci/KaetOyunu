package com.example.a.atkuttasdelenkitap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Button2 extends AppCompatActivity {
    private  int sayac = 0;
    private LinearLayout pnl;
    private TextView tv;
    private Button btn1, btn2;

    private void init() {
        pnl = new LinearLayout(this);
        pnl.setOrientation(LinearLayout.VERTICAL);

        tv = new TextView(this);
        tv.setText("Sayaç : ");

        btn1 = new Button(this);
        btn1.setText("Arttır");

        btn2 = new Button(this);
        btn2.setText("Azalt");

        pnl.addView(btn1);
        pnl.addView(btn2);
        pnl.addView(tv);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayac++;
                tv.setText(String.format("Sayaç : %d" , sayac));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayac--;
                tv.setText(String.format("Sayaç : %d" , sayac));
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(pnl);
    }
}
