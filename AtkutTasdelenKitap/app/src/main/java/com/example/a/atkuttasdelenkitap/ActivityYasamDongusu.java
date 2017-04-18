package com.example.a.atkuttasdelenkitap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ActivityYasamDongusu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_yasam_dongusu);
        Log.e("csd", "onCreatte calıştı aktive nesnesi yaratıldı");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("csd", "onResume calıştı aktive nesnesi stackte ön plana geldi");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("csd", "onDestroy calıştı aktive nesnesi yok edildi");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("csd", "onPause calıştı aktive nesnesi stacte arka plan gitti");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("csd", "onCreatte calıştı aktive nesnesi yeniden yaratıldı");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("csd", "onCreatte calıştı aktive nesnesi calisti");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("csd", "onCreatte calıştı aktive nesnesi durdu");
    }
}
