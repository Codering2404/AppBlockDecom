package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class StateListAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList f81263a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Tuple f81264b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ValueAnimator f81265c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Animator.AnimatorListener f81266d = new AnimatorListenerAdapter() { // from class: com.google.android.material.internal.StateListAnimator.1
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            StateListAnimator stateListAnimator = StateListAnimator.this;
            if (stateListAnimator.f81265c == animator) {
                stateListAnimator.f81265c = null;
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Tuple {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int[] f81268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ValueAnimator f81269b;

        Tuple(int[] iArr, ValueAnimator valueAnimator) {
            this.f81268a = iArr;
            this.f81269b = valueAnimator;
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.f81265c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f81265c = null;
        }
    }

    private void e(Tuple tuple) {
        ValueAnimator valueAnimator = tuple.f81269b;
        this.f81265c = valueAnimator;
        valueAnimator.start();
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        Tuple tuple = new Tuple(iArr, valueAnimator);
        valueAnimator.addListener(this.f81266d);
        this.f81263a.add(tuple);
    }

    public void c() {
        ValueAnimator valueAnimator = this.f81265c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f81265c = null;
        }
    }

    public void d(int[] iArr) {
        Tuple tuple;
        int size = this.f81263a.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                tuple = null;
                break;
            }
            tuple = (Tuple) this.f81263a.get(i3);
            if (StateSet.stateSetMatches(tuple.f81268a, iArr)) {
                break;
            } else {
                i3++;
            }
        }
        Tuple tuple2 = this.f81264b;
        if (tuple == tuple2) {
            return;
        }
        if (tuple2 != null) {
            b();
        }
        this.f81264b = tuple;
        if (tuple != null) {
            e(tuple);
        }
    }
}
