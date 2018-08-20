//package com.kevykat.kevykat;
//
//import android.content.Context;
//import android.graphics.Path;
//import android.support.v4.content.res.ResourcesCompat;
//import android.util.AttributeSet;
//import android.view.View;
//import android.graphics.*;
//
//
//public class MyCanvasView extends View {
//
//    MyCanvasView(Context context) {
//        this(context, null);
//    }
//
//    public MyCanvasView(Context context, AttributeSet attributeSet) {
//        super(context);
//
//        int backgroundColor;
//
//        //int color = (A & 0xff) << 24 | (R & 0xff) << 16 | (G & 0xff) << 8 | (B & 0xff);
//        //int color2 = (A & 0xff) << 200 | (R & 0xff) << 200 | (G & 0xff) << 200 | (B & 0xff);
//        //Color mDrawColor = ResourcesCompat.getColor(getResources(), , null);
//        //backgroundColor = ResourcesCompat.getColor(getResources(), R.color., null);
//
//        // Holds the path we are currently drawing.
//        Path mPath = new Path();
//        // Set up the paint with which to draw.
//        Paint mPaint = new Paint();
//        //mPaint.setColor(backgroundColor);
//        //mPaint.setColor();
//        // Smoothes out edges of what is drawn without affecting shape.
//        mPaint.setAntiAlias(true);
//        // Dithering affects how colors with higher-precision than the device
//        // are down-sampled.
//        mPaint.setDither(true);
//        mPaint.setStyle(Paint.Style.STROKE); // default: FILL
//        mPaint.setStrokeJoin(Paint.Join.ROUND); // default: MITER
//        mPaint.setStrokeCap(Paint.Cap.ROUND); // default: BUTT
//        mPaint.setStrokeWidth(12); // default: Hairline-width (really thin)
//    }
//}
