package com.example.zyz.myapplication.iface;

import com.example.zyz.myapplication.listener.LoginListener;

public interface LoginIface<T> {
   public void login(String u, String p, LoginListener<T> l);
}
