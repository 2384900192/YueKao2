package com.example.yuekao.acyivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.yuekao.R;

public class XiangActivity extends AppCompatActivity {

    private TextView mFferTe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang);
        initView();
    }

    private void initView() {
        mFferTe = (TextView) findViewById(R.id.te_ffer);
        String data = getIntent().getStringExtra("data");
        mFferTe.setText("金额为："+data);
    }
}
