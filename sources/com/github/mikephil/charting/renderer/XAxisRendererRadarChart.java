package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class XAxisRendererRadarChart extends XAxisRenderer {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private RadarChart f68762p;

    public XAxisRendererRadarChart(ViewPortHandler viewPortHandler, XAxis xAxis, RadarChart radarChart) {
        super(viewPortHandler, xAxis, null);
        this.f68762p = radarChart;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public void i(Canvas canvas) {
        if (this.f68752h.f() && this.f68752h.C()) {
            float fV = this.f68752h.V();
            MPPointF mPPointFC = MPPointF.c(0.5f, 0.25f);
            this.f68667e.setTypeface(this.f68752h.c());
            this.f68667e.setTextSize(this.f68752h.b());
            this.f68667e.setColor(this.f68752h.a());
            float sliceAngle = this.f68762p.getSliceAngle();
            float factor = this.f68762p.getFactor();
            MPPointF centerOffsets = this.f68762p.getCenterOffsets();
            MPPointF mPPointFC2 = MPPointF.c(0.0f, 0.0f);
            for (int i3 = 0; i3 < ((IRadarDataSet) ((RadarData) this.f68762p.getData()).l()).J0(); i3++) {
                float f3 = i3;
                String strA = this.f68752h.x().a(f3, this.f68752h);
                Utils.r(centerOffsets, (this.f68762p.getYRange() * factor) + (this.f68752h.L / 2.0f), ((f3 * sliceAngle) + this.f68762p.getRotationAngle()) % 360.0f, mPPointFC2);
                f(canvas, strA, mPPointFC2.f68793c, mPPointFC2.f68794d - (this.f68752h.M / 2.0f), mPPointFC, fV);
            }
            MPPointF.f(centerOffsets);
            MPPointF.f(mPPointFC2);
            MPPointF.f(mPPointFC);
        }
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public void n(Canvas canvas) {
    }
}
