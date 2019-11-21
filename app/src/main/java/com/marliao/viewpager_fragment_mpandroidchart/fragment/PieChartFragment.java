package com.marliao.viewpager_fragment_mpandroidchart.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.marliao.viewpager_fragment_mpandroidchart.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class PieChartFragment extends Fragment {


    private PieChart piechart;

    public PieChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pie_chart, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        piechart = (PieChart) view.findViewById(R.id.piechart);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPieChartData();
    }

    private void initPieChartData() {
        ArrayList<String> xValues = new ArrayList<>();
        xValues.add("淮南一中");
        xValues.add("淮南二中");
        xValues.add("淮南三中");
        xValues.add("淮南四中");
        PieData pieData = new PieData(xValues);

        ArrayList<Entry> yValues = new ArrayList<>();
        Random random = new Random();
        yValues.add(new Entry(15, 0));
        yValues.add(new Entry(1, 1));
        yValues.add(new Entry(11, 2));
        yValues.add(new Entry(41, 3));
        PieDataSet pieDataSet = new PieDataSet(yValues, "高中");
        pieDataSet.setColors(new int[]{0xff4169E1, 0xffdc143c, 0xffADFF2F, 0xff483D8B});
        pieData.setDataSet(pieDataSet);

        pieData.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
                return "";
            }
        });

        Legend legend = piechart.getLegend();
        legend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);
        legend.setTextSize(30);
//        legend.setForm(Legend.LegendForm.LINE);
//        legend.setForm(Legend.LegendForm.SQUARE);
        legend.setForm(Legend.LegendForm.CIRCLE);

        piechart.setDrawHoleEnabled(false);

        piechart.setDescription("这是一个demo");
        piechart.setDrawSliceText(false);

        piechart.setData(pieData);
        piechart.invalidate();
    }
}
