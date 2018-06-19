package com.lenovo.newgame.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lenovo.newgame.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class basic extends AppCompatActivity implements View.OnClickListener {

    ViewGroup parent;
    LayoutInflater inflater;
    View overlay;
    @BindView(R.id.level)
    TextView textViewLevel;
    @BindView(R.id.moves)
    TextView textViewMoves;
    @BindView(R.id.goal)
    TextView textViewGoal;
    @BindView(R.id.answer)
    TextView textViewAnswer;
    @BindView(R.id.setting_button)
    ImageButton settingButton;
    @BindView(R.id.button_8)
    Button button8;
    @BindView(R.id.button_9)
    Button button9;
    @BindView(R.id.button_1)
    Button button1;
    @BindView(R.id.button_2)
    Button button2;
    @BindView(R.id.button_clear)
    Button buttonClear;
    @BindView(R.id.button_4)
    Button button4;
    @BindView(R.id.button_5)
    Button button5;
    @BindView(R.id.button_6)
    Button button6;


    private int level_number = 1;
    private int moves_in_level = 3;
    private int goal_in_level = 12;
    private int result_in_game = 0;
    public  int i;
    public int j = 1;
    public  int soundflag ;
    public int hint;
    private int instruct_flag = 1;
    private List<String> Operator_array= new ArrayList<>();

    private List<Integer> digit_array=new ArrayList<>();
    //private int digit_array[]=new int[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_level);
        ButterKnife.bind(this);
        parent = (ViewGroup) findViewById(R.id.main);
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        overlay = findViewById(R.id.overlay_view);
        overlay = inflater.inflate(R.layout.overlay_layout, parent, false);

        init();
        SharedPreferences prefs = getSharedPreferences("level",MODE_PRIVATE);
        i = prefs.getInt("basiclevel",1);
        soundflag = prefs.getInt("sound",1);
        hint = prefs.getInt("hint",2);

        buttonClear.setText("Hints :"+hint);
        if (hint == 0)
        {
            buttonClear.setClickable(false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                buttonClear.setBackgroundColor(Color.parseColor("#48AC2E"));
            }
            buttonClear.setText("No Hint");
        }
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/digital.ttf");
        textViewAnswer.setTypeface(typeface);
        button2.setOnClickListener(this);
        button5.setOnClickListener(this);
        button8.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        goodGame(i);

    }

    public void call(View view) {
        RelativeLayout relativeLayout1 = (RelativeLayout) findViewById( R.id.instruct1 );
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById( R.id.instruct2 );
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById( R.id.instruct3 );
        switch (j) {
            case 1:
                relativeLayout1.setVisibility( View.GONE );
                relativeLayout2.setVisibility( View.VISIBLE );
                relativeLayout3.setVisibility( View.GONE );
                j++;
                break;
            case 2:
                relativeLayout1.setVisibility( View.GONE );
                relativeLayout2.setVisibility( View.GONE );
                relativeLayout3.setVisibility( View.VISIBLE );
                j++;
                break;
            case 3:
                relativeLayout1.setVisibility( View.GONE );
                relativeLayout2.setVisibility( View.GONE );
                relativeLayout3.setVisibility( View.GONE );
                instruct_flag = 0;
                parent.removeView( overlay );
                break;
        }

    }
    public void init()
    {

        Operator_array.add(0,"0");
        Operator_array.add(1,"X");
        Operator_array.add(2,"0");
        Operator_array.add(3,"0");
        Operator_array.add(4,"+");
        Operator_array.add(5,"0");
        Operator_array.add(6,"0");
        Operator_array.add(7,"+");
        digit_array.add(0,0);
        digit_array.add(1,4);
        digit_array.add(2,0);
        digit_array.add(3,0);
        digit_array.add(4,1);
        digit_array.add(5,0);
        digit_array.add(6,0);
        digit_array.add(7,2);

    }
    public void startGame(int level_number, int moves_in_level, int goal_in_level, int result_in_game) {
        this.level_number = level_number;
        this.moves_in_level = moves_in_level;
        this.goal_in_level = goal_in_level;
        this.result_in_game = result_in_game;
        textViewLevel.setText("LEVEL: "+level_number);
        textViewGoal.setText("GOAL:"+goal_in_level);
        textViewMoves.setText("MOVES: "+moves_in_level);
        textViewAnswer.setText(""+result_in_game);
        button2.setText(""+ Operator_array.get(1) + digit_array.get(1));
        button5.setText(""+ Operator_array.get(4) + digit_array.get(4));
        button8.setText(""+ Operator_array.get(7) + digit_array.get(7));

    }

    @Override
    public void onClick(View view) {

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.bclick);
        if (soundflag ==1 )
            mp.start();

        if (moves_in_level > 0) {
            switch (view.getId()) {


                case R.id.button_2: {
                    textViewAnswer.setText(""+getAnswer(Operator_array.get(1), digit_array.get(1),result_in_game));
                    textViewMoves.setText("MOVES: "+ getMoves(moves_in_level));
                    break;
                }
                case R.id.button_5: {

                    textViewAnswer.setText("" +getAnswer(Operator_array.get(4), digit_array.get(4),result_in_game) );
                    textViewMoves.setText("MOVES: "+ getMoves(moves_in_level));
                    break;
                }
                case R.id.button_8: {

                    textViewAnswer.setText("" +getAnswer(Operator_array.get(7), digit_array.get(7),result_in_game) );
                    textViewMoves.setText("MOVES: "+ getMoves(moves_in_level));
                    break;
                }
                case R.id.button_clear:
                {
                    if ( hint != 0) {
                        hint = hint-1;
                        AlertDialog.Builder dialog = new AlertDialog.Builder( basic.this );
                        dialog.setTitle( "HINTS" );
                        switch(i)
                        {
                            case 1:
                                dialog.setMessage( R.string.flag_1  );
                                break;
                            case 2:
                                dialog.setMessage( R.string.flag_2 );
                                break;
                            case 3:
                                dialog.setMessage( R.string.flag_3 );
                                break;
                            case 4:
                                dialog.setMessage( R.string.flag_4 );
                                break;
                            case 5:
                                dialog.setMessage( R.string.flag_5 );
                                break;
                            case 6:
                                dialog.setMessage( R.string.flag_6 );
                                break;
                            case 7:
                                dialog.setMessage( R.string.flag_7 );
                                break;
                            case 8:
                                dialog.setMessage( R.string.flag_8 );
                                break;
                            case 9:
                                dialog.setMessage( R.string.flag_9 );
                                break;
                            case 10:
                                dialog.setMessage( R.string.flag_10 );
                                break;

                        }
                        dialog.setCancelable( false );
                        dialog.setPositiveButton( "OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences prefs = getSharedPreferences("level",MODE_PRIVATE);
                                prefs.edit().putInt( "hint", hint ).apply();

                            }
                        } ).show();
                    }
                    if (hint == 0)
                    {
                        buttonClear.setClickable(false);
                        buttonClear.setText("No Hint");
                    }
                    else
                        buttonClear.setText("Hints: " + hint );
                }
                    break;
                }
            }
        if (goal_in_level == result_in_game) {
            textViewAnswer.setText("YOU WIN");
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("CONGRATULATIONS");
            dialog.setMessage("YOU WIN");
            dialog.setCancelable(false);
            dialog.setPositiveButton("NEXT LEVEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    i++;
                    SharedPreferences prefs = getSharedPreferences("level",MODE_PRIVATE);
                    prefs.edit().putInt("basiclevel",i).apply();
                    goodGame(i);
                }
            }).show();


        } else {
            if (moves_in_level == 0 && goal_in_level != result_in_game) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("OOPS! Better Luck Next Time");
                dialog.setMessage("YOU LOOSE");
                dialog.setCancelable(false);
                dialog.setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textViewAnswer.setTextSize(65);
                        textViewAnswer.setText("YOU LOOSE");
                        goodGame(i);
                    }
                }).show();

            }
        }

    }

    public void goodGame(final int i )
    {
        if (instruct_flag == 1 && i == 1)
        {
            parent.removeView( overlay );
            parent.addView( overlay );
        }
        else
        {
            parent.removeView( overlay );
        }

        switch (String.valueOf(i))
        {
            case "1":
                Operator_array.add(0,"0");
                Operator_array.add(1,"X");
                Operator_array.add(2,"0");
                Operator_array.add(3,"0");
                Operator_array.add(4,"+");
                Operator_array.add(5,"0");
                Operator_array.add(6,"0");
                Operator_array.add(7,"+");
                digit_array.add(0,0);
                digit_array.add(1,4);
                digit_array.add(2,0);
                digit_array.add(3,0);
                digit_array.add(4,1);
                digit_array.add(5,0);
                digit_array.add(6,0);
                digit_array.add(7,2);

                startGame(1, 3, 12, 0);
                break;

            case "2":
                Operator_array.set(1,"+");
                Operator_array.set(4,"X");
                Operator_array.set(7,"/");
                digit_array.set(1,4);
                digit_array.set(4,4);
                digit_array.set(7,4);

                startGame(2, 3, 4, 3);
                break;
            case "3":
                Operator_array.set(1,"/");
                Operator_array.set(4,"+");
                Operator_array.set(7,"X");
                digit_array.set(1,3);
                digit_array.set(4,3);
                digit_array.set(7,3);
                startGame(3, 3, 12, 0);
                break;
            case "4":
                Operator_array.set(1,"+");
                Operator_array.set(4,"X");
                Operator_array.set(7,"/");
                digit_array.set(1,8);
                digit_array.set(4,10);
                digit_array.set(7,2);

                startGame(4, 5, 404, 0);
                break;
            case "5":
                Operator_array.set(1,"X");
                Operator_array.set(4,"X");
                Operator_array.set(7,"-");
                digit_array.set(1,3);
                digit_array.set(4,2);
                digit_array.set(7,5);

                startGame(5, 3, 50, 10);
                break;
            case "6":
                Operator_array.set(1,"X");
                Operator_array.set(4,"-");
                Operator_array.set(7,"/");
                digit_array.set(1,2);
                digit_array.set(4,9);
                digit_array.set(7,10);

                startGame(6, 4, 23, 171);
                break;
            case "7":
                Operator_array.set(1,"+");
                Operator_array.set(4,"X");
                Operator_array.set(7,"/");
                digit_array.set(1,4);
                digit_array.set(4,9);
                digit_array.set(7,10);

                startGame(7, 2, 2, 3);
                break;
            case "8":
                Operator_array.set(1,"-");
                Operator_array.set(4,"X");
                Operator_array.set(7,"/");
                digit_array.set(1,8);
                digit_array.set(4,11);
                digit_array.set(7,10);

                startGame(8, 3, 100, 99);
                break;
            case "9":
                Operator_array.set(1,"X");
                Operator_array.set(4,"+");
                Operator_array.set(7,"+");
                digit_array.set(1,4);
                digit_array.set(4,2);
                digit_array.set(7,0);

                startGame(9, 4, 64, 0);
                break;
            case "10":
                Operator_array.set(1,"/");
                Operator_array.set(4,"X");
                Operator_array.set(7,"+");
                digit_array.set(1,4);
                digit_array.set(4,2);
                digit_array.set(7,0);
                startGame(10, 3, 100, 800);
                break;

            default:
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("CONGRATULATIONS");
                dialog.setMessage("You Have Completed The Basic Maths Successfully");
                dialog.setCancelable(false);
                dialog.setPositiveButton("Go to home", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(basic.this,HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }).show();
                break;

        }


    }

    public int getAnswer(String op,int number_of_operator,int result_in_game)
    {

        switch(op) {
            case "X":
                this.result_in_game = result_in_game * number_of_operator;
                break;
            case "-":
                this.result_in_game = result_in_game - number_of_operator;
                break;
            case "+":
                this.result_in_game = result_in_game + number_of_operator;
                break;
            case "/":
                this.result_in_game = result_in_game / number_of_operator;
                break;

            case "<<":
                this.result_in_game = result_in_game % 10;
                break;

            case "->":
                this.result_in_game =convert1To2Rec(result_in_game);
                break;
            default:
        }
        return this.result_in_game;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(basic.this,HomeActivity.class);
        startActivity(i);
    }

    public int getMoves(int moves_in_level)
    {
        this.moves_in_level = moves_in_level-1;
        return this.moves_in_level;
    }

    private static int convert1To2Rec(int num) {
        // Base case
        if (num == 0)
            return 0;

        // Extraxt the last digit and change it if needed
        int digit = num % 10;
        if (digit == 1)
            digit = 2;

        return convert1To2Rec(num / 10) * 10 + digit;
    }
}

