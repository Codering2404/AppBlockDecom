package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RadarDataSet extends LineRadarDataSet<RadarEntry> implements IRadarDataSet {
    protected boolean H;
    protected int I;
    protected int J;
    protected int K;
    protected float L;
    protected float M;
    protected float N;

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public float O() {
        return this.N;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public float U() {
        return this.L;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public int V() {
        return this.K;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public int a() {
        return this.I;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public boolean b0() {
        return this.H;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public int f() {
        return this.J;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IRadarDataSet
    public float m() {
        return this.M;
    }
}
