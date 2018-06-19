package com.lenovo.newgame.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.lenovo.newgame.R;
import com.lenovo.newgame.activity.HomeActivity;

import java.util.Arrays;
import java.util.List;


public class object extends AppCompatActivity {
    public MediaPlayer mp;
    static  int size = 45;
    public Button clear,black1,black2,black3 ,b1,b2,b3,b4;
    public int turnmove;
    public TextView Result,move;
    public   TextView Level,Goal;
    public String ResultData="";
    public TextView myTextView;
    public int i=0;
    public int soundflag;
    public List<String>Black3=Arrays.asList("5x4","5","25","150","8x2","23","-4","25");
    public List<String>Black2=Arrays.asList("4X3","1","16","154","1x8","18","12","24");
    public List<String>Goals=Arrays.asList("4X3","14","25","154","8x2","12","18","25");
    public List<String>Move= Arrays.asList("1","1","1","1","1","1","1","1");
    public List<String>Black1=Arrays.asList("2x2","14","30","123","3x3","12","18","22");
    public List<String>resultArray=Arrays.asList( "What will be the sides of rectangle having the area 12 ?", "What will be the radius of circle having the area 616 ?","What will be the area of a square having the side as 5 ?","What will be the area of circle having radius as 7 ?","What will be the sides of a triangle having area as 8 ?","\n" +
            "Which number is a multiple of 4?","6+5-(-7)=","100 divided by x is 4. x=?");
    public String bl1="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_level);

        move=(TextView)findViewById(R.id.moves);
        ImageButton setting =(ImageButton)findViewById(R.id.setting);
        black1= (Button)findViewById(R.id.button_8);
        black2= (Button)findViewById(R.id.button_2);
        black3= (Button)findViewById(R.id.button_5);

        Result=(TextView)findViewById(R.id.answer);
        Result.setTextSize(25);
        Goal=(TextView)findViewById(R.id.goal);
        Level=(TextView)findViewById(R.id.level);
        mp = MediaPlayer.create(this,R.raw.bclick);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/digital.ttf");
//        SharedPreferences prefs = this.getSharedPreferences(
//                "level", Context.MODE_PRIVATE);
        SharedPreferences prefs = getApplicationContext().getSharedPreferences(
                "level", Context.MODE_PRIVATE);
        i = prefs.getInt("objectlevel",i);
        soundflag = prefs.getInt("sound",1 );

        black1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
                ResultData=black1.getText().toString();
                check(ResultData);
            }
        });
        black2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
                ResultData=black2.getText().toString();
                check(ResultData);}
        });
        black3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
                ResultData=black3.getText().toString();

                check(ResultData);
            }
        });

        fun();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(object.this,HomeActivity.class);
        startActivity(i);
    }

    private void fun() {
        if (i < 8) {
            Result.setTextSize(25);
            Goal.setText("Goal");
            Result.setText("" + resultArray.get(i));
            black1.setText(Black1.get(i));
            black2.setText(Black2.get(i));
            black3.setText(Black3.get(i));
            Level.setText("LEVEL " + String.valueOf(i + 1));
            move.setText("Moves : " + Move.get(i));
            turnmove = Integer.parseInt(Move.get(i).toString());
        }
        else
        {
            AlertDialog.Builder dialog = new AlertDialog.Builder(object.this);
            dialog.setTitle("CONGRATULATIONS");
            dialog.setMessage("YOU Have Completed all the Levels of Object Maths \nWould You Like to Start Again From Level 0");

            dialog.setCancelable(false);
            dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences p = getApplicationContext().getSharedPreferences("level",MODE_PRIVATE);
                    p.edit().putInt("objectlevel",0).apply();
                    recreate();

                }
            });
            dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i = new Intent(object.this,HomeActivity.class);
                    startActivity(i);
                }
            }).show();
        }
    }

    private void set(){
        Result.setTextSize(25);
        turnmove-=1;
        String m=move.getText().toString();
        if(turnmove!=0)
        {

            Result.setTextSize(25);
            move.setText("Moves : "+Integer.toString(turnmove));
            Result.setText(Result.getText()+"+"+ResultData);
        }
        else
        {
            check(ResultData);

        }
    }

    private void check(String resultData) {

        if (Goals.get( i ).toString().equals( resultData )) {

            i += 1;
            SharedPreferences prefs = this.getSharedPreferences(
                    "level", Context.MODE_PRIVATE);
            prefs.edit().putInt("objectlevel",i).apply();
            Result.setTextSize( size );
            Result.setText( "YOU WIN" );
            AlertDialog.Builder dialog = new AlertDialog.Builder(object.this);
            dialog.setTitle("CONGRATULATIONS");
            dialog.setMessage("YOU WIN");

            dialog.setCancelable(false);
            dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (i == 8) {
                        Intent intent = new Intent( object.this, HomeActivity.class );
                        startActivity( intent );
                    }else {
                        fun();
                    }

                }
            }).show();


        } else {
            Result.setTextSize( size );
            Result.setText( "YOU LOOSE" );
            AlertDialog.Builder dialog = new AlertDialog.Builder(object.this);
            dialog.setTitle(" Better Luck Next Time ");
            dialog.setMessage("YOU LOOSE");
            dialog.setCancelable(false);
            dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    fun();
                }
            }).show();

        }
    }
    private void call() {
        if (soundflag == 1)
        {
            mp.start();
        }
        else
        {

        }
    }

}
