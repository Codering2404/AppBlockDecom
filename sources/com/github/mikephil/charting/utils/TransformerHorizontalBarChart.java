package com.github.mikephil.charting.utils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class TransformerHorizontalBarChart extends Transformer {
    public TransformerHorizontalBarChart(ViewPortHandler viewPortHandler) {
        super(viewPortHandler);
    }

    @Override // com.github.mikephil.charting.utils.Transformer
    public void l(boolean z2) {
        this.f68805b.reset();
        if (!z2) {
            this.f68805b.postTranslate(this.f68806c.G(), this.f68806c.l() - this.f68806c.F());
        } else {
            this.f68805b.setTranslate(-(this.f68806c.m() - this.f68806c.H()), this.f68806c.l() - this.f68806c.F());
            this.f68805b.postScale(-1.0f, 1.0f);
        }
    }
}
