package com.kevykat.kevykat;

import android.content.Intent;
import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    //variables
    private int frameHeight;

    private ImageView image2;
    private boolean start_flg = false;
    private boolean action_flg = false;
    private Handler handler = new Handler();
    private Timer timer = new Timer();
    //private SoundPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        //calling parent function with "super"
        super.onCreate(savedInstanceState);

        //initalizing new GameView object
        //sets object as current phone screen
        //setContentView(R.layout.activity_main);


        image2 = (ImageView)findViewById(R.id.imageView2);

        setContentView(R.layout.main_game);

    }

    public boolean onTouchEvent(MotionEvent me){

        if (start_flg == false) {

            start_flg = true;

            // Why get frame height and box height here?
            // Because the UI has not been set on the screen in OnCreate()!!

            int boxY = (int)image2.getY();

            // The box is a square.(height and width are the same.)
            int boxSize = image2.getHeight();

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            changePos();
                        }
                    });
                }
            }, 0, 20);


        }
        else {
            if (me.getAction() == MotionEvent.ACTION_DOWN) {
                action_flg = true;

            } else if (me.getAction() == MotionEvent.ACTION_UP) {
                action_flg = false;
            }
        }

        return true;

    }

    public void changePos(){
        image2.setX(image2.getX() + 55);
    }

    // Disable Return Button
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    return true;
            }
        }

        return super.dispatchKeyEvent(event);
    }
}
