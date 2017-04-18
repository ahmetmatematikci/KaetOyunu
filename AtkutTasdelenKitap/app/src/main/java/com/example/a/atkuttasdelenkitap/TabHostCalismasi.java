package com.example.a.atkuttasdelenkitap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class TabHostCalismasi extends AppCompatActivity {
    private TabHost host;

    private void init()
    {
        host = (TabHost) findViewById(android.R.id.tabhost);

        TabHost.TabSpec sp1 = host.newTabSpec("X");
        TabHost.TabSpec sp2 = host.newTabSpec("Y");
        TabHost.TabSpec sp3 = host.newTabSpec("Z");

        sp1.setContent(new Intent(this, Sekme1.class));
        sp2.setContent(new Intent(this, Sekme2.class));
        sp3.setContent(new Intent(this, Sekme3.class));

        sp1.setIndicator("Depo");
        sp2.setIndicator("Muhasebe");
        sp3.setIndicator("Finans");

        host.addTab(sp1);
        host.addTab(sp2);
        host.addTab(sp3);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


}
