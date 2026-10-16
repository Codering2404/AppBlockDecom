package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbrm implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbnp f76721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbrt f76722b;

    zzbrm(zzbrt zzbrtVar, zzbnp zzbnpVar) {
        this.f76721a = zzbnpVar;
        Objects.requireNonNull(zzbrtVar);
        this.f76722b = zzbrtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f76722b.o().c(this.f76721a);
    }
}
