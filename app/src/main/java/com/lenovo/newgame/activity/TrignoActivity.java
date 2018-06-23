package com.lenovo.newgame.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.lenovo.newgame.R;

import java.util.Arrays;
import java.util.List;

public class TrignoActivity extends AppCompatActivity {

    public Button clear,black1,black2,black3,b1 ,b2,b3,b4;
    ImageButton setting;
    public MediaPlayer mp;
    public int turnmove;
    public int soundflag; 
    public TextView Result,move;
    public   TextView Level,Goal;
    public String ResultData="";
    public TextView myTextView;
    public int i=0;
    public List<String>Black3=Arrays.asList("sin0","sin0","cos0","sin45","sec30","cot60","sin30","cos180","cos60","sin0");
    public List<String>Black2=Arrays.asList("cos0","cos0","sin60","cos45","tan45","sin0","tan30","sec180","tan0","cos0");
    public List<String>Goals=Arrays.asList("0.0","1.0","0.86","1.0","1.0","0.0","0.57","-1.0","0.5","0.0");
    public List<String>Move= Arrays.asList("1","1","1","1","1","1","1","1","3","2");
    public List<String>Black1=Arrays.asList("sin90","tan45","cot45","cot45","tan30","sec60","cos30","tan180","cosec0","tan45");
    public String bl1,bl2,bl3="";
    public int size=65;

    @SuppressLint("ResourceType")
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_level);
        move=(TextView)findViewById(R.id.moves);
        ImageButton setting =(ImageButton)findViewById(R.id.setting);
        black1= (Button)findViewById(R.id.button_8);
        black2= (Button)findViewById(R.id.button_2);
        black3= (Button)findViewById(R.id.button_5);

        clear = (Button)findViewById(R.id.button_clear);
        clear.setBackgroundResource(R.drawable.seletor_botao);
        clear.setBackgroundTintList(getApplicationContext().getResources().getColorStateList(R.drawable.buttoncolor));
        Result=(TextView)findViewById(R.id.answer);
        Goal=(TextView)findViewById(R.id.goal);
        Level=(TextView)findViewById(R.id.level);
        mp = MediaPlayer.create(this,R.raw.bclick);

        SharedPreferences prefs = this.getSharedPreferences(
                "level", Context.MODE_PRIVATE);
        soundflag = prefs.getInt( "sound",1 );
        i = prefs.getInt("trignolevel",i);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/digital.ttf");
        Result.setTypeface(typeface);
        black1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
                ResultData=black1.getText().toString();
                bl1=Black1.get(i).toString();
                set();
            }
        });
        black2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
                ResultData=black2.getText().toString();
                bl2=Black2.get(i).toString();
                set();
            }
        });
        black3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
                ResultData=black3.getText().toString();
                bl3=Black3.get(i).toString();
                set();
            }
        });
        fun();
    }

    private void call() {
        if (soundflag == 1)
        {
            mp.start();
        }
    }

    private void fun() {
        if (i <= 9)
        {
            bl1 = "";
            bl2 = "";
            bl3 = "";
            Result.setText("0");
            black1.setText(Black1.get(i));
            black2.setText(Black2.get(i));
            black3.setText(Black3.get(i));
            Goal.setText("Goal :" + Goals.get(i));
            Level.setText("LEVEL " + String.valueOf(i + 1));
            move.setText("Moves : " + Move.get(i));
            turnmove = Integer.parseInt(Move.get(i).toString());
        }
        else
        {
            AlertDialog.Builder dialog = new AlertDialog.Builder(TrignoActivity.this);
            dialog.setTitle("CONGRATULATIONS");
            dialog.setMessage("YOU Have Completed all the Levels of Trignometry Maths \nWould You Like to Start Again From Level 0");

            dialog.setCancelable(false);
            dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    SharedPreferences p = getApplicationContext().getSharedPreferences("level",MODE_PRIVATE);
                    p.edit().putInt("trignolevel",0).apply();
                    recreate();

                }
            });
            dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i = new Intent(TrignoActivity.this,HomeActivity.class);
                    startActivity(i);
                }
            }).show();
        }

    }

    private void set(){
        turnmove=turnmove-1;
        String m=move.getText().toString();
        if(turnmove>0)
        {

            Result.setTextSize(size);
            move.setText("Moves : "+Integer.toString(turnmove));
            Result.setText(Result.getText()+"+"+ResultData);
            size-=20;
        }
        else
        {
            check();

        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(TrignoActivity.this,HomeActivity.class);
        startActivity(i);
    }

    private void check() {
        float s1=getvalue(bl1);
        float s2=getvalue(bl2);
        float s3=getvalue(bl3);
        float r=s1+s2+s3;
        //Toast.makeText(this, Float.toString(r), Toast.LENGTH_LONG).show();
        if(Goals.get(i).toString().equals(Float.toString(r)))
        {
            i+=1;
            SharedPreferences p = getApplicationContext().getSharedPreferences("level",MODE_PRIVATE);
            p.edit().putInt("trignolevel",i).apply();

            size=65;
            Result.setTextSize(size);
            Result.setText("YOU WIN");
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("CONGRATULATIONS");
            dialog.setMessage("YOU WIN");

            dialog.setCancelable(false);
            dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if(i==10){

                        Intent intent =new Intent( TrignoActivity.this,HomeActivity.class );
                        startActivity( intent );
                    }
                    else {

                        fun();
                    }


                }
            }).show();


        }
        else
        {
            size=65;
            Result.setTextSize(50);
            Result.setText("YOU LOOSE");
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
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

    private float getvalue(String bl1) {
        String bll=bl1;
        switch(bll) {
            case "sin90":
                return (float) 1.0;

            case "sin0":
                return (float) 0.0;
            case "sin30":
                return (float) 0.5;
            case "sin60":
                return (float) 0.86;
            case "sin45":
                return (float) 0.70;
            case "cos30":
                return (float) 0.86;
            case "cos60":
                return (float) 0.5;
            case "cos45":
                return (float) 0.70;


            case "cos90":
                return (float) 0.0;

            case "cos0":
                return (float) 1.0;
            case "cosec90":
                return (float) 1.0;
            case "cos180":
                return (float) -1.0;

            case "cosec0":
                return (float) 0.0;
            case "cosec30":
                return (float) 2.0;
            case "cosec60":
                return (float) 1.15;
            case "cosec45":
                return (float) 1.41;

            case "sec90":
                return (float) 0.0;

            case "sec0":
                return (float) 1.0;
            case "sec30":
                return (float) 1.15;
            case "sec60":
                return (float) 2.0;
            case "sec45":
                return (float) 1.41;
            case "cot90":
                return (float) 0.0;

            case "cot0":
                return (float) 0.0;
            case "cot30":
                return (float) 1.73;
            case "cot60":
                return (float) 0.57;


            case "tan45":
                return (float) 1.0;

            case "tan0":
                return (float) 0.0;
            case "tan30":
                return (float) 0.57;
            case "tan60":
                return (float) 1.73;
            case "tan90":
                return (float) 0.0;

            case "cot45":
                return (float) 1.0;
            default:
                return (float) 0.0;
        }

    }
}
