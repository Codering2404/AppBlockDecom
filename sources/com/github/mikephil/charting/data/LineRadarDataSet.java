package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LineRadarDataSet<T extends Entry> extends LineScatterCandleRadarDataSet<T> implements ILineRadarDataSet<T> {
    private int C;
    protected Drawable D;
    private int E;
    private float F;
    private boolean G;

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public int S() {
        return this.C;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public int b() {
        return this.E;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public float g() {
        return this.F;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public boolean m0() {
        return this.G;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet
    public Drawable o() {
        return this.D;
    }
}
