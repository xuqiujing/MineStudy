package com.example.minestudy;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */

public class MyPagerAdapter extends PagerAdapter {
    List<View> mData = new ArrayList<View>();
    List<String> mTitle = new ArrayList<String>();

    public void setmData(List<View> data){
        mData = data;
    }

    public void setmTitle(List<String> mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mData.get(position));
        return mData.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mData.get(position));
    }
}
