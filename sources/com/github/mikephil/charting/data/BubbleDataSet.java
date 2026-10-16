package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BubbleDataSet extends BarLineScatterCandleBubbleDataSet<BubbleEntry> implements IBubbleDataSet {
    private float A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected float f68514y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected boolean f68515z;

    @Override // com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet
    public float H() {
        return this.A;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet
    public boolean Q() {
        return this.f68515z;
    }

    @Override // com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet
    public float c() {
        return this.f68514y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.mikephil.charting.data.DataSet
    /* JADX INFO: renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void X0(BubbleEntry bubbleEntry) {
        super.X0(bubbleEntry);
        float fI = bubbleEntry.i();
        if (fI > this.f68514y) {
            this.f68514y = fI;
        }
    }
}
