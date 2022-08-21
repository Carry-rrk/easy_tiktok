package com.qxy.cof;

import android.graphics.drawable.BitmapDrawable;

import java.util.Vector;

public class personal_info
{
    private String nickname;
    private BitmapDrawable avatar;
    private BitmapDrawable bigAvatar;

    private int followers;
    private int follows;
    private String location;
    private Vector<video_Item> video;

    public personal_info(String nickname, BitmapDrawable avatar, BitmapDrawable bigAvatar, int followers, int follows, String location, Vector<video_Item> video) {
        this.nickname = nickname;
        this.avatar = avatar;
        this.bigAvatar = bigAvatar;
        this.followers = followers;
        this.follows = follows;
        this.location = location;
        this.video = video;
    }

    public BitmapDrawable getBigAvatar() {
        return bigAvatar;
    }

    public void setBigAvatar(BitmapDrawable bigAvatar) {
        this.bigAvatar = bigAvatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public BitmapDrawable getAvatar() {
        return avatar;
    }

    public void setAvatar(BitmapDrawable avatar) {
        this.avatar = avatar;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollows() {
        return follows;
    }

    public void setFollows(int follows) {
        this.follows = follows;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Vector<video_Item> getVideo() {
        return video;
    }

    public void setVideo(Vector<video_Item> video) {
        this.video = video;
    }
}
