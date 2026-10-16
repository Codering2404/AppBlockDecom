package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface ILineDataSet extends ILineRadarDataSet<Entry> {
    int I0(int i3);

    boolean L0();

    float N0();

    int R();

    boolean S0();

    IFillFormatter X();

    DashPathEffect g0();

    boolean i();

    int k();

    float l0();

    float n();

    LineDataSet.Mode o0();
}
