package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbrh implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f76713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbrt f76714b;

    zzbrh(zzbrt zzbrtVar, int i3) {
        this.f76713a = i3;
        Objects.requireNonNull(zzbrtVar);
        this.f76714b = zzbrtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f76714b.o().zzb(this.f76713a);
    }
}
