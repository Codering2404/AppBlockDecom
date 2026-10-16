package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.buffer.BarBuffer;
import com.github.mikephil.charting.buffer.HorizontalBarBuffer;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.ChartInterface;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class HorizontalBarChartRenderer extends BarChartRenderer {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private RectF f68700n;

    public HorizontalBarChartRenderer(BarDataProvider barDataProvider, ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(barDataProvider, chartAnimator, viewPortHandler);
        this.f68700n = new RectF();
        this.f68699f.setTextAlign(Paint.Align.LEFT);
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void e(Canvas canvas) {
        List list;
        float f3;
        MPPointF mPPointF;
        boolean z2;
        int i3;
        float[] fArr;
        float f4;
        int i4;
        int i5;
        float f5;
        BarEntry barEntry;
        boolean z3;
        int i6;
        float f6;
        int i7;
        List list2;
        float f7;
        BarBuffer barBuffer;
        MPPointF mPPointF2;
        BarChartRenderer barChartRenderer = this;
        if (barChartRenderer.g(barChartRenderer.f68670h)) {
            List listG = barChartRenderer.f68670h.getBarData().g();
            float fE = Utils.e(5.0f);
            boolean zB = barChartRenderer.f68670h.b();
            int i8 = 0;
            while (i8 < barChartRenderer.f68670h.getBarData().f()) {
                IBarDataSet iBarDataSet = (IBarDataSet) listG.get(i8);
                if (barChartRenderer.i(iBarDataSet)) {
                    boolean zD = barChartRenderer.f68670h.d(iBarDataSet.K());
                    barChartRenderer.a(iBarDataSet);
                    float f8 = 2.0f;
                    float fA = Utils.a(barChartRenderer.f68699f, "10") / 2.0f;
                    ValueFormatter valueFormatterP = iBarDataSet.p();
                    BarBuffer barBuffer2 = barChartRenderer.f68672j[i8];
                    float fB = barChartRenderer.f68695b.b();
                    MPPointF mPPointFD = MPPointF.d(iBarDataSet.K0());
                    mPPointFD.f68793c = Utils.e(mPPointFD.f68793c);
                    mPPointFD.f68794d = Utils.e(mPPointFD.f68794d);
                    if (iBarDataSet.F0()) {
                        list = listG;
                        f3 = fE;
                        mPPointF = mPPointFD;
                        Transformer transformerA = barChartRenderer.f68670h.a(iBarDataSet.K());
                        int i9 = 0;
                        int length = 0;
                        while (i9 < iBarDataSet.J0() * barChartRenderer.f68695b.a()) {
                            BarEntry barEntry2 = (BarEntry) iBarDataSet.r(i9);
                            int iX = iBarDataSet.x(i9);
                            float[] fArrO = barEntry2.o();
                            if (fArrO == null) {
                                int i10 = length + 1;
                                if (!barChartRenderer.f68749a.B(barBuffer2.f68280b[i10])) {
                                    break;
                                }
                                if (barChartRenderer.f68749a.C(barBuffer2.f68280b[length]) && barChartRenderer.f68749a.y(barBuffer2.f68280b[i10])) {
                                    String strB = valueFormatterP.b(barEntry2);
                                    float fD = Utils.d(barChartRenderer.f68699f, strB);
                                    float f9 = zB ? f3 : -(fD + f3);
                                    float f10 = zB ? -(fD + f3) : f3;
                                    if (zD) {
                                        f9 = (-f9) - fD;
                                        f10 = (-f10) - fD;
                                    }
                                    float f11 = f9;
                                    float f12 = f10;
                                    if (iBarDataSet.I()) {
                                        barEntry = barEntry2;
                                        z2 = zB;
                                        fArr = fArrO;
                                        k(canvas, strB, barBuffer2.f68280b[length + 2] + (barEntry2.e() >= 0.0f ? f11 : f12), barBuffer2.f68280b[i10] + fA, iX);
                                    } else {
                                        barEntry = barEntry2;
                                        z2 = zB;
                                        fArr = fArrO;
                                    }
                                    if (barEntry.d() == null || !iBarDataSet.c0()) {
                                        i3 = i8;
                                    } else {
                                        Drawable drawableD = barEntry.d();
                                        float f13 = barBuffer2.f68280b[length + 2];
                                        if (barEntry.e() < 0.0f) {
                                            f11 = f12;
                                        }
                                        float f14 = barBuffer2.f68280b[i10];
                                        i3 = i8;
                                        Utils.f(canvas, drawableD, (int) (f13 + f11 + mPPointF.f68793c), (int) (f14 + mPPointF.f68794d), drawableD.getIntrinsicWidth(), drawableD.getIntrinsicHeight());
                                    }
                                }
                            } else {
                                BarEntry barEntry3 = barEntry2;
                                z2 = zB;
                                i3 = i8;
                                BarChartRenderer barChartRenderer2 = barChartRenderer;
                                fArr = fArrO;
                                int length2 = fArr.length * 2;
                                float[] fArr2 = new float[length2];
                                float f15 = -barEntry3.l();
                                float f16 = 0.0f;
                                int i11 = 0;
                                int i12 = 0;
                                while (i11 < length2) {
                                    float f17 = fArr[i12];
                                    if (f17 == 0.0f && (f16 == 0.0f || f15 == 0.0f)) {
                                        float f18 = f15;
                                        f15 = f17;
                                        f5 = f18;
                                    } else if (f17 >= 0.0f) {
                                        f16 += f17;
                                        f5 = f15;
                                        f15 = f16;
                                    } else {
                                        f5 = f15 - f17;
                                    }
                                    fArr2[i11] = f15 * fB;
                                    i11 += 2;
                                    i12++;
                                    f15 = f5;
                                }
                                transformerA.k(fArr2);
                                int i13 = 0;
                                while (i13 < length2) {
                                    float f19 = fArr[i13 / 2];
                                    BarEntry barEntry4 = barEntry3;
                                    int i14 = i13;
                                    String strC = valueFormatterP.c(f19, barEntry4);
                                    int i15 = length2;
                                    float fD2 = Utils.d(barChartRenderer2.f68699f, strC);
                                    float f20 = z2 ? f3 : -(fD2 + f3);
                                    float[] fArr3 = fArr2;
                                    float f21 = z2 ? -(fD2 + f3) : f3;
                                    if (zD) {
                                        f20 = (-f20) - fD2;
                                        f21 = (-f21) - fD2;
                                    }
                                    boolean z4 = (f19 == 0.0f && f15 == 0.0f && f16 > 0.0f) || f19 < 0.0f;
                                    float f22 = fArr3[i14];
                                    if (z4) {
                                        f20 = f21;
                                    }
                                    float f23 = f22 + f20;
                                    float[] fArr4 = barBuffer2.f68280b;
                                    float f24 = (fArr4[length + 1] + fArr4[length + 3]) / 2.0f;
                                    if (!barChartRenderer2.f68749a.B(f24)) {
                                        break;
                                    }
                                    if (barChartRenderer2.f68749a.C(f23) && barChartRenderer2.f68749a.y(f24)) {
                                        if (iBarDataSet.I()) {
                                            float f25 = f24 + fA;
                                            f4 = f24;
                                            BarChartRenderer barChartRenderer3 = barChartRenderer2;
                                            i4 = i14;
                                            barEntry3 = barEntry4;
                                            barChartRenderer3.k(canvas, strC, f23, f25, iX);
                                        } else {
                                            f4 = f24;
                                            i4 = i14;
                                            barEntry3 = barEntry4;
                                        }
                                        i5 = iX;
                                        if (barEntry3.d() != null && iBarDataSet.c0()) {
                                            Drawable drawableD2 = barEntry3.d();
                                            Utils.f(canvas, drawableD2, (int) (f23 + mPPointF.f68793c), (int) (f4 + mPPointF.f68794d), drawableD2.getIntrinsicWidth(), drawableD2.getIntrinsicHeight());
                                        }
                                    } else {
                                        i5 = iX;
                                        i4 = i14;
                                        barEntry3 = barEntry4;
                                    }
                                    i13 = i4 + 2;
                                    barChartRenderer2 = this;
                                    length2 = i15;
                                    fArr2 = fArr3;
                                    iX = i5;
                                }
                            }
                            length = fArr == null ? length + 4 : length + (fArr.length * 4);
                            i9++;
                            barChartRenderer = this;
                            i8 = i3;
                            zB = z2;
                        }
                    } else {
                        int i16 = 0;
                        while (i16 < barBuffer2.f68280b.length * barChartRenderer.f68695b.a()) {
                            float[] fArr5 = barBuffer2.f68280b;
                            int i17 = i16 + 1;
                            float f26 = fArr5[i17];
                            float f27 = (fArr5[i16 + 3] + f26) / f8;
                            if (!barChartRenderer.f68749a.B(f26)) {
                                break;
                            }
                            if (barChartRenderer.f68749a.C(barBuffer2.f68280b[i16]) && barChartRenderer.f68749a.y(barBuffer2.f68280b[i17])) {
                                BarEntry barEntry5 = (BarEntry) iBarDataSet.r(i16 / 4);
                                float fE2 = barEntry5.e();
                                MPPointF mPPointF3 = mPPointFD;
                                String strB2 = valueFormatterP.b(barEntry5);
                                float fD3 = Utils.d(barChartRenderer.f68699f, strB2);
                                f6 = f8;
                                float f28 = zB ? fE : -(fD3 + fE);
                                float f29 = zB ? -(fD3 + fE) : fE;
                                if (zD) {
                                    f28 = (-f28) - fD3;
                                    f29 = (-f29) - fD3;
                                }
                                float f30 = f28;
                                float f31 = f29;
                                if (iBarDataSet.I()) {
                                    i7 = i16;
                                    list2 = listG;
                                    barBuffer = barBuffer2;
                                    f7 = fE;
                                    mPPointF2 = mPPointF3;
                                    barChartRenderer = this;
                                    barChartRenderer.k(canvas, strB2, barBuffer2.f68280b[i16 + 2] + (fE2 >= 0.0f ? f30 : f31), f27 + fA, iBarDataSet.x(i16 / 2));
                                } else {
                                    barChartRenderer = this;
                                    i7 = i16;
                                    list2 = listG;
                                    f7 = fE;
                                    barBuffer = barBuffer2;
                                    mPPointF2 = mPPointF3;
                                }
                                if (barEntry5.d() != null && iBarDataSet.c0()) {
                                    Drawable drawableD3 = barEntry5.d();
                                    float f32 = barBuffer.f68280b[i7 + 2];
                                    if (fE2 >= 0.0f) {
                                        f31 = f30;
                                    }
                                    Utils.f(canvas, drawableD3, (int) (f32 + f31 + mPPointF2.f68793c), (int) (f27 + mPPointF2.f68794d), drawableD3.getIntrinsicWidth(), drawableD3.getIntrinsicHeight());
                                }
                            } else {
                                i7 = i16;
                                list2 = listG;
                                f7 = fE;
                                f6 = f8;
                                barBuffer = barBuffer2;
                                mPPointF2 = mPPointFD;
                            }
                            i16 = i7 + 4;
                            barBuffer2 = barBuffer;
                            mPPointFD = mPPointF2;
                            f8 = f6;
                            fE = f7;
                            listG = list2;
                        }
                        list = listG;
                        f3 = fE;
                        mPPointF = mPPointFD;
                    }
                    z3 = zB;
                    i6 = i8;
                    MPPointF.f(mPPointF);
                } else {
                    list = listG;
                    f3 = fE;
                    z3 = zB;
                    i6 = i8;
                }
                i8 = i6 + 1;
                barChartRenderer = this;
                fE = f3;
                listG = list;
                zB = z3;
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer, com.github.mikephil.charting.renderer.DataRenderer
    public void f() {
        BarData barData = this.f68670h.getBarData();
        this.f68672j = new HorizontalBarBuffer[barData.f()];
        for (int i3 = 0; i3 < this.f68672j.length; i3++) {
            IBarDataSet iBarDataSet = (IBarDataSet) barData.e(i3);
            this.f68672j[i3] = new HorizontalBarBuffer(iBarDataSet.J0() * 4 * (iBarDataSet.F0() ? iBarDataSet.A() : 1), barData.f(), iBarDataSet.F0());
        }
    }

    @Override // com.github.mikephil.charting.renderer.DataRenderer
    protected boolean g(ChartInterface chartInterface) {
        return ((float) chartInterface.getData().h()) < ((float) chartInterface.getMaxVisibleCount()) * this.f68749a.r();
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void j(Canvas canvas, IBarDataSet iBarDataSet, int i3) {
        Transformer transformerA = this.f68670h.a(iBarDataSet.K());
        this.f68674l.setColor(iBarDataSet.h());
        this.f68674l.setStrokeWidth(Utils.e(iBarDataSet.d0()));
        int i4 = 0;
        boolean z2 = iBarDataSet.d0() > 0.0f;
        float fA = this.f68695b.a();
        float fB = this.f68695b.b();
        if (this.f68670h.e()) {
            this.f68673k.setColor(iBarDataSet.s0());
            float fT = this.f68670h.getBarData().t() / 2.0f;
            int iMin = Math.min((int) Math.ceil(iBarDataSet.J0() * fA), iBarDataSet.J0());
            for (int i5 = 0; i5 < iMin; i5++) {
                float fH = ((BarEntry) iBarDataSet.r(i5)).h();
                RectF rectF = this.f68700n;
                rectF.top = fH - fT;
                rectF.bottom = fH + fT;
                transformerA.p(rectF);
                if (this.f68749a.B(this.f68700n.bottom)) {
                    if (!this.f68749a.y(this.f68700n.top)) {
                        break;
                    }
                    this.f68700n.left = this.f68749a.h();
                    this.f68700n.right = this.f68749a.i();
                    canvas.drawRect(this.f68700n, this.f68673k);
                }
            }
        }
        Canvas canvas2 = canvas;
        BarBuffer barBuffer = this.f68672j[i3];
        barBuffer.b(fA, fB);
        barBuffer.g(i3);
        barBuffer.h(this.f68670h.d(iBarDataSet.K()));
        barBuffer.f(this.f68670h.getBarData().t());
        barBuffer.e(iBarDataSet);
        transformerA.k(barBuffer.f68280b);
        boolean z3 = iBarDataSet.z().size() == 1;
        if (z3) {
            this.f68696c.setColor(iBarDataSet.M());
        }
        while (i4 < barBuffer.c()) {
            int i6 = i4 + 3;
            if (!this.f68749a.B(barBuffer.f68280b[i6])) {
                return;
            }
            int i7 = i4 + 1;
            if (this.f68749a.y(barBuffer.f68280b[i7])) {
                if (!z3) {
                    this.f68696c.setColor(iBarDataSet.p0(i4 / 4));
                }
                float[] fArr = barBuffer.f68280b;
                int i8 = i4 + 2;
                canvas2.drawRect(fArr[i4], fArr[i7], fArr[i8], fArr[i6], this.f68696c);
                if (z2) {
                    float[] fArr2 = barBuffer.f68280b;
                    canvas.drawRect(fArr2[i4], fArr2[i7], fArr2[i8], fArr2[i6], this.f68674l);
                }
            }
            i4 += 4;
            canvas2 = canvas;
        }
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    public void k(Canvas canvas, String str, float f3, float f4, int i3) {
        this.f68699f.setColor(i3);
        canvas.drawText(str, f3, f4, this.f68699f);
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void l(float f3, float f4, float f5, float f6, Transformer transformer) {
        this.f68671i.set(f4, f3 - f6, f5, f3 + f6);
        transformer.o(this.f68671i, this.f68695b.b());
    }

    @Override // com.github.mikephil.charting.renderer.BarChartRenderer
    protected void m(Highlight highlight, RectF rectF) {
        highlight.m(rectF.centerY(), rectF.right);
    }
}
