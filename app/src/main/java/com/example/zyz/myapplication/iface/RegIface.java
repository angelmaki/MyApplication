package com.example.zyz.myapplication.iface;

import com.example.zyz.myapplication.listener.RegListener;

public interface RegIface<T> {
    public void reg(String u, String p, int gender, String tel, String realname, String regtime, String userheadimage, RegListener<T> r);
}
