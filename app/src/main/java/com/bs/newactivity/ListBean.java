package com.bs.newactivity;

/**
 * Created by admin on 2019/3/8.
 */

public class ListBean {
    private String mText;
    private int mCurrentPos;
    private String mCurrentData;
    public ListBean(String text){
        this.mText = text;
    }
    public ListBean(){}


    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public int getmCurrentPos() {
        return mCurrentPos;
    }

    public void setmCurrentPos(int mCurrentPos) {
        this.mCurrentPos = mCurrentPos;
    }

    public String getmCurrentData() {
        return mCurrentData;
    }

    public void setmCurrentData(String mCurrentData) {
        this.mCurrentData = mCurrentData;
    }
}
