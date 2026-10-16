package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MotionTiming {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f79864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f79865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TimeInterpolator f79866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f79867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f79868e;

    public MotionTiming(long j3, long j4) {
        this.f79866c = null;
        this.f79867d = 0;
        this.f79868e = 1;
        this.f79864a = j3;
        this.f79865b = j4;
    }

    static MotionTiming b(ValueAnimator valueAnimator) {
        MotionTiming motionTiming = new MotionTiming(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        motionTiming.f79867d = valueAnimator.getRepeatCount();
        motionTiming.f79868e = valueAnimator.getRepeatMode();
        return motionTiming;
    }

    private static TimeInterpolator f(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? AnimationUtils.f79850b : interpolator instanceof AccelerateInterpolator ? AnimationUtils.f79851c : interpolator instanceof DecelerateInterpolator ? AnimationUtils.f79852d : interpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f79864a;
    }

    public long d() {
        return this.f79865b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f79866c;
        return timeInterpolator != null ? timeInterpolator : AnimationUtils.f79850b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MotionTiming)) {
            return false;
        }
        MotionTiming motionTiming = (MotionTiming) obj;
        if (c() == motionTiming.c() && d() == motionTiming.d() && g() == motionTiming.g() && h() == motionTiming.h()) {
            return e().getClass().equals(motionTiming.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f79867d;
    }

    public int h() {
        return this.f79868e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public MotionTiming(long j3, long j4, TimeInterpolator timeInterpolator) {
        this.f79867d = 0;
        this.f79868e = 1;
        this.f79864a = j3;
        this.f79865b = j4;
        this.f79866c = timeInterpolator;
    }
}
