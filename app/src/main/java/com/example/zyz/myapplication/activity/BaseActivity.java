package com.example.zyz.myapplication.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.zyz.myapplication.R;

public abstract class BaseActivity extends AppCompatActivity {
    private  int layout_file;
    abstract void initView();
    abstract void initEvent();
    abstract void initData();


    void setLayout_file(int layout_file){
        setContentView(layout_file);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initEvent();
        initData();

    }
    public String getUser_name(){
        SharedPreferences sp;
        sp=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        return sp.getString("username","");
    }
    public String getPassW(){
        SharedPreferences sp;
        sp=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        return sp.getString("password","");
    }
    public String getUser_id(){
        SharedPreferences sp;
        sp=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        return sp.getString("userid","");
    }
    public void showToast(String context){
        Toast.makeText(this,context,Toast.LENGTH_SHORT).show();
    }
}
