package com.github.mikephil.charting.charts;

import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.renderer.BubbleChartRenderer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BubbleChart extends BarLineChartBase<BubbleData> implements BubbleDataProvider {
    @Override // com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider
    public BubbleData getBubbleData() {
        return (BubbleData) this.f68321b;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void n() {
        super.n();
        this.f68337s = new BubbleChartRenderer(this, this.f68340v, this.f68339u);
    }
}
