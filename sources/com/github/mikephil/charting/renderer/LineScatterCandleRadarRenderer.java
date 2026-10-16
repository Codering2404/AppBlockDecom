package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Path;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LineScatterCandleRadarRenderer extends BarLineScatterCandleBubbleRenderer {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Path f68726h;

    public LineScatterCandleRadarRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f68726h = new Path();
    }

    protected void j(Canvas canvas, float f3, float f4, ILineScatterCandleRadarDataSet iLineScatterCandleRadarDataSet) {
        this.f68697d.setColor(iLineScatterCandleRadarDataSet.H0());
        this.f68697d.setStrokeWidth(iLineScatterCandleRadarDataSet.e0());
        this.f68697d.setPathEffect(iLineScatterCandleRadarDataSet.w0());
        if (iLineScatterCandleRadarDataSet.N()) {
            this.f68726h.reset();
            this.f68726h.moveTo(f3, this.f68749a.j());
            this.f68726h.lineTo(f3, this.f68749a.f());
            canvas.drawPath(this.f68726h, this.f68697d);
        }
        if (iLineScatterCandleRadarDataSet.P0()) {
            this.f68726h.reset();
            this.f68726h.moveTo(this.f68749a.h(), f4);
            this.f68726h.lineTo(this.f68749a.i(), f4);
            canvas.drawPath(this.f68726h, this.f68697d);
        }
    }
}
