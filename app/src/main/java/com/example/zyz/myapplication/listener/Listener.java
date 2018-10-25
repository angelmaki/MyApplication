package com.example.zyz.myapplication.listener;

public interface Listener<T> {
    void onResponse(T msg);
    void onFail(String msg);
}
