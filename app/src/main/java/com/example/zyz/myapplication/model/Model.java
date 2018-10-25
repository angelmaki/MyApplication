package com.example.zyz.myapplication.model;


import com.example.zyz.myapplication.bean.PicBean;
import com.example.zyz.myapplication.iface.Iface;
import com.example.zyz.myapplication.listener.Listener;
import com.example.zyz.myapplication.service.Service;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model  implements Iface {
    private Retrofit retrofit;
    private Service service;
    private  static  final  String BASE_URL="http://172.20.141.218/yuejian/public/index.php/admin/api/";

    public  Model(){
        retrofit=new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service=retrofit.create(Service.class);
    }


    @Override
    public void pic(final Listener listener){
        Call<List<PicBean>> call = service.getPic();
        call.enqueue(new Callback<List<PicBean>>() {
            @Override
            public void onResponse(Call<List<PicBean>> call, Response<List<PicBean>> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<PicBean>> call, Throwable t) {
                listener.onFail(t.toString());
            }
        });
    }
}
