package com.example.aone.navigationview_01.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

import com.example.aone.navigationview_01.R;
import com.example.aone.navigationview_01.adapter.DesignDemoPagerAdapter;

public class MainActivity extends AppCompatActivity {

    public CardView mCardView;
    private long clickTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mCardView = (CardView) findViewById(R.id.cv);

        //设置ToolBar标题栏
        /**
         * 在布局文件中
         * 标题栏中的按钮在menu文件的menu_main中设置
         *
         */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        //设置抽屉DrawerLayout
        /**
         * 抽屉布局使用NavigationView控件
         * 设置其宽高，切记写上android:layout_gravity="start"
         * 之后添加两个布局 app:headerLayout="@layout/navigation_header"   app:menu="@menu/drawer"
         * 作用分别是抽屉的上部和下部布局的设置
         * 在menu中的xml文件若实现分组，可写多个group节点
         */
        final DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();//初始化状
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        NavigationView mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        //隐藏某个菜单单列表项
//        MenuItem menuItem=mNavigationView.getMenu().findItem(R.id.navigation_item_attachment);
//        menuItem.setVisible(false);

        //实现抽屉的点击跳转
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.navigation_item_images:
                        Toast.makeText(MainActivity.this, "I'm a images", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_item_attachment:
                        Toast.makeText(MainActivity.this, "I'm a attachment", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_item_location:
                        Toast.makeText(MainActivity.this, "I'm a location", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                item.setChecked(true);//点击了吧它设为选中状态
                mDrawerLayout.closeDrawers();//关闭抽屉
                return true;
            }
        });

        //点击fab
        /**
         * 浮动按钮
         */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.coordinator), "I'm a Snackbar", Snackbar.LENGTH_LONG).setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Snackbar Action", Toast.LENGTH_LONG).show();
                    }
                }).show();
            }
        });

        //TabLayout
        /**
         * ViewPager的功能可以使视图滑动，需要一个适配器， PagerAdapter
         * 三步使用：
         * 1.在主布局中加入 ，如果不加载xml，他不会显示任何内容
         * 2.加载显示的页卡
         * 3.在Activity中实例化ViewPager组件，并设置他的Adapter（就是PagerAdapter，跟ListView相似，）
         * 一般要重写PagerAdapter
         *
         * ViewPager最好跟Fragment一起使用
         */
        DesignDemoPagerAdapter adapter = new DesignDemoPagerAdapter(getSupportFragmentManager(), this);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            assert tab != null;
            tab.setCustomView(adapter.getTabView(i));
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        switch (item.getItemId()) {
            case R.id.action_edit:
                msg += "Click edit";
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_share:
                msg += "Click share";
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                msg += "Click setting";
                break;
            default:
                break;
        }

        if (msg.equals("")) {
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    /**
     * 点击退出程序
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (System.currentTimeMillis() - clickTime > 2000) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            clickTime = System.currentTimeMillis();
        } else {
//            Toast.makeText(this, "exit application", Toast.LENGTH_SHORT).show();
            this.finish();

        }
    }
}
