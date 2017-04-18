package com.bebektakvimi.ahmetmatematikci.dosyaislemleri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class DosyaOkuma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosya_okuma);

        File dosya = new File(this.getFilesDir(), "Deneme.txt");

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(dosya);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String output = "", line = "";
        for (;;) {
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (line !=null) {
                output +=line + "\n\r";

            }
            break;
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView tv = new TextView(this);
        tv.setText(output);
        this.setContentView(tv);
    }
}
