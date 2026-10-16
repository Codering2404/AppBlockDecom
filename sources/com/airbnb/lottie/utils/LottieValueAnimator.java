package com.airbnb.lottie.utils;

import android.view.Choreographer;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private LottieComposition f57097m;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f57089d = 1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f57090f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f57091g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f57092h = 0.0f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f57093i = 0.0f;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f57094j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f57095k = -2.1474836E9f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f57096l = 2.1474836E9f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected boolean f57098n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f57099o = false;

    private void J() {
        if (this.f57097m == null) {
            return;
        }
        float f3 = this.f57093i;
        if (f3 < this.f57095k || f3 > this.f57096l) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f57095k), Float.valueOf(this.f57096l), Float.valueOf(this.f57093i)));
        }
    }

    private float p() {
        LottieComposition lottieComposition = this.f57097m;
        if (lottieComposition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / lottieComposition.i()) / Math.abs(this.f57089d);
    }

    private boolean t() {
        return s() < 0.0f;
    }

    public void A() {
        H(-s());
    }

    public void B(LottieComposition lottieComposition) {
        boolean z2 = this.f57097m == null;
        this.f57097m = lottieComposition;
        if (z2) {
            F(Math.max(this.f57095k, lottieComposition.p()), Math.min(this.f57096l, lottieComposition.f()));
        } else {
            F((int) lottieComposition.p(), (int) lottieComposition.f());
        }
        float f3 = this.f57093i;
        this.f57093i = 0.0f;
        this.f57092h = 0.0f;
        D((int) f3);
        i();
    }

    public void D(float f3) {
        if (this.f57092h == f3) {
            return;
        }
        float fB = MiscUtils.b(f3, r(), q());
        this.f57092h = fB;
        if (this.f57099o) {
            fB = (float) Math.floor(fB);
        }
        this.f57093i = fB;
        this.f57091g = 0L;
        i();
    }

    public void E(float f3) {
        F(this.f57095k, f3);
    }

    public void F(float f3, float f4) {
        if (f3 > f4) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f3), Float.valueOf(f4)));
        }
        LottieComposition lottieComposition = this.f57097m;
        float fP = lottieComposition == null ? -3.4028235E38f : lottieComposition.p();
        LottieComposition lottieComposition2 = this.f57097m;
        float f5 = lottieComposition2 == null ? Float.MAX_VALUE : lottieComposition2.f();
        float fB = MiscUtils.b(f3, fP, f5);
        float fB2 = MiscUtils.b(f4, fP, f5);
        if (fB == this.f57095k && fB2 == this.f57096l) {
            return;
        }
        this.f57095k = fB;
        this.f57096l = fB2;
        D((int) MiscUtils.b(this.f57093i, fB, fB2));
    }

    public void G(int i3) {
        F(i3, (int) this.f57096l);
    }

    public void H(float f3) {
        this.f57089d = f3;
    }

    public void I(boolean z2) {
        this.f57099o = z2;
    }

    @Override // com.airbnb.lottie.utils.BaseLottieAnimator
    void a() {
        super.a();
        b(t());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        a();
        x();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j3) {
        w();
        if (this.f57097m == null || !isRunning()) {
            return;
        }
        L.a("LottieValueAnimator#doFrame");
        float fP = (this.f57091g != 0 ? j3 - r1 : 0L) / p();
        float f3 = this.f57092h;
        if (t()) {
            fP = -fP;
        }
        float f4 = f3 + fP;
        boolean zD = MiscUtils.d(f4, r(), q());
        float f5 = this.f57092h;
        float fB = MiscUtils.b(f4, r(), q());
        this.f57092h = fB;
        if (this.f57099o) {
            fB = (float) Math.floor(fB);
        }
        this.f57093i = fB;
        this.f57091g = j3;
        if (!this.f57099o || this.f57092h != f5) {
            i();
        }
        if (!zD) {
            if (getRepeatCount() == -1 || this.f57094j < getRepeatCount()) {
                e();
                this.f57094j++;
                if (getRepeatMode() == 2) {
                    this.f57090f = !this.f57090f;
                    A();
                } else {
                    float fQ = t() ? q() : r();
                    this.f57092h = fQ;
                    this.f57093i = fQ;
                }
                this.f57091g = j3;
            } else {
                float fR = this.f57089d < 0.0f ? r() : q();
                this.f57092h = fR;
                this.f57093i = fR;
                x();
                b(t());
            }
        }
        J();
        L.b("LottieValueAnimator#doFrame");
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float fR;
        float fQ;
        float fR2;
        if (this.f57097m == null) {
            return 0.0f;
        }
        if (t()) {
            fR = q() - this.f57093i;
            fQ = q();
            fR2 = r();
        } else {
            fR = this.f57093i - r();
            fQ = q();
            fR2 = r();
        }
        return fR / (fQ - fR2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(m());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        LottieComposition lottieComposition = this.f57097m;
        if (lottieComposition == null) {
            return 0L;
        }
        return (long) lottieComposition.d();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f57098n;
    }

    public void j() {
        this.f57097m = null;
        this.f57095k = -2.1474836E9f;
        this.f57096l = 2.1474836E9f;
    }

    public void k() {
        x();
        b(t());
    }

    public float m() {
        LottieComposition lottieComposition = this.f57097m;
        if (lottieComposition == null) {
            return 0.0f;
        }
        return (this.f57093i - lottieComposition.p()) / (this.f57097m.f() - this.f57097m.p());
    }

    public float o() {
        return this.f57093i;
    }

    public float q() {
        LottieComposition lottieComposition = this.f57097m;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f3 = this.f57096l;
        return f3 == 2.1474836E9f ? lottieComposition.f() : f3;
    }

    public float r() {
        LottieComposition lottieComposition = this.f57097m;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f3 = this.f57095k;
        return f3 == -2.1474836E9f ? lottieComposition.p() : f3;
    }

    public float s() {
        return this.f57089d;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i3) {
        super.setRepeatMode(i3);
        if (i3 == 2 || !this.f57090f) {
            return;
        }
        this.f57090f = false;
        A();
    }

    public void u() {
        x();
        c();
    }

    public void v() {
        this.f57098n = true;
        h(t());
        D((int) (t() ? q() : r()));
        this.f57091g = 0L;
        this.f57094j = 0;
        w();
    }

    protected void w() {
        if (isRunning()) {
            y(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void x() {
        y(true);
    }

    protected void y(boolean z2) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z2) {
            this.f57098n = false;
        }
    }

    public void z() {
        this.f57098n = true;
        w();
        this.f57091g = 0L;
        if (t() && o() == r()) {
            D(q());
        } else if (!t() && o() == q()) {
            D(r());
        }
        g();
    }
}
