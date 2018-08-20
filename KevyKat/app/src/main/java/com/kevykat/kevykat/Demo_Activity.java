package com.kevykat.kevykat;
import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class Demo_Activity extends AppCompatActivity {


    //Screen Size

    private int screenWidth;
    private int screenHeight;

    //Images
    private ImageView red;
    private ImageView blue;
    private ImageView green;
    private ImageView purple;

    //positions
    private float redX;
    private float redY;
    private float blueX =0;
    private float blueY =0;
    private float greenX;
    private float greenY;
    private float purpleX;
    private float purpleY;

    //Intialize Class
    private Handler handler = new Handler();
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enemy_movement);

        //setting images
        red = (ImageView)findViewById(R.id.red);
        blue = (ImageView)findViewById(R.id.blue);
        green = (ImageView)findViewById(R.id.green);
        purple = (ImageView)findViewById(R.id.purple);

        //Get Screen Size
        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        //Move to out of screen
        red.setX(-80.0f);
        red.setY(-80.0f);
        blue.setX(-80.0f);
        blue.setY(screenHeight + 80.0f);
        //start the timer
        timer.schedule(new TimerTask(){
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

    public void changePos(){
        //rwsw=ed
        redY -= 10;
        if(red.getY() + red.getHeight() < 0){
            redX = (float)Math.floor(Math.random()* (screenWidth - red.getWidth()));
            redY = screenHeight + 100.0f;
        }
        red.setX(redX);
        red.setY(redY);

        //blue
        blueY += 10;
        if(blue.getY() > screenHeight){
            blueX  = (float)Math.floor(Math.random() * (screenWidth - blue.getWidth()));
            blueY = -100.0f;
        }

        blue.setX(blueX);
        blue.setY(blueY);

        //green
        greenX += 10;
        if(green.getX() > screenWidth){
            greenX = -100.0f;
            greenY = (float)Math.floor((Math.random() * (screenHeight - green.getHeight())));
        }
        green.setX(greenX);
        green.setY(greenY);

        //purple
        purpleX -=10;
        if(purple.getX() + purple.getWidth() < 0){
            purpleX = screenWidth + 100.0f;
            purpleY = (float)Math.floor(Math.random() * (screenHeight - purple.getHeight()));
        }
        purple.setX(purpleX);
        purple.setY(purpleY);
    }
}
