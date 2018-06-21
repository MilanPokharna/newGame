package com.lenovo.newgame.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lenovo.newgame.R;
import com.lenovo.newgame.activity.video;
import com.lenovo.newgame.adapters.RecyclerViewAdapterTwo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class videoFragment extends Fragment {
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
    @BindView(R.id.Preschool)
    TextView preschoolv;
    @BindView(R.id.grade1)
    TextView grade1v;
    @BindView(R.id.grade2)
    TextView grade2v;
    @BindView(R.id.grade3)
    TextView grade3v;
    @BindView(R.id.grade4)
    TextView grade4v;
    Unbinder unbinder;

    public RecyclerViewAdapterTwo adapterTwo;

    public videoFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_video, container, false);
        unbinder = ButterKnife.bind(this, rootview);
        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        preschool.add("https://www.youtube.com/watch?v=xewMVtMk14Q&index=7&list=PLrHqUbddzk2zVIStQGpC-20BHZI5nsbfb");
        preschool.add("https://www.youtube.com/watch?v=s7cstF8Mz74&list=PLrHqUbddzk2zVIStQGpC-20BHZI5nsbfb&index=2");
        preschool.add("https://www.youtube.com/watch?v=PjH-hvB_raQ&list=PLrHqUbddzk2zVIStQGpC-20BHZI5nsbfb&index=15");
        preschool.add("https://www.youtube.com/watch?v=FvcS4BF4cKk&index=22&list=PLrHqUbddzk2zVIStQGpC-20BHZI5nsbfb");
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

//        grade3name.add("");
//        grade3.add("");
//        grade3name.add("");
//        grade3.add("");
//        grade3name.add("");
//        grade3.add("");
//        grade3name.add("");
//        grade3.add("");
//        grade3name.add("");
//        grade3.add("");
//        grade3name.add("");
//        grade3.add("");
//        grade3name.add("");
//        grade3.add("");
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.Preschool, R.id.grade1, R.id.grade2, R.id.grade3, R.id.grade4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Preschool:
                Intent i = new Intent(getContext(),video.class);
                startActivity(i);
                break;
            case R.id.grade1:
                break;
            case R.id.grade2:
                break;
            case R.id.grade3:
                break;
            case R.id.grade4:
                break;
        }
    }
}
