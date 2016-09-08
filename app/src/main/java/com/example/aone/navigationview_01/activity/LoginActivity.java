package com.example.aone.navigationview_01.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aone.navigationview_01.MyTextWatcher;
import com.example.aone.navigationview_01.R;
import com.example.aone.navigationview_01.comm.Http;
import com.example.aone.navigationview_01.utils.ShareUtils;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


/**
 *登陆注册界面
 * Created by aone on 2016/7/26.
 */
public class LoginActivity extends Activity {

    private TextInputLayout mTextInputLayoutName;
    private TextInputLayout mTextInputLayoutPassword;
    private Button loginButton;
    private Button registerButton;
    private EditText username;
    private EditText password;



//    @BindView(R.id.username)EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

//        ButterKnife.bind(this);
        //TextInputLayout设置
        mTextInputLayoutName = (TextInputLayout) findViewById(R.id.usernameWrapper);
        mTextInputLayoutPassword = (TextInputLayout) findViewById(R.id.passwordWrapper);
        mTextInputLayoutName.getEditText().addTextChangedListener(new MyTextWatcher(mTextInputLayoutName, "用户名字长度不能小于3位"));
        mTextInputLayoutPassword.getEditText().addTextChangedListener(new MyTextWatcher(mTextInputLayoutPassword, "密码长度不能小于6位"));


        try {
            File file = new File("data/data/com.example.aone.navigationview_01/shared_prefs", "data.xml");
            FileInputStream fis = new FileInputStream(file);
//            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //登陆
        loginButton = (Button) findViewById(R.id.login_btn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                intent.putExtra("username", username.getText().toString().trim());
                intent.putExtra("pwd", password.getText().toString().trim());
                boolean getInfo = ShareUtils.getUserInfo(LoginActivity.this, username.getText().toString().trim(), password.getText().toString().trim());
                if (getInfo) {
                    startActivity(intent);

                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "不正确，请重新输入", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //注册
        registerButton = (Button) findViewById(R.id.register);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

                finish();
            }
        });

    }




}
