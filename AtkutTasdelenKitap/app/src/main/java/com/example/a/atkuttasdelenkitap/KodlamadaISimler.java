package com.example.a.atkuttasdelenkitap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class KodlamadaISimler extends AppCompatActivity {

    //Global tanımlanmış değişkenler

    private LinearLayout pnlMain;
    private Button btnDeneme;
    private CheckBox checkBox;

    private void init() {
        //pnlMain = (LinearLayout)findViewById(R.id.pnlMain);
        btnDeneme = (Button)findViewById(R.id.btnDeneme);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kodlamada_isimler);
        init();
    }
}
