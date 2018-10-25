package com.example.zyz.myapplication.model;

import com.example.zyz.myapplication.bean.RegBean;
import com.example.zyz.myapplication.iface.RegIface;
import com.example.zyz.myapplication.listener.RegListener;
import com.example.zyz.myapplication.service.Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegModel implements RegIface{
    private Retrofit retrofit;
    private Service service;
    private  static  final String BASE_URL=URL.URL+"yuejian/public/index.php/admin/api/";
   public RegModel(){
        retrofit=new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service=retrofit.create(Service.class);
    }
    @Override
    public void reg(String u, String p, int gender, String tel, String realname, String regtime, String userheadimage, final RegListener r) {
        Call<RegBean> call=service.getRegList(u,p,gender,tel,realname,regtime,userheadimage);
        call.enqueue(new Callback<RegBean>() {
            @Override
            public void onResponse(Call<RegBean> call, Response<RegBean> response) {
                r.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<RegBean> call, Throwable t) {

            }
        });
    }


}
