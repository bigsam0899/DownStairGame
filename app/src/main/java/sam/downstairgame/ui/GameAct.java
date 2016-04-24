package sam.downstairgame.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sam.downstairgame.R;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class GameAct extends AppCompatActivity implements View.OnClickListener {

    private ImageButton moveLeftButton, moveRightButton;
    private DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        drawView = (DrawView) findViewById(R.id.drawView);
        moveLeftButton = (ImageButton) findViewById(R.id.moveLeftButton);
        moveLeftButton.setOnClickListener(this);
        moveRightButton = (ImageButton) findViewById(R.id.moveRightButton);
        moveRightButton.setOnClickListener(this);


    }

    public void onClick(View v) {

        // Using the View's ID to distinguish which button was clicked
        switch (v.getId()) {

            case R.id.moveLeftButton:
                drawView.moveMonsterLeft();
                break;

            case R.id.moveRightButton:
                drawView.moveMonsterRight();
                break;

            default:
                break;
        }
    }
}
