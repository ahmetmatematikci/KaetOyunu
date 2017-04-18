package com.bebektakvimi.ahmetmatematikci.dosyaislemleri;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SDKartaYazma extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        File dir = Environment.getExternalStorageDirectory();
        File subdir = new File(dir.getAbsolutePath() + "/denemeler");
        subdir.mkdirs();

        if (dir.equals(Environment.MEDIA_MOUNTED)) {

            File dosya = new File(subdir, "Dosya.txt");
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(dosya);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            try {
                osw.write("adana yazılım");
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


    } else{
        TextView tv = new TextView(this);
        tv.setText("sd kartınuız bulunammaktadır");
            setContentView(tv);
    }
}
}
