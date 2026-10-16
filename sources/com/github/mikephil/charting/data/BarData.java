package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BarData extends BarLineScatterCandleBubbleData<IBarDataSet> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f68485j;

    public BarData(IBarDataSet... iBarDataSetArr) {
        super(iBarDataSetArr);
        this.f68485j = 0.85f;
    }

    public float t() {
        return this.f68485j;
    }

    public void u(float f3) {
        this.f68485j = f3;
    }
}
