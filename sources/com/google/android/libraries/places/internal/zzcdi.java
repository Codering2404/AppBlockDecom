package com.google.android.libraries.places.internal;

import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcdi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzcdi[] f77665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f77666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f77667c;

    zzcdi() {
        this.f77665a = new zzcdi[Function.MAX_NARGS];
        this.f77666b = 0;
        this.f77667c = 0;
    }

    final /* synthetic */ zzcdi[] a() {
        return this.f77665a;
    }

    final /* synthetic */ int b() {
        return this.f77666b;
    }

    final /* synthetic */ int c() {
        return this.f77667c;
    }

    zzcdi(int i3, int i4) {
        this.f77665a = null;
        this.f77666b = i3;
        int i5 = i4 & 7;
        this.f77667c = i5 == 0 ? 8 : i5;
    }
}
