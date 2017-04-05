package com.example.a.myapplication;

import android.app.Activity;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SDKartAktivite extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        setContentView(tv);

        String durum = Environment.getExternalStorageState();

        if (!durum.equals(Environment.MEDIA_MOUNTED)) {
            tv.setText("SD kart bulunamadı");
        } else {
            File anaDizin = Environment.getExternalStorageDirectory();
            File metinDosyasi = new File(anaDizin.getAbsolutePath() + File.separator + "metin.txt");

            try {
                dosyaYaz(metinDosyasi, "deneme yazısı");
                String metin = dosyaOku(metinDosyasi);
                tv.setText(metin);
                if (!metinDosyasi.delete()) {
                    tv.setText("Dosya silinemiyor");
                }

            } catch (IOException e) {
                tv.setText("Bir kaç hata var" + e.getMessage());
            }
        }

    }


    private void dosyaYaz(File file, String s) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(s);
        writer.close();


    }
    private String dosyaOku(File file) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder metin = new StringBuilder();
        String line;
        while ((line =reader.readLine()) !=null) {
            metin.append(line);
            metin.append("\n");
        }
        reader.close();
        return metin.toString();
    }

}
