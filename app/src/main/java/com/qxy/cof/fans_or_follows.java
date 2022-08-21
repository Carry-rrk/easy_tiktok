package com.qxy.cof;

import android.graphics.drawable.BitmapDrawable;

public class fans_or_follows {
    BitmapDrawable avator;
    String nickname;
    String open_id;
    int sex;

    @Override
    public String toString() {
        return "fans_or_follows{" +
                "avator=" + avator +
                ", nickname='" + nickname + '\'' +
                ", open_id='" + open_id + '\'' +
                ", sex=" + sex +
                '}';
    }

    public fans_or_follows(BitmapDrawable avator, String nickname, String open_id, int sex) {
        this.avator = avator;
        this.nickname = nickname;
        this.open_id = open_id;
        this.sex = sex;
    }

    public BitmapDrawable getAvator() {
        return avator;
    }

    public void setAvator(BitmapDrawable avator) {
        this.avator = avator;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
