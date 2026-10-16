package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbqy implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbnp f76684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbrb f76685b;

    zzbqy(zzbrb zzbrbVar, zzbnp zzbnpVar) {
        this.f76684a = zzbnpVar;
        Objects.requireNonNull(zzbrbVar);
        this.f76685b = zzbrbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f76685b.l().a(this.f76684a);
    }
}
