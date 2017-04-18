package com.example.a.atkuttasdelenkitap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

public class RelativeLayoutGosterim extends AppCompatActivity {
    private RelativeLayout pnl;
    private RelativeLayout.LayoutParams prms1, prms2;
    private Button btn1, btn2;

    private void init() {
        pnl = new RelativeLayout(this);

        btn1 = new Button(this);
        btn1.setText("İlk Buton");
        btn1.setId(1);

        prms1 = new RelativeLayout.LayoutParams(200,80);
        prms1.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        prms1.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        btn1.setLayoutParams(prms1);
        //////////////////

        btn2 = new Button(this);
        btn2.setText("İlk Buton");
        btn2.setId(2);

        prms2 = new RelativeLayout.LayoutParams(170,90);
        prms2.addRule(RelativeLayout.LEFT_OF, btn1.getId());
        prms2.addRule(RelativeLayout.ABOVE, btn1.getId());
        btn2.setLayoutParams(prms2);


        ///////////
        pnl.addView(btn1);
        pnl.addView(btn2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_relative_layout_gosterim);
        init();
        setContentView(pnl);
    }
}
