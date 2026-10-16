package com.google.android.libraries.places.widget.internal.photoviewer;

import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzy extends ViewPager2.OnPageChangeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PlacesLightboxActivity f79136a;

    zzy(PlacesLightboxActivity placesLightboxActivity) {
        this.f79136a = placesLightboxActivity;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public final void c(int i3) {
        PlacesLightboxActivity placesLightboxActivity = this.f79136a;
        placesLightboxActivity.i0(i3);
        if (i3 != placesLightboxActivity.f79091h) {
            placesLightboxActivity.f79090g++;
            placesLightboxActivity.f79091h = i3;
        }
    }
}
