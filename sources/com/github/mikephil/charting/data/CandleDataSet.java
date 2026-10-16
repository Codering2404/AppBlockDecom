package com.github.mikephil.charting.data;

import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CandleDataSet extends LineScatterCandleRadarDataSet<CandleEntry> implements ICandleDataSet {
    private float C;
    private boolean D;
    private float E;
    private boolean F;
    protected Paint.Style G;
    protected Paint.Style H;
    protected int I;
    protected int J;
    protected int K;
    protected int L;

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public int C0() {
        return this.L;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public int J() {
        return this.J;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public boolean L() {
        return this.D;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public int P() {
        return this.I;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public int Q0() {
        return this.K;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public float Y() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.data.DataSet
    /* JADX INFO: renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void X0(CandleEntry candleEntry) {
        if (candleEntry.k() < this.f68537u) {
            this.f68537u = candleEntry.k();
        }
        if (candleEntry.j() > this.f68536t) {
            this.f68536t = candleEntry.j();
        }
        Y0(candleEntry);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.data.DataSet
    /* JADX INFO: renamed from: d1, reason: merged with bridge method [inline-methods] */
    public void Z0(CandleEntry candleEntry) {
        if (candleEntry.j() < this.f68537u) {
            this.f68537u = candleEntry.j();
        }
        if (candleEntry.j() > this.f68536t) {
            this.f68536t = candleEntry.j();
        }
        if (candleEntry.k() < this.f68537u) {
            this.f68537u = candleEntry.k();
        }
        if (candleEntry.k() > this.f68536t) {
            this.f68536t = candleEntry.k();
        }
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public Paint.Style h0() {
        return this.H;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public float j0() {
        return this.E;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public Paint.Style r0() {
        return this.G;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.ICandleDataSet
    public boolean y() {
        return this.F;
    }
}
