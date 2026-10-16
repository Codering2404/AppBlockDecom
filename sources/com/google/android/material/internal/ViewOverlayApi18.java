package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class ViewOverlayApi18 implements ViewOverlayImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewOverlay f81306a;

    ViewOverlayApi18(View view) {
        this.f81306a = view.getOverlay();
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void a(Drawable drawable) {
        this.f81306a.add(drawable);
    }

    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void b(Drawable drawable) {
        this.f81306a.remove(drawable);
    }
}
