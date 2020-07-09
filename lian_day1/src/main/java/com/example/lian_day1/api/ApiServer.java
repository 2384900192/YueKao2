package com.example.lian_day1.api;

import com.example.lian_day1.bean.MainBean;
import com.example.lian_day1.bean.YanBean;
import com.example.lian_day1.bean.ZhuBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServer {

    String URL="https://www.wanandroid.com/";
    String uan="http://yun918.cn/study/public/";



    @POST("user/login")
    @FormUrlEncoded
    Observable<MainBean> getMtent(@Field("username") String username, @Field("password") String password, @Field("phone") String phone, @Field("verify") String verify);


    @POST("user/login")
    @FormUrlEncoded
    Observable<MainBean> getdata(@Field("username") String username, @Field("password") String password);


    @GET("index.php/verify")
    Observable<YanBean> getdata();

}
