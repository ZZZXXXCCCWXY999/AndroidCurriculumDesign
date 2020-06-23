package com.example.newsclient.Util;

import android.content.Context;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.newsclient.Adapter.MyListAdapter;
import com.example.newsclient.Model.NewsData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MJ
 * @description:
 * @date :2020/6/14 21:48
 */
public class NewsNetWork {
    private List<NewsData> datas;
    public static final String URL="https://v.juhe.cn/toutiao/index?type=top&key=a1a755458cc22f129942b34904feb820";
    public void getDatas(Context context, final ListView listView, final MyListAdapter adapter) {
        datas=new ArrayList<NewsData>();
        final RequestQueue mQueue= Volley.newRequestQueue(context);
        JsonObjectRequest stringRequest=new JsonObjectRequest(URL, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject jsonObject2 = response.getJSONObject("result");
                    JSONArray jsonArray = jsonObject2.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject item = jsonArray.getJSONObject(i);
                        NewsData data = new NewsData();
                        data.setNewsTitle(item.getString("title"));
                        data.setNewsDate(item.getString("date"));
                        //data.setNewsContext(item.getString("context"));
                        datas.add(data);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mQueue.add(stringRequest);
    }
}
