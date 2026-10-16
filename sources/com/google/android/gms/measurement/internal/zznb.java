package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zznb implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zznf f74298a;

    zznb(zznf zznfVar) {
        Objects.requireNonNull(zznfVar);
        this.f74298a = zznfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznl zznlVar = this.f74298a.f74305c;
        zzic zzicVar = zznlVar.f73997a;
        Context contextD = zzicVar.d();
        zzicVar.c();
        zznlVar.K(new ComponentName(contextD, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
