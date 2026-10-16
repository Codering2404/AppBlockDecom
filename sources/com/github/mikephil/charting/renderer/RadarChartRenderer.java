package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RadarChartRenderer extends LineRadarRenderer {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected RadarChart f68744i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected Paint f68745j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected Paint f68746k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected Path f68747l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected Path f68748m;

    public RadarChartRenderer(RadarChart radarChart, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
        this.f68747l = new Path();
        this.f68748m = new Path();
        this.f68744i = radarChart;
        Paint paint = new Paint(1);
        this.f68697d = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.f68697d.setStrokeWidth(2.0f);
        this.f68697d.setColor(Color.rgb(255, 187, 115));
        Paint paint2 = new Paint(1);
        this.f68745j = paint2;
        paint2.setStyle(style);
        this.f68746k = new Paint(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void b(Canvas canvas) {
        RadarData radarData = (RadarData) this.f68744i.getData();
        int iJ0 = ((IRadarDataSet) radarData.l()).J0();
        for (IRadarDataSet iRadarDataSet : radarData.g()) {
            if (iRadarDataSet.isVisible()) {
                n(canvas, iRadarDataSet, iJ0);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void c(Canvas canvas) {
        q(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void d(Canvas canvas, Highlight[] highlightArr) {
        RadarChartRenderer radarChartRenderer = this;
        float sliceAngle = radarChartRenderer.f68744i.getSliceAngle();
        float factor = radarChartRenderer.f68744i.getFactor();
        MPPointF centerOffsets = radarChartRenderer.f68744i.getCenterOffsets();
        MPPointF mPPointFC = MPPointF.c(0.0f, 0.0f);
        RadarData radarData = (RadarData) radarChartRenderer.f68744i.getData();
        int length = highlightArr.length;
        int i3 = 0;
        while (i3 < length) {
            Highlight highlight = highlightArr[i3];
            IRadarDataSet iRadarDataSet = (IRadarDataSet) radarData.e(highlight.d());
            if (iRadarDataSet != null && iRadarDataSet.M0()) {
                RadarEntry radarEntry = (RadarEntry) iRadarDataSet.r((int) highlight.h());
                if (radarChartRenderer.h(radarEntry, iRadarDataSet)) {
                    Utils.r(centerOffsets, (radarEntry.e() - radarChartRenderer.f68744i.getYChartMin()) * factor * radarChartRenderer.f68695b.b(), (highlight.h() * sliceAngle * radarChartRenderer.f68695b.a()) + radarChartRenderer.f68744i.getRotationAngle(), mPPointFC);
                    highlight.m(mPPointFC.f68793c, mPPointFC.f68794d);
                    radarChartRenderer.j(canvas, mPPointFC.f68793c, mPPointFC.f68794d, iRadarDataSet);
                    if (iRadarDataSet.b0() && !Float.isNaN(mPPointFC.f68793c) && !Float.isNaN(mPPointFC.f68794d)) {
                        int iF = iRadarDataSet.f();
                        if (iF == 1122867) {
                            iF = iRadarDataSet.p0(0);
                        }
                        if (iRadarDataSet.V() < 255) {
                            iF = ColorTemplate.a(iF, iRadarDataSet.V());
                        }
                        radarChartRenderer.o(canvas, mPPointFC, iRadarDataSet.U(), iRadarDataSet.m(), iRadarDataSet.a(), iF, iRadarDataSet.O());
                    }
                }
            }
            i3++;
            radarChartRenderer = this;
        }
        MPPointF.f(centerOffsets);
        MPPointF.f(mPPointFC);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void e(Canvas canvas) {
        float f3;
        IRadarDataSet iRadarDataSet;
        int i3;
        RadarEntry radarEntry;
        float f4;
        MPPointF mPPointF;
        ValueFormatter valueFormatter;
        RadarChartRenderer radarChartRenderer = this;
        float fA = radarChartRenderer.f68695b.a();
        float fB = radarChartRenderer.f68695b.b();
        float sliceAngle = radarChartRenderer.f68744i.getSliceAngle();
        float factor = radarChartRenderer.f68744i.getFactor();
        MPPointF centerOffsets = radarChartRenderer.f68744i.getCenterOffsets();
        MPPointF mPPointFC = MPPointF.c(0.0f, 0.0f);
        MPPointF mPPointFC2 = MPPointF.c(0.0f, 0.0f);
        float fE = Utils.e(5.0f);
        int i4 = 0;
        while (i4 < ((RadarData) radarChartRenderer.f68744i.getData()).f()) {
            IRadarDataSet iRadarDataSet2 = (IRadarDataSet) ((RadarData) radarChartRenderer.f68744i.getData()).e(i4);
            if (radarChartRenderer.i(iRadarDataSet2)) {
                radarChartRenderer.a(iRadarDataSet2);
                ValueFormatter valueFormatterP = iRadarDataSet2.p();
                MPPointF mPPointFD = MPPointF.d(iRadarDataSet2.K0());
                mPPointFD.f68793c = Utils.e(mPPointFD.f68793c);
                mPPointFD.f68794d = Utils.e(mPPointFD.f68794d);
                int i5 = 0;
                while (i5 < iRadarDataSet2.J0()) {
                    RadarEntry radarEntry2 = (RadarEntry) iRadarDataSet2.r(i5);
                    MPPointF mPPointF2 = mPPointFD;
                    float f5 = i5 * sliceAngle * fA;
                    Utils.r(centerOffsets, (radarEntry2.e() - radarChartRenderer.f68744i.getYChartMin()) * factor * fB, f5 + radarChartRenderer.f68744i.getRotationAngle(), mPPointFC);
                    if (iRadarDataSet2.I()) {
                        ValueFormatter valueFormatter2 = valueFormatterP;
                        i3 = i5;
                        radarEntry = radarEntry2;
                        f4 = fA;
                        mPPointF = mPPointF2;
                        radarChartRenderer = this;
                        valueFormatter = valueFormatter2;
                        iRadarDataSet = iRadarDataSet2;
                        radarChartRenderer.p(canvas, valueFormatter2.i(radarEntry2), mPPointFC.f68793c, mPPointFC.f68794d - fE, iRadarDataSet2.x(i5));
                    } else {
                        iRadarDataSet = iRadarDataSet2;
                        i3 = i5;
                        radarEntry = radarEntry2;
                        f4 = fA;
                        mPPointF = mPPointF2;
                        valueFormatter = valueFormatterP;
                    }
                    if (radarEntry.d() != null && iRadarDataSet.c0()) {
                        Drawable drawableD = radarEntry.d();
                        Utils.r(centerOffsets, (radarEntry.e() * factor * fB) + mPPointF.f68794d, f5 + radarChartRenderer.f68744i.getRotationAngle(), mPPointFC2);
                        float f6 = mPPointFC2.f68794d + mPPointF.f68793c;
                        mPPointFC2.f68794d = f6;
                        Utils.f(canvas, drawableD, (int) mPPointFC2.f68793c, (int) f6, drawableD.getIntrinsicWidth(), drawableD.getIntrinsicHeight());
                    }
                    i5 = i3 + 1;
                    mPPointFD = mPPointF;
                    iRadarDataSet2 = iRadarDataSet;
                    valueFormatterP = valueFormatter;
                    fA = f4;
                }
                f3 = fA;
                MPPointF.f(mPPointFD);
            } else {
                f3 = fA;
            }
            i4++;
            fA = f3;
        }
        MPPointF.f(centerOffsets);
        MPPointF.f(mPPointFC);
        MPPointF.f(mPPointFC2);
    }

    protected void n(Canvas canvas, IRadarDataSet iRadarDataSet, int i3) {
        float fA = this.f68695b.a();
        float fB = this.f68695b.b();
        float sliceAngle = this.f68744i.getSliceAngle();
        float factor = this.f68744i.getFactor();
        MPPointF centerOffsets = this.f68744i.getCenterOffsets();
        MPPointF mPPointFC = MPPointF.c(0.0f, 0.0f);
        Path path = this.f68747l;
        path.reset();
        boolean z2 = false;
        for (int i4 = 0; i4 < iRadarDataSet.J0(); i4++) {
            this.f68696c.setColor(iRadarDataSet.p0(i4));
            Utils.r(centerOffsets, (((RadarEntry) iRadarDataSet.r(i4)).e() - this.f68744i.getYChartMin()) * factor * fB, (i4 * sliceAngle * fA) + this.f68744i.getRotationAngle(), mPPointFC);
            if (!Float.isNaN(mPPointFC.f68793c)) {
                if (z2) {
                    path.lineTo(mPPointFC.f68793c, mPPointFC.f68794d);
                } else {
                    path.moveTo(mPPointFC.f68793c, mPPointFC.f68794d);
                    z2 = true;
                }
            }
        }
        if (iRadarDataSet.J0() > i3) {
            path.lineTo(centerOffsets.f68793c, centerOffsets.f68794d);
        }
        path.close();
        if (iRadarDataSet.m0()) {
            Drawable drawableO = iRadarDataSet.o();
            if (drawableO != null) {
                m(canvas, path, drawableO);
            } else {
                l(canvas, path, iRadarDataSet.S(), iRadarDataSet.b());
            }
        }
        this.f68696c.setStrokeWidth(iRadarDataSet.g());
        this.f68696c.setStyle(Paint.Style.STROKE);
        if (!iRadarDataSet.m0() || iRadarDataSet.b() < 255) {
            canvas.drawPath(path, this.f68696c);
        }
        MPPointF.f(centerOffsets);
        MPPointF.f(mPPointFC);
    }

    public void o(Canvas canvas, MPPointF mPPointF, float f3, float f4, int i3, int i4, float f5) {
        canvas.save();
        float fE = Utils.e(f4);
        float fE2 = Utils.e(f3);
        if (i3 != 1122867) {
            Path path = this.f68748m;
            path.reset();
            path.addCircle(mPPointF.f68793c, mPPointF.f68794d, fE, Path.Direction.CW);
            if (fE2 > 0.0f) {
                path.addCircle(mPPointF.f68793c, mPPointF.f68794d, fE2, Path.Direction.CCW);
            }
            this.f68746k.setColor(i3);
            this.f68746k.setStyle(Paint.Style.FILL);
            canvas.drawPath(path, this.f68746k);
        }
        if (i4 != 1122867) {
            this.f68746k.setColor(i4);
            this.f68746k.setStyle(Paint.Style.STROKE);
            this.f68746k.setStrokeWidth(Utils.e(f5));
            canvas.drawCircle(mPPointF.f68793c, mPPointF.f68794d, fE, this.f68746k);
        }
        canvas.restore();
    }

    public void p(Canvas canvas, String str, float f3, float f4, int i3) {
        this.f68699f.setColor(i3);
        canvas.drawText(str, f3, f4, this.f68699f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void q(Canvas canvas) {
        float sliceAngle = this.f68744i.getSliceAngle();
        float factor = this.f68744i.getFactor();
        float rotationAngle = this.f68744i.getRotationAngle();
        MPPointF centerOffsets = this.f68744i.getCenterOffsets();
        this.f68745j.setStrokeWidth(this.f68744i.getWebLineWidth());
        this.f68745j.setColor(this.f68744i.getWebColor());
        this.f68745j.setAlpha(this.f68744i.getWebAlpha());
        int skipWebLineCount = this.f68744i.getSkipWebLineCount() + 1;
        int iJ0 = ((IRadarDataSet) ((RadarData) this.f68744i.getData()).l()).J0();
        MPPointF mPPointFC = MPPointF.c(0.0f, 0.0f);
        for (int i3 = 0; i3 < iJ0; i3 += skipWebLineCount) {
            Utils.r(centerOffsets, this.f68744i.getYRange() * factor, (i3 * sliceAngle) + rotationAngle, mPPointFC);
            canvas.drawLine(centerOffsets.f68793c, centerOffsets.f68794d, mPPointFC.f68793c, mPPointFC.f68794d, this.f68745j);
        }
        MPPointF.f(mPPointFC);
        this.f68745j.setStrokeWidth(this.f68744i.getWebLineWidthInner());
        this.f68745j.setColor(this.f68744i.getWebColorInner());
        this.f68745j.setAlpha(this.f68744i.getWebAlpha());
        int i4 = this.f68744i.getYAxis().f68382n;
        MPPointF mPPointFC2 = MPPointF.c(0.0f, 0.0f);
        MPPointF mPPointFC3 = MPPointF.c(0.0f, 0.0f);
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = 0;
            while (i6 < ((RadarData) this.f68744i.getData()).h()) {
                float yChartMin = (this.f68744i.getYAxis().f68380l[i5] - this.f68744i.getYChartMin()) * factor;
                Utils.r(centerOffsets, yChartMin, (i6 * sliceAngle) + rotationAngle, mPPointFC2);
                i6++;
                Utils.r(centerOffsets, yChartMin, (i6 * sliceAngle) + rotationAngle, mPPointFC3);
                canvas.drawLine(mPPointFC2.f68793c, mPPointFC2.f68794d, mPPointFC3.f68793c, mPPointFC3.f68794d, this.f68745j);
            }
        }
        MPPointF.f(mPPointFC2);
        MPPointF.f(mPPointFC3);
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    public void f() {
    }
}
