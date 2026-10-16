package com.github.mikephil.charting.charts;

import android.graphics.RectF;
import android.util.Log;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.HorizontalBarHighlighter;
import com.github.mikephil.charting.renderer.HorizontalBarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.renderer.YAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.utils.HorizontalViewPortHandler;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.TransformerHorizontalBarChart;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class HorizontalBarChart extends BarChart {

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    private RectF f68357w0;

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    protected void Q() {
        Transformer transformer = this.f68300g0;
        YAxis yAxis = this.f68296c0;
        float f3 = yAxis.H;
        float f4 = yAxis.I;
        XAxis xAxis = this.f68328j;
        transformer.m(f3, f4, xAxis.I, xAxis.H);
        Transformer transformer2 = this.f68299f0;
        YAxis yAxis2 = this.f68295b0;
        float f5 = yAxis2.H;
        float f6 = yAxis2.I;
        XAxis xAxis2 = this.f68328j;
        transformer2.m(f5, f6, xAxis2.I, xAxis2.H);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    public void f() {
        z(this.f68357w0);
        RectF rectF = this.f68357w0;
        float f3 = rectF.left + 0.0f;
        float fZ = rectF.top + 0.0f;
        float f4 = rectF.right + 0.0f;
        float fZ2 = rectF.bottom + 0.0f;
        if (this.f68295b0.j0()) {
            fZ += this.f68295b0.Z(this.f68297d0.c());
        }
        if (this.f68296c0.j0()) {
            fZ2 += this.f68296c0.Z(this.f68298e0.c());
        }
        XAxis xAxis = this.f68328j;
        float f5 = xAxis.L;
        if (xAxis.f()) {
            if (this.f68328j.W() == XAxis.XAxisPosition.BOTTOM) {
                f3 += f5;
            } else if (this.f68328j.W() == XAxis.XAxisPosition.TOP) {
                f4 += f5;
            } else if (this.f68328j.W() == XAxis.XAxisPosition.BOTH_SIDED) {
                f3 += f5;
                f4 += f5;
            }
        }
        float extraTopOffset = fZ + getExtraTopOffset();
        float extraRightOffset = f4 + getExtraRightOffset();
        float extraBottomOffset = fZ2 + getExtraBottomOffset();
        float extraLeftOffset = f3 + getExtraLeftOffset();
        float fE = Utils.e(this.V);
        this.f68339u.K(Math.max(fE, extraLeftOffset), Math.max(fE, extraTopOffset), Math.max(fE, extraRightOffset), Math.max(fE, extraBottomOffset));
        if (this.f68320a) {
            Log.i("MPAndroidChart", "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
            StringBuilder sb = new StringBuilder();
            sb.append("Content: ");
            sb.append(this.f68339u.o().toString());
            Log.i("MPAndroidChart", sb.toString());
        }
        P();
        Q();
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getHighestVisibleX() {
        a(YAxis.AxisDependency.LEFT).h(this.f68339u.h(), this.f68339u.j(), this.f68310q0);
        return (float) Math.min(this.f68328j.G, this.f68310q0.f68790d);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider
    public float getLowestVisibleX() {
        a(YAxis.AxisDependency.LEFT).h(this.f68339u.h(), this.f68339u.f(), this.f68309p0);
        return (float) Math.max(this.f68328j.H, this.f68309p0.f68790d);
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.Chart
    public Highlight k(float f3, float f4) {
        if (this.f68321b != null) {
            return getHighlighter().a(f4, f3);
        }
        if (!this.f68320a) {
            return null;
        }
        Log.e("MPAndroidChart", "Can't select by touch. No data set.");
        return null;
    }

    @Override // com.github.mikephil.charting.charts.Chart
    protected float[] l(Highlight highlight) {
        return new float[]{highlight.f(), highlight.e()};
    }

    @Override // com.github.mikephil.charting.charts.BarChart, com.github.mikephil.charting.charts.BarLineChartBase, com.github.mikephil.charting.charts.Chart
    protected void n() {
        this.f68339u = new HorizontalViewPortHandler();
        super.n();
        this.f68299f0 = new TransformerHorizontalBarChart(this.f68339u);
        this.f68300g0 = new TransformerHorizontalBarChart(this.f68339u);
        this.f68337s = new HorizontalBarChartRenderer(this, this.f68340v, this.f68339u);
        setHighlighter(new HorizontalBarHighlighter(this));
        this.f68297d0 = new YAxisRendererHorizontalBarChart(this.f68339u, this.f68295b0, this.f68299f0);
        this.f68298e0 = new YAxisRendererHorizontalBarChart(this.f68339u, this.f68296c0, this.f68300g0);
        this.f68301h0 = new XAxisRendererHorizontalBarChart(this.f68339u, this.f68328j, this.f68299f0, this);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRangeMaximum(float f3) {
        this.f68339u.R(this.f68328j.I / f3);
    }

    @Override // com.github.mikephil.charting.charts.BarLineChartBase
    public void setVisibleXRangeMinimum(float f3) {
        this.f68339u.P(this.f68328j.I / f3);
    }
}
