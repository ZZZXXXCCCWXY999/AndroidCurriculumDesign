package com.example.newsclient.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.newsclient.MainActivity;
import com.example.newsclient.Model.NewsData;
import com.example.newsclient.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText username_et;
    private EditText password_et;
    private Button login_bt;
    private Button register_bt;
    private String URL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username_et = (EditText) findViewById(R.id.username_et);
        password_et = (EditText) findViewById(R.id.password_et);
        login_bt = (Button) findViewById(R.id.login_bt);
        register_bt = (Button) findViewById(R.id.register_bt);
        URL="http://192.168.0.24:8080/login?username";
        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               URL=URL+"="+username_et.getText()+"&password="+password_et.getText();
               getDatas(URL);
                URL="http://192.168.0.24:8080/login?username";
            }
        });
        register_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        });
    }
    private void getDatas(String url) {
        final RequestQueue mQueue= Volley.newRequestQueue(this);
        JsonObjectRequest stringRequest=new JsonObjectRequest(Request.Method.GET,url,null , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //Toast.makeText(LoginActivity.this, "true", Toast.LENGTH_SHORT).show();
                try {
                    String result=response.getString("isok");
                    if(result=="true"){
                        Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                       LoginActivity.this.startActivity(intent);

                    }else {
                        Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    }
//                    JSONArray jsonArray = response.getJSONArray("object");
//                    Log.e("tagg","sonArray");
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        JSONObject item = jsonArray.getJSONObject(i);
//                        NewsData data = new NewsData();
//                        data.setNewsTitle(item.getString("title"));
//                        data.setNewsDate(item.getString("date"));
//                        data.setNewsContext(item.getString("message"));
//                        //Log.e("tag",item.getString("url"));
//                        datas.add(data);
//                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("tagg","Error");

            }
        });
        mQueue.add(stringRequest);
    }

}
