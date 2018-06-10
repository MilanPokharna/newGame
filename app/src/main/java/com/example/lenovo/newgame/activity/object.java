package com.example.lenovo.newgame.activity;



import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.newgame.R;
import com.example.lenovo.newgame.activity.HomeActivity;

import java.util.Arrays;
import java.util.List;

public class object extends AppCompatActivity {

    public Button clear,black1,black2,black3 ,b1,b2,b3,b4;
    public int turnmove;
    public TextView Result,move;
    public   TextView Level,Goal;
    public String ResultData="";
    public TextView myTextView;
    public int i=0;
    public List<String>Black3=Arrays.asList("5x4","5","25","150","8x2");
    public List<String>Black2=Arrays.asList("4X3","1","16","154","1x8");
    public List<String>Goals=Arrays.asList("4X3","14","25","154","8x2");
    public List<String>Move= Arrays.asList("1","1","1","1","1");
    public List<String>Black1=Arrays.asList("2x2","14","30","123","3x3");
    public List<String>resultArray=Arrays.asList( "What will be the sides of rectangle having the area 12 ?", "What will be the radius of circle having the area 616 ?","What will be the area of a square having the side as 5 ?","What will be the area of circle having radius as 7 ?","What will be the sides of a triangle having area as 8 ?");
    public String bl1="";


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
        Result.setTextSize(25);
        Goal=(TextView)findViewById(R.id.goal);
        Level=(TextView)findViewById(R.id.level);
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.bclick);


        black1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                ResultData=black1.getText().toString();
                check(ResultData);
            }
        });
        black2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                ResultData=black2.getText().toString();
                check(ResultData);}
        });
        black3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                ResultData=black3.getText().toString();

                check(ResultData);
            }
        });
        clear.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                fun();
            }
        });
        fun();


    }

    private void fun() {
        Result.setTextSize(25);
        Goal.setText( "Goal" );
        Result.setText(""+resultArray.get( i ));
        black1.setText(Black1.get(i));
        black2.setText(Black2.get(i));
        black3.setText(Black3.get(i));
        Level.setText("LEVEL " + String.valueOf(i + 1));
        move.setText("Moves : " + Move.get(i));
        turnmove = Integer.parseInt(Move.get(i).toString());
    }

    private void set(){
        Result.setTextSize(25);
        turnmove-=1;
        String m=move.getText().toString();
        if(turnmove!=0)
        {

            Result.setTextSize(25);;
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
            Result.setTextSize( 25 );
            Result.setText( "YOU WIN" );
            AlertDialog.Builder dialog = new AlertDialog.Builder(object.this);
            dialog.setTitle("CONGRATULATIONS");
            dialog.setMessage("YOU WIN");

            dialog.setCancelable(false);
            dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (i == 5) {
                        Intent intent = new Intent( object.this, HomeActivity.class );
                        startActivity( intent );
                    }else {
                        fun();
                    }

                }
            }).show();


        } else {
            Result.setTextSize( 25 );
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

}
