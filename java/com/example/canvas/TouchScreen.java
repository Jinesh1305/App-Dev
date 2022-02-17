package com.example.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class TouchScreen extends View {
    Paint mypaint;
    Path mypath;
     public TouchScreen(Context context, AttributeSet attrs){
         super(context,attrs);
         mypaint=new Paint();
         mypath=new Path();
         mypaint.setColor(Color.RED);
         mypaint.setStrokeWidth(6f);
         mypaint.setStyle(Paint.Style.STROKE);
         mypaint.setStrokeJoin(Paint.Join.ROUND);
     }
    public boolean onTouchEvent(MotionEvent event){
        float event_x=event.getX();
        float event_y=event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:   // placing or touching the screen
                mypath.moveTo(event_x,event_y);
                return true;
            case MotionEvent.ACTION_MOVE:   // Dragging on the screen
                mypath.lineTo(event_x,event_y);
                break;
            case MotionEvent.ACTION_UP:  // release
                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }
    public void onDrawForeground(Canvas c){
        c.drawPath(mypath,mypaint);
    }
    public void clearCanvas(){
         invalidate();
         mypath.reset();
    }

}
