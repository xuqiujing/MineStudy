package com.example.minestudy;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private MyPagerAdapter myPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager)findViewById(R.id.vp_main_page);
        myPagerAdapter = new MyPagerAdapter();
        setupViewPager();
    }

    private void setupViewPager(){
        List<View> list = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        list.add(li.inflate(R.layout.layout_viewpager_one, null));
        list.add(li.inflate(R.layout.layout_viewpager_two, null));
        list.add(li.inflate(R.layout.layout_viewpager_three, null));
        List<String> title = Arrays.asList("Page 1", "Page 2", "Page 3");

        myPagerAdapter.setmData(list);
        myPagerAdapter.setmTitle(title);
        mViewPager.setAdapter(myPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Toast.makeText(MainActivity.this, "onPageScrolled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(MainActivity.this, "onPageSelected page="+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Toast.makeText(MainActivity.this, "onPageScrollStateChanged state="+state, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
