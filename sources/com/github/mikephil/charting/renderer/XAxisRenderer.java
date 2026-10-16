package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
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
public class XAxisRenderer extends AxisRenderer {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected XAxis f68752h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected Path f68753i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected float[] f68754j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected RectF f68755k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected float[] f68756l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected RectF f68757m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    float[] f68758n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Path f68759o;

    public XAxisRenderer(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer transformer) {
        super(viewPortHandler, transformer, xAxis);
        this.f68753i = new Path();
        this.f68754j = new float[2];
        this.f68755k = new RectF();
        this.f68756l = new float[2];
        this.f68757m = new RectF();
        this.f68758n = new float[4];
        this.f68759o = new Path();
        this.f68752h = xAxis;
        this.f68667e.setColor(-16777216);
        this.f68667e.setTextAlign(Paint.Align.CENTER);
        this.f68667e.setTextSize(Utils.e(10.0f));
    }

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    public void a(float f3, float f4, boolean z2) {
        float f5;
        double d3;
        if (this.f68749a.k() > 10.0f && !this.f68749a.v()) {
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

    @Override // com.github.mikephil.charting.renderer.AxisRenderer
    protected void b(float f3, float f4) {
        super.b(f3, f4);
        d();
    }

    protected void d() {
        String strW = this.f68752h.w();
        this.f68667e.setTypeface(this.f68752h.c());
        this.f68667e.setTextSize(this.f68752h.b());
        FSize fSizeB = Utils.b(this.f68667e, strW);
        float f3 = fSizeB.f68786c;
        float fA = Utils.a(this.f68667e, "Q");
        FSize fSizeT = Utils.t(f3, fA, this.f68752h.V());
        this.f68752h.J = Math.round(f3);
        this.f68752h.K = Math.round(fA);
        this.f68752h.L = Math.round(fSizeT.f68786c);
        this.f68752h.M = Math.round(fSizeT.f68787d);
        FSize.c(fSizeT);
        FSize.c(fSizeB);
    }

    protected void e(Canvas canvas, float f3, float f4, Path path) {
        path.moveTo(f3, this.f68749a.f());
        path.lineTo(f3, this.f68749a.j());
        canvas.drawPath(path, this.f68666d);
        path.reset();
    }

    protected void f(Canvas canvas, String str, float f3, float f4, MPPointF mPPointF, float f5) {
        Utils.g(canvas, str, f3, f4, this.f68667e, mPPointF, f5);
    }

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
                fArr[i4] = this.f68752h.f68381m[i4 / 2];
            } else {
                fArr[i4] = this.f68752h.f68380l[i4 / 2];
            }
        }
        this.f68665c.k(fArr);
        int i5 = 0;
        while (i5 < i3) {
            float fD = fArr[i5];
            if (this.f68749a.C(fD)) {
                ValueFormatter valueFormatterX = this.f68752h.x();
                XAxis xAxis = this.f68752h;
                int i6 = i5 / 2;
                String strA = valueFormatterX.a(xAxis.f68380l[i6], xAxis);
                if (this.f68752h.X()) {
                    int i7 = this.f68752h.f68382n;
                    if (i6 == i7 - 1 && i7 > 1) {
                        float fD2 = Utils.d(this.f68667e, strA);
                        if (fD2 > this.f68749a.H() * 2.0f && fD + fD2 > this.f68749a.m()) {
                            fD -= fD2 / 2.0f;
                        }
                    } else if (i5 == 0) {
                        fD += Utils.d(this.f68667e, strA) / 2.0f;
                    }
                }
                canvas2 = canvas;
                f4 = f3;
                mPPointF2 = mPPointF;
                f(canvas2, strA, fD, f4, mPPointF2, fV);
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

    public RectF h() {
        this.f68755k.set(this.f68749a.o());
        this.f68755k.inset(-this.f68664b.t(), 0.0f);
        return this.f68755k;
    }

    public void i(Canvas canvas) {
        if (this.f68752h.f() && this.f68752h.C()) {
            float fE = this.f68752h.e();
            this.f68667e.setTypeface(this.f68752h.c());
            this.f68667e.setTextSize(this.f68752h.b());
            this.f68667e.setColor(this.f68752h.a());
            MPPointF mPPointFC = MPPointF.c(0.0f, 0.0f);
            if (this.f68752h.W() == XAxis.XAxisPosition.TOP) {
                mPPointFC.f68793c = 0.5f;
                mPPointFC.f68794d = 1.0f;
                g(canvas, this.f68749a.j() - fE, mPPointFC);
            } else if (this.f68752h.W() == XAxis.XAxisPosition.TOP_INSIDE) {
                mPPointFC.f68793c = 0.5f;
                mPPointFC.f68794d = 1.0f;
                g(canvas, this.f68749a.j() + fE + this.f68752h.M, mPPointFC);
            } else if (this.f68752h.W() == XAxis.XAxisPosition.BOTTOM) {
                mPPointFC.f68793c = 0.5f;
                mPPointFC.f68794d = 0.0f;
                g(canvas, this.f68749a.f() + fE, mPPointFC);
            } else if (this.f68752h.W() == XAxis.XAxisPosition.BOTTOM_INSIDE) {
                mPPointFC.f68793c = 0.5f;
                mPPointFC.f68794d = 0.0f;
                g(canvas, (this.f68749a.f() - fE) - this.f68752h.M, mPPointFC);
            } else {
                mPPointFC.f68793c = 0.5f;
                mPPointFC.f68794d = 1.0f;
                g(canvas, this.f68749a.j() - fE, mPPointFC);
                mPPointFC.f68793c = 0.5f;
                mPPointFC.f68794d = 0.0f;
                g(canvas, this.f68749a.f() + fE, mPPointFC);
            }
            MPPointF.f(mPPointFC);
        }
    }

    public void j(Canvas canvas) {
        Canvas canvas2;
        if (this.f68752h.z() && this.f68752h.f()) {
            this.f68668f.setColor(this.f68752h.m());
            this.f68668f.setStrokeWidth(this.f68752h.o());
            this.f68668f.setPathEffect(this.f68752h.n());
            if (this.f68752h.W() == XAxis.XAxisPosition.TOP || this.f68752h.W() == XAxis.XAxisPosition.TOP_INSIDE || this.f68752h.W() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas2 = canvas;
                canvas2.drawLine(this.f68749a.h(), this.f68749a.j(), this.f68749a.i(), this.f68749a.j(), this.f68668f);
            } else {
                canvas2 = canvas;
            }
            if (this.f68752h.W() == XAxis.XAxisPosition.BOTTOM || this.f68752h.W() == XAxis.XAxisPosition.BOTTOM_INSIDE || this.f68752h.W() == XAxis.XAxisPosition.BOTH_SIDED) {
                canvas2.drawLine(this.f68749a.h(), this.f68749a.f(), this.f68749a.i(), this.f68749a.f(), this.f68668f);
            }
        }
    }

    public void k(Canvas canvas) {
        if (this.f68752h.B() && this.f68752h.f()) {
            int iSave = canvas.save();
            canvas.clipRect(h());
            if (this.f68754j.length != this.f68664b.f68382n * 2) {
                this.f68754j = new float[this.f68752h.f68382n * 2];
            }
            float[] fArr = this.f68754j;
            for (int i3 = 0; i3 < fArr.length; i3 += 2) {
                float[] fArr2 = this.f68752h.f68380l;
                int i4 = i3 / 2;
                fArr[i3] = fArr2[i4];
                fArr[i3 + 1] = fArr2[i4];
            }
            this.f68665c.k(fArr);
            o();
            Path path = this.f68753i;
            path.reset();
            for (int i5 = 0; i5 < fArr.length; i5 += 2) {
                e(canvas, fArr[i5], fArr[i5 + 1], path);
            }
            canvas.restoreToCount(iSave);
        }
    }

    public void l(Canvas canvas, LimitLine limitLine, float[] fArr, float f3) {
        String strM = limitLine.m();
        if (strM == null || strM.equals("")) {
            return;
        }
        this.f68669g.setStyle(limitLine.r());
        this.f68669g.setPathEffect(null);
        this.f68669g.setColor(limitLine.a());
        this.f68669g.setStrokeWidth(0.5f);
        this.f68669g.setTextSize(limitLine.b());
        float fQ = limitLine.q() + limitLine.d();
        LimitLine.LimitLabelPosition limitLabelPositionN = limitLine.n();
        if (limitLabelPositionN == LimitLine.LimitLabelPosition.RIGHT_TOP) {
            float fA = Utils.a(this.f68669g, strM);
            this.f68669g.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(strM, fArr[0] + fQ, this.f68749a.j() + f3 + fA, this.f68669g);
        } else if (limitLabelPositionN == LimitLine.LimitLabelPosition.RIGHT_BOTTOM) {
            this.f68669g.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(strM, fArr[0] + fQ, this.f68749a.f() - f3, this.f68669g);
        } else if (limitLabelPositionN != LimitLine.LimitLabelPosition.LEFT_TOP) {
            this.f68669g.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(strM, fArr[0] - fQ, this.f68749a.f() - f3, this.f68669g);
        } else {
            this.f68669g.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(strM, fArr[0] - fQ, this.f68749a.j() + f3 + Utils.a(this.f68669g, strM), this.f68669g);
        }
    }

    public void m(Canvas canvas, LimitLine limitLine, float[] fArr) {
        float[] fArr2 = this.f68758n;
        fArr2[0] = fArr[0];
        fArr2[1] = this.f68749a.j();
        float[] fArr3 = this.f68758n;
        fArr3[2] = fArr[0];
        fArr3[3] = this.f68749a.f();
        this.f68759o.reset();
        Path path = this.f68759o;
        float[] fArr4 = this.f68758n;
        path.moveTo(fArr4[0], fArr4[1]);
        Path path2 = this.f68759o;
        float[] fArr5 = this.f68758n;
        path2.lineTo(fArr5[2], fArr5[3]);
        this.f68669g.setStyle(Paint.Style.STROKE);
        this.f68669g.setColor(limitLine.p());
        this.f68669g.setStrokeWidth(limitLine.q());
        this.f68669g.setPathEffect(limitLine.l());
        canvas.drawPath(this.f68759o, this.f68669g);
    }

    public void n(Canvas canvas) {
        List listV = this.f68752h.v();
        if (listV == null || listV.size() <= 0) {
            return;
        }
        float[] fArr = this.f68756l;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        for (int i3 = 0; i3 < listV.size(); i3++) {
            LimitLine limitLine = (LimitLine) listV.get(i3);
            if (limitLine.f()) {
                int iSave = canvas.save();
                this.f68757m.set(this.f68749a.o());
                this.f68757m.inset(-limitLine.q(), 0.0f);
                canvas.clipRect(this.f68757m);
                fArr[0] = limitLine.o();
                fArr[1] = 0.0f;
                this.f68665c.k(fArr);
                m(canvas, limitLine, fArr);
                l(canvas, limitLine, fArr, limitLine.e() + 2.0f);
                canvas.restoreToCount(iSave);
            }
        }
    }

    protected void o() {
        this.f68666d.setColor(this.f68752h.r());
        this.f68666d.setStrokeWidth(this.f68752h.t());
        this.f68666d.setPathEffect(this.f68752h.s());
    }
}
