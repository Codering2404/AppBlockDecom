package com.github.mikephil.charting.charts;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.highlight.RadarHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.renderer.RadarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererRadarChart;
import com.github.mikephil.charting.renderer.YAxisRendererRadarChart;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RadarChart extends PieRadarChartBase<RadarData> {
    private float L;
    private float M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private int R;
    private YAxis S;
    protected YAxisRendererRadarChart T;
    protected XAxisRendererRadarChart U;

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public int A(float f3) {
        float fQ = Utils.q(f3 - getRotationAngle());
        float sliceAngle = getSliceAngle();
        int iJ0 = ((IRadarDataSet) ((RadarData) this.f68321b).l()).J0();
        int i3 = 0;
        while (i3 < iJ0) {
            int i4 = i3 + 1;
            if ((i4 * sliceAngle) - (sliceAngle / 2.0f) > fQ) {
                return i3;
            }
            i3 = i4;
        }
        return 0;
    }

    public float getFactor() {
        RectF rectFO = this.f68339u.o();
        return Math.min(rectFO.width() / 2.0f, rectFO.height() / 2.0f) / this.S.I;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    public float getRadius() {
        RectF rectFO = this.f68339u.o();
        return Math.min(rectFO.width() / 2.0f, rectFO.height() / 2.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredBaseOffset() {
        return (this.f68328j.f() && this.f68328j.C()) ? this.f68328j.L : Utils.e(10.0f);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected float getRequiredLegendOffset() {
        return this.f68336r.d().getTextSize() * 4.0f;
    }

    public int getSkipWebLineCount() {
        return this.R;
    }

    public float getSliceAngle() {
        return 360.0f / ((IRadarDataSet) ((RadarData) this.f68321b).l()).J0();
    }

    public int getWebAlpha() {
        return this.P;
    }

    public int getWebColor() {
        return this.N;
    }

    public int getWebColorInner() {
        return this.O;
    }

    public float getWebLineWidth() {
        return this.L;
    }

    public float getWebLineWidthInner() {
        return this.M;
    }

    public YAxis getYAxis() {
        return this.S;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart, com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMax() {
        return this.S.G;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart, com.github.mikephil.charting.interfaces.dataprovider.ChartInterface
    public float getYChartMin() {
        return this.S.H;
    }

    public float getYRange() {
        return this.S.I;
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    protected void n() {
        super.n();
        this.S = new YAxis(YAxis.AxisDependency.LEFT);
        this.L = Utils.e(1.5f);
        this.M = Utils.e(0.75f);
        this.f68337s = new RadarChartRenderer(this, this.f68340v, this.f68339u);
        this.T = new YAxisRendererRadarChart(this.f68339u, this.S, this);
        this.U = new XAxisRendererRadarChart(this.f68339u, this.f68328j, this);
        this.f68338t = new RadarHighlighter(this);
    }

    @Override // com.github.mikephil.charting.charts.Chart, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f68321b == null) {
            return;
        }
        if (this.f68328j.f()) {
            XAxisRendererRadarChart xAxisRendererRadarChart = this.U;
            XAxis xAxis = this.f68328j;
            xAxisRendererRadarChart.a(xAxis.H, xAxis.G, false);
        }
        this.U.i(canvas);
        if (this.Q) {
            this.f68337s.c(canvas);
        }
        if (this.S.f() && this.S.D()) {
            this.T.l(canvas);
        }
        this.f68337s.b(canvas);
        if (w()) {
            this.f68337s.d(canvas, this.B);
        }
        if (this.S.f() && !this.S.D()) {
            this.T.l(canvas);
        }
        this.T.i(canvas);
        this.f68337s.e(canvas);
        this.f68336r.e(canvas);
        h(canvas);
        i(canvas);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase, com.github.mikephil.charting.charts.Chart
    public void s() {
        if (this.f68321b == null) {
            return;
        }
        x();
        YAxisRendererRadarChart yAxisRendererRadarChart = this.T;
        YAxis yAxis = this.S;
        yAxisRendererRadarChart.a(yAxis.H, yAxis.G, yAxis.i0());
        XAxisRendererRadarChart xAxisRendererRadarChart = this.U;
        XAxis xAxis = this.f68328j;
        xAxisRendererRadarChart.a(xAxis.H, xAxis.G, false);
        Legend legend = this.f68331m;
        if (legend != null && !legend.H()) {
            this.f68336r.a(this.f68321b);
        }
        f();
    }

    public void setDrawWeb(boolean z2) {
        this.Q = z2;
    }

    public void setSkipWebLineCount(int i3) {
        this.R = Math.max(0, i3);
    }

    public void setWebAlpha(int i3) {
        this.P = i3;
    }

    public void setWebColor(int i3) {
        this.N = i3;
    }

    public void setWebColorInner(int i3) {
        this.O = i3;
    }

    public void setWebLineWidth(float f3) {
        this.L = Utils.e(f3);
    }

    public void setWebLineWidthInner(float f3) {
        this.M = Utils.e(f3);
    }

    @Override // com.github.mikephil.charting.charts.PieRadarChartBase
    protected void x() {
        super.x();
        YAxis yAxis = this.S;
        RadarData radarData = (RadarData) this.f68321b;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.l(radarData.r(axisDependency), ((RadarData) this.f68321b).p(axisDependency));
        this.f68328j.l(0.0f, ((IRadarDataSet) ((RadarData) this.f68321b).l()).J0());
    }
}
