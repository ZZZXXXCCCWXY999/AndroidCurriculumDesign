package com.example.newsclient.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsclient.Model.NewsData;
import com.example.newsclient.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MJ
 * @description:
 * @date :2020/6/14 22:10
 */
public class MyListAdapter extends BaseAdapter {
    private List<NewsData> datas=new ArrayList<NewsData>();
    private Context context;
    private LayoutInflater layoutInflater;
    public MyListAdapter(Context context,List<NewsData> datas){
        this.datas=datas;
        this.context=context;
        this.layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            view=  layoutInflater.inflate(R.layout.item_news_list,null);
            view.setTag(new ViewHolder(view));
        }
        intiViews((NewsData) getItem(i),(ViewHolder)view.getTag());
        return view;
    }
    private void intiViews(NewsData data,ViewHolder holder){
        holder.tvTitle.setText(data.getNewsTitle());
        holder.tvDate.setText(data.getNewsDate());
    }
    protected  class ViewHolder{
        private TextView tvTitle;
        private TextView tvDate;
        public ViewHolder(View view ){
            tvTitle=(TextView)view.findViewById(R.id.title_tv);
            tvDate=(TextView)view.findViewById(R.id.date_tv);
        }
    }
}

