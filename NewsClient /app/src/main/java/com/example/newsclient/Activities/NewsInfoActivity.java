package com.example.newsclient.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.example.newsclient.R;

public class NewsInfoActivity extends AppCompatActivity {
    private TextView tvTitle;
    private TextView tvContent;
    private TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_info);
        initViews();
    }

    private void initViews() {

        tvTitle=(TextView)this.findViewById(R.id.title_tv);
        tvDate=(TextView)this.findViewById(R.id.date_tv);
        tvContent=(TextView)this.findViewById(R.id.content_tv);
        Intent intent=this.getIntent();
        String newsTitle=intent.getStringExtra("newsTitle");
        String newsDate=intent.getStringExtra("newsDate");
        String newsContent=intent.getStringExtra("newsContent");


        tvTitle.setText(newsTitle);
        tvDate.setText(newsDate);
        tvContent.setText(newsContent);
    }

}
