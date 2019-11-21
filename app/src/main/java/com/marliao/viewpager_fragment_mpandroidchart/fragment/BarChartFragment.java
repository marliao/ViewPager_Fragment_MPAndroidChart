package com.marliao.viewpager_fragment_mpandroidchart.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.marliao.viewpager_fragment_mpandroidchart.R;
import com.marliao.viewpager_fragment_mpandroidchart.view.MyMarkerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class BarChartFragment extends Fragment {


    private BarChart barchart;

    public BarChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bar_chart, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        barchart = (BarChart) view.findViewById(R.id.barchart);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initBarChartData();
    }

    private void initBarChartData() {
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            xValues.add(i + 1 + "月");
        }
        BarData barData = new BarData(xValues);
        Random random = new Random();
        ArrayList<BarEntry> yValues1 = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            yValues1.add(new BarEntry(random.nextInt(50), i));
        }
        BarDataSet barDataSet1 = new BarDataSet(yValues1, "温度");
        barDataSet1.setColor(0xffDC143C);
        barDataSet1.setHighlightEnabled(true);
        barData.addDataSet(barDataSet1);
        ArrayList<BarEntry> yValues2 = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            yValues2.add(new BarEntry(random.nextInt(50), i));
        }
        BarDataSet barDataSet2 = new BarDataSet(yValues2, "湿度");
        barData.addDataSet(barDataSet2);
        barData.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
                float val = entry.getVal();
                DecimalFormat df = new DecimalFormat("##");
                return df.format(val);
            }
        });

        XAxis xAxis = barchart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);

        YAxis axisRight = barchart.getAxisRight();
        axisRight.setDrawAxisLine(false);
        axisRight.setDrawGridLines(false);
        axisRight.setDrawLabels(false);

        YAxis axisLeft = barchart.getAxisLeft();
        axisLeft.setAxisMaxValue(50);
        axisLeft.setAxisMinValue(0);
        axisLeft.setDrawGridLines(false);

        barchart.setDrawBorders(false);
        barchart.setDrawGridBackground(false);

        MyMarkerView myMarkerView = new MyMarkerView(getActivity(), R.layout.marker_view);
        barchart.setMarkerView(myMarkerView);
        barchart.setDescription("这是一个demo");

        barchart.setData(barData);
        barchart.invalidate();
    }
}
