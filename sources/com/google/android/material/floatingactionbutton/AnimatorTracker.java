package com.google.android.material.floatingactionbutton;

import android.animation.Animator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class AnimatorTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animator f80970a;

    public void a() {
        Animator animator = this.f80970a;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void b() {
        this.f80970a = null;
    }

    public void c(Animator animator) {
        a();
        this.f80970a = animator;
    }
}
