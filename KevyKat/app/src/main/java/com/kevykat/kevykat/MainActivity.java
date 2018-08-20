package com.kevykat.kevykat;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

/*
////CURRENT KNOWN PROBLEMS
-shrinks at bottom and right sides
-lost at top and left sides
    -need window size in order to create appropriate margins
        -to get window size i need to extend activity
        -extending activity is not compatible with srccompat files
        Solution:
            -stay at extend AppCompatActivity
            -create a GlobalLayoutListener to get the universal window measurements

-landscape mode not working
-blah blah blah
*/
/*

MainActivity
Summary:
the process of the gameplay itself

Expectations:
-Transition from the main menu and to the game itself
-run the game process
-keep a score
-pause menu
    -pause upon input
    -resume upon input
    -exit upon input
    -etc.
-Transition to the main menu or other menus

 */
public class MainActivity extends AppCompatActivity {

    //The layout that is wrapped around the main character
    private ViewGroup mainLayout;
    //main character
    private ImageView image;

    //new positions
    private int xDelta;
    private int yDelta;

    private int windowHeight;
    private int windowWidth;

    //creation of the xml (in this case "Activity_touch" onto the phone screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //call necessary parent constructors
        super.onCreate(savedInstanceState);
        //sets the view for the phone screen
        setContentView(R.layout.activity_touch);

        //instantiate drawables that will be used
        mainLayout = (RelativeLayout) findViewById(R.id.main);

        //add constraints to layou


        image = (ImageView) findViewById(R.id.image);

        //settings the TouchListener action event for the main character
        image.setOnTouchListener(onTouchListener());

    }


    //Action event for when the phone screen is touched
    private OnTouchListener onTouchListener() {

        //return dynamic touchlistenr
        return new OnTouchListener(){



            //parent function that is used to initiate the touch event
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {

                //getting coordinate where the screen was touched
                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();
                Log.d("Kevin","(" + x + "," + y + ")");


                //switch statement for the following: press, release, and drag on phone screen
                switch (event.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        //calculating new position
                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;
                        view.setLayoutParams(lParams);
                        Log.d("Kevin", "ACTION DOWN");
                        break;

                    case MotionEvent.ACTION_UP:
                        Toast.makeText(MainActivity.this,
                                "thanks for new location!", Toast.LENGTH_SHORT)
                                .show();
                        Log.d("Kevin", "ACTION UP");
                        break;

                    case MotionEvent.ACTION_MOVE:

                        //getting the paramters of the layout
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view
                                .getLayoutParams();

                        //changing the new position of the layout
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;
                        view.setLayoutParams(layoutParams);

                        Log.d("Kevin", "ACTION MOVE");
                        break;
                }
                mainLayout.invalidate();
                return true;
            }
        };
    }
}