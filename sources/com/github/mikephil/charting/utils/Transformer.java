package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Transformer {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected ViewPortHandler f68806c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Matrix f68804a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Matrix f68805b = new Matrix();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected float[] f68807d = new float[1];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected float[] f68808e = new float[1];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected float[] f68809f = new float[1];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected float[] f68810g = new float[1];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected Matrix f68811h = new Matrix();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float[] f68812i = new float[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Matrix f68813j = new Matrix();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Matrix f68814k = new Matrix();

    public Transformer(ViewPortHandler viewPortHandler) {
        this.f68806c = viewPortHandler;
    }

    public float[] a(IBubbleDataSet iBubbleDataSet, float f3, int i3, int i4) {
        int i5 = ((i4 - i3) + 1) * 2;
        if (this.f68808e.length != i5) {
            this.f68808e = new float[i5];
        }
        float[] fArr = this.f68808e;
        for (int i6 = 0; i6 < i5; i6 += 2) {
            Entry entryR = iBubbleDataSet.r((i6 / 2) + i3);
            if (entryR != null) {
                fArr[i6] = entryR.h();
                fArr[i6 + 1] = entryR.e() * f3;
            } else {
                fArr[i6] = 0.0f;
                fArr[i6 + 1] = 0.0f;
            }
        }
        f().mapPoints(fArr);
        return fArr;
    }

    public float[] b(ICandleDataSet iCandleDataSet, float f3, float f4, int i3, int i4) {
        int i5 = ((int) (((i4 - i3) * f3) + 1.0f)) * 2;
        if (this.f68810g.length != i5) {
            this.f68810g = new float[i5];
        }
        float[] fArr = this.f68810g;
        for (int i6 = 0; i6 < i5; i6 += 2) {
            CandleEntry candleEntry = (CandleEntry) iCandleDataSet.r((i6 / 2) + i3);
            if (candleEntry != null) {
                fArr[i6] = candleEntry.h();
                fArr[i6 + 1] = candleEntry.j() * f4;
            } else {
                fArr[i6] = 0.0f;
                fArr[i6 + 1] = 0.0f;
            }
        }
        f().mapPoints(fArr);
        return fArr;
    }

    public float[] c(ILineDataSet iLineDataSet, float f3, float f4, int i3, int i4) {
        int i5 = (((int) ((i4 - i3) * f3)) + 1) * 2;
        if (this.f68809f.length != i5) {
            this.f68809f = new float[i5];
        }
        float[] fArr = this.f68809f;
        for (int i6 = 0; i6 < i5; i6 += 2) {
            Entry entryR = iLineDataSet.r((i6 / 2) + i3);
            if (entryR != null) {
                fArr[i6] = entryR.h();
                fArr[i6 + 1] = entryR.e() * f4;
            } else {
                fArr[i6] = 0.0f;
                fArr[i6 + 1] = 0.0f;
            }
        }
        f().mapPoints(fArr);
        return fArr;
    }

    public float[] d(IScatterDataSet iScatterDataSet, float f3, float f4, int i3, int i4) {
        int i5 = ((int) (((i4 - i3) * f3) + 1.0f)) * 2;
        if (this.f68807d.length != i5) {
            this.f68807d = new float[i5];
        }
        float[] fArr = this.f68807d;
        for (int i6 = 0; i6 < i5; i6 += 2) {
            Entry entryR = iScatterDataSet.r((i6 / 2) + i3);
            if (entryR != null) {
                fArr[i6] = entryR.h();
                fArr[i6 + 1] = entryR.e() * f4;
            } else {
                fArr[i6] = 0.0f;
                fArr[i6 + 1] = 0.0f;
            }
        }
        f().mapPoints(fArr);
        return fArr;
    }

    public MPPointD e(float f3, float f4) {
        float[] fArr = this.f68812i;
        fArr[0] = f3;
        fArr[1] = f4;
        k(fArr);
        float[] fArr2 = this.f68812i;
        return MPPointD.b(fArr2[0], fArr2[1]);
    }

    public Matrix f() {
        this.f68813j.set(this.f68804a);
        this.f68813j.postConcat(this.f68806c.f68828a);
        this.f68813j.postConcat(this.f68805b);
        return this.f68813j;
    }

    public MPPointD g(float f3, float f4) {
        MPPointD mPPointDB = MPPointD.b(0.0d, 0.0d);
        h(f3, f4, mPPointDB);
        return mPPointDB;
    }

    public void h(float f3, float f4, MPPointD mPPointD) {
        float[] fArr = this.f68812i;
        fArr[0] = f3;
        fArr[1] = f4;
        j(fArr);
        float[] fArr2 = this.f68812i;
        mPPointD.f68789c = fArr2[0];
        mPPointD.f68790d = fArr2[1];
    }

    public void i(Path path) {
        path.transform(this.f68804a);
        path.transform(this.f68806c.p());
        path.transform(this.f68805b);
    }

    public void j(float[] fArr) {
        Matrix matrix = this.f68811h;
        matrix.reset();
        this.f68805b.invert(matrix);
        matrix.mapPoints(fArr);
        this.f68806c.p().invert(matrix);
        matrix.mapPoints(fArr);
        this.f68804a.invert(matrix);
        matrix.mapPoints(fArr);
    }

    public void k(float[] fArr) {
        this.f68804a.mapPoints(fArr);
        this.f68806c.p().mapPoints(fArr);
        this.f68805b.mapPoints(fArr);
    }

    public void l(boolean z2) {
        this.f68805b.reset();
        if (!z2) {
            this.f68805b.postTranslate(this.f68806c.G(), this.f68806c.l() - this.f68806c.F());
        } else {
            this.f68805b.setTranslate(this.f68806c.G(), -this.f68806c.I());
            this.f68805b.postScale(1.0f, -1.0f);
        }
    }

    public void m(float f3, float f4, float f5, float f6) {
        float fK = this.f68806c.k() / f4;
        float fG = this.f68806c.g() / f5;
        if (Float.isInfinite(fK)) {
            fK = 0.0f;
        }
        if (Float.isInfinite(fG)) {
            fG = 0.0f;
        }
        this.f68804a.reset();
        this.f68804a.postTranslate(-f3, -f6);
        this.f68804a.postScale(fK, -fG);
    }

    public void n(RectF rectF, float f3) {
        rectF.top *= f3;
        rectF.bottom *= f3;
        this.f68804a.mapRect(rectF);
        this.f68806c.p().mapRect(rectF);
        this.f68805b.mapRect(rectF);
    }

    public void o(RectF rectF, float f3) {
        rectF.left *= f3;
        rectF.right *= f3;
        this.f68804a.mapRect(rectF);
        this.f68806c.p().mapRect(rectF);
        this.f68805b.mapRect(rectF);
    }

    public void p(RectF rectF) {
        this.f68804a.mapRect(rectF);
        this.f68806c.p().mapRect(rectF);
        this.f68805b.mapRect(rectF);
    }
}
