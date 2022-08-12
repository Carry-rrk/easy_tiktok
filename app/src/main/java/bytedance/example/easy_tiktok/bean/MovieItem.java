package bytedance.example.easy_tiktok.bean;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import bytedance.example.easy_tiktok.BR;

public class MovieItem extends BaseObservable {

    Drawable img;//图片
    String title;//电影名称
    String score;//豆瓣评分
    String mark;//标记、电影类别
    String timeOn;//上映时间
    String hots;//热度

    public MovieItem(Drawable img, String title, String score, String mark, String timeOn, String hots) {
        this.img = img;
        this.title = title;
        this.score = score;
        this.mark = mark;
        this.timeOn = timeOn;
        this.hots = hots;
    }

    @Bindable
    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
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

    @Bindable
    public String getHots() {
        return hots;
    }

    public void setHots(String hots) {
        this.hots = hots;
        notifyPropertyChanged(BR.hots);
    }
}
