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
public class YAxisRenderer extends AxisRenderer {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected YAxis f68763h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected Paint f68764i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected Path f68765j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected RectF f68766k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected float[] f68767l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected Path f68768m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected RectF f68769n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected Path f68770o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected float[] f68771p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected RectF f68772q;

    public YAxisRenderer(ViewPortHandler viewPortHandler, YAxis yAxis, Transformer transformer) {
        super(viewPortHandler, transformer, yAxis);
        this.f68765j = new Path();
        this.f68766k = new RectF();
        this.f68767l = new float[2];
        this.f68768m = new Path();
        this.f68769n = new RectF();
        this.f68770o = new Path();
        this.f68771p = new float[2];
        this.f68772q = new RectF();
        this.f68763h = yAxis;
        if (this.f68749a != null) {
            this.f68667e.setColor(-16777216);
            this.f68667e.setTextSize(Utils.e(10.0f));
            Paint paint = new Paint(1);
            this.f68764i = paint;
            paint.setColor(-7829368);
            this.f68764i.setStrokeWidth(1.0f);
            this.f68764i.setStyle(Paint.Style.STROKE);
        }
    }

    protected void d(Canvas canvas, float f3, float[] fArr, float f4) {
        int i3 = this.f68763h.g0() ? this.f68763h.f68382n : this.f68763h.f68382n - 1;
        for (int i4 = !this.f68763h.f0() ? 1 : 0; i4 < i3; i4++) {
            canvas.drawText(this.f68763h.p(i4), f3, fArr[(i4 * 2) + 1] + f4, this.f68667e);
        }
    }

    protected void e(Canvas canvas) {
        int iSave = canvas.save();
        this.f68769n.set(this.f68749a.o());
        this.f68769n.inset(0.0f, -this.f68763h.e0());
        canvas.clipRect(this.f68769n);
        MPPointD mPPointDE = this.f68665c.e(0.0f, 0.0f);
        this.f68764i.setColor(this.f68763h.d0());
        this.f68764i.setStrokeWidth(this.f68763h.e0());
        Path path = this.f68768m;
        path.reset();
        path.moveTo(this.f68749a.h(), (float) mPPointDE.f68790d);
        path.lineTo(this.f68749a.i(), (float) mPPointDE.f68790d);
        canvas.drawPath(path, this.f68764i);
        canvas.restoreToCount(iSave);
    }

    public RectF f() {
        this.f68766k.set(this.f68749a.o());
        this.f68766k.inset(0.0f, -this.f68664b.t());
        return this.f68766k;
    }

    protected float[] g() {
        int length = this.f68767l.length;
        int i3 = this.f68763h.f68382n;
        if (length != i3 * 2) {
            this.f68767l = new float[i3 * 2];
        }
        float[] fArr = this.f68767l;
        for (int i4 = 0; i4 < fArr.length; i4 += 2) {
            fArr[i4 + 1] = this.f68763h.f68380l[i4 / 2];
        }
        this.f68665c.k(fArr);
        return fArr;
    }

    protected Path h(Path path, int i3, float[] fArr) {
        int i4 = i3 + 1;
        path.moveTo(this.f68749a.G(), fArr[i4]);
        path.lineTo(this.f68749a.i(), fArr[i4]);
        return path;
    }

    public void i(Canvas canvas) {
        float fI;
        float fI2;
        float f3;
        if (this.f68763h.f() && this.f68763h.C()) {
            float[] fArrG = g();
            this.f68667e.setTypeface(this.f68763h.c());
            this.f68667e.setTextSize(this.f68763h.b());
            this.f68667e.setColor(this.f68763h.a());
            float fD = this.f68763h.d();
            float fA = (Utils.a(this.f68667e, "A") / 2.5f) + this.f68763h.e();
            YAxis.AxisDependency axisDependencyV = this.f68763h.V();
            YAxis.YAxisLabelPosition yAxisLabelPositionW = this.f68763h.W();
            if (axisDependencyV == YAxis.AxisDependency.LEFT) {
                if (yAxisLabelPositionW == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                    this.f68667e.setTextAlign(Paint.Align.RIGHT);
                    fI = this.f68749a.G();
                    f3 = fI - fD;
                } else {
                    this.f68667e.setTextAlign(Paint.Align.LEFT);
                    fI2 = this.f68749a.G();
                    f3 = fI2 + fD;
                }
            } else if (yAxisLabelPositionW == YAxis.YAxisLabelPosition.OUTSIDE_CHART) {
                this.f68667e.setTextAlign(Paint.Align.LEFT);
                fI2 = this.f68749a.i();
                f3 = fI2 + fD;
            } else {
                this.f68667e.setTextAlign(Paint.Align.RIGHT);
                fI = this.f68749a.i();
                f3 = fI - fD;
            }
            d(canvas, f3, fArrG, fA);
        }
    }

    public void j(Canvas canvas) {
        if (this.f68763h.f() && this.f68763h.z()) {
            this.f68668f.setColor(this.f68763h.m());
            this.f68668f.setStrokeWidth(this.f68763h.o());
            if (this.f68763h.V() == YAxis.AxisDependency.LEFT) {
                canvas.drawLine(this.f68749a.h(), this.f68749a.j(), this.f68749a.h(), this.f68749a.f(), this.f68668f);
            } else {
                canvas.drawLine(this.f68749a.i(), this.f68749a.j(), this.f68749a.i(), this.f68749a.f(), this.f68668f);
            }
        }
    }

    public void k(Canvas canvas) {
        if (this.f68763h.f()) {
            if (this.f68763h.B()) {
                int iSave = canvas.save();
                canvas.clipRect(f());
                float[] fArrG = g();
                this.f68666d.setColor(this.f68763h.r());
                this.f68666d.setStrokeWidth(this.f68763h.t());
                this.f68666d.setPathEffect(this.f68763h.s());
                Path path = this.f68765j;
                path.reset();
                for (int i3 = 0; i3 < fArrG.length; i3 += 2) {
                    canvas.drawPath(h(path, i3, fArrG), this.f68666d);
                    path.reset();
                }
                canvas.restoreToCount(iSave);
            }
            if (this.f68763h.h0()) {
                e(canvas);
            }
        }
    }

    public void l(Canvas canvas) {
        List listV = this.f68763h.v();
        if (listV == null || listV.size() <= 0) {
            return;
        }
        float[] fArr = this.f68771p;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        Path path = this.f68770o;
        path.reset();
        for (int i3 = 0; i3 < listV.size(); i3++) {
            LimitLine limitLine = (LimitLine) listV.get(i3);
            if (limitLine.f()) {
                int iSave = canvas.save();
                this.f68772q.set(this.f68749a.o());
                this.f68772q.inset(0.0f, -limitLine.q());
                canvas.clipRect(this.f68772q);
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
                    this.f68669g.setTypeface(limitLine.c());
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
