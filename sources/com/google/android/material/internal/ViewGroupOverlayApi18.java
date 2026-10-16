package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.ViewGroupOverlay;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroupOverlay f81299a;

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void a(Drawable drawable) {
        this.f81299a.add(drawable);
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void b(Drawable drawable) {
        this.f81299a.remove(drawable);
    }
}
