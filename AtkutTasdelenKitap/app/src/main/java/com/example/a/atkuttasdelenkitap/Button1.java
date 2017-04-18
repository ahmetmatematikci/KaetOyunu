package com.example.a.atkuttasdelenkitap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Button1 extends AppCompatActivity {
    private  int sayac = 0;
    private TextView tv;
    private Button btn, btn2,btn3;

    private void init() {
        tv = (TextView)findViewById(R.id.textView);
        btn = (Button)findViewById(R.id.btnIncrement);
        btn2 = (Button)findViewById(R.id.btnIncrement2);
        btn3 = (Button)findViewById(R.id.btnIncrement3);
        btn2.setOnClickListener(new ClickHandler());

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                --sayac;
                tv.setText(String.format("Sayaç: %d", sayac));
            }
        });


    }


    public void BtnClick(View view) {
        ++sayac;
        tv.setText(String.format("Sayaç: %d" , sayac));
    }

    public class ClickHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            ++sayac;
            tv.setText(String.format("Sayaç : %d", sayac));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button1);
        init();
    }
}
