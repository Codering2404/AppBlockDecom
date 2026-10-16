package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbnu implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbnv f76507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Runnable f76508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbnx f76509c;

    zzbnu(zzbnx zzbnxVar, zzbnv zzbnvVar, Runnable runnable) {
        this.f76507a = zzbnvVar;
        this.f76508b = runnable;
        Objects.requireNonNull(zzbnxVar);
        this.f76509c = zzbnxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbnx zzbnxVar = this.f76509c;
        zzbnxVar.a(this.f76507a);
        zzbnxVar.zza();
    }

    public final String toString() {
        return String.valueOf(this.f76508b.toString()).concat("(scheduled in SynchronizationContext)");
    }
}
