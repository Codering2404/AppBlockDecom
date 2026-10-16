package com.github.mikephil.charting.charts;

import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LineChartRenderer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LineChart extends BarLineChartBase<LineData> implements LineDataProvider {
    @Override // com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider
    public LineData getLineData() {
        return (LineData) this.f68321b;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void n() {
        super.n();
        this.f68337s = new LineChartRenderer(this, this.f68340v, this.f68339u);
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        DataRenderer dataRenderer = this.f68337s;
        if (dataRenderer != null && (dataRenderer instanceof LineChartRenderer)) {
            ((LineChartRenderer) dataRenderer).w();
        }
        super.onDetachedFromWindow();
    }
}
