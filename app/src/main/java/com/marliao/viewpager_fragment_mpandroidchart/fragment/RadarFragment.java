package com.marliao.viewpager_fragment_mpandroidchart.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.marliao.viewpager_fragment_mpandroidchart.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class RadarFragment extends Fragment {


    private RadarChart radarchart;

    public RadarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_radar, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        radarchart = (RadarChart) view.findViewById(R.id.radarchart);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRadarChartData();
    }

    private void initRadarChartData() {

        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            xValues.add(i + 1 + "月");
        }
        RadarData radarData = new RadarData(xValues);
        Random random = new Random();
        ArrayList<Entry> yValues1 = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            yValues1.add(new Entry(random.nextInt(50), i));
        }
        RadarDataSet radarDataSet = new RadarDataSet(yValues1, "温度");
        radarDataSet.setDrawFilled(true);
        radarData.addDataSet(radarDataSet);
        radarData.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
                return "";
            }
        });

        radarchart.setDescription("这是一个小Demo");

        radarchart.setData(radarData);
        radarchart.invalidate();
    }
}
