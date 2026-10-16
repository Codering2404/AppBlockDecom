package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PercentFormatter extends ValueFormatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DecimalFormat f68570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PieChart f68571b;

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String f(float f3) {
        return this.f68570a.format(f3) + " %";
    }

    @Override // com.github.mikephil.charting.formatter.ValueFormatter
    public String g(float f3, PieEntry pieEntry) {
        PieChart pieChart = this.f68571b;
        return (pieChart == null || !pieChart.L()) ? this.f68570a.format(f3) : f(f3);
    }
}
