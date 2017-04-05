package com.example.a.myapplication;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class AssestAktivite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        setContentView(tv);
        AssetManager assetManager = getAssets();
        InputStream inputStream = null;

        try {
            inputStream = assetManager.open("deneme/uydurma.txt");
            String metin = metinYukle(inputStream);
            tv.setText(metin);
        }catch (IOException e) {
            tv.setText("Dosya yok");
        }

    }
    public String metinYukle(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[4096];
        int uzunluk = 0;
        while ((uzunluk = inputStream.read(bytes) ) > 0)
            byteArrayOutputStream.write(bytes,0,uzunluk);
        return new String(byteArrayOutputStream.toByteArray(),"UTF8");
    }
}
