package com.marliao.viewpager_fragment_mpandroidchart.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
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
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class LineChartFragment extends Fragment {


    private LineChart linechart;
    private Timer timer;
    private TimerTask timerTask;

    public LineChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_line_chart, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        linechart = (LineChart) view.findViewById(R.id.linechart);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initLineChartData();
    }

    private void initLineChartData() {
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            xValues.add(i + 1 + "月");
        }
        LineData lineData = new LineData(xValues);
        Random random = new Random();
        ArrayList<Entry> yValues1 = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            yValues1.add(new Entry(random.nextInt(50), i));
        }
        LineDataSet lineDataSet1 = new LineDataSet(yValues1, "温度");
        lineDataSet1.setColor(0xffDC143C);
        lineDataSet1.setCircleColor(0xffDC143C);
        lineDataSet1.setDrawCircleHole(false);
        lineDataSet1.setDrawFilled(true);
        lineDataSet1.setDrawCubic(true);
        lineDataSet1.setHighlightEnabled(true);
        lineData.addDataSet(lineDataSet1);
        ArrayList<Entry> yValues2 = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            yValues2.add(new Entry(random.nextInt(50), i));
        }
        LineDataSet lineDataSet2 = new LineDataSet(yValues2, "湿度");
        lineData.addDataSet(lineDataSet2);
        lineData.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
                float val = entry.getVal();
                DecimalFormat df = new DecimalFormat("##");
                return df.format(val);
            }
        });

        XAxis xAxis = linechart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);

        YAxis axisRight = linechart.getAxisRight();
        axisRight.setDrawAxisLine(false);
        axisRight.setDrawGridLines(false);
        axisRight.setDrawLabels(false);

        YAxis axisLeft = linechart.getAxisLeft();
        axisLeft.setAxisMaxValue(50);
        axisLeft.setAxisMinValue(0);
        axisLeft.setDrawGridLines(false);

        linechart.setDrawBorders(false);
        linechart.setDrawGridBackground(false);

        MyMarkerView myMarkerView = new MyMarkerView(getActivity(), R.layout.marker_view);
        linechart.setMarkerView(myMarkerView);
        linechart.setDescription("这是一个demo");

        linechart.setData(lineData);
        linechart.invalidate();
    }
}
