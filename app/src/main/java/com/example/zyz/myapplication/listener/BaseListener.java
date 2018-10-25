package com.example.zyz.myapplication.listener;

import java.util.List;

public interface BaseListener<T> {
    void onResponse(List<T> msg);
    void onFail(String msg);
}
