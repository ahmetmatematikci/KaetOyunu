package com.example.a.myapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {
    String aktivite[] = {"normalaktivite", "TekDokunmatikAktivite","CokluDokunmatikACtivite", "TusBasmaActivite",
            "IvmeOlcer", "AssestAktivite","SDKartAktivite","SesOynatAktivite","MuzikOynatAktivite",
            "TamEkranAktivite","YeniCizAktivite","SekilCizAktivite","ResimCizAktivite","MetinYazAktivite","SurfaceViewAktivite"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        setListAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, aktivite));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String aktiviteAdi = aktivite[position];
        try {
            Class clazz = Class.forName("com.example.a.myapplication." + aktiviteAdi);
            Intent intent = new Intent(this, clazz);
            startActivity(intent);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
