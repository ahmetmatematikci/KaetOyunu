package com.bebektakvimi.ahmetmatematikci.dosyaislemleri;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;

public class KokDizini extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //setContentView(R.layout.activity_kok_dizini);

        File rootDir = Environment.getRootDirectory();
        File content[] = rootDir.listFiles();
        String str = "";
        for (File f:content) {
            if (f.isDirectory()) {
                str +=String.format("<dir>%s %d bytes \n \r", f.getName(), f.getFreeSpace());
            }else {
                str +=String.format("%s %d bytes \n\r", f.getName(), f.getFreeSpace());
            }
        }
        TextView tv = new TextView(this);
        tv.setText(str);
        setContentView(tv);

    }
}
