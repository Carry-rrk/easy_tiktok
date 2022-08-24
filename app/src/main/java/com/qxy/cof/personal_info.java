package com.qxy.cof;

import android.graphics.drawable.BitmapDrawable;

import java.util.Vector;

public class personal_info
{
    private String nickname;
    private BitmapDrawable avatar;
    private BitmapDrawable bigAvatar;

    private Vector<fans_or_follows> fans;
    private Vector<fans_or_follows> follows;
    private String location;
    private Vector<video_Item> video;



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

    public personal_info(String nickname, BitmapDrawable avatar, BitmapDrawable bigAvatar, Vector<fans_or_follows> followers, Vector<fans_or_follows> fans, String location, Vector<video_Item> video) {
        this.nickname = nickname;
        this.avatar = avatar;
        this.bigAvatar = bigAvatar;
        this.fans = fans;
        this.follows = follows;
        this.location = location;
        this.video = video;
    }

    public Vector<fans_or_follows> getFans() {
        return fans;
    }

    public void setFans(Vector<fans_or_follows> fans) {
        this.fans = fans;
    }

    public Vector<fans_or_follows> getFollows() {
        return follows;
    }

    public void setFollows(Vector<fans_or_follows> follows) {
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

    @Override
    public String toString() {
        return "personal_info{" +
                "nickname='" + nickname + '\'' +
                ", avatar=" + avatar +
                ", bigAvatar=" + bigAvatar +
                ", fans=" + fans +
                ", follows=" + follows +
                ", location='" + location + '\'' +
                ", video=" + video +
                '}';
    }
}
