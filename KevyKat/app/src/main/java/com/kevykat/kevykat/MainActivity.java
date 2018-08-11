package com.kevykat.kevykat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    GameView g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //calling parent function with "super"
        super.onCreate(savedInstanceState);

        //initalizing new GameView object
        g = new GameView(this);

        //sets object as current phone screen

        //screen for the game
        setContentView(g);

        //screen for activity.main.xml layout
        //setContentView(R.layout.activity_main);

    }
}
