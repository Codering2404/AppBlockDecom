package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbqj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbnp f76651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbqu f76652b;

    zzbqj(zzbqu zzbquVar, zzbnp zzbnpVar) {
        this.f76651a = zzbnpVar;
        Objects.requireNonNull(zzbquVar);
        this.f76652b = zzbquVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbnp zzbnpVar = this.f76651a;
        this.f76652b.k().e(zzbnpVar.h(), zzbnpVar.i());
    }
}
