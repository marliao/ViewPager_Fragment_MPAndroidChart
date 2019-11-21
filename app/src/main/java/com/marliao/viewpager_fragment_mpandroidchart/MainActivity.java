package com.marliao.viewpager_fragment_mpandroidchart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.marliao.viewpager_fragment_mpandroidchart.fragment.BarChartFragment;
import com.marliao.viewpager_fragment_mpandroidchart.fragment.LineChartFragment;
import com.marliao.viewpager_fragment_mpandroidchart.fragment.PieChartFragment;
import com.marliao.viewpager_fragment_mpandroidchart.fragment.RadarFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager_mpchart;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new LineChartFragment());
        fragmentList.add(new PieChartFragment());
        fragmentList.add(new BarChartFragment());
        fragmentList.add(new RadarFragment());
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
        viewpager_mpchart.setAdapter(myAdapter);
    }

    private void initView() {
        viewpager_mpchart = (ViewPager) findViewById(R.id.viewpager_mpchart);
    }

    private class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

}
