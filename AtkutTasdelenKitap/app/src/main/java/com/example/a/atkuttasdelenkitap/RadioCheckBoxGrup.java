package com.example.a.atkuttasdelenkitap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class RadioCheckBoxGrup extends AppCompatActivity {
    private EditText txtTaksitSayisi;
    private LinearLayout pnlTaksitler, pnlTaksitSayisi;
    private RadioButton rdoTaksit, rdoTekCekim;

    private void init() {
        pnlTaksitler = (LinearLayout)findViewById(R.id.pnlTaksitler);
        pnlTaksitSayisi = (LinearLayout)findViewById(R.id.pnlTaksitSayisi);
        txtTaksitSayisi = (EditText)findViewById(R.id.txtTaksitSayisi);
        rdoTaksit = (RadioButton)findViewById(R.id.rdoTaksit);
        rdoTekCekim = (RadioButton)findViewById(R.id.rdoTekCekim);
    }

    public class RadioSelection implements CompoundButton.OnCheckedChangeListener
    {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (rdoTaksit.isChecked()) {
                pnlTaksitler.setVisibility(View.VISIBLE);
                pnlTaksitSayisi.setVisibility(View.VISIBLE);
            } else {
                pnlTaksitler.setVisibility(View.INVISIBLE);
                pnlTaksitSayisi.setVisibility(View.INVISIBLE);
            }
        }
    }

    private void registerListeners() {
        rdoTaksit.setOnCheckedChangeListener(new RadioSelection());
        rdoTekCekim.setOnCheckedChangeListener(new RadioSelection());
    }

    public void btnTaksitlendirClick(View v) {
        pnlTaksitler.removeAllViews();

        int taksitSayisi = Integer.valueOf(txtTaksitSayisi.getText().toString());

        for (int i=1; i<=taksitSayisi; i++ ) {

            CheckBox chk = new CheckBox(this);
            chk.setText(i+ ".Taksit");

            //Checkboxlar için event handler

            chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (((CheckBox)buttonView).isChecked()) {
                        String str = ((CheckBox)buttonView).getText().toString();
                        Toast.makeText(RadioCheckBoxGrup.this, str, Toast.LENGTH_LONG ).show();
                    }
                }
            });
            pnlTaksitler.addView(chk);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_radio_check_box_grup);
        init();
        registerListeners();
    }
}
