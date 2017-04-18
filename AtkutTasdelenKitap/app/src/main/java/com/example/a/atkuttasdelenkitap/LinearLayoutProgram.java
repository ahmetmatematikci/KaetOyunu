package com.example.a.atkuttasdelenkitap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class LinearLayoutProgram extends AppCompatActivity {
    private ScrollView sv;
    private CheckBox chk;
    private Button btn;
    private LinearLayout pnl;

    private void init() {
        sv = new ScrollView(this);

        pnl = new LinearLayout(this);
        pnl.setOrientation(LinearLayout.VERTICAL);
        for (int i = 1; i<=20;++i) {
            if (i%2 ==0) {
                chk = new CheckBox(this);
                chk.setId(i);
                chk.setText("Seçenek " +i);
                //layout parametreleri
                LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(200,80);
                lp1.setMargins(10,5,10,5);
                lp1.gravity = Gravity.RIGHT;
                chk.setLayoutParams(lp1);
                pnl.addView(chk);


            } else {
                btn = new Button(this);
                btn.setId(i);
                btn.setText("Düğme " + i);
                LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(250,90);
                lp2.setMargins(10,5,10,5);
                btn.setLayoutParams(lp2);
                pnl.addView(btn);
            }
        }
        //Linerlayout scrollwiew a child olarak eklenmiştir.
        sv.addView(pnl);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(sv);
    }
}
