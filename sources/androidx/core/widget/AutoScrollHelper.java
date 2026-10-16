package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f34627s = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final View f34630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f34631d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f34634h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f34635i;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f34639m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    boolean f34640n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    boolean f34641o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    boolean f34642p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f34643q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f34644r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ClampedScroller f34628a = new ClampedScroller();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Interpolator f34629b = new AccelerateInterpolator();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f34632f = {0.0f, 0.0f};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float[] f34633g = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float[] f34636j = {0.0f, 0.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float[] f34637k = {0.0f, 0.0f};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float[] f34638l = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ClampedScroller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f34645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f34646b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f34647c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f34648d;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private float f34654j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f34655k;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f34649e = Long.MIN_VALUE;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f34653i = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f34650f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f34651g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f34652h = 0;

        ClampedScroller() {
        }

        private float e(long j3) {
            if (j3 < this.f34649e) {
                return 0.0f;
            }
            long j4 = this.f34653i;
            if (j4 < 0 || j3 < j4) {
                return AutoScrollHelper.e((j3 - r0) / this.f34645a, 0.0f, 1.0f) * 0.5f;
            }
            float f3 = this.f34654j;
            return (1.0f - f3) + (f3 * AutoScrollHelper.e((j3 - j4) / this.f34655k, 0.0f, 1.0f));
        }

        private float g(float f3) {
            return ((-4.0f) * f3 * f3) + (f3 * 4.0f);
        }

        public void a() {
            if (this.f34650f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fG = g(e(jCurrentAnimationTimeMillis));
            long j3 = jCurrentAnimationTimeMillis - this.f34650f;
            this.f34650f = jCurrentAnimationTimeMillis;
            float f3 = j3 * fG;
            this.f34651g = (int) (this.f34647c * f3);
            this.f34652h = (int) (f3 * this.f34648d);
        }

        public int b() {
            return this.f34651g;
        }

        public int c() {
            return this.f34652h;
        }

        public int d() {
            float f3 = this.f34647c;
            return (int) (f3 / Math.abs(f3));
        }

        public int f() {
            float f3 = this.f34648d;
            return (int) (f3 / Math.abs(f3));
        }

        public boolean h() {
            return this.f34653i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f34653i + ((long) this.f34655k);
        }

        public void i() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f34655k = AutoScrollHelper.f((int) (jCurrentAnimationTimeMillis - this.f34649e), 0, this.f34646b);
            this.f34654j = e(jCurrentAnimationTimeMillis);
            this.f34653i = jCurrentAnimationTimeMillis;
        }

        public void j(int i3) {
            this.f34646b = i3;
        }

        public void k(int i3) {
            this.f34645a = i3;
        }

        public void l(float f3, float f4) {
            this.f34647c = f3;
            this.f34648d = f4;
        }

        public void m() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f34649e = jCurrentAnimationTimeMillis;
            this.f34653i = -1L;
            this.f34650f = jCurrentAnimationTimeMillis;
            this.f34654j = 0.5f;
            this.f34651g = 0;
            this.f34652h = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ScrollAnimationRunnable implements Runnable {
        ScrollAnimationRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (autoScrollHelper.f34642p) {
                if (autoScrollHelper.f34640n) {
                    autoScrollHelper.f34640n = false;
                    autoScrollHelper.f34628a.m();
                }
                ClampedScroller clampedScroller = AutoScrollHelper.this.f34628a;
                if (clampedScroller.h() || !AutoScrollHelper.this.u()) {
                    AutoScrollHelper.this.f34642p = false;
                    return;
                }
                AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                if (autoScrollHelper2.f34641o) {
                    autoScrollHelper2.f34641o = false;
                    autoScrollHelper2.c();
                }
                clampedScroller.a();
                AutoScrollHelper.this.j(clampedScroller.b(), clampedScroller.c());
                ViewCompat.e0(AutoScrollHelper.this.f34630c, this);
            }
        }
    }

    public AutoScrollHelper(View view) {
        this.f34630c = view;
        float f3 = Resources.getSystem().getDisplayMetrics().density;
        float f4 = (int) ((1575.0f * f3) + 0.5f);
        o(f4, f4);
        float f5 = (int) ((f3 * 315.0f) + 0.5f);
        p(f5, f5);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f34627s);
        r(500);
        q(500);
    }

    private float d(int i3, float f3, float f4, float f5) {
        float fH = h(this.f34632f[i3], f4, this.f34633g[i3], f3);
        if (fH == 0.0f) {
            return 0.0f;
        }
        float f6 = this.f34636j[i3];
        float f7 = this.f34637k[i3];
        float f8 = this.f34638l[i3];
        float f9 = f6 * f5;
        return fH > 0.0f ? e(fH * f9, f7, f8) : -e((-fH) * f9, f7, f8);
    }

    static float e(float f3, float f4, float f5) {
        return f3 > f5 ? f5 : f3 < f4 ? f4 : f3;
    }

    static int f(int i3, int i4, int i5) {
        return i3 > i5 ? i5 : i3 < i4 ? i4 : i3;
    }

    private float g(float f3, float f4) {
        if (f4 == 0.0f) {
            return 0.0f;
        }
        int i3 = this.f34634h;
        if (i3 == 0 || i3 == 1) {
            if (f3 < f4) {
                if (f3 >= 0.0f) {
                    return 1.0f - (f3 / f4);
                }
                if (this.f34642p && i3 == 1) {
                    return 1.0f;
                }
            }
        } else if (i3 == 2 && f3 < 0.0f) {
            return f3 / (-f4);
        }
        return 0.0f;
    }

    private float h(float f3, float f4, float f5, float f6) {
        float interpolation;
        float fE = e(f3 * f4, 0.0f, f5);
        float fG = g(f4 - f6, fE) - g(f6, fE);
        if (fG < 0.0f) {
            interpolation = -this.f34629b.getInterpolation(-fG);
        } else {
            if (fG <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f34629b.getInterpolation(fG);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f34640n) {
            this.f34642p = false;
        } else {
            this.f34628a.i();
        }
    }

    private void v() {
        int i3;
        if (this.f34631d == null) {
            this.f34631d = new ScrollAnimationRunnable();
        }
        this.f34642p = true;
        this.f34640n = true;
        if (this.f34639m || (i3 = this.f34635i) <= 0) {
            this.f34631d.run();
        } else {
            ViewCompat.f0(this.f34630c, this.f34631d, i3);
        }
        this.f34639m = true;
    }

    public abstract boolean a(int i3);

    public abstract boolean b(int i3);

    void c() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f34630c.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public abstract void j(int i3, int i4);

    public AutoScrollHelper k(int i3) {
        this.f34635i = i3;
        return this;
    }

    public AutoScrollHelper l(int i3) {
        this.f34634h = i3;
        return this;
    }

    public AutoScrollHelper m(boolean z2) {
        if (this.f34643q && !z2) {
            i();
        }
        this.f34643q = z2;
        return this;
    }

    public AutoScrollHelper n(float f3, float f4) {
        float[] fArr = this.f34633g;
        fArr[0] = f3;
        fArr[1] = f4;
        return this;
    }

    public AutoScrollHelper o(float f3, float f4) {
        float[] fArr = this.f34638l;
        fArr[0] = f3 / 1000.0f;
        fArr[1] = f4 / 1000.0f;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f34643q
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.i()
            goto L58
        L1a:
            r5.f34641o = r2
            r5.f34639m = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f34630c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f34630c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.AutoScrollHelper$ClampedScroller r7 = r5.f34628a
            r7.l(r0, r6)
            boolean r6 = r5.f34642p
            if (r6 != 0) goto L58
            boolean r6 = r5.u()
            if (r6 == 0) goto L58
            r5.v()
        L58:
            boolean r6 = r5.f34644r
            if (r6 == 0) goto L61
            boolean r6 = r5.f34642p
            if (r6 == 0) goto L61
            return r2
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public AutoScrollHelper p(float f3, float f4) {
        float[] fArr = this.f34637k;
        fArr[0] = f3 / 1000.0f;
        fArr[1] = f4 / 1000.0f;
        return this;
    }

    public AutoScrollHelper q(int i3) {
        this.f34628a.j(i3);
        return this;
    }

    public AutoScrollHelper r(int i3) {
        this.f34628a.k(i3);
        return this;
    }

    public AutoScrollHelper s(float f3, float f4) {
        float[] fArr = this.f34632f;
        fArr[0] = f3;
        fArr[1] = f4;
        return this;
    }

    public AutoScrollHelper t(float f3, float f4) {
        float[] fArr = this.f34636j;
        fArr[0] = f3 / 1000.0f;
        fArr[1] = f4 / 1000.0f;
        return this;
    }

    boolean u() {
        ClampedScroller clampedScroller = this.f34628a;
        int iF = clampedScroller.f();
        int iD = clampedScroller.d();
        if (iF == 0 || !b(iF)) {
            return iD != 0 && a(iD);
        }
        return true;
    }
}
