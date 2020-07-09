package com.example.yuekao;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.yuekao.acyivity.DuiActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private EditText mShuEd;
    private Button mTiaoU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mShuEd = (EditText) findViewById(R.id.ed_shu);
        mTiaoU = (Button) findViewById(R.id.u_tiao);
        mTiaoU.setOnClickListener(this);
        setSupportActionBar(mToolbar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.u_tiao:
                // TODO 20/06/23
                Editable text = mShuEd.getText();
                Intent intent = new Intent(MainActivity.this, DuiActivity.class);

                intent.putExtra("shu",text+"200");
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
