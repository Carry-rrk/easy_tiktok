package com.qxy.tic.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.qxy.tic.Util.CusVideoView;
import com.qxy.tic.Util.CustomLayoutManager;
import com.qxy.tic.Util.JsonUti;
import com.qxy.tic.R;
import com.qxy.tic.Util.OnPageSlideListener;
import com.qxy.tic.adapter.VideoAdapter;
import com.qxy.tic.bean.Bean;

import org.json.JSONArray;

import java.util.List;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class MainActivity extends AppCompatActivity {

    private List<Bean.ItemListBean> datas;
    private CustomLayoutManager mLayoutManager;
    private RecyclerView recyclerView;
    private VideoAdapter mAdapter;

    public MainActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        initView();
        initListener();
    }

    //初始化监听
    private void initListener() {
        mLayoutManager.setOnPageSlideListener(new OnPageSlideListener() {
            @Override
            public void onPageRelease(boolean isNext, int position) {
                int index;
                if (isNext) {
                    index = 0;
                } else {
                    index = 1;
                }
                releaseVideo(index);
            }

            @Override
            public void onPageSelected(int position, boolean isNext) {
                playVideo();
            }
        });
    }


    private void playVideo() {
        View itemView = recyclerView.getChildAt(0);
        final CusVideoView mVideoView = itemView.findViewById(R.id.mVideoView);
        final ImageView mPlay = itemView.findViewById(R.id.play_photo);
        final ImageView mThumb = itemView.findViewById(R.id.mThumb);
        final MediaPlayer[] mMediaPlayer = new MediaPlayer[1];
        mVideoView.start();
        mVideoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                mMediaPlayer[0] = mp;
                mp.setLooping(true);
                mThumb.animate().alpha(0).setDuration(200).start();
                return false;
            }
        });

        //暂停控制
        mPlay.setOnClickListener(new View.OnClickListener() {
            boolean isPlaying = true;

            @Override
            public void onClick(View v) {
                if (mVideoView.isPlaying()) {
                    mPlay.animate().alpha(1f).start();
                    mVideoView.pause();
                    isPlaying = false;
                } else {
                    mPlay.animate().alpha(0f).start();
                    mVideoView.start();
                    isPlaying = true;
                }
            }
        });
    }

    private void releaseVideo(int index) {
        View itemView = recyclerView.getChildAt(index);
        final CusVideoView mVideoView = itemView.findViewById(R.id.mVideoView);
        final ImageView mThumb = itemView.findViewById(R.id.mThumb);
        final ImageView mPlay = itemView.findViewById(R.id.play_photo);
        mVideoView.stopPlayback();
        mThumb.animate().alpha(1).start();
        mPlay.animate().alpha(0f).start();
    }

    //初始化View
    private void initView() {
        recyclerView = findViewById(R.id.RecyclerView);
        mLayoutManager = new CustomLayoutManager(this, OrientationHelper.VERTICAL, false);
        Fix();
        Log.e("TAG",datas.size()+"");
        mAdapter = new VideoAdapter(this, datas);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }


    private void Fix() {
        String json = JsonUti.getJson(this,"test.json");
        Log.e("test",json);
        Bean bean=new Gson().fromJson(json,Bean.class);
        datas = bean.getItemList();
    }

}