package com.github.mikephil.charting.data;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LineScatterCandleRadarDataSet<T extends Entry> extends BarLineScatterCandleBubbleDataSet<T> implements ILineScatterCandleRadarDataSet<T> {
    protected float A;
    protected DashPathEffect B;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected boolean f68550y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected boolean f68551z;

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public boolean N() {
        return this.f68550y;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public boolean P0() {
        return this.f68551z;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public float e0() {
        return this.A;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet
    public DashPathEffect w0() {
        return this.B;
    }
}
