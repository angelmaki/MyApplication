package com.example.zyz.myapplication.listener;

public interface LoginListener<T> {
    public void onResponse(T L);
    public void onFail(String msg);
}
