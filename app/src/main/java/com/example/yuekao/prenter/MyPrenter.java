package com.example.yuekao.prenter;

import com.example.yuekao.bean.MyBean;
import com.example.yuekao.model.MyModel;
import com.example.yuekao.view.MyView;

import java.util.List;

public class MyPrenter implements MyModel.CallBack {
    private MyView myView;
    private MyModel myModel;

    public MyPrenter(MyView myView) {
        this.myView = myView;
        myModel=new MyModel();
    }

    public void getData(){
        myModel.getData(this);
    }
    @Override
    public void showToast(String str) {
        myView.showToast(str);
    }

    @Override
    public void showList(List<MyBean.DataBean.ListBean> listBeans) {
        myView.showList(listBeans);
    }
}
