package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.CandleData;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.CandleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class CandleStickChartRenderer extends LineScatterCandleRadarRenderer {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected CandleDataProvider f68685i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float[] f68686j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float[] f68687k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float[] f68688l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float[] f68689m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float[] f68690n;

    public CandleStickChartRenderer(CandleDataProvider candleDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f68686j = new float[8];
        this.f68687k = new float[4];
        this.f68688l = new float[4];
        this.f68689m = new float[4];
        this.f68690n = new float[4];
        this.f68685i = candleDataProvider;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void b(Canvas canvas) {
        for (ICandleDataSet iCandleDataSet : this.f68685i.getCandleData().g()) {
            if (iCandleDataSet.isVisible()) {
                k(canvas, iCandleDataSet);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void d(Canvas canvas, Highlight[] highlightArr) {
        CandleData candleData = this.f68685i.getCandleData();
        for (Highlight highlight : highlightArr) {
            ILineScatterCandleRadarDataSet iLineScatterCandleRadarDataSet = (ICandleDataSet) candleData.e(highlight.d());
            if (iLineScatterCandleRadarDataSet != null && iLineScatterCandleRadarDataSet.M0()) {
                CandleEntry candleEntry = (CandleEntry) iLineScatterCandleRadarDataSet.a0(highlight.h(), highlight.j());
                if (h(candleEntry, iLineScatterCandleRadarDataSet)) {
                    MPPointD mPPointDE = this.f68685i.a(iLineScatterCandleRadarDataSet.K()).e(candleEntry.h(), ((candleEntry.k() * this.f68695b.b()) + (candleEntry.j() * this.f68695b.b())) / 2.0f);
                    highlight.m((float) mPPointDE.f68789c, (float) mPPointDE.f68790d);
                    j(canvas, (float) mPPointDE.f68789c, (float) mPPointDE.f68790d, iLineScatterCandleRadarDataSet);
                }
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void e(Canvas canvas) {
        CandleEntry candleEntry;
        CandleStickChartRenderer candleStickChartRenderer = this;
        if (candleStickChartRenderer.g(candleStickChartRenderer.f68685i)) {
            List listG = candleStickChartRenderer.f68685i.getCandleData().g();
            int i3 = 0;
            while (i3 < listG.size()) {
                ICandleDataSet iCandleDataSet = (ICandleDataSet) listG.get(i3);
                if (candleStickChartRenderer.i(iCandleDataSet) && iCandleDataSet.J0() >= 1) {
                    candleStickChartRenderer.a(iCandleDataSet);
                    Transformer transformerA = candleStickChartRenderer.f68685i.a(iCandleDataSet.K());
                    candleStickChartRenderer.f68676g.a(candleStickChartRenderer.f68685i, iCandleDataSet);
                    float fA = candleStickChartRenderer.f68695b.a();
                    float fB = candleStickChartRenderer.f68695b.b();
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = candleStickChartRenderer.f68676g;
                    float[] fArrB = transformerA.b(iCandleDataSet, fA, fB, xBounds.f68677a, xBounds.f68678b);
                    float fE = Utils.e(5.0f);
                    ValueFormatter valueFormatterP = iCandleDataSet.p();
                    MPPointF mPPointFD = MPPointF.d(iCandleDataSet.K0());
                    mPPointFD.f68793c = Utils.e(mPPointFD.f68793c);
                    mPPointFD.f68794d = Utils.e(mPPointFD.f68794d);
                    int i4 = 0;
                    while (i4 < fArrB.length) {
                        float f3 = fArrB[i4];
                        float f4 = fArrB[i4 + 1];
                        if (!candleStickChartRenderer.f68749a.A(f3)) {
                            break;
                        }
                        if (candleStickChartRenderer.f68749a.z(f3) && candleStickChartRenderer.f68749a.D(f4)) {
                            int i5 = i4 / 2;
                            CandleEntry candleEntry2 = (CandleEntry) iCandleDataSet.r(candleStickChartRenderer.f68676g.f68677a + i5);
                            if (iCandleDataSet.I()) {
                                candleEntry = candleEntry2;
                                candleStickChartRenderer.l(canvas, valueFormatterP.e(candleEntry2), f3, f4 - fE, iCandleDataSet.x(i5));
                            } else {
                                candleEntry = candleEntry2;
                            }
                            if (candleEntry.d() != null && iCandleDataSet.c0()) {
                                Drawable drawableD = candleEntry.d();
                                Utils.f(canvas, drawableD, (int) (f3 + mPPointFD.f68793c), (int) (f4 + mPPointFD.f68794d), drawableD.getIntrinsicWidth(), drawableD.getIntrinsicHeight());
                            }
                        }
                        i4 += 2;
                        candleStickChartRenderer = this;
                    }
                    MPPointF.f(mPPointFD);
                }
                i3++;
                candleStickChartRenderer = this;
            }
        }
    }

    protected void k(Canvas canvas, ICandleDataSet iCandleDataSet) {
        Transformer transformerA = this.f68685i.a(iCandleDataSet.K());
        float fB = this.f68695b.b();
        float fJ0 = iCandleDataSet.j0();
        boolean zL = iCandleDataSet.L();
        this.f68676g.a(this.f68685i, iCandleDataSet);
        this.f68696c.setStrokeWidth(iCandleDataSet.Y());
        int i3 = this.f68676g.f68677a;
        while (true) {
            BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.f68676g;
            if (i3 > xBounds.f68679c + xBounds.f68677a) {
                return;
            }
            CandleEntry candleEntry = (CandleEntry) iCandleDataSet.r(i3);
            if (candleEntry != null) {
                float fH = candleEntry.h();
                float fL = candleEntry.l();
                float fI = candleEntry.i();
                float fJ = candleEntry.j();
                float fK = candleEntry.k();
                if (zL) {
                    float[] fArr = this.f68686j;
                    fArr[0] = fH;
                    fArr[2] = fH;
                    fArr[4] = fH;
                    fArr[6] = fH;
                    if (fL > fI) {
                        fArr[1] = fJ * fB;
                        fArr[3] = fL * fB;
                        fArr[5] = fK * fB;
                        fArr[7] = fI * fB;
                    } else if (fL < fI) {
                        fArr[1] = fJ * fB;
                        fArr[3] = fI * fB;
                        fArr[5] = fK * fB;
                        fArr[7] = fL * fB;
                    } else {
                        fArr[1] = fJ * fB;
                        float f3 = fL * fB;
                        fArr[3] = f3;
                        fArr[5] = fK * fB;
                        fArr[7] = f3;
                    }
                    transformerA.k(fArr);
                    if (!iCandleDataSet.y()) {
                        this.f68696c.setColor(iCandleDataSet.C0() == 1122867 ? iCandleDataSet.p0(i3) : iCandleDataSet.C0());
                    } else if (fL > fI) {
                        this.f68696c.setColor(iCandleDataSet.Q0() == 1122867 ? iCandleDataSet.p0(i3) : iCandleDataSet.Q0());
                    } else if (fL < fI) {
                        this.f68696c.setColor(iCandleDataSet.J() == 1122867 ? iCandleDataSet.p0(i3) : iCandleDataSet.J());
                    } else {
                        this.f68696c.setColor(iCandleDataSet.P() == 1122867 ? iCandleDataSet.p0(i3) : iCandleDataSet.P());
                    }
                    this.f68696c.setStyle(Paint.Style.STROKE);
                    canvas.drawLines(this.f68686j, this.f68696c);
                    float[] fArr2 = this.f68687k;
                    fArr2[0] = (fH - 0.5f) + fJ0;
                    fArr2[1] = fI * fB;
                    fArr2[2] = (fH + 0.5f) - fJ0;
                    fArr2[3] = fL * fB;
                    transformerA.k(fArr2);
                    if (fL > fI) {
                        if (iCandleDataSet.Q0() == 1122867) {
                            this.f68696c.setColor(iCandleDataSet.p0(i3));
                        } else {
                            this.f68696c.setColor(iCandleDataSet.Q0());
                        }
                        this.f68696c.setStyle(iCandleDataSet.h0());
                        float[] fArr3 = this.f68687k;
                        canvas.drawRect(fArr3[0], fArr3[3], fArr3[2], fArr3[1], this.f68696c);
                    } else if (fL < fI) {
                        if (iCandleDataSet.J() == 1122867) {
                            this.f68696c.setColor(iCandleDataSet.p0(i3));
                        } else {
                            this.f68696c.setColor(iCandleDataSet.J());
                        }
                        this.f68696c.setStyle(iCandleDataSet.r0());
                        float[] fArr4 = this.f68687k;
                        canvas.drawRect(fArr4[0], fArr4[1], fArr4[2], fArr4[3], this.f68696c);
                    } else {
                        if (iCandleDataSet.P() == 1122867) {
                            this.f68696c.setColor(iCandleDataSet.p0(i3));
                        } else {
                            this.f68696c.setColor(iCandleDataSet.P());
                        }
                        float[] fArr5 = this.f68687k;
                        canvas.drawLine(fArr5[0], fArr5[1], fArr5[2], fArr5[3], this.f68696c);
                    }
                } else {
                    float[] fArr6 = this.f68688l;
                    fArr6[0] = fH;
                    fArr6[1] = fJ * fB;
                    fArr6[2] = fH;
                    fArr6[3] = fK * fB;
                    float[] fArr7 = this.f68689m;
                    fArr7[0] = (fH - 0.5f) + fJ0;
                    float f4 = fL * fB;
                    fArr7[1] = f4;
                    fArr7[2] = fH;
                    fArr7[3] = f4;
                    float[] fArr8 = this.f68690n;
                    fArr8[0] = (fH + 0.5f) - fJ0;
                    float f5 = fI * fB;
                    fArr8[1] = f5;
                    fArr8[2] = fH;
                    fArr8[3] = f5;
                    transformerA.k(fArr6);
                    transformerA.k(this.f68689m);
                    transformerA.k(this.f68690n);
                    this.f68696c.setColor(fL > fI ? iCandleDataSet.Q0() == 1122867 ? iCandleDataSet.p0(i3) : iCandleDataSet.Q0() : fL < fI ? iCandleDataSet.J() == 1122867 ? iCandleDataSet.p0(i3) : iCandleDataSet.J() : iCandleDataSet.P() == 1122867 ? iCandleDataSet.p0(i3) : iCandleDataSet.P());
                    float[] fArr9 = this.f68688l;
                    canvas.drawLine(fArr9[0], fArr9[1], fArr9[2], fArr9[3], this.f68696c);
                    float[] fArr10 = this.f68689m;
                    canvas.drawLine(fArr10[0], fArr10[1], fArr10[2], fArr10[3], this.f68696c);
                    float[] fArr11 = this.f68690n;
                    canvas.drawLine(fArr11[0], fArr11[1], fArr11[2], fArr11[3], this.f68696c);
                }
            }
            i3++;
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
