package com.example.a.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IvmeOlcer extends AppCompatActivity implements SensorEventListener{
    TextView tv;
    String metin = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv = new TextView(this);
         setContentView(tv);
        SensorManager manager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() ==0) {
            tv.setText("Ivme Olçer yok");
        }else {
            Sensor ivmeolcer = manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
            if (!manager.registerListener(this,ivmeolcer,SensorManager.SENSOR_DELAY_GAME)) {
                tv.setText("Sensor kayıt edilemiyor.");
            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        metin = "";
        metin = "x: ";
        metin = metin + event.values[0];
        metin = "y: ";
        metin = metin + event.values[1];
        metin = "z: ";
        metin = metin + event.values[2];
        tv.setText(metin.toString());

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
