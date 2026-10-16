package com.github.mikephil.charting.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ViewPortHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Matrix f68828a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected RectF f68829b = new RectF();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected float f68830c = 0.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected float f68831d = 0.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f68832e = 1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f68833f = Float.MAX_VALUE;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f68834g = 1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f68835h = Float.MAX_VALUE;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f68836i = 1.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f68837j = 1.0f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f68838k = 0.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f68839l = 0.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f68840m = 0.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f68841n = 0.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected float[] f68842o = new float[9];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected Matrix f68843p = new Matrix();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected final float[] f68844q = new float[9];

    public boolean A(float f3) {
        return this.f68829b.right >= (((float) ((int) (f3 * 100.0f))) / 100.0f) - 1.0f;
    }

    public boolean B(float f3) {
        return this.f68829b.top <= f3;
    }

    public boolean C(float f3) {
        return z(f3) && A(f3);
    }

    public boolean D(float f3) {
        return B(f3) && y(f3);
    }

    public void E(Matrix matrix, RectF rectF) {
        float fWidth;
        float fHeight;
        matrix.getValues(this.f68844q);
        float[] fArr = this.f68844q;
        float f3 = fArr[2];
        float f4 = fArr[0];
        float f5 = fArr[5];
        float f6 = fArr[4];
        this.f68836i = Math.min(Math.max(this.f68834g, f4), this.f68835h);
        this.f68837j = Math.min(Math.max(this.f68832e, f6), this.f68833f);
        if (rectF != null) {
            fWidth = rectF.width();
            fHeight = rectF.height();
        } else {
            fWidth = 0.0f;
            fHeight = 0.0f;
        }
        this.f68838k = Math.min(Math.max(f3, ((-fWidth) * (this.f68836i - 1.0f)) - this.f68840m), this.f68840m);
        float fMax = Math.max(Math.min(f5, (fHeight * (this.f68837j - 1.0f)) + this.f68841n), -this.f68841n);
        this.f68839l = fMax;
        float[] fArr2 = this.f68844q;
        fArr2[2] = this.f68838k;
        fArr2[0] = this.f68836i;
        fArr2[5] = fMax;
        fArr2[4] = this.f68837j;
        matrix.setValues(fArr2);
    }

    public float F() {
        return this.f68831d - this.f68829b.bottom;
    }

    public float G() {
        return this.f68829b.left;
    }

    public float H() {
        return this.f68830c - this.f68829b.right;
    }

    public float I() {
        return this.f68829b.top;
    }

    public Matrix J(Matrix matrix, View view, boolean z2) {
        this.f68828a.set(matrix);
        E(this.f68828a, this.f68829b);
        if (z2) {
            view.invalidate();
        }
        matrix.set(this.f68828a);
        return matrix;
    }

    public void K(float f3, float f4, float f5, float f6) {
        this.f68829b.set(f3, f4, this.f68830c - f5, this.f68831d - f6);
    }

    public void L(float f3, float f4) {
        float fG = G();
        float fI = I();
        float fH = H();
        float F = F();
        this.f68831d = f4;
        this.f68830c = f3;
        K(fG, fI, fH, F);
    }

    public void M(float f3) {
        this.f68840m = Utils.e(f3);
    }

    public void N(float f3) {
        this.f68841n = Utils.e(f3);
    }

    public void O(float f3) {
        if (f3 == 0.0f) {
            f3 = Float.MAX_VALUE;
        }
        this.f68835h = f3;
        E(this.f68828a, this.f68829b);
    }

    public void P(float f3) {
        if (f3 == 0.0f) {
            f3 = Float.MAX_VALUE;
        }
        this.f68833f = f3;
        E(this.f68828a, this.f68829b);
    }

    public void Q(float f3) {
        if (f3 < 1.0f) {
            f3 = 1.0f;
        }
        this.f68834g = f3;
        E(this.f68828a, this.f68829b);
    }

    public void R(float f3) {
        if (f3 < 1.0f) {
            f3 = 1.0f;
        }
        this.f68832e = f3;
        E(this.f68828a, this.f68829b);
    }

    public void S(float f3, float f4, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f68828a);
        matrix.setScale(f3, f4);
    }

    public void T(float[] fArr, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f68828a);
        matrix.postTranslate(-(fArr[0] - G()), -(fArr[1] - I()));
    }

    public void U(float f3, float f4, float f5, float f6, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f68828a);
        matrix.postScale(f3, f4, f5, f6);
    }

    public void V(float f3, float f4, Matrix matrix) {
        matrix.reset();
        matrix.set(this.f68828a);
        matrix.postScale(f3, f4);
    }

    public boolean a() {
        return this.f68836i < this.f68835h;
    }

    public boolean b() {
        return this.f68837j < this.f68833f;
    }

    public boolean c() {
        return this.f68836i > this.f68834g;
    }

    public boolean d() {
        return this.f68837j > this.f68832e;
    }

    public void e(float[] fArr, View view) {
        Matrix matrix = this.f68843p;
        matrix.reset();
        matrix.set(this.f68828a);
        matrix.postTranslate(-(fArr[0] - G()), -(fArr[1] - I()));
        J(matrix, view, true);
    }

    public float f() {
        return this.f68829b.bottom;
    }

    public float g() {
        return this.f68829b.height();
    }

    public float h() {
        return this.f68829b.left;
    }

    public float i() {
        return this.f68829b.right;
    }

    public float j() {
        return this.f68829b.top;
    }

    public float k() {
        return this.f68829b.width();
    }

    public float l() {
        return this.f68831d;
    }

    public float m() {
        return this.f68830c;
    }

    public MPPointF n() {
        return MPPointF.c(this.f68829b.centerX(), this.f68829b.centerY());
    }

    public RectF o() {
        return this.f68829b;
    }

    public Matrix p() {
        return this.f68828a;
    }

    public float q() {
        return this.f68836i;
    }

    public float r() {
        return this.f68837j;
    }

    public float s() {
        return Math.min(this.f68829b.width(), this.f68829b.height());
    }

    public boolean t() {
        return this.f68840m <= 0.0f && this.f68841n <= 0.0f;
    }

    public boolean u() {
        return v() && w();
    }

    public boolean v() {
        float f3 = this.f68836i;
        float f4 = this.f68834g;
        return f3 <= f4 && f4 <= 1.0f;
    }

    public boolean w() {
        float f3 = this.f68837j;
        float f4 = this.f68832e;
        return f3 <= f4 && f4 <= 1.0f;
    }

    public boolean x(float f3, float f4) {
        return C(f3) && D(f4);
    }

    public boolean y(float f3) {
        return this.f68829b.bottom >= ((float) ((int) (f3 * 100.0f))) / 100.0f;
    }

    public boolean z(float f3) {
        return this.f68829b.left <= f3 + 1.0f;
    }
}
