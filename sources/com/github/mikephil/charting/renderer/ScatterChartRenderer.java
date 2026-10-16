package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.ScatterDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ScatterChartRenderer extends LineScatterCandleRadarRenderer {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected ScatterDataProvider f68750i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float[] f68751j;

    public ScatterChartRenderer(ScatterDataProvider scatterDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f68751j = new float[2];
        this.f68750i = scatterDataProvider;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void b(Canvas canvas) {
        for (IScatterDataSet iScatterDataSet : this.f68750i.getScatterData().g()) {
            if (iScatterDataSet.isVisible()) {
                k(canvas, iScatterDataSet);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void d(Canvas canvas, Highlight[] highlightArr) {
        ScatterData scatterData = this.f68750i.getScatterData();
        for (Highlight highlight : highlightArr) {
            ILineScatterCandleRadarDataSet iLineScatterCandleRadarDataSet = (IScatterDataSet) scatterData.e(highlight.d());
            if (iLineScatterCandleRadarDataSet != null && iLineScatterCandleRadarDataSet.M0()) {
                Entry entryA0 = iLineScatterCandleRadarDataSet.a0(highlight.h(), highlight.j());
                if (h(entryA0, iLineScatterCandleRadarDataSet)) {
                    MPPointD mPPointDE = this.f68750i.a(iLineScatterCandleRadarDataSet.K()).e(entryA0.h(), entryA0.e() * this.f68695b.b());
                    highlight.m((float) mPPointDE.f68789c, (float) mPPointDE.f68790d);
                    j(canvas, (float) mPPointDE.f68789c, (float) mPPointDE.f68790d, iLineScatterCandleRadarDataSet);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void e(Canvas canvas) {
        Entry entry;
        ScatterChartRenderer scatterChartRenderer = this;
        if (scatterChartRenderer.g(scatterChartRenderer.f68750i)) {
            List listG = scatterChartRenderer.f68750i.getScatterData().g();
            int i3 = 0;
            while (i3 < scatterChartRenderer.f68750i.getScatterData().f()) {
                IScatterDataSet iScatterDataSet = (IScatterDataSet) listG.get(i3);
                if (scatterChartRenderer.i(iScatterDataSet) && iScatterDataSet.J0() >= 1) {
                    scatterChartRenderer.a(iScatterDataSet);
                    scatterChartRenderer.f68676g.a(scatterChartRenderer.f68750i, iScatterDataSet);
                    Transformer transformerA = scatterChartRenderer.f68750i.a(iScatterDataSet.K());
                    float fA = scatterChartRenderer.f68695b.a();
                    float fB = scatterChartRenderer.f68695b.b();
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = scatterChartRenderer.f68676g;
                    float[] fArrD = transformerA.d(iScatterDataSet, fA, fB, xBounds.f68677a, xBounds.f68678b);
                    float fE = Utils.e(iScatterDataSet.w());
                    ValueFormatter valueFormatterP = iScatterDataSet.p();
                    MPPointF mPPointFD = MPPointF.d(iScatterDataSet.K0());
                    mPPointFD.f68793c = Utils.e(mPPointFD.f68793c);
                    mPPointFD.f68794d = Utils.e(mPPointFD.f68794d);
                    int i4 = 0;
                    while (i4 < fArrD.length && scatterChartRenderer.f68749a.A(fArrD[i4])) {
                        if (scatterChartRenderer.f68749a.z(fArrD[i4])) {
                            int i5 = i4 + 1;
                            if (scatterChartRenderer.f68749a.D(fArrD[i5])) {
                                int i6 = i4 / 2;
                                Entry entryR = iScatterDataSet.r(scatterChartRenderer.f68676g.f68677a + i6);
                                if (iScatterDataSet.I()) {
                                    entry = entryR;
                                    scatterChartRenderer.l(canvas, valueFormatterP.h(entryR), fArrD[i4], fArrD[i5] - fE, iScatterDataSet.x(i6 + scatterChartRenderer.f68676g.f68677a));
                                } else {
                                    entry = entryR;
                                }
                                if (entry.d() != null && iScatterDataSet.c0()) {
                                    Drawable drawableD = entry.d();
                                    Utils.f(canvas, drawableD, (int) (fArrD[i4] + mPPointFD.f68793c), (int) (fArrD[i5] + mPPointFD.f68794d), drawableD.getIntrinsicWidth(), drawableD.getIntrinsicHeight());
                                }
                            }
                        }
                        i4 += 2;
                        scatterChartRenderer = this;
                    }
                    MPPointF.f(mPPointFD);
                }
                i3++;
                scatterChartRenderer = this;
            }
        }
    }

    protected void k(Canvas canvas, IScatterDataSet iScatterDataSet) {
        IScatterDataSet iScatterDataSet2 = iScatterDataSet;
        if (iScatterDataSet2.J0() < 1) {
            return;
        }
        ViewPortHandler viewPortHandler = this.f68749a;
        Transformer transformerA = this.f68750i.a(iScatterDataSet2.K());
        float fB = this.f68695b.b();
        IShapeRenderer iShapeRendererB0 = iScatterDataSet2.B0();
        if (iShapeRendererB0 == null) {
            Log.i("MISSING", "There's no IShapeRenderer specified for ScatterDataSet");
            return;
        }
        int iMin = (int) Math.min(Math.ceil(iScatterDataSet2.J0() * this.f68695b.a()), iScatterDataSet2.J0());
        int i3 = 0;
        while (i3 < iMin) {
            Entry entryR = iScatterDataSet2.r(i3);
            this.f68751j[0] = entryR.h();
            this.f68751j[1] = entryR.e() * fB;
            transformerA.k(this.f68751j);
            if (!viewPortHandler.A(this.f68751j[0])) {
                return;
            }
            if (viewPortHandler.z(this.f68751j[0]) && viewPortHandler.D(this.f68751j[1])) {
                this.f68696c.setColor(iScatterDataSet2.p0(i3 / 2));
                ViewPortHandler viewPortHandler2 = this.f68749a;
                float[] fArr = this.f68751j;
                iShapeRendererB0.a(canvas, iScatterDataSet2, viewPortHandler2, fArr[0], fArr[1], this.f68696c);
            }
            i3++;
            iScatterDataSet2 = iScatterDataSet;
        }
    }

    public void l(Canvas canvas, String str, float f3, float f4, int i3) {
        this.f68699f.setColor(i3);
        canvas.drawText(str, f3, f4, this.f68699f);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void f() {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void c(Canvas canvas) {
    }
}
