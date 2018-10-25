package com.example.zyz.myapplication.activity;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zyz.myapplication.R;
import com.example.zyz.myapplication.bean.RegBean;
import com.example.zyz.myapplication.listener.RegListener;
import com.example.zyz.myapplication.model.RegModel;

public class NewregActivity extends BaseActivity {


    private EditText et_newusername;
    private EditText et_newpassword;
    private TextView gender;
    private RadioButton man;
    private RadioButton woman;
    private EditText et_realname;
    private EditText et_tel;
    private EditText et_regtime;
    private EditText et_headimage;
    private Button bt_newreg;
    RegModel model;
    RegListener<RegBean> listener;
    Intent intent;

    @Override
    void initView() {
        setLayout_file(R.layout.newreg_layout);
        et_newusername = (EditText) findViewById(R.id.et_newusername);
        et_newpassword = (EditText) findViewById(R.id.et_newpassword);
        et_realname = (EditText) findViewById(R.id.et_realname);
        et_tel = (EditText) findViewById(R.id.et_tel);
        et_regtime = (EditText) findViewById(R.id.et_regtime);
        et_headimage = (EditText) findViewById(R.id.et_headimage);
        gender = (TextView) findViewById(R.id.gender);
        bt_newreg = (Button) findViewById(R.id.bt_newreg);
        intent=new Intent(NewregActivity.this,MainActivity.class);
    }

    @Override
    void initEvent() {
        listener =new RegListener<RegBean>() {
            @Override
            public void onResponse(RegBean L) {
                if (L.getMessage().equals("1")) {
                    showToast("缺少提交数据");
                }
                if (L.getMessage().equals("2")) {
                    showToast("注册成功");
                    intent.putExtra("reg_name", et_newusername.getText().toString());
                    setResult(2, intent);
                    finish();
                }
                if (L.getMessage().equals("3")) {
                    showToast("注册失败");
                }
                if (L.getMessage().equals("4")) {
                    showToast("该用户已被注册");
                }
            }

            @Override
            public void onFail(String msg) {
                Toast.makeText(NewregActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    void initData() {

    }


}