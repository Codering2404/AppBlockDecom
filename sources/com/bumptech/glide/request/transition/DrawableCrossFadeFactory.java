package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f67240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f67241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DrawableCrossFadeTransition f67242c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {
    }

    private Transition b() {
        if (this.f67242c == null) {
            this.f67242c = new DrawableCrossFadeTransition(this.f67240a, this.f67241b);
        }
        return this.f67242c;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition a(DataSource dataSource, boolean z2) {
        return dataSource == DataSource.MEMORY_CACHE ? NoTransition.b() : b();
    }
}
