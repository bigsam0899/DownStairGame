package sam.downstairgame.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import sam.downstairgame.R;

public class HomeAct extends AppCompatActivity {

    Button btnSetting, btnRanking;
    ImageView ivMonster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnSetting = (Button) findViewById(R.id.btnSetting);
        btnRanking = (Button) findViewById(R.id.btnRanking);
        ivMonster = (ImageView) findViewById(R.id.ivMonster);

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeAct.this, SettingAct.class));
            }
        });
        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeAct.this, RankingAct.class));
            }
        });
        ivMonster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeAct.this, GameAct.class));
            }
        });



    }
}
