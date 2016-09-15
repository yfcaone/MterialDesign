package com.example.aone.navigationview_01.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.aone.navigationview_01.R;
import com.example.aone.navigationview_01.fragment.DesignDemoFragment;

/**
 *ViewPager的适配器
 * Created by aone on 2016/7/26.
 */
public class DesignDemoPagerAdapter extends FragmentStatePagerAdapter {

    private Context context;

    public DesignDemoPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        System.out.println("+++++++++++++++++++++position="+position);
        return DesignDemoFragment.newInstance(position);
    }


    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

    //加载显示的页卡
    public View getTabView(int position) {
        String[] tabTitleArray = {"英雄联盟", "守望先锋", "魔兽世界", "穿越火线", "使命召唤OL", "我的战争"};
        View view = LayoutInflater.from(context).inflate(R.layout.tab_item, null);
        TextView tv = (TextView) view.findViewById(R.id.tab_item1);
        tv.setText(tabTitleArray[position]);
        return view;
    }
}
