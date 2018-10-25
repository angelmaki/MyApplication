package com.example.zyz.myapplication.iface;

import com.example.zyz.myapplication.bean.PicBean;
import com.example.zyz.myapplication.listener.Listener;

import java.util.List;

public interface Iface<T> {
    public void pic(Listener<List<PicBean>> listener);
}
