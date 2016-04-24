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
public class Monster {
    float x = 50; // Cannon's center (x,y)
    float y =0;
    float stepX = 50; // Cannon's step in  x direction
    float stepY = 15;
    int lowerX, lowerY, upperX, upperY;
    //private Paint paint; // The paint style, color used for drawing
    Bitmap monster;

    private Context mContext;

    // Constructor
    public Monster(int color, Context c) {
        mContext = c;


        // create a bitmap from the supplied image (the image is the icon that is part of the app)
        monster= Bitmap.createScaledBitmap(BitmapFactory.decodeResource(mContext.getResources(),
                R.drawable.monstertwo),50,50, false);

    }


    public void setBounds(int lx, int ly, int ux, int uy) {
        lowerX = lx;
        lowerY = ly;
        upperX = ux;
        upperY = uy;

        if (x < 0 && y < 0) {
            x = ux/2;
            y = uy;
        }
        x = (float) (ux)/2;
        y=lowerY;
    }

    public void fall(){
        y+=stepY;
    }

    public void moveLeft() {
        // Get new (x,y) position of the canvas by moving it left
        // when the left button is clicked. Ensure that it does not
        // move off the screen.
        if (x - 30 > 0) {
            x -= stepX;
        }
    }
    public boolean fallout(){
        if(y> upperY+10)
            return true;
        else
            return false;
    }
    public void moveRight() {
        // Get new (x,y) position of the canvas by moving it right
        // when the right button is clicked. Ensure that it does not
        // move off the screen.
        if (x + 30 < upperX) {
            x += stepX;
        }
    }
    // Returns the rectangle enclosing the Guy. Used for collision detection
    public float getPosition() {
        return x;
    }
    public RectF getRect() {
        return new RectF(x,y+50,x+50,y+100);
    }
    public Rect getRectrect() {
        return new Rect((int)x-25,(int)y-25,(int)x+25,(int)y+25);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setY(float speed){y=speed;}

    public void draw(Canvas canvas) {
        // left top
        canvas.drawBitmap(monster, x, y, null);

    }
}
