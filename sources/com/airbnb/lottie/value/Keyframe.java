package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Keyframe<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LottieComposition f57110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f57111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f57112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Interpolator f57113d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Interpolator f57114e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Interpolator f57115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f57116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Float f57117h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f57118i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f57119j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f57120k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f57121l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f57122m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f57123n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PointF f57124o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public PointF f57125p;

    public Keyframe(LottieComposition lottieComposition, Object obj, Object obj2, Interpolator interpolator, float f3, Float f4) {
        this.f57118i = -3987645.8f;
        this.f57119j = -3987645.8f;
        this.f57120k = 784923401;
        this.f57121l = 784923401;
        this.f57122m = Float.MIN_VALUE;
        this.f57123n = Float.MIN_VALUE;
        this.f57124o = null;
        this.f57125p = null;
        this.f57110a = lottieComposition;
        this.f57111b = obj;
        this.f57112c = obj2;
        this.f57113d = interpolator;
        this.f57114e = null;
        this.f57115f = null;
        this.f57116g = f3;
        this.f57117h = f4;
    }

    public boolean a(float f3) {
        return f3 >= f() && f3 < c();
    }

    public Keyframe b(Object obj, Object obj2) {
        return new Keyframe(obj, obj2);
    }

    public float c() {
        if (this.f57110a == null) {
            return 1.0f;
        }
        if (this.f57123n == Float.MIN_VALUE) {
            if (this.f57117h == null) {
                this.f57123n = 1.0f;
            } else {
                this.f57123n = f() + ((this.f57117h.floatValue() - this.f57116g) / this.f57110a.e());
            }
        }
        return this.f57123n;
    }

    public float d() {
        if (this.f57119j == -3987645.8f) {
            this.f57119j = ((Float) this.f57112c).floatValue();
        }
        return this.f57119j;
    }

    public int e() {
        if (this.f57121l == 784923401) {
            this.f57121l = ((Integer) this.f57112c).intValue();
        }
        return this.f57121l;
    }

    public float f() {
        LottieComposition lottieComposition = this.f57110a;
        if (lottieComposition == null) {
            return 0.0f;
        }
        if (this.f57122m == Float.MIN_VALUE) {
            this.f57122m = (this.f57116g - lottieComposition.p()) / this.f57110a.e();
        }
        return this.f57122m;
    }

    public float g() {
        if (this.f57118i == -3987645.8f) {
            this.f57118i = ((Float) this.f57111b).floatValue();
        }
        return this.f57118i;
    }

    public int h() {
        if (this.f57120k == 784923401) {
            this.f57120k = ((Integer) this.f57111b).intValue();
        }
        return this.f57120k;
    }

    public boolean i() {
        return this.f57113d == null && this.f57114e == null && this.f57115f == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f57111b + ", endValue=" + this.f57112c + ", startFrame=" + this.f57116g + ", endFrame=" + this.f57117h + ", interpolator=" + this.f57113d + '}';
    }

    public Keyframe(LottieComposition lottieComposition, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, float f3, Float f4) {
        this.f57118i = -3987645.8f;
        this.f57119j = -3987645.8f;
        this.f57120k = 784923401;
        this.f57121l = 784923401;
        this.f57122m = Float.MIN_VALUE;
        this.f57123n = Float.MIN_VALUE;
        this.f57124o = null;
        this.f57125p = null;
        this.f57110a = lottieComposition;
        this.f57111b = obj;
        this.f57112c = obj2;
        this.f57113d = null;
        this.f57114e = interpolator;
        this.f57115f = interpolator2;
        this.f57116g = f3;
        this.f57117h = f4;
    }

    protected Keyframe(LottieComposition lottieComposition, Object obj, Object obj2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f3, Float f4) {
        this.f57118i = -3987645.8f;
        this.f57119j = -3987645.8f;
        this.f57120k = 784923401;
        this.f57121l = 784923401;
        this.f57122m = Float.MIN_VALUE;
        this.f57123n = Float.MIN_VALUE;
        this.f57124o = null;
        this.f57125p = null;
        this.f57110a = lottieComposition;
        this.f57111b = obj;
        this.f57112c = obj2;
        this.f57113d = interpolator;
        this.f57114e = interpolator2;
        this.f57115f = interpolator3;
        this.f57116g = f3;
        this.f57117h = f4;
    }

    public Keyframe(Object obj) {
        this.f57118i = -3987645.8f;
        this.f57119j = -3987645.8f;
        this.f57120k = 784923401;
        this.f57121l = 784923401;
        this.f57122m = Float.MIN_VALUE;
        this.f57123n = Float.MIN_VALUE;
        this.f57124o = null;
        this.f57125p = null;
        this.f57110a = null;
        this.f57111b = obj;
        this.f57112c = obj;
        this.f57113d = null;
        this.f57114e = null;
        this.f57115f = null;
        this.f57116g = Float.MIN_VALUE;
        this.f57117h = Float.valueOf(Float.MAX_VALUE);
    }

    private Keyframe(Object obj, Object obj2) {
        this.f57118i = -3987645.8f;
        this.f57119j = -3987645.8f;
        this.f57120k = 784923401;
        this.f57121l = 784923401;
        this.f57122m = Float.MIN_VALUE;
        this.f57123n = Float.MIN_VALUE;
        this.f57124o = null;
        this.f57125p = null;
        this.f57110a = null;
        this.f57111b = obj;
        this.f57112c = obj2;
        this.f57113d = null;
        this.f57114e = null;
        this.f57115f = null;
        this.f57116g = Float.MIN_VALUE;
        this.f57117h = Float.valueOf(Float.MAX_VALUE);
    }
}
