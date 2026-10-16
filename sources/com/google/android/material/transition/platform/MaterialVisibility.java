package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.transition.platform.VisibilityAnimatorProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VisibilityAnimatorProvider f82812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private VisibilityAnimatorProvider f82813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f82814c;

    private static void a(List list, VisibilityAnimatorProvider visibilityAnimatorProvider, ViewGroup viewGroup, View view, boolean z2) {
        if (visibilityAnimatorProvider == null) {
            return;
        }
        Animator animatorB = z2 ? visibilityAnimatorProvider.b(viewGroup, view) : visibilityAnimatorProvider.a(viewGroup, view);
        if (animatorB != null) {
            list.add(animatorB);
        }
    }

    private Animator b(ViewGroup viewGroup, View view, boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        a(arrayList, this.f82812a, viewGroup, view, z2);
        a(arrayList, this.f82813b, viewGroup, view, z2);
        Iterator it = this.f82814c.iterator();
        while (it.hasNext()) {
            a(arrayList, (VisibilityAnimatorProvider) it.next(), viewGroup, view, z2);
        }
        h(viewGroup.getContext(), z2);
        AnimatorSetCompat.a(animatorSet, arrayList);
        return animatorSet;
    }

    private void h(Context context, boolean z2) {
        TransitionUtils.q(this, context, e(z2));
        TransitionUtils.r(this, context, g(z2), c(z2));
    }

    TimeInterpolator c(boolean z2) {
        return AnimationUtils.f79850b;
    }

    int e(boolean z2) {
        return 0;
    }

    int g(boolean z2) {
        return 0;
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return b(viewGroup, view, true);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return b(viewGroup, view, false);
    }
}
