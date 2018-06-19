package com.lenovo.newgame.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lenovo.newgame.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Game> MainImageUploadInfoList;

    public RecyclerViewAdapter(Context context, List<Game> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.cardview, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        Game blog = MainImageUploadInfoList.get(position);
        holder.username.setText(blog.getUsername());
        holder.score.setText(blog.getScore());
        Glide.with(context.getApplicationContext()).load(blog.getProfileimage()).into(holder.profileImage);
    }

    @Override
    public int getItemCount() {
        return MainImageUploadInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView score;
        CircleImageView profileImage;
        TextView username;
        ViewHolder(View itemView) {

            super(itemView);

            username = (TextView) itemView.findViewById(R.id.name_user);

            score = (TextView) itemView.findViewById(R.id.score);

            profileImage = (CircleImageView) itemView.findViewById(R.id.profileimage);

        }
    }
public void clear(){
        final int  size =MainImageUploadInfoList.size();
        MainImageUploadInfoList.clear();
        notifyItemRangeChanged(  0,size );
}
}
