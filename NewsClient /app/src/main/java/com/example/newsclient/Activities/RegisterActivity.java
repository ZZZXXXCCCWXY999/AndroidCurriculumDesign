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
import com.example.newsclient.R;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    private EditText username_et;
    private EditText password_et;
    private Button register_bt;
    private String URL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username_et = (EditText) findViewById(R.id.username_et);
        password_et = (EditText) findViewById(R.id.password_et);
        register_bt = (Button) findViewById(R.id.register_bt);
        URL="http://192.168.0.24:8080/register";
        register_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getDatas();
            }
        });
    }
    private void getDatas(){
        final RequestQueue mQueue= Volley.newRequestQueue(this);
	 // <span style="color:#ff0000;"> //封装请求参数 </span>
                JSONObject jsonStr=new JSONObject();
        try {
            jsonStr.put("username",username_et.getText().toString());
            jsonStr.put("password",password_et.getText().toString());
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST,URL
                ,jsonStr, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                // TODO Auto-generated method stub
                JSONObject jsonObject;
                try {
                    String result=response.getString("isok");
                    if(result=="true"){
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(RegisterActivity.this, MainActivity.class);
                        RegisterActivity.this.startActivity(intent);
                    }else {
                        Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        },new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                Log.e("TAG", "onErrorResponse: ");
            }
        });
        mQueue.add(jsonObjectRequest);


    }
}
