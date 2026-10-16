package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultFillFormatter implements IFillFormatter {
    @Override // com.github.mikephil.charting.formatter.IFillFormatter
    public float a(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider) {
        float yChartMax = lineDataProvider.getYChartMax();
        float yChartMin = lineDataProvider.getYChartMin();
        LineData lineData = lineDataProvider.getLineData();
        if (iLineDataSet.d() > 0.0f && iLineDataSet.l() < 0.0f) {
            return 0.0f;
        }
        if (lineData.o() > 0.0f) {
            yChartMax = 0.0f;
        }
        if (lineData.q() < 0.0f) {
            yChartMin = 0.0f;
        }
        return iLineDataSet.l() >= 0.0f ? yChartMin : yChartMax;
    }
}
