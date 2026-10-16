package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.facebook.appevents.AppEventsConstants;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.BubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.renderer.BarLineScatterCandleBubbleRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BubbleChartRenderer extends BarLineScatterCandleBubbleRenderer {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected BubbleDataProvider f68681h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float[] f68682i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float[] f68683j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float[] f68684k;

    public BubbleChartRenderer(BubbleDataProvider bubbleDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f68682i = new float[4];
        this.f68683j = new float[2];
        this.f68684k = new float[3];
        this.f68681h = bubbleDataProvider;
        this.f68696c.setStyle(Paint.Style.FILL);
        this.f68697d.setStyle(Paint.Style.STROKE);
        this.f68697d.setStrokeWidth(Utils.e(1.5f));
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void b(Canvas canvas) {
        for (IBubbleDataSet iBubbleDataSet : this.f68681h.getBubbleData().g()) {
            if (iBubbleDataSet.isVisible()) {
                j(canvas, iBubbleDataSet);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(android.graphics.Canvas r18, com.github.mikephil.charting.highlight.Highlight[] r19) {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.renderer.BubbleChartRenderer.d(android.graphics.Canvas, com.github.mikephil.charting.highlight.Highlight[]):void");
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void e(Canvas canvas) {
        BubbleEntry bubbleEntry;
        float f3;
        BubbleChartRenderer bubbleChartRenderer = this;
        BubbleData bubbleData = bubbleChartRenderer.f68681h.getBubbleData();
        if (bubbleData != null && bubbleChartRenderer.g(bubbleChartRenderer.f68681h)) {
            List listG = bubbleData.g();
            float fA = Utils.a(bubbleChartRenderer.f68699f, AppEventsConstants.EVENT_PARAM_VALUE_YES);
            int i3 = 0;
            while (i3 < listG.size()) {
                IBubbleDataSet iBubbleDataSet = (IBubbleDataSet) listG.get(i3);
                if (bubbleChartRenderer.i(iBubbleDataSet) && iBubbleDataSet.J0() >= 1) {
                    bubbleChartRenderer.a(iBubbleDataSet);
                    float fMax = Math.max(0.0f, Math.min(1.0f, bubbleChartRenderer.f68695b.a()));
                    float fB = bubbleChartRenderer.f68695b.b();
                    bubbleChartRenderer.f68676g.a(bubbleChartRenderer.f68681h, iBubbleDataSet);
                    Transformer transformerA = bubbleChartRenderer.f68681h.a(iBubbleDataSet.K());
                    BarLineScatterCandleBubbleRenderer.XBounds xBounds = bubbleChartRenderer.f68676g;
                    float[] fArrA = transformerA.a(iBubbleDataSet, fB, xBounds.f68677a, xBounds.f68678b);
                    float f4 = fMax == 1.0f ? fB : fMax;
                    ValueFormatter valueFormatterP = iBubbleDataSet.p();
                    MPPointF mPPointFD = MPPointF.d(iBubbleDataSet.K0());
                    mPPointFD.f68793c = Utils.e(mPPointFD.f68793c);
                    mPPointFD.f68794d = Utils.e(mPPointFD.f68794d);
                    int i4 = 0;
                    while (i4 < fArrA.length) {
                        int i5 = i4 / 2;
                        int iX = iBubbleDataSet.x(bubbleChartRenderer.f68676g.f68677a + i5);
                        int iArgb = Color.argb(Math.round(255.0f * f4), Color.red(iX), Color.green(iX), Color.blue(iX));
                        float f5 = fArrA[i4];
                        float f6 = fArrA[i4 + 1];
                        if (!bubbleChartRenderer.f68749a.A(f5)) {
                            break;
                        }
                        if (bubbleChartRenderer.f68749a.z(f5) && bubbleChartRenderer.f68749a.D(f6)) {
                            BubbleEntry bubbleEntry2 = (BubbleEntry) iBubbleDataSet.r(i5 + bubbleChartRenderer.f68676g.f68677a);
                            if (iBubbleDataSet.I()) {
                                f3 = f6;
                                bubbleEntry = bubbleEntry2;
                                bubbleChartRenderer.k(canvas, valueFormatterP.d(bubbleEntry2), f5, f6 + (0.5f * fA), iArgb);
                            } else {
                                bubbleEntry = bubbleEntry2;
                                f3 = f6;
                            }
                            if (bubbleEntry.d() != null && iBubbleDataSet.c0()) {
                                Drawable drawableD = bubbleEntry.d();
                                Utils.f(canvas, drawableD, (int) (f5 + mPPointFD.f68793c), (int) (f3 + mPPointFD.f68794d), drawableD.getIntrinsicWidth(), drawableD.getIntrinsicHeight());
                            }
                        }
                        i4 += 2;
                        bubbleChartRenderer = this;
                    }
                    MPPointF.f(mPPointFD);
                }
                i3++;
                bubbleChartRenderer = this;
            }
        }
    }

    protected void j(Canvas canvas, IBubbleDataSet iBubbleDataSet) {
        if (iBubbleDataSet.J0() < 1) {
            return;
        }
        Transformer transformerA = this.f68681h.a(iBubbleDataSet.K());
        float fB = this.f68695b.b();
        this.f68676g.a(this.f68681h, iBubbleDataSet);
        float[] fArr = this.f68682i;
        fArr[0] = 0.0f;
        fArr[2] = 1.0f;
        transformerA.k(fArr);
        boolean zQ = iBubbleDataSet.Q();
        float[] fArr2 = this.f68682i;
        float fMin = Math.min(Math.abs(this.f68749a.f() - this.f68749a.j()), Math.abs(fArr2[2] - fArr2[0]));
        int i3 = this.f68676g.f68677a;
        while (true) {
            BarLineScatterCandleBubbleRenderer.XBounds xBounds = this.f68676g;
            if (i3 > xBounds.f68679c + xBounds.f68677a) {
                return;
            }
            BubbleEntry bubbleEntry = (BubbleEntry) iBubbleDataSet.r(i3);
            this.f68683j[0] = bubbleEntry.h();
            this.f68683j[1] = bubbleEntry.e() * fB;
            transformerA.k(this.f68683j);
            float fL = l(bubbleEntry.i(), iBubbleDataSet.c(), fMin, zQ) / 2.0f;
            if (this.f68749a.B(this.f68683j[1] + fL) && this.f68749a.y(this.f68683j[1] - fL) && this.f68749a.z(this.f68683j[0] + fL)) {
                if (!this.f68749a.A(this.f68683j[0] - fL)) {
                    return;
                }
                this.f68696c.setColor(iBubbleDataSet.p0((int) bubbleEntry.h()));
                float[] fArr3 = this.f68683j;
                canvas.drawCircle(fArr3[0], fArr3[1], fL, this.f68696c);
            }
            i3++;
        }
    }

    public void k(Canvas canvas, String str, float f3, float f4, int i3) {
        this.f68699f.setColor(i3);
        canvas.drawText(str, f3, f4, this.f68699f);
    }

    protected float l(float f3, float f4, float f5, boolean z2) {
        if (z2) {
            f3 = f4 == 0.0f ? 1.0f : (float) Math.sqrt(f3 / f4);
        }
        return f5 * f3;
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void f() {
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void c(Canvas canvas) {
    }
}
