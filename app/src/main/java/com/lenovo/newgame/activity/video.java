package com.lenovo.newgame.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.lenovo.newgame.R;

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

    public ArrayList<Integer> preschoolimg = new ArrayList<>();
    public ArrayList<Integer> grade1img = new ArrayList<>();
    public ArrayList<Integer> grade2img = new ArrayList<>();
    public ArrayList<Integer> grade3img = new ArrayList<>();
    public ArrayList<Integer> grade4img = new ArrayList<>();

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


        preschoolimg.add(R.drawable.countingtoten);
        preschoolname.add("Counting to 10 Video for Kids");
        preschool.add("https://www.youtube.com/watch?v=xewMVtMk14Q&index=7&list=PLrHqUbddzk2zVIStQGpC-20BHZI5nsbfb");
        preschoolname.add("Addition Video for Kids ");
        preschoolimg.add(R.drawable.additionvideoforkids);
        preschool.add("https://www.youtube.com/watch?v=s7cstF8Mz74&list=PLrHqUbddzk2zVIStQGpC-20BHZI5nsbfb&index=2");
        preschoolimg.add(R.drawable.doubleaddition);
        preschoolname.add("Doubles Addition for Kids");
        preschool.add("https://www.youtube.com/watch?v=PjH-hvB_raQ&list=PLrHqUbddzk2zVIStQGpC-20BHZI5nsbfb&index=15");
        preschoolimg.add(R.drawable.learningnumberforkids);
        preschoolname.add("Counting for Kids  1 to 20");
        preschool.add("https://www.youtube.com/watch?v=FvcS4BF4cKk&index=22&list=PLrHqUbddzk2zVIStQGpC-20BHZI5nsbfb");
        preschoolimg.add(R.drawable.preschoolcollection);
        preschoolname.add("Preschool Learning Collection");
        preschool.add("https://www.youtube.com/watch?v=KwRsEhdJ3Fo&list=PLrHqUbddzk2zVIStQGpC-20BHZI5nsbfb&index=23");

        grade1img.add(R.drawable.additionwordproblems);
        grade1name.add("Addition Word Problems 1st Grade");
        grade1.add("https://www.youtube.com/watch?v=q7mi24ClSMw&index=7&list=PLrHqUbddzk2zZKzpIXLsQLtzcZDG0UaiU");
        grade1img.add(R.drawable.wordproblemssubtration);
        grade1name.add("Word Problems Subtraction");
        grade1.add("https://www.youtube.com/watch?v=9Z2gpbYiEXo&list=PLrHqUbddzk2zZKzpIXLsQLtzcZDG0UaiU&index=5");
        grade1img.add(R.drawable.addingthreewholenumbers);
        grade1name.add("Adding Three Whole Numbers ");
        grade1.add("https://www.youtube.com/watch?v=81NfQ350vw8&index=18&list=PLrHqUbddzk2zZKzpIXLsQLtzcZDG0UaiU");
        grade1img.add(R.drawable.placevalue);
        grade1name.add("Place Value First Grade");
        grade1.add("https://www.youtube.com/watch?v=1F3AycEDksY&index=23&list=PLrHqUbddzk2zZKzpIXLsQLtzcZDG0UaiU");
        grade1img.add(R.drawable.countingtoonetwenty);
        grade1name.add("Counting to 120 ");
        grade1.add("https://www.youtube.com/watch?v=WwGwQ4oGloY&index=30&list=PLrHqUbddzk2zZKzpIXLsQLtzcZDG0UaiU");
        grade1img.add(R.drawable.additionndsubtrationstrategies);
        grade1name.add("Addition and Subtraction Strategies ");
        grade1.add("https://www.youtube.com/watch?v=FtjkzSnZ4G4&index=32&list=PLrHqUbddzk2zZKzpIXLsQLtzcZDG0UaiU");

        grade2img.add(R.drawable.addingandsubtratinglargenumbers);
        grade2name.add("Adding and Subtracting Large Numbers ");
        grade2.add("https://www.youtube.com/watch?v=zyVliUqkths&index=3&list=PLrHqUbddzk2wEUyCeoBzj3z_AKPFEh-g5");
        grade2img.add(R.drawable.compairingnumbers);
        grade2name.add("Comparing Numbers  Greater Than Less Than");
        grade2.add("https://www.youtube.com/watch?v=rLZbniMGAVA&index=7&list=PLrHqUbddzk2wEUyCeoBzj3z_AKPFEh-g5");
        grade2img.add(R.drawable.doubledigitaddition);
        grade2name.add("Double Digit Addition with Regrouping ");
        grade2.add("https://www.youtube.com/watch?v=ayFAh4VNMFA&index=11&list=PLrHqUbddzk2wEUyCeoBzj3z_AKPFEh-g5");
        grade2img.add(R.drawable.subtractionandregrouping);
        grade2name.add("Subtraction and Regrouping with Zeros");
        grade2.add("https://www.youtube.com/watch?v=ML1KoW9JMwA&index=16&list=PLrHqUbddzk2wEUyCeoBzj3z_AKPFEh-g5");
        grade2img.add(R.drawable.fractions);
        grade2name.add("Fractions  Partitioning Shapes");
        grade2.add("https://www.youtube.com/watch?v=6ooKWyPI0i4&index=17&list=PLrHqUbddzk2wEUyCeoBzj3z_AKPFEh-g5");
        grade2img.add(R.drawable.learningoddandeven);
        grade2name.add("Learning Odd and Even Numbers ");
        grade2.add("https://www.youtube.com/watch?v=uuD5JlrMnAk&index=19&list=PLrHqUbddzk2wEUyCeoBzj3z_AKPFEh-g5");
        grade2img.add(R.drawable.multiplicationvocab);
        grade2name.add("Multiplication Vocabulary ");
        grade2.add("https://www.youtube.com/watch?v=3SrN2RdWv1Y&index=26&list=PLrHqUbddzk2wEUyCeoBzj3z_AKPFEh-g5");

        Intent i = getIntent();
        value = i.getStringExtra("value");
        callme(value);
    }

    private void callme(String value) {
        if (value.equals("preschool"))
        {
            Toast.makeText(this, "preschool", Toast.LENGTH_SHORT).show();
            adapterTwo = new RecyclerViewAdapterTwo(video.this,preschool,preschoolname,preschoolimg);
            progressDialog.dismiss();
            recyclerView.setAdapter( adapterTwo );
        }
        else if (value.equals("grade1"))
        {
            adapterTwo = new RecyclerViewAdapterTwo(video.this,grade1,grade1name,grade1img);
            progressDialog.dismiss();
            recyclerView.setAdapter( adapterTwo );
        }
        else if (value.equals("grade2"))
        {
            adapterTwo = new RecyclerViewAdapterTwo(video.this,grade2,grade2name,grade2img);
            progressDialog.dismiss();
            recyclerView.setAdapter( adapterTwo );
        }
        else if (value.equals("grade3"))
        {
            adapterTwo = new RecyclerViewAdapterTwo(video.this,grade2,grade2name,grade2img);
            progressDialog.dismiss();
            recyclerView.setAdapter( adapterTwo );
        }
        else if (value.equals("grade4"))
        {
            adapterTwo = new RecyclerViewAdapterTwo(video.this,grade2,grade2name,grade2img);
            progressDialog.dismiss();
            recyclerView.setAdapter( adapterTwo );
        }
        else
        {
            Toast.makeText(this, "no selection", Toast.LENGTH_SHORT).show();
        }
    }
    }
