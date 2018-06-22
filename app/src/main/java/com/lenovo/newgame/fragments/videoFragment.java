package com.lenovo.newgame.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lenovo.newgame.R;
import com.lenovo.newgame.activity.video;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class videoFragment extends Fragment {


    @BindView(R.id.preschool)
    LinearLayout preschool;
    @BindView(R.id.grade1)
    LinearLayout grade1;
    @BindView(R.id.grade2)
    LinearLayout grade2;
    @BindView(R.id.grade3)
    LinearLayout grade3;
    @BindView(R.id.grade4)
    LinearLayout grade4;
    Unbinder unbinder;
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

    @OnClick({R.id.preschool, R.id.grade1, R.id.grade2, R.id.grade3, R.id.grade4})
    public void onViewClicked(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.preschool:
                i = new Intent(getContext(), video.class);
                i.putExtra("value", "preschool");
                startActivity(i);
                break;
            case R.id.grade1:
                i = new Intent(getContext(), video.class);
                i.putExtra("value", "grade1");
                startActivity(i);
                break;
            case R.id.grade2:
                i = new Intent(getContext(), video.class);
                i.putExtra("value", "grade2");
                startActivity(i);
                break;
            case R.id.grade3:
                i = new Intent(getContext(), video.class);
                i.putExtra("value", "grade3");
                startActivity(i);
                break;
            case R.id.grade4:
                i = new Intent(getContext(), video.class);
                i.putExtra("value", "grade4");
                startActivity(i);
                break;
            default:
                Toast.makeText(getContext(), "helooo guyss", Toast.LENGTH_SHORT).show();
        }
    }

}
