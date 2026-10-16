package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class XAxisRendererHorizontalBarChart extends XAxisRenderer {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected BarChart f68760p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected Path f68761q;

    public XAxisRendererHorizontalBarChart(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer transformer, BarChart barChart) {
        super(viewPortHandler, xAxis, transformer);
        this.f68761q = new Path();
        this.f68760p = barChart;
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer, com.github.mikephil.charting.renderer.AxisRenderer
    public void a(float f3, float f4, boolean z2) {
        float f5;
        double d3;
        if (this.f68749a.k() > 10.0f && !this.f68749a.w()) {
            MPPointD mPPointDG = this.f68665c.g(this.f68749a.h(), this.f68749a.f());
            MPPointD mPPointDG2 = this.f68665c.g(this.f68749a.h(), this.f68749a.j());
            if (z2) {
                f5 = (float) mPPointDG2.f68790d;
                d3 = mPPointDG.f68790d;
            } else {
                f5 = (float) mPPointDG.f68790d;
                d3 = mPPointDG2.f68790d;
            }
            float f6 = (float) d3;
            MPPointD.c(mPPointDG);
            MPPointD.c(mPPointDG2);
            f3 = f5;
            f4 = f6;
        }
        b(f3, f4);
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    protected void d() {
        this.f68667e.setTypeface(this.f68752h.c());
        this.f68667e.setTextSize(this.f68752h.b());
        FSize fSizeB = Utils.b(this.f68667e, this.f68752h.w());
        float fD = (int) (fSizeB.f68786c + (this.f68752h.d() * 3.5f));
        float f3 = fSizeB.f68787d;
        FSize fSizeT = Utils.t(fSizeB.f68786c, f3, this.f68752h.V());
        this.f68752h.J = Math.round(fD);
        this.f68752h.K = Math.round(f3);
        XAxis xAxis = this.f68752h;
        xAxis.L = (int) (fSizeT.f68786c + (xAxis.d() * 3.5f));
        this.f68752h.M = Math.round(fSizeT.f68787d);
        FSize.c(fSizeT);
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    protected void e(Canvas canvas, float f3, float f4, Path path) {
        path.moveTo(this.f68749a.i(), f4);
        path.lineTo(this.f68749a.h(), f4);
        canvas.drawPath(path, this.f68666d);
        path.reset();
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    protected void g(Canvas canvas, float f3, MPPointF mPPointF) {
        Canvas canvas2;
        float f4;
        MPPointF mPPointF2;
        float fV = this.f68752h.V();
        boolean zY = this.f68752h.y();
        int i3 = this.f68752h.f68382n * 2;
        float[] fArr = new float[i3];
        for (int i4 = 0; i4 < i3; i4 += 2) {
            if (zY) {
                fArr[i4 + 1] = this.f68752h.f68381m[i4 / 2];
            } else {
                fArr[i4 + 1] = this.f68752h.f68380l[i4 / 2];
            }
        }
        this.f68665c.k(fArr);
        int i5 = 0;
        while (i5 < i3) {
            float f5 = fArr[i5 + 1];
            if (this.f68749a.D(f5)) {
                ValueFormatter valueFormatterX = this.f68752h.x();
                XAxis xAxis = this.f68752h;
                String strA = valueFormatterX.a(xAxis.f68380l[i5 / 2], xAxis);
                canvas2 = canvas;
                f4 = f3;
                mPPointF2 = mPPointF;
                f(canvas2, strA, f4, f5, mPPointF2, fV);
            } else {
                canvas2 = canvas;
                f4 = f3;
                mPPointF2 = mPPointF;
            }
            i5 += 2;
            canvas = canvas2;
            f3 = f4;
            mPPointF = mPPointF2;
        }
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public RectF h() {
        this.f68755k.set(this.f68749a.o());
        this.f68755k.inset(0.0f, -this.f68664b.t());
        return this.f68755k;
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public void i(Canvas canvas) {
        if (this.f68752h.f() && this.f68752h.C()) {
            float fD = this.f68752h.d();
            this.f68667e.setTypeface(this.f68752h.c());
            this.f68667e.setTextSize(this.f68752h.b());
            this.f68667e.setColor(this.f68752h.a());
            MPPointF mPPointFC = MPPointF.c(0.0f, 0.0f);
            if (this.f68752h.W() == XAxis.XAxisPosition.TOP) {
                mPPointFC.f68793c = 0.0f;
                mPPointFC.f68794d = 0.5f;
                g(canvas, this.f68749a.i() + fD, mPPointFC);
            } else if (this.f68752h.W() == XAxis.XAxisPosition.TOP_INSIDE) {
                mPPointFC.f68793c = 1.0f;
                mPPointFC.f68794d = 0.5f;
                g(canvas, this.f68749a.i() - fD, mPPointFC);
            } else if (this.f68752h.W() == XAxis.XAxisPosition.BOTTOM) {
                mPPointFC.f68793c = 1.0f;
                mPPointFC.f68794d = 0.5f;
                g(canvas, this.f68749a.h() - fD, mPPointFC);
            } else if (this.f68752h.W() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                mPPointFC.f68793c = 1.0f;
                mPPointFC.f68794d = 0.5f;
                g(canvas, this.f68749a.h() + fD, mPPointFC);
            } else {
                mPPointFC.f68793c = 0.0f;
                mPPointFC.f68794d = 0.5f;
                g(canvas, this.f68749a.i() + fD, mPPointFC);
                mPPointFC.f68793c = 1.0f;
                mPPointFC.f68794d = 0.5f;
                g(canvas, this.f68749a.h() - fD, mPPointFC);
            }
            MPPointF.f(mPPointFC);
        }
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public void j(Canvas canvas) {
        Canvas canvas2;
        if (this.f68752h.z() && this.f68752h.f()) {
            this.f68668f.setColor(this.f68752h.m());
            this.f68668f.setStrokeWidth(this.f68752h.o());
            if (this.f68752h.W() == XAxis.XAxisPosition.TOP || this.f68752h.W() == XAxis.XAxisPosition.TOP_INSIDE || this.f68752h.W() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas2 = canvas;
                canvas2.drawLine(this.f68749a.i(), this.f68749a.j(), this.f68749a.i(), this.f68749a.f(), this.f68668f);
            } else {
                canvas2 = canvas;
            }
            if (this.f68752h.W() == XAxis.XAxisPosition.BOTTOM || this.f68752h.W() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.f68752h.W() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas2.drawLine(this.f68749a.h(), this.f68749a.j(), this.f68749a.h(), this.f68749a.f(), this.f68668f);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.XAxisRenderer
    public void n(Canvas canvas) {
        List listV = this.f68752h.v();
        if (listV == null || listV.size() <= 0) {
            return;
        }
        float[] fArr = this.f68756l;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        Path path = this.f68761q;
        path.reset();
        for (int i3 = 0; i3 < listV.size(); i3++) {
            LimitLine limitLine = (LimitLine) listV.get(i3);
            if (limitLine.f()) {
                int iSave = canvas.save();
                this.f68757m.set(this.f68749a.o());
                this.f68757m.inset(0.0f, -limitLine.q());
                canvas.clipRect(this.f68757m);
                this.f68669g.setStyle(Paint.Style.STROKE);
                this.f68669g.setColor(limitLine.p());
                this.f68669g.setStrokeWidth(limitLine.q());
                this.f68669g.setPathEffect(limitLine.l());
                fArr[1] = limitLine.o();
                this.f68665c.k(fArr);
                path.moveTo(this.f68749a.h(), fArr[1]);
                path.lineTo(this.f68749a.i(), fArr[1]);
                canvas.drawPath(path, this.f68669g);
                path.reset();
                String strM = limitLine.m();
                if (strM != null && !strM.equals("")) {
                    this.f68669g.setStyle(limitLine.r());
                    this.f68669g.setPathEffect(null);
                    this.f68669g.setColor(limitLine.a());
                    this.f68669g.setStrokeWidth(0.5f);
                    this.f68669g.setTextSize(limitLine.b());
                    float fA = Utils.a(this.f68669g, strM);
                    float fE = Utils.e(4.0f) + limitLine.d();
                    float fQ = limitLine.q() + fA + limitLine.e();
                    LimitLine.LimitLabelPosition limitLabelPositionN = limitLine.n();
                    if (limitLabelPositionN == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                        this.f68669g.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(strM, this.f68749a.i() - fE, (fArr[1] - fQ) + fA, this.f68669g);
                    } else if (limitLabelPositionN == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                        this.f68669g.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(strM, this.f68749a.i() - fE, fArr[1] + fQ, this.f68669g);
                    } else if (limitLabelPositionN == LimitLine.LimitLabelPosition.LEFT_TOP) {
                        this.f68669g.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(strM, this.f68749a.h() + fE, (fArr[1] - fQ) + fA, this.f68669g);
                    } else {
                        this.f68669g.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(strM, this.f68749a.G() + fE, fArr[1] + fQ, this.f68669g);
                    }
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
