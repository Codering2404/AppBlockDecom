package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class NoTransition<R> implements Transition<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final NoTransition f67245a = new NoTransition();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final TransitionFactory f67246b = new NoAnimationFactory();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class NoAnimationFactory<R> implements TransitionFactory<R> {
        @Override // com.bumptech.glide.request.transition.TransitionFactory
        public Transition a(DataSource dataSource, boolean z2) {
            return NoTransition.f67245a;
        }
    }

    public static Transition b() {
        return f67245a;
    }

    public static TransitionFactory c() {
        return f67246b;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean a(Object obj, Transition.ViewAdapter viewAdapter) {
        return false;
    }
}
