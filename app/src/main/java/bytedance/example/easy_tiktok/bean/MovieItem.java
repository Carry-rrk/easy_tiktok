package bytedance.example.easy_tiktok.bean;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import java.util.Vector;

import bytedance.example.easy_tiktok.BR;

public class MovieItem extends BaseObservable {

    Vector<String> actors;
    Vector<String> directors;
    long discussion_hot;
    long hot;
    long influence_hot;
    String id;
    String score;
    String title;//电影名称
    String name_en;
    BitmapDrawable img;//图片
    String timeOn;//上映时间
    String search_hot;
    long topic_hot;
    String mark;//标记、电影类别

    public MovieItem(Vector<String> actors, Vector<String> directors, long discussion_hot, long hot, long influence_hot, String id, String score, String title, String name_en, BitmapDrawable img, String timeOn, String search_hot, long topic_hot, String mark) {
        this.actors = actors;
        this.directors = directors;
        this.discussion_hot = discussion_hot;
        this.hot = hot;
        this.influence_hot = influence_hot;
        this.id = id;
        this.score = score;
        this.title = title;
        this.name_en = name_en;
        this.img = img;
        this.timeOn = timeOn;
        this.search_hot = search_hot;
        this.topic_hot = topic_hot;
        this.mark = mark;
    }

    @Bindable
    public Drawable getImg() {
        return img;
    }

    public void setImg(BitmapDrawable img) {
        this.img = img;
        notifyPropertyChanged(BR.img);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
        notifyPropertyChanged(BR.score);
    }

    @Bindable
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
        notifyPropertyChanged(BR.mark);
    }

    @Bindable
    public String getTimeOn() {
        return timeOn;
    }

    public void setTimeOn(String timeOn) {
        this.timeOn = timeOn;
        notifyPropertyChanged(BR.timeOn);
    }

//    @Bindable
//    public String getHots() {
//        return String.valueOf(search_hot);
//    }
//
//    public void setHots(String hot) {
//        this.hot = Integer.parseInt(search_hot);
//        notifyPropertyChanged(BR.hots);
//    }

    @Bindable
    public String getSearch_hot() {
        return search_hot;
    }

    public void setSearch_hot(String search_hot) {
        this.search_hot = search_hot;
        notifyPropertyChanged(BR.search_hot);
    }
}
