package com.example.zyz.myapplication.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zyz.myapplication.R;


public class PicViewHolder extends RecyclerView.ViewHolder{

    public ImageView pic_img;
    public TextView pic_author;
    public TextView pic_club;
    public TextView pic_uptime;
    public ImageView pic_collect;


    public PicViewHolder(View itemView) {
        super(itemView);
        pic_img=(ImageView)itemView.findViewById(R.id.pic_img);
        pic_author=(TextView)itemView.findViewById(R.id.pic_author);
        pic_club=(TextView)itemView.findViewById(R.id.pic_club);
        pic_uptime=(TextView)itemView.findViewById(R.id.pic_uptime);
        pic_collect=(ImageView)itemView.findViewById(R.id.pic_collect);
    }
}
