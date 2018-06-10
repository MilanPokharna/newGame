package com.example.lenovo.newgame.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.newgame.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class basic extends AppCompatActivity {

    @BindView(R.id.level)
    TextView textViewLevel;
    @BindView(R.id.moves)
    TextView textViewMoves;
    @BindView(R.id.goal)
    TextView textViewGoal;
    @BindView(R.id.answer)
    TextView textViewAnswer;
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
    @BindView(R.id.header)
    LinearLayout header;
    @BindView(R.id.r3)
    LinearLayout r3;
    @BindView(R.id.r1)
    LinearLayout r1;
    @BindView(R.id.r2)
    LinearLayout r2;
    @BindView(R.id.setting_button)
    ImageButton settingButton;
    private int level_number = 1;
    private int moves_in_level = 3;
    private int goal_in_level = 12;
    private int result_in_game = 0;
    //    private String Operator_array[]=new String[9];
//    private int digit_array[]=new int[9];
    private int flag = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_level);
        ButterKnife.bind(this);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/digital.ttf");
        textViewAnswer.setTypeface(typeface);
        startGame(level_number, moves_in_level, goal_in_level, result_in_game);
    }

    public void startGame(int level_number, int moves_in_level, int goal_in_level, int result_in_game) {
        this.level_number = level_number;
        this.moves_in_level = moves_in_level;
        this.goal_in_level = goal_in_level;
        this.result_in_game = result_in_game;
        String strI = String.valueOf(level_number);
        textViewLevel.setText(("Level :" + strI));
        String strm = String.valueOf(moves_in_level);
        textViewMoves.setText("Moves :" + strm);
        String r = String.valueOf(result_in_game);
        textViewAnswer.setText(r);
        String g = String.valueOf(goal_in_level);
        textViewGoal.setText("Goal :" + g);
        if (flag == 1) {
            button2.setText("X4");
            button5.setText("+1");
            button8.setText("+2");
        } else if (flag == 2) {
            button2.setText("+4");
            button5.setText("X4");
            button8.setText("/4");
        } else if (flag == 3) {
            button2.setText("/3");
            button5.setText("+3");
            button8.setText("X3");
        } else if (flag == 4) {
            button2.setText("+8");
            button5.setText("X10");
            button8.setText("/2");
        } else if (flag == 5) {
            button2.setText("X3");
            button5.setText("X2");
            button8.setText("-5");
        } else if (flag == 6) {
            button2.setText("X2");
            button5.setText("-9");
            button8.setText("/10");
        } else if (flag == 7) {
            button2.setText("+4");
            button5.setText("X9");
            button8.setText("/10");
        } else if (flag == 8) {
            button2.setText("-8");
            button5.setText("X11");
            button8.setText("/10");
        } else if (flag == 9) {
            button2.setText("X4");
            button5.setText("+2");
            button8.setText("+0");
        } else if (flag == 10) {
            button2.setText("/4");
            button5.setText("X2");
            button8.setText("+0");
        }
    }


    @OnClick({R.id.button_8, R.id.button_2, R.id.button_5})
    public void onViewClicked(View view) {
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.bclick);
        switch (view.getId()) {
            case R.id.button_8:
                mp.start();
                if (flag == 1) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game + 2;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setMessage("YOU LOOSE");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(1, 3, 12, 0);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(1, moves_in_level, goal_in_level, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setMessage("YOU WIN");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 2;
                                startGame(2, 3, 4, 3);

                            }
                        }).show();

                    }
                } else if (flag == 2) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game / 4;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(2, 3, 4, 3);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(2, moves_in_level, goal_in_level, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setMessage("YOU WIN");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 3;
                                startGame(3, 3, 12, 0);

                            }
                        }).show();

                    }
                } else if (flag == 3) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game * 3;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setMessage("YOU LOOSE");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(3, 3, 12, 0);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(3, moves_in_level, 12, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 4;
                                startGame(4, 5, 404, 0);

                            }
                        }).show();

                    }
                } else if (flag == 4) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game / 2;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(4, 5, 404, 0);

                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(4, moves_in_level, 404, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 5;
                                startGame(5, 3, 50, 10);

                            }
                        }).show();

                    }
                } else if (flag == 5) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game - 5;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setCancelable(false);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(5, 3, 50, 10);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(5, moves_in_level, 50, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 6;
                                startGame(6, 4, 23, 171);
                            }
                        }).show();

                    }
                } else if (flag == 6) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game / 10;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(6, 4, 23, 171);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(6, moves_in_level, 23, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setMessage("YOU WIN");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 7;
                                startGame(7, 2, 2, 3);

                            }
                        }).show();

                    }
                } else if (flag == 7) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game / 10;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setCancelable(false);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(7, 2, 2, 3);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(7, moves_in_level, 2, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setCancelable(false);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 8;
                                startGame(8, 3, 100, 99);
                            }
                        }).show();

                    }
                } else if (flag == 8) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game / 10;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setCancelable(false);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(8, 3, 100, 99);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(8, moves_in_level, 100, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setCancelable(false);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 9;
                                startGame(9, 4, 64, 0);

                            }
                        }).show();

                    }
                } else if (flag == 9) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game + 0;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setCancelable(false);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(9, 4, 64, 0);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(9, moves_in_level, 64, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setMessage("YOU WIN");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 10;
                                startGame(10, 3, 100, 800);

                            }
                        }).show();

                    }
                } else if (flag == 10) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game + 0;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(10, 3, 100, 800);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(10, moves_in_level, 100, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU Have Completed The Basic Level Successfully");
                        dialog.setPositiveButton("Go to Intermediate Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(basic.this, HomeActivity.class);
                                startActivity(intent);
                            }
                        }).show();

                    }
                }
                break;
            case R.id.button_2:
                mp.start();
                if (flag == 1) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game * 4;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setCancelable(false);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(1, 3, 12, 0);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(1, moves_in_level, goal_in_level, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setCancelable(false);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 2;
                                startGame(2, 3, 4, 3);
                            }
                        }).show();
                    }
                } else if (flag == 2) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game + 4;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(2, 3, 4, 3);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(2, moves_in_level, 4, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 3;
                                startGame(3, 3, 12, 0);

                            }
                        }).show();

                    }
                } else if (flag == 3) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game / 3;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setCancelable(false);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(3, 3, 12, 0);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(3, moves_in_level, 12, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 4;
                                startGame(4, 5, 404, 0);

                            }
                        }).show();

                    }
                } else if (flag == 4) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game + 8;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setCancelable(false);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(4, 5, 404, 0);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(4, moves_in_level, 404, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 5;
                                startGame(5, 3, 50, 10);

                            }
                        }).show();

                    }
                } else if (flag == 5) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game * 3;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setMessage("YOU LOOSE");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(5, 3, 50, 10);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(5, moves_in_level, 50, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setCancelable(false);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 6;
                                startGame(6, 4, 23, 171);
                            }
                        }).show();

                    }
                } else if (flag == 6) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game * 2;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(6, 4, 23, 171);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(6, moves_in_level, 23, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setCancelable(false);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 7;
                                startGame(7, 2, 2, 3);

                            }
                        }).show();

                    }
                } else if (flag == 7) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game + 4;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(7, 2, 2, 3);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(7, moves_in_level, 2, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 8;
                                startGame(8, 3, 100, 99);
                            }
                        }).show();

                    }
                } else if (flag == 8) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game - 8;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(8, 3, 100, 99);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(8, moves_in_level, 100, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 9;
                                startGame(9, 4, 64, 0);

                            }
                        }).show();

                    }
                } else if (flag == 9) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game * 4;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(9, 4, 64, 0);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(9, moves_in_level, 64, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 10;
                                startGame(10, 3, 100, 800);

                            }
                        }).show();

                    }
                } else if (flag == 10) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game / 4;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(10, 3, 100, 800);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(10, moves_in_level, 100, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU Have Completed The Basic Level Successfully");
                        dialog.setPositiveButton("Go to Intermediate Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(basic.this, HomeActivity.class);
                                startActivity(intent);
                            }
                        }).show();


                    }
                }
                break;
            case R.id.button_5:
                mp.start();
                if (flag == 1) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game + 1;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setMessage("YOU LOOSE");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(1, 3, 12, 0);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(1, moves_in_level, goal_in_level, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setCancelable(false);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 2;
                                startGame(2, 3, 4, 3);
                            }
                        }).show();
                    }
                } else if (flag == 2) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game * 4;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(2, 3, 4, 3);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(2, moves_in_level, 4, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setCancelable(false);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 3;
                                startGame(3, 3, 12, 0);

                            }
                        }).show();

                    }
                } else if (flag == 3) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game + 3;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(3, 3, 12, 0);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(3, moves_in_level, 12, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 4;
                                startGame(4, 5, 404, 0);

                            }
                        }).show();

                    }
                } else if (flag == 4) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game * 10;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(4, 5, 404, 0);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(4, moves_in_level, 404, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 5;
                                startGame(5, 3, 50, 10);

                            }
                        }).show();

                    }
                } else if (flag == 5) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game * 2;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(5, 3, 50, 10);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(5, moves_in_level, 50, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setCancelable(false);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 6;
                                startGame(6, 4, 23, 171);
                            }
                        }).show();

                    }
                } else if (flag == 6) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game - 9;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(6, 4, 23, 171);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(6, moves_in_level, 23, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 7;
                                startGame(7, 2, 2, 3);

                            }
                        }).show();

                    }
                } else if (flag == 7) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game * 9;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(7, 2, 2, 3);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(7, moves_in_level, 2, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 8;
                                startGame(8, 3, 100, 99);
                            }
                        }).show();

                    }
                } else if (flag == 8) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game * 11;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setCancelable(false);
                        dialog.setMessage("YOU LOOSE");
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(8, 3, 100, 99);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(8, moves_in_level, 100, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setCancelable(false);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 9;
                                startGame(9, 4, 64, 0);

                            }
                        }).show();

                    }
                } else if (flag == 9) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game + 2;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setMessage("YOU LOOSE");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(9, 4, 64, 0);
                            }
                        }).show();

                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(9, moves_in_level, 64, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setCancelable(false);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setMessage("YOU WIN");
                        dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                flag = 10;
                                startGame(10, 3, 100, 800);

                            }
                        }).show();

                    }
                } else if (flag == 10) {
                    moves_in_level = moves_in_level - 1;
                    result_in_game = result_in_game * 2;
                    if ((moves_in_level == 0) && (result_in_game != goal_in_level)) {
                        textViewAnswer.setText("You Loose");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setTitle("OOPS Better Luck Next Time ");
                        dialog.setMessage("YOU LOOSE");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("PLAY AGAIN", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startGame(10, 3, 100, 800);
                            }
                        }).show();
                    } else if ((moves_in_level != 0) && (result_in_game != goal_in_level)) {
                        String a = String.valueOf(result_in_game);
                        textViewAnswer.setText(a);
                        startGame(10, moves_in_level, 100, result_in_game);
                    } else if ((moves_in_level == 0) && (result_in_game == goal_in_level)) {
                        textViewAnswer.setText("You WIN");
                        AlertDialog.Builder dialog = new AlertDialog.Builder(basic.this);
                        dialog.setCancelable(false);
                        dialog.setTitle("CONGRATULATIONS");
                        dialog.setMessage("YOU Have Completed The Basic Level Successfully");
                        dialog.setPositiveButton("Go to Intermediate Level", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(basic.this, HomeActivity.class);
                                startActivity(intent);
                            }
                        }).show();


                    }
                }
                break;
        }
    }

}

