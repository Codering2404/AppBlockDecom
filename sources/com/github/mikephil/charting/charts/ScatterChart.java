package com.github.mikephil.charting.charts;

import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.renderer.ScatterChartRenderer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ScatterChart extends BarLineChartBase<ScatterData> implements ScatterDataProvider {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum ScatterShape {
        SQUARE("SQUARE"),
        CIRCLE("CIRCLE"),
        TRIANGLE("TRIANGLE"),
        CROSS("CROSS"),
        X("X"),
        CHEVRON_UP("CHEVRON_UP"),
        CHEVRON_DOWN("CHEVRON_DOWN");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f68374a;

        ScatterShape(String str) {
            this.f68374a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f68374a;
        }
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider
    public ScatterData getScatterData() {
        return (ScatterData) this.f68321b;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void n() {
        super.n();
        this.f68337s = new ScatterChartRenderer(this, this.f68340v, this.f68339u);
        getXAxis().T(0.5f);
        getXAxis().S(0.5f);
    }
}
