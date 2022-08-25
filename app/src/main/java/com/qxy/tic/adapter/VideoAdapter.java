package com.qxy.tic.adapter;

import android.content.Context;
import android.icu.text.DecimalFormat;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.qxy.tic.R;
import com.qxy.tic.bean.Bean;
import com.qxy.tic.Util.CusVideoView;


import java.io.IOException;
import java.util.List;

import cn.jzvd.JZDataSource;
import cn.jzvd.Jzvd;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private Context context;
    private int [] videos={R.raw.hmbb,R.raw.mkbk,R.raw.mq};
    private List<Bean.ItemListBean> datas;

    public VideoAdapter(Context context, List<Bean.ItemListBean> mDatas) {
        this.context = context;
        this.datas = mDatas;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_main_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Bean.ItemListBean itemListBean = datas.get(position);

        holder.mTitle.setText(itemListBean.getTitle());
        String iconURL = itemListBean.getAvatar_large();
        if (!TextUtils.isEmpty(iconURL)) {
            Glide.with(context).load(iconURL).into(holder.mPhoto);
        }
        holder.mHeart.setText(deal(itemListBean.getLike()));
        holder.mReply.setText(deal(itemListBean.getReply()));
        holder.mVideoView.setVideoURI(Uri.parse("android.resource://" + context.getPackageName() + "/" + videos[position % 3]));
        holder.mDate.setText("发布日期：" + itemListBean.getDate());
        holder.mShare.setText(deal(itemListBean.getShare()));
        holder.mPlay.setText("累计播放" + itemListBean.getPlay() + "次");
        holder.mMarquee.setText(itemListBean.getUsername() + "创作的原声-" + itemListBean.getUsername());
        holder.mMarquee.setSelected(true);
        String thumbURL = itemListBean.getImage();
    }

    public String deal(String tmp) {
        String string;

        int a = Integer.parseInt(tmp);
        if (a >= 1000) {
            Log.e("deal", tmp);
            double tag = Integer.parseInt(tmp) / 1000.0;
            DecimalFormat df = new DecimalFormat("#.0");
            string = df.format(tag) + "w";
        } else {
            string = tmp;
        }

        return string;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout mRootView;
        ImageView mThumb;
        TextView mDate;
        ImageView mPhoto;
        TextView mTitle;
        TextView mHeart;
        TextView mReply;
        TextView mMarquee;
        CusVideoView mVideoView;
        TextView mShare;
        TextView mPlay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mRootView = itemView.findViewById(R.id.mRootView);
            mThumb = itemView.findViewById(R.id.mThumb);
            mPlay = itemView.findViewById(R.id.mPlay);
            mPhoto = itemView.findViewById(R.id.item_iv);
            mVideoView = itemView.findViewById(R.id.mVideoView);
            mTitle = itemView.findViewById(R.id.mTitle);
            mHeart = itemView.findViewById(R.id.heart);
            mReply = itemView.findViewById(R.id.replay);
            mShare = itemView.findViewById(R.id.share);
            mMarquee = itemView.findViewById(R.id.mMarquee);
            mDate = itemView.findViewById(R.id.mDate);

        }
    }

    public JZDataSource VideoInit(int i){
        String name="";
        if (i%3==1){
            name= "raw/mq.mp4";
        }else if (i%3==2){
            name= "raw/mkbk.mp4";

        }else{

            name= "raw/hmbb.mp4";
        }
        JZDataSource jzDataSource = null;
        try {
            jzDataSource = new JZDataSource(context.getAssets().openFd(name));
            jzDataSource.title = "";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  jzDataSource;
    }

}