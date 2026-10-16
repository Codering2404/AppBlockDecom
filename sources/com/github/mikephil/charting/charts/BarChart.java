package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.highlight.BarHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.renderer.BarChartRenderer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BarChart extends BarLineChartBase<BarData> implements BarDataProvider {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    protected boolean f68290s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private boolean f68291t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private boolean f68292u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private boolean f68293v0;

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f68290s0 = false;
        this.f68291t0 = true;
        this.f68292u0 = false;
        this.f68293v0 = false;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean b() {
        return this.f68291t0;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean c() {
        return this.f68290s0;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public boolean e() {
        return this.f68292u0;
    }

    @Override // com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider
    public BarData getBarData() {
        return (BarData) this.f68321b;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    public Highlight k(float f3, float f4) {
        if (this.f68321b == null) {
            Log.e("MPAndroidChart", "Can't select by touch. No data set.");
            return null;
        }
        Highlight highlightA = getHighlighter().a(f3, f4);
        return (highlightA == null || !c()) ? highlightA : new Highlight(highlightA.h(), highlightA.j(), highlightA.i(), highlightA.k(), highlightA.d(), -1, highlightA.b());
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void n() {
        super.n();
        this.f68337s = new BarChartRenderer(this, this.f68340v, this.f68339u);
        setHighlighter(new BarHighlighter(this));
        getXAxis().T(0.5f);
        getXAxis().S(0.5f);
    }

    public void setDrawBarShadow(boolean z2) {
        this.f68292u0 = z2;
    }

    public void setDrawValueAboveBar(boolean z2) {
        this.f68291t0 = z2;
    }

    public void setFitBars(boolean z2) {
        this.f68293v0 = z2;
    }

    public void setHighlightFullBarEnabled(boolean z2) {
        this.f68290s0 = z2;
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    protected void y() {
        if (this.f68293v0) {
            this.f68328j.l(((BarData) this.f68321b).n() - (((BarData) this.f68321b).t() / 2.0f), ((BarData) this.f68321b).m() + (((BarData) this.f68321b).t() / 2.0f));
        } else {
            this.f68328j.l(((BarData) this.f68321b).n(), ((BarData) this.f68321b).m());
        }
        YAxis yAxis = this.f68295b0;
        BarData barData = (BarData) this.f68321b;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.l(barData.r(axisDependency), ((BarData) this.f68321b).p(axisDependency));
        YAxis yAxis2 = this.f68296c0;
        BarData barData2 = (BarData) this.f68321b;
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        yAxis2.l(barData2.r(axisDependency2), ((BarData) this.f68321b).p(axisDependency2));
    }
}
