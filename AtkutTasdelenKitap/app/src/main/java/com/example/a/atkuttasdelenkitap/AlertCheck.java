package com.example.a.atkuttasdelenkitap;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AlertCheck extends AppCompatActivity {

    private String s = "Seçtikleriniz :   ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("İşletim sistemi tercihinz");
        final CharSequence items[] = {"CSDOS", "WİNDOWS", "MACOSX", "PARDUS"};

        final boolean checkedItems[] = {true,false,true,false};
        DialogInterface.OnMultiChoiceClickListener listener = new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    s +=items[which] + "n\r";
                    Toast.makeText(AlertCheck.this, items[which], Toast.LENGTH_LONG).show();
                }
            }
        };
        dlg.setMultiChoiceItems(items,checkedItems,listener);
        dlg.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(AlertCheck.this, s,Toast.LENGTH_LONG).show();
            }
        });
        dlg.show();
        setContentView(R.layout.activity_alert_check);

    }

}
