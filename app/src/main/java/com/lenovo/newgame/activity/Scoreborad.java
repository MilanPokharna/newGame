package com.lenovo.newgame.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lenovo.newgame.R;

import java.util.ArrayList;
import java.util.List;

public class Scoreborad extends AppCompatActivity {
    ProgressDialog progressDialog;

    List<Game> list = new ArrayList<>();

    FirebaseUser user;
    RecyclerViewAdapter adapter;
    RecyclerViewAdapter clearAdapter;
    DatabaseReference databaseReference;
 public  RecyclerView mRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_scoreborad );
        mRecycleView =(RecyclerView)findViewById( R.id.recycleview );
        mRecycleView.setHasFixedSize( true );
        clearAdapter =  new RecyclerViewAdapter( this,list );
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(Scoreborad.this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        mRecycleView.setLayoutManager(mLayoutManager);

         progressDialog = new ProgressDialog( Scoreborad.this );

        progressDialog.setMessage("getting the Score ...");
//
        progressDialog.show();
        databaseReference = FirebaseDatabase.getInstance().getReference().child( "User" );
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                clearAdapter.clear();
                int i=1;
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {

                    Game game = dataSnapshot.getValue( Game.class );
                    list.add( game );
                }
                adapter=new RecyclerViewAdapter( Scoreborad.this,list );
                progressDialog.dismiss();
                mRecycleView.setAdapter( adapter );
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }



        });

    }
}
