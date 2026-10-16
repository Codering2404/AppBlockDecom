package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PieDataSet extends DataSet<PieEntry> implements IPieDataSet {
    private ValuePosition A;
    private ValuePosition B;
    private boolean C;
    private int D;
    private float E;
    private float F;
    private float G;
    private float H;
    private boolean I;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f68552x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f68553y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f68554z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum ValuePosition {
        INSIDE_SLICE,
        OUTSIDE_SLICE
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float B() {
        return this.H;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float E0() {
        return this.F;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float G() {
        return this.f68554z;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float T() {
        return this.f68552x;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.data.DataSet
    /* JADX INFO: renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void X0(PieEntry pieEntry) {
        if (pieEntry == null) {
            return;
        }
        Z0(pieEntry);
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public int n0() {
        return this.D;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public boolean q() {
        return this.f68553y;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public ValuePosition q0() {
        return this.A;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float t() {
        return this.E;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public float u() {
        return this.G;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public ValuePosition x0() {
        return this.B;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public boolean y0() {
        return this.I;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IPieDataSet
    public boolean z0() {
        return this.C;
    }
}
