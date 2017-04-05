package com.example.a.myapplication;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.io.IOException;
import java.io.InputStream;

public class ResimCizAktivite extends AppCompatActivity {
    class RenderView extends View {
        Bitmap resim;
        Rect hedef = new Rect();

        public RenderView(Context context) {
            super(context);
            try {
                AssetManager assetManager=context.getAssets();
                InputStream inputStream = assetManager.open("resim.jpg");
                resim = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
            }catch (IOException e) {
               // e.printStackTrace();
            }
        }

        @Override
        protected void onDraw(Canvas canvas) {
            hedef.set(50,50,350,450);
            canvas.drawBitmap(resim, null,hedef,null);
            invalidate();
           // super.onDraw(canvas);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_resim_ciz_aktivite);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(new RenderView(this));
    }
}
