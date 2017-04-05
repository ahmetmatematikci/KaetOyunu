package com.example.a.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class SekilCizAktivite extends AppCompatActivity {

    class YeniView extends View{
        Paint paint;

        public YeniView(Context context) {
            super(context);
            paint = new Paint();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawRGB(171,245,46);
            paint.setColor(Color.BLUE);
            canvas.drawLine(canvas.getWidth() -1,0,0,canvas.getHeight()-1,paint);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setColor(0xfc77af11);
            canvas.drawCircle(canvas.getWidth()/2, canvas.getHeight()/2, 40,paint);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(0x230ac0ff);
            canvas.drawRect(200,150,250,200,paint);
            invalidate();
           // super.onDraw(canvas);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(new YeniView(this));
    }
}
