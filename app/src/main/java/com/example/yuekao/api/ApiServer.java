package com.example.yuekao.api;

import com.example.yuekao.bean.MyBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServer {
    String url="http://yun918.cn/";
    @GET("ks/jiekou1.json")
    Observable<MyBean> getData();
}
