package bytedance.example.easy_tiktok.bean;

import android.graphics.drawable.Drawable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import bytedance.example.easy_tiktok.BR;

public class ShowItem extends BaseObservable {

    Drawable img;//图片
    String title;//名称
    String actor;//演员列表
    String mark;//标记、集数
    String timeOn;//播出时间
    String hots;//热度

    public ShowItem(Drawable img, String title, String actor, String mark, String timeOn, String hots) {
        this.img = img;
        this.title = title;
        this.actor = actor;
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
    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
        notifyPropertyChanged(BR.actor);
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
