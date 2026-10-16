package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionValues;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class MaterialFade extends MaterialVisibility<FadeProvider> {
    private static final int W = R.attr.Y;
    private static final int X = R.attr.f79479b0;
    private static final int Y = R.attr.f79485e0;
    private static final int Z = R.attr.f79483d0;

    @Override // com.google.android.material.transition.MaterialVisibility
    int B0(boolean z2) {
        return z2 ? Y : Z;
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator r0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.r0(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.transition.MaterialVisibility, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator t0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.t0(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    TimeInterpolator y0(boolean z2) {
        return AnimationUtils.f79849a;
    }

    @Override // com.google.android.material.transition.MaterialVisibility
    int z0(boolean z2) {
        return z2 ? W : X;
    }
}
