package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewPropertyTransition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ViewPropertyAnimationFactory<R> implements TransitionFactory<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewPropertyTransition.Animator f67251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewPropertyTransition f67252b;

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition a(DataSource dataSource, boolean z2) {
        if (dataSource == DataSource.MEMORY_CACHE || !z2) {
            return NoTransition.b();
        }
        if (this.f67252b == null) {
            this.f67252b = new ViewPropertyTransition(this.f67251a);
        }
        return this.f67252b;
    }
}
