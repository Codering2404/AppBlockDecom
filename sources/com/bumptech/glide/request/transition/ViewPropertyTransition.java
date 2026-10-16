package com.bumptech.glide.request.transition;

import android.view.View;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ViewPropertyTransition<R> implements Transition<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Animator f67253a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Animator {
        void a(View view);
    }

    public ViewPropertyTransition(Animator animator) {
        this.f67253a = animator;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean a(Object obj, Transition.ViewAdapter viewAdapter) {
        if (viewAdapter.a() == null) {
            return false;
        }
        this.f67253a.a(viewAdapter.a());
        return false;
    }
}
