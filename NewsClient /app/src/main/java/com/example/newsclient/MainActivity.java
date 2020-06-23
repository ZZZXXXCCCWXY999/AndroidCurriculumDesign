package com.example.newsclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.newsclient.Activities.LoginActivity;
import com.example.newsclient.Activities.NewsInfoActivity;
import com.example.newsclient.Adapter.MyListAdapter;
import com.example.newsclient.Model.NewsData;
import com.example.newsclient.Util.NewsNetWork;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String URL="http://192.168.0.24:8080/news";
    private ListView listView;
    private List<NewsData> datas;
    private MyListAdapter adapter;
    private NewsNetWork newsNetWork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)this.findViewById(R.id.news_list);
        datas=new ArrayList<NewsData>();
        newsNetWork=new NewsNetWork();

        getDatas(URL);
        adapter = new MyListAdapter(this, datas);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this, NewsInfoActivity.class);
                intent.putExtra("newsTitle",datas.get(i).getNewsTitle());
                intent.putExtra("newsDate",datas.get(i).getNewsDate());
                intent.putExtra("newsContent",datas.get(i).getNewsContext());
                MainActivity.this.startActivity(intent);
            }
        });

    }
    private void getDatas(String url) {
        Log.e("tag","getDatas");
        final RequestQueue mQueue= Volley.newRequestQueue(this);
        JsonObjectRequest stringRequest=new JsonObjectRequest(Request.Method.GET,url,null , new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                   // Log.e("tagg","onResponse");
                    //SONObject jsonObject2 = response.getJSONObject("object");
                    JSONArray jsonArray = response.getJSONArray("object");
                    Log.e("tagg","sonArray");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject item = jsonArray.getJSONObject(i);
                        NewsData data = new NewsData();
                        data.setNewsTitle(item.getString("title"));
                        data.setNewsDate(item.getString("date"));
                        data.setNewsContext(item.getString("message"));
                        //Log.e("tag",item.getString("url"));
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
                //System.out.println(error);
                Log.e("tagg","Error");

            }
        });
        mQueue.add(stringRequest);
    }
}
