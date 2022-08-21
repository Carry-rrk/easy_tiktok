package com.qxy.cof;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class userinfo_tools {
    private String acess_token = "act.600df9cbeda54e05152aed6caacc738728uGbwsTBITBCysjePDAzn09PGqq";
    private String open_id = "_0008n4jVtq4e6qQR8e9lEbgyQrCHgtzJBCo";
    OkHttpClient httpClient = new OkHttpClient.Builder().build();
    public Bitmap getURLimage(String url) {
        Bitmap bmp = null;
        try {
            URL myurl = new URL(url);
            // 获得连接
            HttpURLConnection conn = (HttpURLConnection) myurl.openConnection();
            conn.setConnectTimeout(6000);//设置超时
            conn.setDoInput(true);
            conn.setUseCaches(false);//不缓存
            conn.connect();
            InputStream is = conn.getInputStream();//获得图片的数据流
            bmp = BitmapFactory.decodeStream(is);//读取图像数据
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bmp;
    }
    public Vector<fans_or_follows> getFollows()
    {
        final int[] cursor = {0};
        Vector<fans_or_follows> res = new Vector<>();
        final boolean[] hasnext = {true};
        while (hasnext[0]) {
            final String[] respStr = new String[1];
            Request re = new Request.Builder()
                    .url("https://open.douyin.com//following//list//?open_id=" + open_id + "&cursor=" + String.valueOf(cursor[0])+"&count=10&")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("access-token", acess_token)
                    .get()
                    .build();
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Response resp = httpClient.newCall(re).execute();
                        respStr[0] = resp.body().string();
                        JSONObject data = new JSONObject(respStr[0]).getJSONObject("data");
                        JSONArray ls = data.getJSONArray("list");
//                        Log.d("rrkdebug",respStr[0]);
                        hasnext[0] = data.getBoolean("has_more");
//                        hasnext[0] = false;
                        for(int i=0;i<ls.length();i++)
                        {
                            JSONObject tmp = ls.getJSONObject(i);
                            res.add(new fans_or_follows(new BitmapDrawable(getURLimage(tmp.getString("avatar"))),tmp.getString("nickname"),tmp.getString("open_id"), tmp.getInt("gender")));
                        }
                        cursor[0] =data.getInt("cursor");
//                    Log.d("rrkdebug", "run: "+respStr[0]);
                    } catch (Exception e) {
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
        return res;
    }
    public Vector<fans_or_follows> getFans()
    {
        final int[] cursor = {0};
        Vector<fans_or_follows> res = new Vector<>();
        final boolean[] hasnext = {true};
        while (hasnext[0]) {
            final String[] respStr = new String[1];
            Request re = new Request.Builder()
                    .url("https://open.douyin.com//fans//list//?open_id=" + open_id + "&cursor=" + String.valueOf(cursor[0])+"&count=10&")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("access-token", acess_token)
                    .get()
                    .build();
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Response resp = httpClient.newCall(re).execute();
                        respStr[0] = resp.body().string();
                        JSONObject data = new JSONObject(respStr[0]).getJSONObject("data");
                        JSONArray ls = data.getJSONArray("list");
                        Log.d("rrkdebug",respStr[0]);
//                        hasnext[0] = data.getBoolean("has_more");
//                        hasnext[0] = false;
                        for(int i=0;i<ls.length();i++)
                        {
                            JSONObject tmp = ls.getJSONObject(i);
                            res.add(new fans_or_follows(new BitmapDrawable(getURLimage(tmp.getString("avatar"))),tmp.getString("nickname"),tmp.getString("open_id"), tmp.getInt("gender")));
                        }
                        cursor[0] =data.getInt("cursor");
//                    Log.d("rrkdebug", "run: "+respStr[0]);
                    } catch (Exception e) {
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
        return res;
    }
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
