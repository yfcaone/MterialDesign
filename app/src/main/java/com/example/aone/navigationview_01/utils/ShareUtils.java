package com.example.aone.navigationview_01.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by aone on 2016/7/28.
 */
public class ShareUtils {

    public static boolean saveUserInfo(Context context, String number, String password) {
        boolean info = false;
        SharedPreferences sp = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();

        edit.putString("userName", number);
        edit.putString("pwd", password);
        if (number != null && number.length() > 4) {
            if (password != null && password.length() > 6) {
                edit.commit();
                System.out.println(edit.commit());
                info = true;
            } else {
                info = false;
            }

        } else {
            info = false;
        }
        return info;

    }

    public static boolean getUserInfo(Context context, String name, String paw) {
        boolean ab = false;
        SharedPreferences sp = context.getSharedPreferences("data", Context.MODE_APPEND);
        String number = sp.getString("userName", null);
        String password = sp.getString("pwd", null);

        if (name.equals(number)) {
            if (paw.equals(password)) {
                ab = true;
            }
        } else {
            ab = false;
        }
        return ab;
    }
}
