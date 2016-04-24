package sam.downstairgame.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

import sam.downstairgame.R;

/**
 * Created by Fujitsu on 24/4/2016.
 */
public class Stair {
    float x; // Stair top left corner (x,y)
    float y;
    float stepX = 10; // Guy's step in (x,y) direction
    float stepY = -5;// gives speed of motion, larger means faster speed
    int lowerX, lowerY, upperX, upperY; // boundaries
    private Context mContext;
    // private Paint paint; // The paint style, color used for drawing
    Bitmap stair;

    // Constructor
    public Stair(int color, Context c) {
        mContext = c;

        // paint= new Paint();
        //paint.setColor(color);
        stair = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(mContext.getResources(),
                R.drawable.stair),150,30, false);

    }

    public void setBounds(int lx, int ly, int ux, int uy,int startX , int startY) {
        lowerX = lx;
        lowerY = ly;
        upperX = ux;
        upperY = uy;
        //starting first in middle
        //random  starting x position, fixed y position
        x = (float) startX;

        //((upperX-700)*Math.random());
        y = (float)startY;
    }
    public int getUpperX(){return upperX;}
    public void setXY(int xx, int yy){
        x=xx;
        y=yy;
    }
    //chnage to
    public boolean move(int speed) {
        // Get new (x,y) position. Movement is always in vertical direction upwards
        y += (stepY-speed);
        // Detect when the guy reaches the bottom of the screen
        // restart at a random location at the top of the screen
        if (y +50 < 0) {
            x = (float) ((upperX-155)*Math.random());
            y =upperY;
            return true;
        }
        else
            return true;
    }
    // When you reset, starts the Android Guy from a random X co-ordinate location
    // at the top of the screen again
    public void reset() {
        x = (float) ((upperX-155)*Math.random());
        y = upperY;
    }
    public RectF getRect() {
        return new RectF( x+10, y+50,x+150, y+100);
    }
    //public RectF getRect() {
    //       return new RectF( x-150, y-25,x+150, y+25);
    // }
    public Rect getRectrect() {
        return new Rect((int)x,(int)y,(int)x+150,(int)y+50);
    }

    public float getX() {
        return x;
    }


    public float getY() {
        return y;
    }

    public void draw(Canvas canvas) {
        // canvas.drawLine(x, y - 100, x, y, paint);
        // canvas.drawRect(x -150, y - 20, x + 150, y+20, paint);
        //  canvas.drawRect(x - 10, y - 40, x + 10, y, paint);
        //draw on left top
        canvas.drawBitmap(stair, x, y+50, null);
        //canvas.drawBitmap(stair, x, y+20, null);

    }

}
