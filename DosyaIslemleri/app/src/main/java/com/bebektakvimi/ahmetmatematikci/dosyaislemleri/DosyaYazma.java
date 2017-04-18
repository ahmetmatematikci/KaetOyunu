package com.bebektakvimi.ahmetmatematikci.dosyaislemleri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class DosyaYazma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosya_yazma);

        File dosya = new File(this.getFilesDir(), "Deneme.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(dosya);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        try {
            osw.write( "ilk yazılar desti desti ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
