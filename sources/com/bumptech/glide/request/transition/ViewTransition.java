package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ViewTransition<R> implements Transition<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewTransitionAnimationFactory f67254a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface ViewTransitionAnimationFactory {
        Animation a(Context context);
    }

    ViewTransition(ViewTransitionAnimationFactory viewTransitionAnimationFactory) {
        this.f67254a = viewTransitionAnimationFactory;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean a(Object obj, Transition.ViewAdapter viewAdapter) {
        View viewA = viewAdapter.a();
        if (viewA == null) {
            return false;
        }
        viewA.clearAnimation();
        viewA.startAnimation(this.f67254a.a(viewA.getContext()));
        return false;
    }
}
