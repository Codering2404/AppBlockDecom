package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public abstract class BaseTarget<Z> implements Target<Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Request f67186a;

    @Override // com.bumptech.glide.request.target.Target
    public Request b() {
        return this.f67186a;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void i(Request request) {
        this.f67186a = request;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void f(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void g(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void j(Drawable drawable) {
    }
}
