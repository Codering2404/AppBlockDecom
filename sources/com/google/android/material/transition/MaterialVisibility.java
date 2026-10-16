package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.transition.VisibilityAnimatorProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {
    private final VisibilityAnimatorProvider T;
    private VisibilityAnimatorProvider U;
    private final List V;

    private void C0(Context context, boolean z2) {
        TransitionUtils.p(this, context, z0(z2));
        TransitionUtils.q(this, context, B0(z2), y0(z2));
    }

    private static void w0(List list, VisibilityAnimatorProvider visibilityAnimatorProvider, ViewGroup viewGroup, View view, boolean z2) {
        if (visibilityAnimatorProvider == null) {
            return;
        }
        Animator animatorB = z2 ? visibilityAnimatorProvider.b(viewGroup, view) : visibilityAnimatorProvider.a(viewGroup, view);
        if (animatorB != null) {
            list.add(animatorB);
        }
    }

    private Animator x0(ViewGroup viewGroup, View view, boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        w0(arrayList, this.T, viewGroup, view, z2);
        w0(arrayList, this.U, viewGroup, view, z2);
        Iterator it = this.V.iterator();
        while (it.hasNext()) {
            w0(arrayList, (VisibilityAnimatorProvider) it.next(), viewGroup, view, z2);
        }
        C0(viewGroup.getContext(), z2);
        AnimatorSetCompat.a(animatorSet, arrayList);
        return animatorSet;
    }

    int B0(boolean z2) {
        return 0;
    }

    @Override // androidx.transition.Visibility
    public Animator r0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return x0(viewGroup, view, true);
    }

    @Override // androidx.transition.Visibility
    public Animator t0(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return x0(viewGroup, view, false);
    }

    TimeInterpolator y0(boolean z2) {
        return AnimationUtils.f79850b;
    }

    int z0(boolean z2) {
        return 0;
    }
}
