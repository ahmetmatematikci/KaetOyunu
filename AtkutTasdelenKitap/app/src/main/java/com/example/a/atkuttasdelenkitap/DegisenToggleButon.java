package com.example.a.atkuttasdelenkitap;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class DegisenToggleButon extends AppCompatActivity {
    private LinearLayout pnl;
    private Switch swtWaveForm;
    private TextView tv;

    private void init() {
        pnl = new LinearLayout(this);
        pnl.setOrientation(LinearLayout.HORIZONTAL);

        swtWaveForm = new Switch(this);
        //Bu özellikl ap 21 ile desteklenme
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP) {
            swtWaveForm.setShowText(false);
        }
        swtWaveForm.setTextOff("Kare Dalga");
        swtWaveForm.setTextOn("Sinüs  Dalga");
        pnl.addView(swtWaveForm);

        tv = new TextView(this);
        pnl.addView(tv);

    }

    private void setSwtWaveForm_CheckedChange() {
        swtWaveForm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (swtWaveForm.isChecked()) {
                    tv.setText(swtWaveForm.getTextOn());
                } else {
                    tv.setText(swtWaveForm.getTextOff());
                }
            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(pnl);
        setSwtWaveForm_CheckedChange();
    }
}
