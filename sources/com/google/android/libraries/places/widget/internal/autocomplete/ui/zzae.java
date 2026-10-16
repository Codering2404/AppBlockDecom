package com.google.android.libraries.places.widget.internal.autocomplete.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.internal.zznb;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzae extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f79027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ RecyclerView.ViewHolder f79028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f79029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzaf f79030d;

    zzae(zzaf zzafVar, View view, RecyclerView.ViewHolder viewHolder, ViewPropertyAnimator viewPropertyAnimator) {
        this.f79027a = view;
        this.f79028b = viewHolder;
        this.f79029c = viewPropertyAnimator;
        Objects.requireNonNull(zzafVar);
        this.f79030d = zzafVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        try {
            zzaf.g0(this.f79027a);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        try {
            ViewPropertyAnimator viewPropertyAnimator = this.f79029c;
            viewPropertyAnimator.setListener(null);
            zzaf zzafVar = this.f79030d;
            RecyclerView.ViewHolder viewHolder = this.f79028b;
            zzafVar.B(viewHolder);
            zzafVar.e0().remove(viewHolder);
            zzafVar.c0();
            viewPropertyAnimator.setStartDelay(0L);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        try {
            this.f79027a.setAlpha(0.0f);
            this.f79030d.C(this.f79028b);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }
}
