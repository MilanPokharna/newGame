package com.example.lenovo.newgame.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.lenovo.newgame.R;

public class HomeActivity extends AppCompatActivity {

    ImageButton learn,trigno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home );
        learn=(ImageButton)findViewById(R.id.learn);
        trigno=(ImageButton)findViewById(R.id.trigno);
        ImageButton object =(ImageButton)findViewById(R.id.object);
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.bclick);

        object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        mp.start();
                Intent i=new Intent(HomeActivity.this,object.class);
                startActivity(i);
            }
        });

        trigno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                Intent i=new Intent(HomeActivity.this,TrignoActivity.class);
                startActivity(i);
            }
        });
        learn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                Intent i= new Intent(HomeActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });


    }

    public void easylevel(View view) {
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.bclick);
        mp.start();
        Intent intent =  new Intent(  HomeActivity.this, basic.class );
        startActivity( intent );
    }

    @Override
    public void onBackPressed() {

        finish();
    }
}
