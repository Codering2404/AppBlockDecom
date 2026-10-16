package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.DrawingDelegate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class IndeterminateAnimatorDelegate<T extends Animator> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected IndeterminateDrawable f81546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final List f81547b = new ArrayList();

    protected IndeterminateAnimatorDelegate(int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            this.f81547b.add(new DrawingDelegate.ActiveIndicator());
        }
    }

    abstract void a();

    protected float b(int i3, int i4, int i5) {
        return (i3 - i4) / i5;
    }

    public abstract void c();

    public abstract void d(Animatable2Compat.AnimationCallback animationCallback);

    protected void e(IndeterminateDrawable indeterminateDrawable) {
        this.f81546a = indeterminateDrawable;
    }

    abstract void f();

    abstract void g();

    public abstract void h();
}
