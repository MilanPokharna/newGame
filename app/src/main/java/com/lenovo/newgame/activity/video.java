package com.lenovo.newgame.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.lenovo.newgame.R;
import com.lenovo.newgame.adapters.RecyclerViewAdapterTwo;

import java.util.ArrayList;
import java.util.List;

public class video extends AppCompatActivity {

    public List<String> preschool = new ArrayList<>();
    public List<String> grade1 = new ArrayList<>();
    public List<String> grade2 = new ArrayList<>();
    public List<String> grade3 = new ArrayList<>();
    public List<String> grade4 = new ArrayList<>();

    public List<String> preschoolname = new ArrayList<>();
    public List<String> grade1name = new ArrayList<>();
    public List<String> grade2name = new ArrayList<>();
    public List<String> grade3name = new ArrayList<>();
    public List<String> grade4name = new ArrayList<>();
    public ProgressDialog progressDialog;

    public RecyclerViewAdapterTwo adapterTwo;
    public RecyclerView recyclerView;
    public String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        recyclerView = (RecyclerView) findViewById(R.id.recycleview2);
        recyclerView.setHasFixedSize(true);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(video.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        progressDialog = new ProgressDialog(video.this);

        progressDialog.setMessage("getting the Score ...");
//
        progressDialog.show();

        preschoolname.add("1");
        preschool.add("https://www.youtube.com/watch?v=xewMVtMk14Q&index=7&list=PLrHqUbddzk2zVIStQGpC-20BHZI5nsbfb");
        preschoolname.add("2");
        preschool.add("https://www.youtube.com/watch?v=s7cstF8Mz74&list=PLrHqUbddzk2zVIStQGpC-20BHZI5nsbfb&index=2");
        preschoolname.add("3");
        preschool.add("https://www.youtube.com/watch?v=PjH-hvB_raQ&list=PLrHqUbddzk2zVIStQGpC-20BHZI5nsbfb&index=15");
        preschoolname.add("4");
        preschool.add("https://www.youtube.com/watch?v=FvcS4BF4cKk&index=22&list=PLrHqUbddzk2zVIStQGpC-20BHZI5nsbfb");
        preschoolname.add("5");
        preschool.add("https://www.youtube.com/watch?v=KwRsEhdJ3Fo&list=PLrHqUbddzk2zVIStQGpC-20BHZI5nsbfb&index=23");

        grade1name.add("Addition Word Problems 1st Grade");
        grade1.add("https://www.youtube.com/watch?v=q7mi24ClSMw&index=7&list=PLrHqUbddzk2zZKzpIXLsQLtzcZDG0UaiU");
        grade1name.add("Word Problems Subtraction First Grade");
        grade1.add("https://www.youtube.com/watch?v=9Z2gpbYiEXo&list=PLrHqUbddzk2zZKzpIXLsQLtzcZDG0UaiU&index=5");
        grade1name.add("Adding Three Whole Numbers 1st Grade");
        grade1.add("https://www.youtube.com/watch?v=81NfQ350vw8&index=18&list=PLrHqUbddzk2zZKzpIXLsQLtzcZDG0UaiU");
        grade1name.add("Place Value First Grade");
        grade1.add("https://www.youtube.com/watch?v=1F3AycEDksY&index=23&list=PLrHqUbddzk2zZKzpIXLsQLtzcZDG0UaiU");
        grade1name.add("Counting to 120 - First Grade");
        grade1.add("https://www.youtube.com/watch?v=WwGwQ4oGloY&index=30&list=PLrHqUbddzk2zZKzpIXLsQLtzcZDG0UaiU");
        grade1name.add("Addition and Subtraction Strategies 1st Grade Math");
        grade1.add("https://www.youtube.com/watch?v=FtjkzSnZ4G4&index=32&list=PLrHqUbddzk2zZKzpIXLsQLtzcZDG0UaiU");

        grade2name.add("Adding and Subtracting Large Numbers 2nd Grade ");
        grade2.add("https://www.youtube.com/watch?v=zyVliUqkths&index=3&list=PLrHqUbddzk2wEUyCeoBzj3z_AKPFEh-g5");
        grade2name.add("Comparing Numbers - Greater Than Less Than");
        grade2.add("https://www.youtube.com/watch?v=rLZbniMGAVA&index=7&list=PLrHqUbddzk2wEUyCeoBzj3z_AKPFEh-g5");
        grade2name.add("Double Digit Addition with Regrouping - 1st and 2nd Grade");
        grade2.add("https://www.youtube.com/watch?v=ayFAh4VNMFA&index=11&list=PLrHqUbddzk2wEUyCeoBzj3z_AKPFEh-g5");
        grade2name.add("Subtraction and Regrouping with Zeros 2nd Grade Math");
        grade2.add("https://www.youtube.com/watch?v=ML1KoW9JMwA&index=16&list=PLrHqUbddzk2wEUyCeoBzj3z_AKPFEh-g5");
        grade2name.add("Fractions for 2nd Grade Kids - Partitioning Shapes Into Halves and Thirds");
        grade2.add("https://www.youtube.com/watch?v=6ooKWyPI0i4&index=17&list=PLrHqUbddzk2wEUyCeoBzj3z_AKPFEh-g5");
        grade2name.add("Learning Odd and Even Numbers for Kids - 1st and 2nd Grade");
        grade2.add("https://www.youtube.com/watch?v=uuD5JlrMnAk&index=19&list=PLrHqUbddzk2wEUyCeoBzj3z_AKPFEh-g5");
        grade2name.add("Multiplication Vocabulary - Math Video Elementary Kids");
        grade2.add("https://www.youtube.com/watch?v=3SrN2RdWv1Y&index=26&list=PLrHqUbddzk2wEUyCeoBzj3z_AKPFEh-g5");

        Intent i = getIntent();
        value = i.getStringExtra("value");
        callme(value);
    }

    private void callme(String value) {
        if (value.equals("preschool"))
        {
            Toast.makeText(this, "preschool", Toast.LENGTH_SHORT).show();
            adapterTwo = new RecyclerViewAdapterTwo(video.this,preschool,preschoolname);
            progressDialog.dismiss();
            recyclerView.setAdapter( adapterTwo );
        }
        else if (value.equals("grade1"))
        {
            adapterTwo = new RecyclerViewAdapterTwo(video.this,grade1,grade1name);
            progressDialog.dismiss();
            recyclerView.setAdapter( adapterTwo );
        }
        else if (value.equals("grade2"))
        {
            adapterTwo = new RecyclerViewAdapterTwo(video.this,grade2,grade2name);
            progressDialog.dismiss();
            recyclerView.setAdapter( adapterTwo );
        }
        else if (value.equals("grade3"))
        {
            adapterTwo = new RecyclerViewAdapterTwo(video.this,preschool,preschoolname);
            progressDialog.dismiss();
            recyclerView.setAdapter( adapterTwo );
        }
        else if (value.equals("grade4"))
        {
            adapterTwo = new RecyclerViewAdapterTwo(video.this,preschool,preschoolname);
            progressDialog.dismiss();
            recyclerView.setAdapter( adapterTwo );
        }
        else
        {
            Toast.makeText(this, "no selection", Toast.LENGTH_SHORT).show();
        }
    }
    }
