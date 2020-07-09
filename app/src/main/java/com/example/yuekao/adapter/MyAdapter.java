package com.example.yuekao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuekao.R;
import com.example.yuekao.bean.MyBean;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    Context context;
    List<MyBean.DataBean.ListBean> list;

    public MyAdapter(Context context, List<MyBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.activity_itme, viewGroup, false);
        return new ViewHolder1(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyBean.DataBean.ListBean listBean = list.get(i);
        ViewHolder1 viewHolder1= (ViewHolder1) viewHolder;
        viewHolder1.tv_name.setText(listBean.getName());
        viewHolder1.tv_price.setText(listBean.getPrice()+"元");
        viewHolder1.tv_sellCount.setText("销售："+listBean.getSellCount()+"个");
        viewHolder1.tv_stockCount.setText("库存："+listBean.getStockCount()+"个");
        Glide.with(context).load(listBean.getPic()).into(viewHolder1.iv_pic);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder1 extends RecyclerView.ViewHolder {
            TextView tv_name,tv_price,tv_sellCount,tv_stockCount;
            ImageView iv_pic;
            CheckBox cherck;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_sellCount = itemView.findViewById(R.id.tv_sellCount);
            tv_stockCount = itemView.findViewById(R.id.tv_stockCount);
            cherck = itemView.findViewById(R.id.cherck);
            iv_pic = itemView.findViewById(R.id.iv_pic);
        }
    }
}
