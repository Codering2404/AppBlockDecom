package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewTransition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ViewAnimationFactory<R> implements TransitionFactory<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewTransition.ViewTransitionAnimationFactory f67247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Transition f67248b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ConcreteViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Animation f67249a;

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public Animation a(Context context) {
            return this.f67249a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ResourceViewTransitionAnimationFactory implements ViewTransition.ViewTransitionAnimationFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f67250a;

        @Override // com.bumptech.glide.request.transition.ViewTransition.ViewTransitionAnimationFactory
        public Animation a(Context context) {
            return AnimationUtils.loadAnimation(context, this.f67250a);
        }
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition a(DataSource dataSource, boolean z2) {
        if (dataSource == DataSource.MEMORY_CACHE || !z2) {
            return NoTransition.b();
        }
        if (this.f67248b == null) {
            this.f67248b = new ViewTransition(this.f67247a);
        }
        return this.f67248b;
    }
}
