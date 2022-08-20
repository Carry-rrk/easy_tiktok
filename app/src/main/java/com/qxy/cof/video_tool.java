package com.qxy.cof;

import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class video_tool {

    private String acess_token = "act.37bb89f60920314589967ef51a6ce43dgohgpUBjMsuxPzbxdQfyJiwaTFAT";
    private String open_id = "_000HnpKgd17bqZQxq02KjnYFYfYsLfLs2AF";
    OkHttpClient httpClient = new OkHttpClient.Builder().build();
    public void get_list()
    {
        final String[] respStr = new String[1];
        Request re = new Request.Builder()
                .url("https://open.douyin.com//video//list//?open_id="+open_id+"&count=10")
                .addHeader("Content-Type", "application/json")
                .addHeader("access-token",acess_token)
                .get()
                .build();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response resp = httpClient.newCall(re).execute();
                    respStr[0] = resp.body().string();
                    Log.d("rrkdebug", "run: "+respStr[0]);
                } catch (IOException e) {
                    e.printStackTrace();
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
