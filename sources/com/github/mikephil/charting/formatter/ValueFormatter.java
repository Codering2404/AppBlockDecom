package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarEntry;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ValueFormatter implements IAxisValueFormatter, IValueFormatter {
    public String a(float f3, AxisBase axisBase) {
        return f(f3);
    }

    public String b(BarEntry barEntry) {
        return f(barEntry.e());
    }

    public String c(float f3, BarEntry barEntry) {
        return f(f3);
    }

    public String d(BubbleEntry bubbleEntry) {
        return f(bubbleEntry.i());
    }

    public String e(CandleEntry candleEntry) {
        return f(candleEntry.j());
    }

    public String f(float f3) {
        return String.valueOf(f3);
    }

    public String g(float f3, PieEntry pieEntry) {
        return f(f3);
    }

    public String h(Entry entry) {
        return f(entry.e());
    }

    public String i(RadarEntry radarEntry) {
        return f(radarEntry.e());
    }
}
