package com.example.aone.navigationview_01;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * 
 * Created by aone on 2016/7/26.
 */
public class MyTextWatcher implements TextWatcher {

    private TextInputLayout mTextInputLayout;
    private String errorInfo;

    public MyTextWatcher(TextInputLayout textInputLayout, String errorInfo) {
        this.mTextInputLayout = textInputLayout;
        this.errorInfo = errorInfo;
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        if (mTextInputLayout.getEditText().getText().toString().length() < 6) {
            mTextInputLayout.setErrorEnabled(true);//是否设置提示信息;
            mTextInputLayout.setError(errorInfo);//设置错误提示信息
        } else {
            mTextInputLayout.setErrorEnabled(false);//不设置错误提示信息
        }
    }

}
