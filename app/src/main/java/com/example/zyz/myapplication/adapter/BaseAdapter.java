package com.example.zyz.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;

import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter {
    private LayoutInflater inflater;
    Context context;
    List<T> items;
    int layoutResource;

    public BaseAdapter (Context context, List<T> items,int layoutResource){
        this.context = context;
        this.items = items;
        this.layoutResource = layoutResource;
    }

    public int getItemCount(){return items.size();}
}
