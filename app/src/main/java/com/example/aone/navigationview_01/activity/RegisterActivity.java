package com.example.aone.navigationview_01.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aone.navigationview_01.MyTextWatcher;
import com.example.aone.navigationview_01.R;
import com.example.aone.navigationview_01.utils.ShareUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 * Created by aone on 2016/7/28.
 */
public class RegisterActivity extends Activity {

    private TextInputLayout mTextInputLayoutname;
    private TextInputLayout mTextInputLayoutpassword;
    private EditText musername;
    private EditText mpassoword;
    private Button complete_btn;
    private Button return_btn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        musername = (EditText) findViewById(R.id.username);
        mpassoword = (EditText) findViewById(R.id.password);


        mTextInputLayoutname = (TextInputLayout) findViewById(R.id.usernameWrapper1);
        mTextInputLayoutpassword = (TextInputLayout) findViewById(R.id.passwordWrapper1);
        mTextInputLayoutname.getEditText().addTextChangedListener(new MyTextWatcher(mTextInputLayoutname, "用户名字长度不能小于4位"));
        mTextInputLayoutpassword.getEditText().addTextChangedListener(new MyTextWatcher(mTextInputLayoutpassword, "用户名字长度不能小于6位"));

        complete_btn = (Button) findViewById(R.id.completr_btn);
        complete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passDate();
            }
        });
        return_btn = (Button) findViewById(R.id.retnru_btv);
        return_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    /**
     * 注册并保存信息
     */
    public void passDate() {
        Intent intent = new Intent();
        intent.putExtra("name", musername.getText().toString().trim());
        intent.putExtra("password", mpassoword.getText().toString().trim());

//        startActivity(intent);
        boolean isSaveSuccess = ShareUtils.saveUserInfo(RegisterActivity.this, musername.getText().toString().trim(), mpassoword.getText().toString().trim());
        if (isSaveSuccess) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
        }
    }
}
