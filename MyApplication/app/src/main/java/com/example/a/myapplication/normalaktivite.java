package com.example.a.myapplication;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class normalaktivite extends Activity {
    String metin = "";
    TextView tv;

    private void ekrandaGoster(String text){
        metin = metin +text + "\n";
        tv.setText(metin);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv = new TextView(this);
        tv.setText(metin);
        setContentView(tv);
        ekrandaGoster("OnCreate cagirildi");
        //setContentView(R.layout.activity_normalaktivite);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ekrandaGoster("On resume cağirildi");
    }

    @Override
    protected void onPause() {
        super.onPause();
        ekrandaGoster("On pausse cağirildi");
    }
}
