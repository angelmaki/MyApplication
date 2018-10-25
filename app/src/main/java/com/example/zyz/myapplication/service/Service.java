package com.example.zyz.myapplication.service;

import com.example.zyz.myapplication.bean.LoginBean;
import com.example.zyz.myapplication.bean.PicBean;
import com.example.zyz.myapplication.bean.RegBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Service {
    @POST("login")
    Call<LoginBean> getLoginList(@Query("username") String Loginname, @Query("password") String
            Loginpass);
    @POST("reg")
    Call<RegBean>getRegList(@Query("user_name") String usermane, @Query("user_password")String password
            , @Query("user_gender") int gender, @Query("user_tel")String tel, @Query("user_realname")String realname,
                            @Query("user_regtime")String regtime, @Query("user_userheadimage")String headimage
    );
    @GET("getshowpiclist")
    Call<List<PicBean>> getPic();
}
