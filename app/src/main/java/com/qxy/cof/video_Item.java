package com.qxy.cof;

import android.graphics.drawable.BitmapDrawable;

public class video_Item {
    BitmapDrawable videoCover;
    String realUrl;
    String title;
    int comment_count;
    int digg_count;
    int download_count;
    int forward_count;
    int play_count;
    int share_count;

    @Override
    public String toString() {
        return "video_Item{" +
                "videoCover=" + videoCover +
                ", realUrl='" + realUrl + '\'' +
                ", title='" + title + '\'' +
                ", comment_count=" + comment_count +
                ", digg_count=" + digg_count +
                ", download_count=" + download_count +
                ", forward_count=" + forward_count +
                ", play_count=" + play_count +
                ", share_count=" + share_count +
                '}';
    }

    public video_Item(BitmapDrawable videoCover, String realUrl, String title, int comment_count, int digg_count, int download_count, int forward_count, int play_count, int share_count) {
        this.videoCover = videoCover;
        this.realUrl = realUrl;
        this.title = title;
        this.comment_count = comment_count;
        this.digg_count = digg_count;
        this.download_count = download_count;
        this.forward_count = forward_count;
        this.play_count = play_count;
        this.share_count = share_count;
    }

    public BitmapDrawable getVideoCover() {
        return videoCover;
    }

    public void setVideoCover(BitmapDrawable videoCover) {
        this.videoCover = videoCover;
    }

    public String getRealUrl() {
        return realUrl;
    }

    public void setRealUrl(String realUrl) {
        this.realUrl = realUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getDigg_count() {
        return digg_count;
    }

    public void setDigg_count(int digg_count) {
        this.digg_count = digg_count;
    }

    public int getDownload_count() {
        return download_count;
    }

    public void setDownload_count(int download_count) {
        this.download_count = download_count;
    }

    public int getForward_count() {
        return forward_count;
    }

    public void setForward_count(int forward_count) {
        this.forward_count = forward_count;
    }

    public int getPlay_count() {
        return play_count;
    }

    public void setPlay_count(int play_count) {
        this.play_count = play_count;
    }

    public int getShare_count() {
        return share_count;
    }

    public void setShare_count(int share_count) {
        this.share_count = share_count;
    }
}
