package com.example.lian_day1.prenter;

import android.text.TextUtils;

import com.example.lian_day1.bean.MainBean;
import com.example.lian_day1.bean.ZhuBean;
import com.example.lian_day1.model.MyModel;
import com.example.lian_day1.view.MyView;

public class MyPrenter implements MyModel.CallBack {

    private MyView myView;
    private MyModel myModel;

    public MyPrenter(MyView myView) {
        this.myView = myView;
        myModel=new MyModel();
    }
    public void getMtent() {
        String name = myView.getName();
        String pass = myView.getpass();
        String passed = myView.getpassed();
        String phone = myView.getphone();
        String verify = myView.getverify();
        if (TextUtils.isEmpty(name)&&TextUtils.isEmpty(pass)&&TextUtils.isEmpty(passed)&&TextUtils.isEmpty(phone)&&TextUtils.isEmpty(verify)){
            myView.showToast("账号密码为空");
        }if (pass.equals(passed)){
            myView.showToast("密码不匹配");
        }else {
            myModel.getMtent(name,pass,phone,verify,this);
        }
    }
    @Override
    public void onSuccess(MainBean zhuBean) {
        if (zhuBean.getErrorCode()==-1){
            myView.showToast(zhuBean.getErrorMsg());
        }else {
            myView.toActivity();
        }
    }

    @Override
    public void onFail(String str) {
        if (myView!=null){
            myView.showToast(str);
        }
    }
    public void destroy(){
        if (myView!=null){
            myView= null;
        }
        if (myModel!=null){
            myModel.dispose();
            myModel= null;
        }
    }
}
