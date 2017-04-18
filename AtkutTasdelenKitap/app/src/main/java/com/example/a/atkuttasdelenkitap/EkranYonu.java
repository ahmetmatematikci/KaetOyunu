package com.example.a.atkuttasdelenkitap;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class EkranYonu extends AppCompatActivity {

    private View PortraitDesign() {
        LinearLayout p = new LinearLayout(this);
        p.setBackgroundColor(Color.BLUE);
        Button btn = new Button(this);
        btn.setText("Portrait- Düşey");
        p.addView(btn);
        return p;
    }

    private View LandspaceDesign() {
        AbsoluteLayout p = new AbsoluteLayout(this);
        p.setBackgroundColor(Color.GREEN);
        CheckBox chk = new CheckBox(this);
        chk.setText("Landspace yaty");
        p.addView(chk);
        return p;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowManager wm = (WindowManager)this.getSystemService(Context.WINDOW_SERVICE);
        Display dsp = wm.getDefaultDisplay();

        if (dsp.getHeight() > dsp.getWidth())
            setContentView(PortraitDesign());
        else
            setContentView(LandspaceDesign());
       // setContentView(R.layout.activity_ekran_yonu);
    }
}
