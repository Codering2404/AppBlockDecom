package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DrawableCrossFadeTransition implements Transition<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f67243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f67244b;

    public DrawableCrossFadeTransition(int i3, boolean z2) {
        this.f67243a = i3;
        this.f67244b = z2;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean a(Drawable drawable, Transition.ViewAdapter viewAdapter) {
        Drawable drawableE = viewAdapter.e();
        if (drawableE == null) {
            drawableE = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawableE, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f67244b);
        transitionDrawable.startTransition(this.f67243a);
        viewAdapter.d(transitionDrawable);
        return true;
    }
}
