package com.example.a.myapplication;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;

public class SurfaceViewAktivite extends Activity {

    FastRenderView rView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        rView = new FastRenderView(this);

        setContentView(rView);

    }

    @Override
    protected void onResume() {
        super.onResume();

        rView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        rView.pause();
    }

    class FastRenderView extends SurfaceView implements Runnable {

        Thread rThread = null;
        SurfaceHolder holder;
        volatile boolean calisiyor = false;

        public FastRenderView (Context context) {
            super(context);
            holder = getHolder();
        }

        public void resume() {
            calisiyor = true;
            rThread = new Thread(this);
            rThread.start();
        }


        @Override
        public void run() {

            while (calisiyor) {
                if (!holder.getSurface().isValid())
                    continue;
                Canvas canvas = holder.lockCanvas();
                canvas.drawRGB(255,0,0);
                holder.unlockCanvasAndPost(canvas);
            }

        }

        public void pause() {
            calisiyor = false;
            while (true) {
                try {
                    rThread.join();
                }catch (InterruptedException e){

                }
            }
        }
    }
}
