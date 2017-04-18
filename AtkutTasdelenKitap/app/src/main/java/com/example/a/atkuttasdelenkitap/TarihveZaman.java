package com.example.a.atkuttasdelenkitap;

import android.app.TimePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;

public class TarihveZaman extends AppCompatActivity {
    TextView tv;


    public class ZamanHandler implements TimePickerDialog.OnTimeSetListener{

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            SimpleDateFormat sdf = new SimpleDateFormat();
            String str = sdf.format(new Time(hourOfDay,minute,0));
            TarihveZaman.this.setTitle(str);
            tv = (TextView)findViewById(R.id.textView13);

            tv.setText(Integer.toString(hourOfDay));

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TimePickerDialog dlg = new TimePickerDialog(this,new ZamanHandler(),8,0,true);


        //setContentView(R.layout.activity_tarihve_zaman);
        dlg.setTitle("Alarm Saati");
        dlg.show();
    }
}
