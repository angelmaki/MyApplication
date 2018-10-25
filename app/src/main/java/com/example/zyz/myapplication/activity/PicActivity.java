package com.example.zyz.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zyz.myapplication.R;
import com.example.zyz.myapplication.adapter.PicAdapter;
import com.example.zyz.myapplication.bean.PicBean;
import com.example.zyz.myapplication.listener.Listener;
import com.example.zyz.myapplication.model.Model;

import java.util.ArrayList;
import java.util.List;

public class PicActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<PicBean> list;
    String userid;
    private PicAdapter adapter;
    private Listener<List<PicBean>> listener;
    public Model model;
    public int showpicid;


    @Override
    void initView() {
        setLayout_file(R.layout.activity_pic);
        recyclerView = (RecyclerView) findViewById(R.id.pic_list);
    }

    @Override
    void initEvent() {

        listener = new Listener<List<PicBean>>(){
            @Override
            public void onResponse(List<PicBean> msg){
               adapter = new PicAdapter(PicActivity.this,msg);
                layoutManager=new LinearLayoutManager(PicActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
                adapter.setList(msg);
            }

            @Override
            public void onFail(String msg){
                Toast.makeText(PicActivity.this,"失败",Toast.LENGTH_SHORT);
            }
        };
        model = new Model();
        model.pic(listener);

    }

    @Override
    void initData() {

    }
}
