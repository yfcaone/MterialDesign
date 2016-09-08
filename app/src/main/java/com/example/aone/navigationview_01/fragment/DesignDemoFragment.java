package com.example.aone.navigationview_01.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aone.navigationview_01.R;
import com.example.aone.navigationview_01.activity.MainActivity;
import com.example.aone.navigationview_01.adapter.DesignDemoRecyclerAdapter;
import com.example.aone.navigationview_01.comm.Http;
import com.example.aone.navigationview_01.comm.Json;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 *RecyclerView 和Fragment结合
 * Created by aone on 2016/7/26.
 */
public class DesignDemoFragment extends Fragment {

    //    private MyHandler mHandler;
    private String response;
    private static final String TAB_POSITION = "tab_position";
    private List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

    private List<Map<String, Object>> itemData;

    public DesignDemoFragment() {

    }

    public static DesignDemoFragment newInstance(int tabPosition) {


        DesignDemoFragment fragment = new DesignDemoFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_POSITION, tabPosition);
        fragment.setArguments(args);
        return fragment;
    }

    //显示信息
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        dataDemo();
        Bundle args = getArguments();
        int tabPosition = args.getInt(TAB_POSITION);
        ArrayList<String> items = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            items.add("Tab #" + tabPosition + "item #" + i);
        }
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new DesignDemoRecyclerAdapter(items));
        return v;
    }


    public void dataDemo() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                response = Http.getGetstr("http://192.168.191.1:1000/ajax/Q_getquestion.ashx?title=");
                System.out.println("+++++++++++++++++++++++");
                List<Object> pragme = new ArrayList<Object>();
                pragme.add("ID");
                pragme.add("type");
                pragme.add("subtype");
                pragme.add("title");
                pragme.add("countss");

                try {
                    data = Json.get_map_list(response, "Table", pragme);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Message message = new Message();
                message.what = 1;
                System.out.println("++++++++++++++++++++++++++data" + data);
            }
        }).start();
    }
//                    Looper curLooper = Looper.myLooper();
//                    Looper mainLooper = Looper.getMainLooper();
//                    String msg;
//                    if (curLooper == null) {
//                        mHandler = new MyHandler(mainLooper);
//                        System.out.println("++++++++++++++++mHandler="+mHandler);
//                        msg = "curLooper is null";
//                    } else {
//                        mHandler = new MyHandler(curLooper);
//                        System.out.println("++++++++++++++++mHandler"+mHandler);
//                        msg = "This is curLooper";
//                    }
//                    mHandler.removeMessages(0);
//                    Message m = mHandler.obtainMessage(1, 1, 1, data);
//                    mHandler.sendMessage(m);
//                    System.out.println("+++++++++++++++++++++m=" + m);

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                System.out.println("+++++++++++++++");
            }
            super.handleMessage(msg);
        }
    };
//    private class MyHandler extends Handler {
//        public MyHandler(Looper looper) {
//            super(looper);
//        }
//
//        @Override
//        public void handleMessage(Message msg) {
//            if (msg.what == 1) {
//                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
//            }
//            String itemData = msg.obj.toString();
//            System.out.println(msg.obj.toString());
//        }
//    }
}

