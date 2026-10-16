package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcao extends zzcas {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzcat f77343b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcao(zzcat zzcatVar) {
        super(zzcatVar, null);
        Objects.requireNonNull(zzcatVar);
        this.f77343b = zzcatVar;
        int i3 = zzcew.f77735a;
    }

    @Override // com.google.android.libraries.places.internal.zzcas
    public final void a() {
        int iZzm;
        zzcff zzcffVar = new zzcff();
        int i3 = zzcew.f77735a;
        zzcat zzcatVar = this.f77343b;
        synchronized (zzcatVar.c()) {
            zzcffVar.i2(zzcatVar.zze(), zzcatVar.zze().zzi());
            zzcatVar.i(false);
            iZzm = zzcatVar.zzm();
        }
        zzcat zzcatVar2 = this.f77343b;
        zzcatVar2.k().i2(zzcffVar, zzcffVar.zzb());
        synchronized (zzcatVar2.c()) {
            zzcatVar2.r(zzcatVar2.zzm() - iZzm);
        }
    }
}
