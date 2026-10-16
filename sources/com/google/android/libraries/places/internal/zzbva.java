package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbva implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbnp f76935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbvb f76936b;

    zzbva(zzbvb zzbvbVar, zzbnp zzbnpVar) {
        this.f76935a = zzbnpVar;
        Objects.requireNonNull(zzbvbVar);
        this.f76936b = zzbvbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f76936b.b(this.f76935a);
    }
}
