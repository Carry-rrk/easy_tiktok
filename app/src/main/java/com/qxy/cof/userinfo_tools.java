package com.qxy.cof;

import android.util.Log;

import org.json.JSONObject;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class userinfo_tools {
    private String acess_token = "act.37bb89f60920314589967ef51a6ce43dgohgpUBjMsuxPzbxdQfyJiwaTFAT";
    private String open_id = "_000HnpKgd17bqZQxq02KjnYFYfYsLfLs2AF";
    OkHttpClient httpClient = new OkHttpClient.Builder().build();
    public void get_user_info()
    {
        RequestBody rb = new FormBody.Builder()
                .add("access_token",acess_token)
                .add("open_id",open_id)
                .build();
        Request re = new Request.Builder()
                .url("https://open.douyin.com/oauth/userinfo/")
                .addHeader("Content-Type", "application/json")
                .post(rb)
                .build();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                {
                    Response resp;
                    String a,str;

                    {
                        try {
                            resp = httpClient.newCall(re).execute();
                            a = resp.body().string();
                            Log.d("rrkdebug", "run: "+a);
//                            str  = new JSONObject(a).getJSONObject("data").getString("access_token");

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
