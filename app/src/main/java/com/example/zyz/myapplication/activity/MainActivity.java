package com.example.zyz.myapplication.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zyz.myapplication.R;
import com.example.zyz.myapplication.bean.LoginBean;
import com.example.zyz.myapplication.listener.LoginListener;
import com.example.zyz.myapplication.model.LoginModel;

public class MainActivity extends BaseActivity {

    private CheckBox checkBox;
    private Button bt_login;
    private TextView tv_fgpassword;
    private TextView tv_newreg;
    private TextView tv_phonereg;
    private EditText et_user;
    private EditText et_password;
    int userid;
    private CheckBox cb_remember;
    Intent intent;
    Intent intent1;
    LoginModel model;
    SharedPreferences sp;
    LoginListener<LoginBean> listener;

    @Override
    void initView() {
        setLayout_file(R.layout.login_layout);
        tv_fgpassword=(TextView)findViewById(R.id.tv_fgpassword);
        tv_newreg=(TextView)findViewById(R.id.tv_newreg);
        et_user=(EditText) findViewById(R.id.et_user);
        et_password=(EditText)findViewById(R.id.et_password);
        tv_phonereg=(TextView)findViewById(R.id.tv_phonereg);
        intent1=new Intent(MainActivity.this, NewregActivity.class);
        intent=new Intent(MainActivity.this,IndexActivity.class);
        cb_remember=(CheckBox)findViewById(R.id.cb_remember);
        bt_login=(Button)findViewById(R.id.bt_login);
    }

    @Override
    void initEvent() {
        listener=new LoginListener<LoginBean>() {
            @Override
            public void onResponse(LoginBean L) {
                if (L.getMessage().equals("success")) {
                    userid = L.getUserid();
                    saveUser();
                    showToast("登录成功");
                    startActivity(intent);
                }
                if (L.getMessage().equals("用户不存在")) {
                    showToast("用户不存在");
                }
                if(L.getMessage().equals("密码错误")){
                    showToast("密码错误");
                }
            }

            @Override
            public void onFail(String msg) {
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        };
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_user.getText().toString().trim().equals("")||et_password.getText().toString().trim().equals(""))
                {
                    showToast("用户名或密码不能为空.");
                }
                else {
                    //拿着用户名和密码去服务器判断数据是否正确
                    model=new LoginModel();
                    model.login(et_user.getText().toString(),et_password.getText().toString(),listener);
                    // Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    // saveUser();
                }
            }
        });
        tv_newreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intent1,1);
            }
        });
    }

    @Override
    void initData() {

    }
    public void saveUser(){
        SharedPreferences sp=getSharedPreferences("userInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("username",et_user.getText().toString());
        editor.putString("password",et_password.getText().toString());
        editor.putInt("userid",userid);
        editor.commit();
    }

}
