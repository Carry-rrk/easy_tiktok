package com.qxy.cof;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;


import androidx.annotation.NonNull;

import java.util.List;
import java.util.Vector;


public class MovieItem  {

    Vector<String> actors;
    Vector<String> directors;
    long discussion_hot;
    long hot;
    long influence_hot;
    String id;
    String maoyan_id;
    String title;//电影名称
    String name_en;
    BitmapDrawable img;//图片
    String timeOn;//上映时间
    long search_hot;
    long topic_hot;
    String mark;//标记、电影类别\

    public MovieItem(Vector<String> actors, Vector<String> directors, long discussion_hot, long hot, long influence_hot, String id, String maoyan_id, String title, String name_en, BitmapDrawable img, String timeOn, long search_hot, long topic_hot, String mark) {
        this.actors = actors;
        this.directors = directors;
        this.discussion_hot = discussion_hot;
        this.hot = hot;
        this.influence_hot = influence_hot;
        this.id = id;
        this.maoyan_id = maoyan_id;
        this.title = title;
        this.name_en = name_en;
        this.img = img;
        this.timeOn = timeOn;
        this.search_hot = search_hot;
        this.topic_hot = topic_hot;
        this.mark = mark;
    }

    public Vector<String> getActors() {
        return actors;
    }

    public void setActors(Vector<String> actors) {
        this.actors = actors;
    }

    public Vector<String> getDirectors() {
        return directors;
    }

    public void setDirectors(Vector<String> directors) {
        this.directors = directors;
    }

    public long getDiscussion_hot() {
        return discussion_hot;
    }

    public void setDiscussion_hot(long discussion_hot) {
        this.discussion_hot = discussion_hot;
    }

    public long getHot() {
        return hot;
    }

    public void setHot(long hot) {
        this.hot = hot;
    }

    public long getInfluence_hot() {
        return influence_hot;
    }

    public void setInfluence_hot(long influence_hot) {
        this.influence_hot = influence_hot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaoyan_id() {
        return maoyan_id;
    }

    public void setMaoyan_id(String maoyan_id) {
        this.maoyan_id = maoyan_id;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public long getSearch_hot() {
        return search_hot;
    }

    public void setSearch_hot(long search_hot) {
        this.search_hot = search_hot;
    }

    public long getTopic_hot() {
        return topic_hot;
    }

    public void setTopic_hot(long topic_hot) {
        this.topic_hot = topic_hot;
    }








    public BitmapDrawable getImg() {
        return img;
    }

    public void setImg(BitmapDrawable img) {
        this.img = img;

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;

    }




    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;

    }


    public String getTimeOn() {
        return timeOn;
    }

    public void setTimeOn(String timeOn) {
        this.timeOn = timeOn;

    }

    @NonNull
    @Override
    public String toString() {
        return timeOn+title+mark+name_en+id+maoyan_id;
    }
}