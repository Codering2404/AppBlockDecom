package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmm extends zzay {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ zznl f74249e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzmm(zznl zznlVar, zzjg zzjgVar) {
        super(zzjgVar);
        Objects.requireNonNull(zznlVar);
        this.f74249e = zznlVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void a() {
        zznl zznlVar = this.f74249e;
        zznlVar.h();
        if (zznlVar.W()) {
            zznlVar.f73997a.a().w().a("Inactivity, disconnecting from the service");
            zznlVar.A();
        }
    }
}
