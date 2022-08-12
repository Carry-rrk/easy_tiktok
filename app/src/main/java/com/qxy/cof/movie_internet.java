package com.qxy.cof;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class movie_internet {
    private String client_token ="";
        public boolean init(String clint_key,String client_serect){
            OkHttpClient httpClient = new OkHttpClient.Builder().build();
            RequestBody rb = new FormBody.Builder()
                    .add("client_secret",client_serect)
                    .add("grant_type","client_credential")
                    .add("client_key",clint_key)
                    .build();
            Request re = new Request.Builder()
                    .url("https://open.douyin.com//oauth/client_token/")
                    .addHeader("Content-Type", "multipart/form-data")
                    .post(rb)
                    .build();
            Call call = httpClient.newCall(re);
            call.enqueue(new Callback() {
                             @Override
                             public void onFailure(Call call, IOException e) {
                                 e.printStackTrace();
                                 Log.d("rrkdebug", "response:falier");
                             }

                             @Override
                             public void onResponse(Call call, okhttp3.Response response) throws IOException {
                                 String s = response.body().string();
                                 Log.d("rrkdebug", "response: " +s );
                             }
                         }
            );
            return true;
        }
}
