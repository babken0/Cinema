package com.nikovarchapet.cinema.cinema;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import static android.content.ContentValues.TAG;


public class
DrawingViews extends View {
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int touchX, touchY;
    private int radius;
    private int distanceX=10;
    private int distanceY;
    private int width;
    private int heigth;
    private Hall hall = new Hall("", 0, 0);



    public DrawingViews(Context context) {
        super(context);
        init();

    }

    public DrawingViews(Context context, AttributeSet attrs ) {
        super(context, attrs);
        init();

    }

    private void init() {

        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w>0 && h>0){
            initWithSize();
        }
    }

    private void initWithSize() {
        width=getWidth();
        heigth=getHeight();
        radius=width/(2*hall.rowCount);///(width-20-hall.rowCount*10)/(2*hall.rowCount);
        distanceY=2*radius;//((heigth-20-radius*hall.seatCount)/hall.seatCount);

    }
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.GRAY);
        for (Place p : hall.places) {
            if(p.free ){
                paint.setColor(Color.YELLOW);
                canvas.drawCircle(p.rownumber * (2*radius) + radius, p.seatnumber * (2*radius) + distanceY, radius - 10, paint);
            }else{
                paint.setColor(Color.GREEN);
                canvas.drawCircle(p.rownumber * (2*radius) + radius, p.seatnumber * (2*radius) + distanceY, radius - 10, paint);
            }
        }


    }

    public void setHall(Hall hall) {
        this.hall = hall;
        initWithSize();
        invalidate();
    }

    private void belongs(double touchx, double touchy){
        for (Place p: hall.places) {
            if(Math.sqrt(Math.pow((p.rownumber * (2*radius) + radius-touchx),2)+Math.pow((p.seatnumber * (2*radius) + distanceY-touchy),2))<20){
                p.free =false;
                invalidate();
                break;
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                touchX = (int) event.getX();
                touchY = (int) event.getY();
                Log.e(TAG,touchX + "55555555555" +touchY);
                belongs(touchX,touchY);
                break;


        }
        return true;
    }
}
