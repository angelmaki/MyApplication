package com.example.zyz.myapplication.model;

import com.example.zyz.myapplication.bean.LoginBean;
import com.example.zyz.myapplication.iface.LoginIface;
import com.example.zyz.myapplication.listener.LoginListener;
import com.example.zyz.myapplication.service.Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginModel implements LoginIface {
    private Retrofit retrofit;
    private Service service;
    private  static  final String BASE_URL=URL.URL+"yuejian/public/index.php/admin/api/";


    public LoginModel(){
        retrofit=new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service=retrofit.create(Service.class);
    }


    @Override
    public void login(String u, String p, final LoginListener l) {
        Call<LoginBean> call=service.getLoginList(u,p);
        call.enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                l.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                l.onFail(t.toString());
            }
        });
    }
    }


