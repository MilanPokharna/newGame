package com.lenovo.newgame.activity;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lenovo.newgame.R;
import com.lenovo.newgame.manger.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Scoreborad extends AppCompatActivity {
    ProgressDialog progressDialog;

    List<Game> list = new ArrayList<>();
    public SwipeRefreshLayout swipeRefreshLayout;
    public static TextView score_first,score_second,score_third;
    public static TextView first_name,second_name,third_name;
    public static CircleImageView profileimage1,profileimage2,profileimage3;



    FirebaseUser user;
    RecyclerViewAdapter adapter;
    RecyclerViewAdapter clearAdapter;
    DatabaseReference databaseReference;
    List<Integer>score=new ArrayList<>();
 public  RecyclerView mRecycleView;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_scoreborad );
        Toolbar toolbar=(Toolbar)findViewById(R.id.scorecard_toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        score_first=(TextView)findViewById(R.id.score_first);
        score_second=(TextView)findViewById(R.id.score_second);
        score_third=(TextView)findViewById(R.id.score_third);

        first_name=(TextView)findViewById(R.id.first);
        second_name=(TextView)findViewById(R.id.second);
        third_name=(TextView)findViewById(R.id.third);

        profileimage1=(CircleImageView)findViewById(R.id.profileimage1);

        profileimage2=(CircleImageView)findViewById(R.id.profileimage2);

        profileimage3=(CircleImageView)findViewById(R.id.profileimage3);


        mRecycleView =(RecyclerView)findViewById( R.id.recycleview );
        mRecycleView.setHasFixedSize( true );
        clearAdapter =  new RecyclerViewAdapter( this,list ,score);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(Scoreborad.this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        mRecycleView.setLayoutManager(mLayoutManager);
        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipeRefreshLayout);

         progressDialog = new ProgressDialog( Scoreborad.this );

        progressDialog.setMessage("getting the Score ...");

        progressDialog.show();
        databaseReference = FirebaseDatabase.getInstance().getReference().child( "User" );
        databaseReference.keepSynced(true);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                clearAdapter.clear();
                int i=1;
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    Game game = dataSnapshot.getValue( Game.class );
                    String s=dataSnapshot.child("score").getValue().toString();
                    score.add(Integer.parseInt(s));
                    list.add( game );
                }
                Collections.sort(score);
                adapter=new RecyclerViewAdapter( Scoreborad.this,list,score );
                progressDialog.dismiss();
                mRecycleView.setAdapter( adapter );
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }



        });
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                //adapter = new RecyclerViewAdapter(MainActivity.this, list,stringList);
                Intent intent = new Intent(Scoreborad.this,Scoreborad.class);
                finish();
                startActivity(intent);
                overridePendingTransition( 0, 0);


//                        adapter = new RecyclerViewAdapter(MainActivity.this, list,stringList);
//
//                        recyclerView.setAdapter(adapter);


                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
