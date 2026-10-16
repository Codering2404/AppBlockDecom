package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmq extends zzay {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ zznl f74261e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzmq(zznl zznlVar, zzjg zzjgVar) {
        super(zzjgVar);
        Objects.requireNonNull(zznlVar);
        this.f74261e = zznlVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void a() {
        this.f74261e.f73997a.a().r().a("Tasks have been queued for a long time");
    }
}
