package com.google.android.material.motion;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.activity.BackEventCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.google.android.material.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class MaterialBackAnimationHelper<V extends View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TimeInterpolator f81333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final View f81334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f81335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final int f81336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final int f81337e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BackEventCompat f81338f;

    public MaterialBackAnimationHelper(View view) {
        this.f81334b = view;
        Context context = view.getContext();
        this.f81333a = MotionUtils.g(context, R.attr.f79491h0, PathInterpolatorCompat.a(0.0f, 0.0f, 0.0f, 1.0f));
        this.f81335c = MotionUtils.f(context, R.attr.X, 300);
        this.f81336d = MotionUtils.f(context, R.attr.f79479b0, 150);
        this.f81337e = MotionUtils.f(context, R.attr.f79477a0, 100);
    }

    public float a(float f3) {
        return this.f81333a.getInterpolation(f3);
    }

    protected BackEventCompat b() {
        if (this.f81338f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        BackEventCompat backEventCompat = this.f81338f;
        this.f81338f = null;
        return backEventCompat;
    }

    public BackEventCompat c() {
        BackEventCompat backEventCompat = this.f81338f;
        this.f81338f = null;
        return backEventCompat;
    }

    protected void d(BackEventCompat backEventCompat) {
        this.f81338f = backEventCompat;
    }

    protected BackEventCompat e(BackEventCompat backEventCompat) {
        if (this.f81338f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        BackEventCompat backEventCompat2 = this.f81338f;
        this.f81338f = backEventCompat;
        return backEventCompat2;
    }
}
