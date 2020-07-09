package com.example.lian_day1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lian_day1.activity.DengActivity;
import com.example.lian_day1.activity.ZhuActivity;
import com.example.lian_day1.prenter.MainPresenter;
import com.example.lian_day1.view.MainView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainView {

    private EditText mNameEd;
    private EditText mPassEd;
    private Button mDengBu;
    private Button mZhuBu;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mainPresenter = new MainPresenter(this);
    }

    private void initView() {
        mNameEd = (EditText) findViewById(R.id.ed_name);
        mPassEd = (EditText) findViewById(R.id.ed_pass);
        mDengBu = (Button) findViewById(R.id.bu_deng);
        mDengBu.setOnClickListener(this);
        mZhuBu = (Button) findViewById(R.id.bu_zhu);
        mZhuBu.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==200&&resultCode==300){
            String data1 = data.getStringExtra("data");
            mNameEd.setText(data1);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bu_deng:
                // TODO 20/06/28
                mainPresenter.getMtent();
                break;
            case R.id.bu_zhu:
                // TODO 20/06/28
                Intent intent = new Intent(MainActivity.this, ZhuActivity.class);
                startActivityForResult(intent,200);
                break;
            default:
                break;
        }
    }

    @Override
    public String getName() {
        return mNameEd.getText().toString();

    }

    @Override
    public String getpass() {
        return mPassEd.getText().toString();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void toActivity() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, DengActivity.class);
        startActivity(intent);

    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.destroy();
    }
}
