package com.example.aone.navigationview_01.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.aone.navigationview_01.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //设置ToolBar标题栏
        /**
         * 标题栏中的按钮在menu文件的menu_main中设置
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace);
        toolbar.setTitle("Title");
        toolbar.setSubtitle("Subtitle");

        toolbar.inflateMenu(R.menu.menu_second);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        /**
         * CollapsingToolbarLayout作用是提供一个可以折叠的Toolbar,他继承至FrameLayout，
         * 给他设置layout_scrollFlags，他可以包含在CollapsingToolbarLayout中的控件在响应
         * layout_behavior事件时作出相应的scrollFags滚动事件
         */


        CollapsingToolbarLayout collapsingToolbar= (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Second Activity");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
