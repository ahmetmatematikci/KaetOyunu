package com.example.a.atkuttasdelenkitap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;

public class GridLayoutMatris extends AppCompatActivity {
    private GridLayout pnl;
    private Button btn;

    private void init() {

        pnl = new GridLayout(this);
        pnl.setOrientation(GridLayout.VERTICAL);
        pnl.setColumnCount(4);
        pnl.setRowCount(3);

        for (int i =0; i<12; ++i) {
            btn = new Button(this);
            btn.setText("D" + i);
            btn.setWidth(120);
            btn.setHeight(90);
            pnl.addView(btn);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_grid_layout_matris);

        init();
        setContentView(pnl);
    }
}
