package com.github.mikephil.charting.interfaces.dataprovider;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.utils.Transformer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface BarLineScatterCandleBubbleDataProvider extends ChartInterface {
    Transformer a(YAxis.AxisDependency axisDependency);

    boolean d(YAxis.AxisDependency axisDependency);

    BarLineScatterCandleBubbleData getData();

    float getHighestVisibleX();

    float getLowestVisibleX();
}
