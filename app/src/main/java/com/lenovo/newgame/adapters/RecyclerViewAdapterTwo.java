package com.lenovo.newgame.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lenovo.newgame.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapterTwo extends RecyclerView.Adapter<RecyclerViewAdapterTwo.ViewHolder> {

    public Context context;
    public List<String> templist = new ArrayList<>();
    public List<String> namelist = new ArrayList<>();

    public RecyclerViewAdapterTwo(Context context, List<String> templist , List<String>namelist) {
        this.context = context;
        this.templist = templist;
        this.namelist = namelist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewtwo, parent, false);
        return new ViewHolder(view);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView img;
        public TextView text;
        public CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.image);
            text = (TextView)itemView.findViewById(R.id.text);
            cardView = (CardView)itemView.findViewById(R.id.linear);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.text.setText(namelist.get(position));
        holder.img.setImageResource(R.drawable.quiztime);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(templist.get(position)));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }


}