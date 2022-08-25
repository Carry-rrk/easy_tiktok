package com.qxy.tic.Util;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

import cn.jzvd.JzvdStd;

public class CusVideoView extends VideoView {
    public CusVideoView(Context context) {
        super(context);
    }

    public CusVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getDefaultSize(getWidth(), widthMeasureSpec);
        int height = getDefaultSize(getHeight(), heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

}

