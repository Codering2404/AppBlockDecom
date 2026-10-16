package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MaterialFade extends MaterialVisibility<FadeProvider> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f82804d = R.attr.Y;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f82805f = R.attr.f79479b0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f82806g = R.attr.f79485e0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f82807h = R.attr.f79483d0;

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    TimeInterpolator c(boolean z2) {
        return AnimationUtils.f79849a;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    int e(boolean z2) {
        return z2 ? f82804d : f82805f;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    int g(boolean z2) {
        return z2 ? f82806g : f82807h;
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
