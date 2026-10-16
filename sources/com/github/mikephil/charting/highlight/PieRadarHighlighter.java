package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class PieRadarHighlighter<T extends PieRadarChartBase> implements IHighlighter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected PieRadarChartBase f68588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected List f68589b = new ArrayList();

    public PieRadarHighlighter(PieRadarChartBase pieRadarChartBase) {
        this.f68588a = pieRadarChartBase;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.github.mikephil.charting.data.ChartData] */
    @Override // com.github.mikephil.charting.highlight.IHighlighter
    public Highlight a(float f3, float f4) {
        if (this.f68588a.y(f3, f4) > this.f68588a.getRadius()) {
            return null;
        }
        float fZ = this.f68588a.z(f3, f4);
        PieRadarChartBase pieRadarChartBase = this.f68588a;
        if (pieRadarChartBase instanceof PieChart) {
            fZ /= pieRadarChartBase.getAnimator().b();
        }
        int iA = this.f68588a.A(fZ);
        if (iA < 0 || iA >= this.f68588a.getData().l().J0()) {
            return null;
        }
        return b(iA, f3, f4);
    }

    protected abstract Highlight b(int i3, float f3, float f4);
}
