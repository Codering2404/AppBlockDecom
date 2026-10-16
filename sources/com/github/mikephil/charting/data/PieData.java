package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class PieData extends ChartData<IPieDataSet> {
    @Override // com.github.mikephil.charting.data.ChartData
    public Entry i(Highlight highlight) {
        return t().r((int) highlight.h());
    }

    public IPieDataSet t() {
        return (IPieDataSet) this.f68529i.get(0);
    }

    @Override // com.github.mikephil.charting.data.ChartData
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public IPieDataSet e(int i3) {
        if (i3 == 0) {
            return t();
        }
        return null;
    }

    public float v() {
        float fE = 0.0f;
        for (int i3 = 0; i3 < t().J0(); i3++) {
            fE += ((PieEntry) t().r(i3)).e();
        }
        return fE;
    }
}
