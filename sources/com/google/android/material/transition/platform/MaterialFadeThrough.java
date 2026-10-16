package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MaterialFadeThrough extends MaterialVisibility<FadeThroughProvider> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f82808d = R.attr.U;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f82809f = R.attr.f79487f0;

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    int e(boolean z2) {
        return f82808d;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    int g(boolean z2) {
        return f82809f;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }
}
