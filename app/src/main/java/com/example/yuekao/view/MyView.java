package com.example.yuekao.view;

import com.example.yuekao.bean.MyBean;

import java.util.List;

public interface MyView {
    void showToast(String str);
    void showList(List<MyBean.DataBean.ListBean> listBeans);
}
