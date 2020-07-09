package com.example.lian_day1.model;



import com.example.lian_day1.api.ApiServer;
import com.example.lian_day1.bean.MainBean;
import com.example.lian_day1.bean.ZhuBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel {
    public Disposable pis;

    public void getMtent(String name, String pass,String phone, String verify, final CallBack callBack){
        Retrofit builder = new Retrofit.Builder()
                .baseUrl(ApiServer.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiServer apiService = builder.create(ApiServer.class);
        Observable<MainBean> mtent = apiService.getMtent(name, pass,phone,verify);
        mtent.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        pis=d;
                    }

                    @Override
                    public void onNext(MainBean zhuBean) {
                        if (zhuBean!=null){
                            callBack.onSuccess(zhuBean);
                        }else {
                            callBack.onFail("参数有误");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void dispose(){
        pis.dispose();
    }

    public interface  CallBack{
        void onSuccess(MainBean zhuBean);
        void onFail(String str);
    }
}
