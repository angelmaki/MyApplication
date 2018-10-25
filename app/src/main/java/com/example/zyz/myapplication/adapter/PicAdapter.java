package com.example.zyz.myapplication.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.zyz.myapplication.R;
import com.example.zyz.myapplication.activity.PicDetailActivity;
import com.example.zyz.myapplication.bean.PicBean;
import com.example.zyz.myapplication.viewHolder.PicViewHolder;

import java.util.List;

public class PicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<PicBean> list;
    private AdapterView.OnItemClickListener mOnItemClickListener = null;

    public PicAdapter(Context context, List<PicBean> list) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
    }

    public void setList(List<PicBean> l){
        list=l;
        notifyDataSetChanged();
    }





    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.pic_item,parent,false);
        PicViewHolder vh= new PicViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PicViewHolder viewHolder = (PicViewHolder) holder;
        final int showpicid = list.get(position).getShowpicid();
        final int userid = list.get(position).getUserid();
        final int clubid = list.get(position).getClubid();
        final String showpicuptime = list.get(position).getShowpicuptime();
        final String showpiccontent = list.get(position).getShowpiccontent();
        final String showpicpath = list.get(position).getShowpicpath();

        viewHolder.pic_uptime.setText(showpicuptime);

        /*viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(context, PicDetailActivity.class);
                    intent.putExtra("showpicid", showpicid);
                    intent.putExtra("userid", userid);
                    intent.putExtra("clubid", clubid);
                    intent.putExtra("showpicuptime", showpicuptime);
                    intent.putExtra("showpiccontent", showpiccontent);
                    intent.putExtra("showpicpath", showpicpath);
                context.startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount () {
        return list.size();
    }
}



