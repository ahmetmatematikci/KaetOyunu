package com.example.a.atkuttasdelenkitap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProgramatikYontem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_programatik_yontem);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);

        Button child1 = new Button(this);
        child1.setText("Düğme");
        child1.setWidth(200);
        child1.setHeight(80);
        root.addView(child1);

        CheckBox child2 = new CheckBox(this);
        child2.setText("Düğme");
        root.addView(child2);

        TextView child3 = new TextView(this);
        child3.setText("Programatik Yöntem");
        child3.setWidth(200);
        child3.setHeight(40);
        root.addView(child3);

        this.setContentView(root);
    }
}
