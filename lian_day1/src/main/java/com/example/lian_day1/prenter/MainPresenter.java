package com.example.lian_day1.prenter;

import android.text.TextUtils;

import com.example.lian_day1.bean.MainBean;
import com.example.lian_day1.model.MainModel;
import com.example.lian_day1.view.MainView;


public class MainPresenter implements MainModel.CallBack {
    private MainView mainView;
    private MainModel mainModel ;

    public void getMtent() {
        String name = mainView.getName();
        String pass = mainView.getpass();
        if (TextUtils.isEmpty(name)||TextUtils.isEmpty(pass)){
            mainView.showToast("账号密码为空");
        }else {
            mainModel.getMtent(name,pass,this);
        }
    }

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        mainModel =new MainModel();
    }

    @Override
    public void onSuccess(MainBean mainBean) {
        if (mainBean.getErrorCode()==-1){
            mainView.showToast(mainBean.getErrorMsg());
        }else {
            mainView.toActivity();
        }
    }

    @Override
    public void onFail(String str) {
        if (mainView!=null){
            mainView.showToast(str);
        }
    }
    public void destroy(){
        if (mainView!=null){
            mainView= null;
        }
        if (mainModel!=null){
            mainModel.dispose();
            mainModel= null;
        }
    }
}
