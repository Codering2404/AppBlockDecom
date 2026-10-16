package com.google.android.libraries.places.widget.internal.photoviewer;

import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzb extends ViewPager2.OnPageChangeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PageSelectionIndicator f79097a;

    zzb(PageSelectionIndicator pageSelectionIndicator) {
        this.f79097a = pageSelectionIndicator;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void c(int i3) {
        this.f79097a.a(i3);
    }
}
