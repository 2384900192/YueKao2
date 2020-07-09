package com.example.lian_day1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lian_day1.MainActivity;
import com.example.lian_day1.R;
import com.example.lian_day1.api.ApiServer;
import com.example.lian_day1.bean.YanBean;
import com.example.lian_day1.bean.ZhuBean;
import com.example.lian_day1.prenter.MyPrenter;
import com.example.lian_day1.view.MyView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ZhuActivity extends AppCompatActivity implements View.OnClickListener, MyView {

    private EditText mUserEd;
    private EditText mWordEd;
    private EditText mPasswordEd;
    private EditText mPhoneEd;
    private EditText mVerifyEd;
    private Button mCeBu;
    private String user;
    private String password;
    private String phone;
    private String verify;
    private MyPrenter myPrenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        initView();
        myPrenter = new MyPrenter(this);
    }



    private void initView() {
        mUserEd = (EditText) findViewById(R.id.ed_user);
        mWordEd = (EditText) findViewById(R.id.ed_word);
        mPasswordEd = (EditText) findViewById(R.id.ed_password);
        mPhoneEd = (EditText) findViewById(R.id.ed_phone);
        mVerifyEd = (EditText) findViewById(R.id.ed_verify);
        mCeBu = (Button) findViewById(R.id.bu_ce);
        mCeBu.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bu_ce:
                // TODO 20/06/28
                myPrenter.getMtent();
                break;
            default:
                break;
        }
    }

    @Override
    public String getName() {
        return mUserEd.getText().toString();
    }

    @Override
    public String getpass() {
        return mPasswordEd.getText().toString();
    }

    @Override
    public String getpassed() {
        return null;
    }

    @Override
    public String getphone() {
        return mPhoneEd.getText().toString();
    }

    @Override
    public String getverify() {
        return mVerifyEd.getText().toString();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toActivity() {
        String s = mUserEd.getText().toString();
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(ZhuActivity.this, MainActivity.class);
        Intent intent = getIntent();
        intent.putExtra("data",s);
        setResult(300,intent);
        finish();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        myPrenter.destroy();
    }
}
