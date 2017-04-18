package com.example.a.atkuttasdelenkitap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.Toast;

public class ToastOrnek extends AppCompatActivity {

    private AbsoluteLayout pnl;
    private Button btn;

    private void init() {
        pnl = new AbsoluteLayout(this);

        btn = new Button(this);
        btn.setText("Toast Göster");
        pnl.addView(btn);
    }

    private void btn_Click() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(ToastOrnek.this, "Toaas Başlığı", Toast.LENGTH_LONG);
                t.setGravity(Gravity.CENTER, -5 ,10);
                t.show();
            }
        });
    }

    private void registerHandlers() {
        btn_Click();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        registerHandlers();
        setContentView(pnl);
    }
}
