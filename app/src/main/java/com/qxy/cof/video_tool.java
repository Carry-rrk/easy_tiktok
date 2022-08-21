package com.qxy.cof;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class video_tool {

    private String acess_token = "act.600df9cbeda54e05152aed6caacc738728uGbwsTBITBCysjePDAzn09PGqq";
    private String open_id = "_0008n4jVtq4e6qQR8e9lEbgyQrCHgtzJBCo";
    OkHttpClient httpClient = new OkHttpClient.Builder().build();
    public JSONObject getVideoUrl(String share_url,String video_id) throws JSONException
    {
        final String[] respStr = new String[1];
        Request re = new Request.Builder()
                .url("https://query.asilu.com/aweme/info?url="+share_url+"&id="+video_id)
                .addHeader("Content-Type", "application/json")
//                .addHeader("access-token",acess_token)
                .get()
                .build();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response resp = httpClient.newCall(re).execute();
                    respStr[0] = resp.body().string();
//                    Log.d("rrkdebug", "run: "+respStr[0]);
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
        return new JSONObject(respStr[0]);
    }
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
    public Vector<video_Item> getVideo(String list) throws JSONException
    {
        Vector<video_Item> res = new Vector<>();
        JSONArray ja = null;
        ja = new JSONObject(list).getJSONObject("data").getJSONArray("list");
        for(int i=0;i<ja.length();i++)
        {
            JSONObject obj = ja.getJSONObject(i);
            String share_url = obj.getString("share_url");
            String video_id = obj.getString("video_id");
            JSONObject statics = obj.getJSONObject("statistics");
            String title = obj.getString("title");
            JSONObject video  = getVideoUrl(share_url,video_id);
            final Bitmap[] cover = new Bitmap[1];
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        cover[0] = getURLimage(video.getString("image"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
            res.add(new video_Item(new BitmapDrawable(cover[0]),video.getString("video"),title,statics.getInt("comment_count"),statics.getInt("digg_count"),statics.getInt("download_count"),statics.getInt("forward_count"),statics.getInt("play_count"),statics.getInt("share_count")));

        }
        return res;
    }


    public String get_list()
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
//                    Log.d("rrkdebug", "run: "+respStr[0]);
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
        return respStr[0];
    }
}
