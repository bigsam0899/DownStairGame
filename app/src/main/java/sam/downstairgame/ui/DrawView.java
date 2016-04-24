package sam.downstairgame.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;


/**
 * Created by Fujitsu on 24/4/2016.
 */
public class DrawView extends View {

    private int width, height;
    boolean end;
    boolean restartGame;
    Context mContext;
    private int countingStair;
    // We can have multiple bullets and explosions
    // keep track of them in ArrayList
//    ArrayList<Bullet> bullets;
//    ArrayList<Explosion> explosions;
//    Cannon cannon;
//    AndroidGuy androidGuy;
    // ArrayList<Stair> stairs;
    // Stair stair, stair2;
    Monster monster;
    //int a[]= new int[5];
    Stair s[] = new Stair[5];

    public boolean getEnd() {
        return end;
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        end = false;
        mContext = context;
        countingStair = 0;
        //creaate a stair obj
        // stair = new Stair(Color.RED, mContext);
        // stair2 = new Stair(Color.RED, mContext);
        for (int i = 0; i < 5; i++) {
            s[i] = new Stair(Color.RED, mContext);
        }
        // create a cannon object
        monster = new Monster(Color.BLUE, mContext);

        //  stairs = new ArrayList<Stair>();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawGameBoard(canvas);

        end = monster.fallout();

        // Delay for a short while before forcing another redraw of the screen
        // If we update the screen every 30 ms, it's sufficiently fast 33 fps > 24 fps
        // needed for the human eye to see the motion as continuous.
        try {
            Thread.sleep(35);
        } catch (InterruptedException e) {
        }

        // A call to invalidate causes the Android framework to call the onDraw
        // method of the DrawView
        // Thus every time the screen is refreshed, the framework is again
        // forced to call the onDraw
        // method. This creates the animation on the screen to simulate the game
        // playing
        if(!end)
            invalidate();
        else {
            restartGame = true;
            end=false;
           // Intent i = new Intent(getContext(), PauseActivity.class);

        //    getContext().startActivity(i);
        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);


        width = w;
        height = h;
        // monster.setBounds(0, 0, width, height);
        // stair.setBounds(0, 0, width, height, width / 2, height / 2);
        //  stair2.setBounds(0, 0, width, height, width / 2, height / 4);
        monster.setBounds(0, 0, width, height);
        int num = 1 / 6;
//        for (int i = 0; i < 5; i++) {
//            stairs.get(i).setBounds(0, 0, width, height, width / 2, height / num);
//            num++;
//        }
        int hh = height / 5;
        int j = 50;
        for (int i = 0; i < 5; i++) {
            s[i].setBounds(0, 0, width, height, width / 2, (i + 1) * hh - j);
            j -= 10;


        }

    }

    //            cannon.setBounds(0,0,width,height);
//            androidGuy.setBounds(0, 0, width, height);
//            for (int i = 0; i < bullets.size(); i++ ) {
//                bullets.get(i).setBounds(0,0,width,height);
//            }
    public void drawGameBoard(Canvas canvas) {
        //Background color
        canvas.drawColor(Color.WHITE);
        monster.draw(canvas);


        //monster.draw(canvas);
//        if (stair != null) {
//            stair.draw(canvas);
//        }
//        if (stair2 != null) {
//            //if(count--==0);
//            //else
//            stair2.draw(canvas);
//
//        }
        for (int i = 0; i < 5; i++) {
            if (s[i] != null)
                s[i].draw(canvas);
        }
        // if (y +50 < 0) {
        //  x = (float) ((upperX-155)*Math.random());
        //   y =upperY;
        //}

//        for (int i = 0; i < 5; i++) {
//            if (stairs.get(i) != null)
//                stairs.get(i).draw(canvas);
//        }
//        for (int i = 0; i < 5; i++) {
//            if (!stairs.get(i).move())
//                stairs.remove(stairs.get(i));
//
//        }
//        //check to see  whether need to remove stair
//        if (stair.move() == false) {
//            stair = null;
//        }
//        if (stair2.move() == false) {
//            stair2 = null;
//        }
        int speed = 2;
        for (int i = 0; i < 5; i++) {
            if (!s[i].move(speed) ) {
                s[i] = null;
                speed += 3;
            }
        }
        monster.fall();
//        if (RectF.intersects(monster.getRect(), stair.getRect())) {
//            // if (Rect.intersects(monster.getRectrect(), stair.getRectrect()))
//                monster.setY(stair.getY());
//        }
//        if (RectF.intersects(monster.getRect(), stair2.getRect())) {
//            // if (Rect.intersects(monster.getRectrect(), stair.getRectrect()))
//                monster.setY(stair2.getY());
//        }
        for (int i = 0; i < 5; i++) {
            if (RectF.intersects(monster.getRect(), s[i].getRect())) {
                // if (Rect.intersects(monster.getRectrect(), stair.getRectrect()))
                monster.setY(s[i].getY());
            }
        }


    }

    public void moveMonsterLeft() {
        monster.moveLeft();
    }

    public void moveMonsterRight() {
        monster.moveRight();
    }
}




