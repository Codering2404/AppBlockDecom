package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zznz extends zzay {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ zzoa f74359e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zznz(zzoa zzoaVar, zzjg zzjgVar) {
        super(zzjgVar);
        Objects.requireNonNull(zzoaVar);
        this.f74359e = zzoaVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void a() {
        zzoa zzoaVar = this.f74359e;
        zzoc zzocVar = zzoaVar.f74365d;
        zzocVar.h();
        zzic zzicVar = zzocVar.f73997a;
        zzoaVar.d(false, false, zzicVar.e().a());
        zzocVar.f73997a.M().k(zzicVar.e().a());
    }
}
