package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class CustomTarget<T> implements Target<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f67187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f67188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Request f67189c;

    public CustomTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final Request b() {
        return this.f67189c;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void i(Request request) {
        this.f67189c = request;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void k(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.d(this.f67187a, this.f67188b);
    }

    public CustomTarget(int i3, int i4) {
        if (Util.v(i3, i4)) {
            this.f67187a = i3;
            this.f67188b = i4;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i3 + " and height: " + i4);
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
    public final void c(SizeReadyCallback sizeReadyCallback) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void f(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void j(Drawable drawable) {
    }
}
