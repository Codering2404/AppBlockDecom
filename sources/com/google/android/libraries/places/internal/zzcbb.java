package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcbb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbon f77373a;

    zzcbb(zzcbc zzcbcVar, zzbon zzbonVar) {
        this.f77373a = zzbonVar;
        Objects.requireNonNull(zzcbcVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f77373a.a();
    }
}
