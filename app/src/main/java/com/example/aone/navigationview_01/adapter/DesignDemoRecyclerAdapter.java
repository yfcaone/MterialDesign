package com.example.aone.navigationview_01.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aone.navigationview_01.R;
import com.example.aone.navigationview_01.activity.SecondActivity;
import com.example.aone.navigationview_01.comm.Http;
import com.example.aone.navigationview_01.comm.Json;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Recyclerview的适配器
 * Created by aone on 2016/7/25.
 */
public class DesignDemoRecyclerAdapter extends RecyclerView.Adapter<DesignDemoRecyclerAdapter.ViewHolder> {

    private List<String> mItems;

    private String date;

    public DesignDemoRecyclerAdapter(List<String> items) {
        this.mItems = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String item = mItems.get(position);
        holder.mTextView.setText(item);

        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                context.startActivity(new Intent(context, SecondActivity.class));
            }
        });

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                v.setBackgroundColor(0xfff11111);
//                ((TextView)( v.findViewById(R.id.list_item))).setText("进入");
//                ((TextView)(v.findViewById(R.id.list_item))).setTextColor(0xFFFF0000);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    //重写ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTextView;
        private CardView mCardView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.list_item);
            mCardView = (CardView) itemView.findViewById(R.id.cv);

        }
    }
}
