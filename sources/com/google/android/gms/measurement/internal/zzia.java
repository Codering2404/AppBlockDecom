package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzia implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzjs f73883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzic f73884b;

    zzia(zzic zzicVar, zzjs zzjsVar) {
        this.f73883a = zzjsVar;
        Objects.requireNonNull(zzicVar);
        this.f73884b = zzicVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzic zzicVar = this.f73884b;
        zzjs zzjsVar = this.f73883a;
        zzicVar.p(zzjsVar);
        zzicVar.v(zzjsVar.f74032d);
    }
}
