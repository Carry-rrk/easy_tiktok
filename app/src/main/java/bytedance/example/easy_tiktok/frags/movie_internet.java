package com.qxy.data;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;

import bytedance.example.easy_tiktok.bean.MovieItem;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class movie_internet {
    private volatile String client_token;

    public  String getClient_token() {
        return client_token;
    }
    OkHttpClient httpClient = new OkHttpClient.Builder().build();

    public void setClient_token(String ct) {
        client_token = ct;
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


    public boolean init(String clint_key,String client_serect){
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
                            str  = new JSONObject(a).getJSONObject("data").getString("access_token");
                            setClient_token(str);
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


        return getClient_token()!=null;
    }

    public Vector<String> WordSplitting(String text) {
        // 先分割单词
        Vector<String> word = new Vector<String>();
        int i =0,tmp=-1;
        while (i<text.length())
        {
            if(text.charAt(i) == '\"')
            {
                if(tmp == -1) {
                    tmp = i;
                }
                else
                {
                    word.add(text.substring(tmp,i+1));
                    tmp=-1;
                }
            }
            i++;
        }
        return word;
    }
    //type为类型， * 1 - 电影 * 2 - 电视剧 * 3 - 综艺
    public ArrayList<MovieItem> get_movielist(int type){
//            Log.d("rrkdebug",client_token);
        ArrayList<MovieItem> res = new ArrayList<MovieItem>();
        String[] list_m;
        final String[] respStr = new String[1];
        Request re = new Request.Builder()
                .url("https://open.douyin.com/discovery/ent/rank/item/?type="+String.valueOf(type))
                .addHeader("Content-Type", "application/json")
                .addHeader("access-token",client_token)
                .get()
                .build();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                        Log.d("rrkdebug","111");

                    Response resp = httpClient.newCall(re).execute();
//                        Log.d("rrkdebug","111");

                    respStr[0] = resp.body().string();
//                        Log.d("rrkdebug","111");
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
        try {
            String list_movie = new JSONObject(respStr[0]).getJSONObject("data").getString("list");
            list_movie = list_movie.substring(1,list_movie.length()-1);
            list_m =  list_movie.split("\\},");
            for(int i=0;i<list_m.length;i++){
                list_m[i]+="}";
                JSONObject mov  = new JSONObject(list_m[i]);
                String actTmp = mov.getString("actors");
                Vector<String> actors  = WordSplitting(actTmp);
                for(int j  =0;j<actors.size();j++)
                {
                    actors.set(j,actors.get(j).substring(1,actors.get(j).length()-1));
                }
                String dirTmp = mov.getString("directors");
                Vector<String> directors = WordSplitting(dirTmp);
                for(int j  =0;j<directors.size();j++)
                {
                    directors.set(j,directors.get(j).substring(1,directors.get(j).length()-1));
                }

                long dis_hot = mov.getLong("discussion_hot");
                long hot = mov.getLong("hot");
                long inf_hot = mov.getLong("influence_hot");
                String id = mov.getString("id");
                String maoyan_id = mov.getString("maoyan_id");
                String title  = mov.getString("name");
                String name_en = mov.getString("name_en");

                String poster = mov.getString("poster");
                final Bitmap[] img = new Bitmap[1];
                Thread tt = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        img[0] = getURLimage(poster);
                    }
                });
                tt.start();
                try {
                    tt.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String timeOn = mov.getString("release_date");
                long s_hot = mov.getLong("search_hot");
                long t_hot = mov.getLong("topic_hot");
                String mark = mov.getString("type");
                BitmapDrawable a = new BitmapDrawable(img[0]);
                MovieItem mm = new MovieItem(actors,directors,dis_hot,hot,inf_hot,id,maoyan_id,title,name_en,a,timeOn,s_hot,t_hot,mark);
                res.add(mm);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }



        return res;
    }
}