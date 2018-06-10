package com.example.lenovo.newgame.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.newgame.R;

import java.util.Arrays;
import java.util.List;

public class TrignoActivity extends AppCompatActivity {

    public Button clear,black1,black2,black3,b1 ,b2,b3,b4;
    ImageButton setting;
    public int turnmove;
    public TextView Result,move;
    public   TextView Level,Goal;
    public String ResultData="";
    public TextView myTextView;
    public int i=0;
    public List<String>Black3=Arrays.asList("sin0","sin0","cos0","sin45","sec0","cot60","sin180","cos180","cos60","sin0");
    public List<String>Black2=Arrays.asList("cos0","cos0","sin90","cos45","cosec0","sec60","tan180","sec180","tan0","cos0");
    public List<String>Goals=Arrays.asList("0","1","1","1","2","-1","-1",".5","1","0");
    public List<String>Move= Arrays.asList("1","1","1","1","1","1","1","1","3","2");
    public List<String>Black1=Arrays.asList("sin90","tan45","cot45","cot45","tan0","cosec60","cos180","tan180","cosec0","tan45");
    public String bl1,bl2,bl3="";
    public int size=65;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trigno);
        clear=(Button)findViewById(R.id.bclear);
        move=(TextView)findViewById(R.id.moves);
        ImageButton setting =(ImageButton)findViewById(R.id.setting);
        black1= (Button)findViewById(R.id.black1);
        black2= (Button)findViewById(R.id.black2);
        black3= (Button)findViewById(R.id.black3);
        b1= (Button)findViewById(R.id.b1);
        b2= (Button)findViewById(R.id.b2);
        b3= (Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        Result=(TextView)findViewById(R.id.answer);
        Goal=(TextView)findViewById(R.id.goal);
        Level=(TextView)findViewById(R.id.level);
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.bclick);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                i=0;
                fun();
            }
        });

        setting =(ImageButton)findViewById(R.id.setting);
        black1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                ResultData=black1.getText().toString();
                bl1=Black1.get(i).toString();
                set();
            }
        });
        black2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                ResultData=black2.getText().toString();
                bl2=Black2.get(i).toString();
                set();
            }
        });
        black3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                ResultData=black3.getText().toString();
                bl3=Black3.get(i).toString();
                set();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                fun();
            }
        });
        fun();


    }

    private void fun() {
        bl1="";
        bl2="";
        bl3="";
        Result.setText("0");
        black1.setText(Black1.get(i));
        black2.setText(Black2.get(i));
        black3.setText(Black3.get(i));
        Goal.setText("Goal :" + Goals.get(i));
        Level.setText("LEVEL " + String.valueOf(i + 1));
        move.setText("Moves : " + Move.get(i));
        turnmove = Integer.parseInt(Move.get(i).toString());




    }

    private void set(){
        turnmove=turnmove-1;
        String m=move.getText().toString();
        if(turnmove>=0)
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

    private void check() {
        int s1=getvalue(bl1);
        int s2=getvalue(bl2);
        int s3=getvalue(bl3);
        int r=s1+s2+s3;
        Toast.makeText(this, Integer.toString(r)+Integer.toString(s1)+Integer.toString(s2)+Integer.toString(s3), Toast.LENGTH_LONG).show();
        if(Goals.get(i).toString().equals(Integer.toString(r)))
        {
            i+=1;
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
                    if(i>=10){
                        b1.setEnabled(true);
                        b1.setBackgroundResource(R.drawable.seletor_botao2);

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

    private int getvalue(String bl1) {
        String bll=bl1;
        switch(bll) {
            case "sin90":
                    return 1;

            case "sin0":
                return 0;

            case "cos90":
                return 0;

            case "cos0":
                return 1;


            case "tan45":
                return 1;

            case "tan0":
                return 0;
            default:
                return 0;
        }

    }
}
