package com.example.a.atkuttasdelenkitap;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;

public class TableLayoutMatrisOrnegi extends AppCompatActivity {
    private HorizontalScrollView hsv;
    private TableLayout pnl;
    private TableRow row;
    private Button btn;

    private void init(){
        hsv = new HorizontalScrollView(this);
        pnl = new TableLayout(this);
        for (int r = 1; r<6; ++r) {
            row = new TableRow(this);
            for (int c = 1 ; c<5; ++c) {
                btn = new Button(this);
                btn.setText(String.format("R:%d C:%d",r,c));
                btn.setWidth(150);
                btn.setHeight(60);
                row.addView(btn);
            }
            pnl.addView(row);
           // pnl.setOrientation(LinearLayout.HORIZONTAL);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        //setContentView(R.layout.activity_table_layout_matris_ornegi);
        setContentView(pnl);
        //////Child elemanı yakalama////
        TableRow tr = (TableRow)pnl.getChildAt(2);
        ((Button)tr.getChildAt(1)).setBackgroundColor(Color.YELLOW);
       // hsv.addView(pnl);

    }
}
