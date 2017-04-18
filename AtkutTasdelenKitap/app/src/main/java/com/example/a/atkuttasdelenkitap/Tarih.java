package com.example.a.atkuttasdelenkitap;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

public class Tarih extends AppCompatActivity {
    TextView tv;

    public class TarihHandler implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            int m = month +1;
            Tarih.this.setTitle(dayOfMonth +"/" + m + "/" + year);
            tv = (TextView)findViewById(R.id.textView25);
            tv.setText(year + "/ " + month + "/" + dayOfMonth) ;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarih);
        DatePickerDialog dlg = new DatePickerDialog(this,new TarihHandler(), 2017,07,12);
        dlg.setTitle("Alarm tarigi");
        dlg.show();
    }
}
