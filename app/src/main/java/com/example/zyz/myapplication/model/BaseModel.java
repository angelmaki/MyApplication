package com.example.zyz.myapplication.model;



import com.example.zyz.myapplication.listener.BaseListener;
import com.example.zyz.myapplication.listener.Listener;
import com.example.zyz.myapplication.service.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseModel {
    Retrofit retrofit;
    Service service;
    public static final String BASE_URL="http://119.29.120.74/yuejian/public/index.php/admin/api/";
    public Retrofit getRetrofit(){
        retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
    public Service getService(){
        service=retrofit.create(Service.class);
        return service;
    }
    public <T> void callenqueue(Call<T> call, final Listener<T> listener){
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                listener.onFail(t.toString());
            }
        });
    }
    public <T> void callenqueueList(Call<List<T>> call, final BaseListener<T> listener){
        call.enqueue(new Callback<List<T>>() {
            @Override
            public void onResponse(Call<List<T>> call, Response<List<T>> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<T>> call, Throwable t) {
                listener.onFail(t.toString());
            }
        });
    }
}
