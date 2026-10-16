package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.MPPointD;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class YAxisRendererHorizontalBarChart extends YAxisRenderer {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected Path f68773r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected Path f68774s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected float[] f68775t;

    public YAxisRendererHorizontalBarChart(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer transformer) {
        super(viewPortHandler, yAxis, transformer);
        this.f68773r = new Path();
        this.f68774s = new Path();
        this.f68775t = new float[4];
        this.f68669g.setTextAlign(Paint.Align.LEFT);
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void a(float f3, float f4, boolean z2) {
        float f5;
        double d3;
        if (this.f68749a.g() > 10.0f && !this.f68749a.v()) {
            MPPointD mPPointDG = this.f68665c.g(this.f68749a.h(), this.f68749a.j());
            MPPointD mPPointDG2 = this.f68665c.g(this.f68749a.i(), this.f68749a.j());
            if (z2) {
                f5 = (float) mPPointDG2.f68789c;
                d3 = mPPointDG.f68789c;
            } else {
                f5 = (float) mPPointDG.f68789c;
                d3 = mPPointDG2.f68789c;
            }
            float f6 = (float) d3;
            MPPointD.c(mPPointDG);
            MPPointD.c(mPPointDG2);
            f3 = f5;
            f4 = f6;
        }
        b(f3, f4);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected void d(Canvas canvas, float f3, float[] fArr, float f4) {
        this.f68667e.setTypeface(this.f68763h.c());
        this.f68667e.setTextSize(this.f68763h.b());
        this.f68667e.setColor(this.f68763h.a());
        int i3 = this.f68763h.g0() ? this.f68763h.f68382n : this.f68763h.f68382n - 1;
        for (int i4 = !this.f68763h.f0() ? 1 : 0; i4 < i3; i4++) {
            canvas.drawText(this.f68763h.p(i4), fArr[i4 * 2], f3 - f4, this.f68667e);
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected void e(Canvas canvas) {
        int iSave = canvas.save();
        this.f68769n.set(this.f68749a.o());
        this.f68769n.inset(-this.f68763h.e0(), 0.0f);
        canvas.clipRect(this.f68772q);
        MPPointD mPPointDE = this.f68665c.e(0.0f, 0.0f);
        this.f68764i.setColor(this.f68763h.d0());
        this.f68764i.setStrokeWidth(this.f68763h.e0());
        Path path = this.f68773r;
        path.reset();
        path.moveTo(((float) mPPointDE.f68789c) - 1.0f, this.f68749a.j());
        path.lineTo(((float) mPPointDE.f68789c) - 1.0f, this.f68749a.f());
        canvas.drawPath(path, this.f68764i);
        canvas.restoreToCount(iSave);
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public RectF f() {
        this.f68766k.set(this.f68749a.o());
        this.f68766k.inset(-this.f68664b.t(), 0.0f);
        return this.f68766k;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected float[] g() {
        int length = this.f68767l.length;
        int i3 = this.f68763h.f68382n;
        if (length != i3 * 2) {
            this.f68767l = new float[i3 * 2];
        }
        float[] fArr = this.f68767l;
        for (int i4 = 0; i4 < fArr.length; i4 += 2) {
            fArr[i4] = this.f68763h.f68380l[i4 / 2];
        }
        this.f68665c.k(fArr);
        return fArr;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    protected Path h(Path path, int i3, float[] fArr) {
        path.moveTo(fArr[i3], this.f68749a.j());
        path.lineTo(fArr[i3], this.f68749a.f());
        return path;
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public void i(Canvas canvas) {
        float f3;
        if (this.f68763h.f() && this.f68763h.C()) {
            float[] fArrG = g();
            this.f68667e.setTypeface(this.f68763h.c());
            this.f68667e.setTextSize(this.f68763h.b());
            this.f68667e.setColor(this.f68763h.a());
            this.f68667e.setTextAlign(Paint.Align.CENTER);
            float fE = Utils.e(2.5f);
            float fA = Utils.a(this.f68667e, "Q");
            YAxis.AxisDependency axisDependencyV = this.f68763h.V();
            YAxis.YAxisLabelPosition yAxisLabelPositionW = this.f68763h.W();
            if (axisDependencyV == YAxis.AxisDependency.LEFT) {
                f3 = (yAxisLabelPositionW == YAxis.YAxisLabelPosition.OUTSIDE_CHART ? this.f68749a.j() : this.f68749a.j()) - fE;
            } else {
                f3 = (yAxisLabelPositionW == YAxis.YAxisLabelPosition.OUTSIDE_CHART ? this.f68749a.f() : this.f68749a.f()) + fA + fE;
            }
            d(canvas, f3, fArrG, this.f68763h.e());
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public void j(Canvas canvas) {
        if (this.f68763h.f() && this.f68763h.z()) {
            this.f68668f.setColor(this.f68763h.m());
            this.f68668f.setStrokeWidth(this.f68763h.o());
            if (this.f68763h.V() == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.f68749a.h(), this.f68749a.j(), this.f68749a.i(), this.f68749a.j(), this.f68668f);
            } else {
                canvas.drawLine(this.f68749a.h(), this.f68749a.f(), this.f68749a.i(), this.f68749a.f(), this.f68668f);
            }
        }
    }

    @Override // com.github.mikephil.charting.renderer.YAxisRenderer
    public void l(Canvas canvas) {
        char c3;
        List listV = this.f68763h.v();
        if (listV == null || listV.size() <= 0) {
            return;
        }
        float[] fArr = this.f68775t;
        char c4 = 0;
        float f3 = 0.0f;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        Path path = this.f68774s;
        path.reset();
        int i3 = 0;
        while (i3 < listV.size()) {
            LimitLine limitLine = (LimitLine) listV.get(i3);
            if (limitLine.f()) {
                int iSave = canvas.save();
                this.f68772q.set(this.f68749a.o());
                this.f68772q.inset(-limitLine.q(), f3);
                canvas.clipRect(this.f68772q);
                fArr[c4] = limitLine.o();
                fArr[2] = limitLine.o();
                this.f68665c.k(fArr);
                fArr[1] = this.f68749a.j();
                fArr[3] = this.f68749a.f();
                path.moveTo(fArr[c4], fArr[1]);
                path.lineTo(fArr[2], fArr[3]);
                this.f68669g.setStyle(Paint.Style.STROKE);
                this.f68669g.setColor(limitLine.p());
                this.f68669g.setPathEffect(limitLine.l());
                this.f68669g.setStrokeWidth(limitLine.q());
                canvas.drawPath(path, this.f68669g);
                path.reset();
                String strM = limitLine.m();
                if (strM == null || strM.equals("")) {
                    c3 = c4;
                } else {
                    this.f68669g.setStyle(limitLine.r());
                    this.f68669g.setPathEffect(null);
                    this.f68669g.setColor(limitLine.a());
                    this.f68669g.setTypeface(limitLine.c());
                    this.f68669g.setStrokeWidth(0.5f);
                    this.f68669g.setTextSize(limitLine.b());
                    float fQ = limitLine.q() + limitLine.d();
                    float fE = Utils.e(2.0f) + limitLine.e();
                    LimitLine.LimitLabelPosition limitLabelPositionN = limitLine.n();
                    c3 = c4;
                    if (limitLabelPositionN == LimitLine.LimitLabelPosition.RIGHT_TOP) {
                        float fA = Utils.a(this.f68669g, strM);
                        this.f68669g.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(strM, fArr[c3] + fQ, this.f68749a.j() + fE + fA, this.f68669g);
                    } else if (limitLabelPositionN == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
                        this.f68669g.setTextAlign(Paint.Align.LEFT);
                        canvas.drawText(strM, fArr[c3] + fQ, this.f68749a.f() - fE, this.f68669g);
                    } else if (limitLabelPositionN == LimitLine.LimitLabelPosition.LEFT_TOP) {
                        this.f68669g.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(strM, fArr[c3] - fQ, this.f68749a.j() + fE + Utils.a(this.f68669g, strM), this.f68669g);
                    } else {
                        this.f68669g.setTextAlign(Paint.Align.RIGHT);
                        canvas.drawText(strM, fArr[c3] - fQ, this.f68749a.f() - fE, this.f68669g);
                    }
                }
                canvas.restoreToCount(iSave);
            } else {
                c3 = c4;
            }
            i3++;
            c4 = c3;
            f3 = 0.0f;
        }
    }
}
