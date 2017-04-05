package com.example.a.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MetinYazAktivite extends AppCompatActivity {
    class RenderView extends View {
        Paint paint;
        Typeface fonttipi;
        Rect bounds = new Rect();

        public RenderView(Context context) {
            super(context);
            paint = new Paint();
            fonttipi = Typeface.createFromAsset(context.getAssets(),"x.ttf");
        }

        @Override
        protected void onDraw(Canvas canvas) {
            //super.onDraw(canvas);
            paint.setColor(Color.RED);
            paint.setTypeface(fonttipi);
            paint.setTextSize(120);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText("Ahmet KILIÇ", canvas.getWidth()/2,250, paint);
            String text ="ADANA";
            paint.setColor(Color.GREEN);
            paint.setTextSize(90);
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds(text,0,text.length(),bounds);
            canvas.drawText(text,canvas.getWidth()-bounds.width(), 640, paint);
            invalidate();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_metin_yaz_aktivite);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(new RenderView(this));
    }
}
