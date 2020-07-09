package com.example.yuekao.acyivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuekao.R;
import com.example.yuekao.adapter.MyAdapter;
import com.example.yuekao.bean.MyBean;
import com.example.yuekao.prenter.MyPrenter;
import com.example.yuekao.view.MyView;

import java.util.ArrayList;
import java.util.List;

public class DuiActivity extends AppCompatActivity implements View.OnClickListener, MyView {

    private Toolbar mToob;
    private EditText mShoujiEd;
    private EditText mShouji2Ed;
    private RecyclerView mRecycler;
    private Button mQuBu;
    private Button mQueren;
    private List<MyBean.DataBean.ListBean> list;
    private MyAdapter myAdapter;
    private String shu;
    private TextView mJinTv;
    private TextView mXuTv;
    MyBean.DataBean post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dui);
        initView();
        initData();
        shu = getIntent().getStringExtra("shu");
    }

    private void initData() {
        MyPrenter myPrenter = new MyPrenter(this);
        myPrenter.getData();
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        mRecycler.setAdapter(myAdapter);
        mJinTv.setText("账户余额：200" );

    }

    private void initView() {
        mToob = (Toolbar) findViewById(R.id.toob);
        mShoujiEd = (EditText) findViewById(R.id.ed_shouji);
        mShouji2Ed = (EditText) findViewById(R.id.ed_shouji2);
        mRecycler = (RecyclerView) findViewById(R.id.recycler);
        mQuBu = (Button) findViewById(R.id.bu_qu);
        mQuBu.setOnClickListener(this);
        mQueren = (Button) findViewById(R.id.queren);
        mQueren.setOnClickListener(this);
        mJinTv = (TextView) findViewById(R.id.tv_jin);
        mXuTv = (TextView) findViewById(R.id.tv_xu);
        setSupportActionBar(mToob);

//        mXuTv.setText(""+post.getService());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bu_qu:
                // TODO 20/06/23
                break;
            case R.id.queren:
                // TODO 20/06/23

                        Intent intent = new Intent(DuiActivity.this, XiangActivity.class);
                        intent.putExtra("data","98");
                        startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showList(List<MyBean.DataBean.ListBean> listBeans) {
        list.addAll(listBeans);
        myAdapter.notifyDataSetChanged();

    }
}
