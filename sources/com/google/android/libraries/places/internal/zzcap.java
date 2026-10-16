package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcap extends zzcas {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzcat f77344b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcap(zzcat zzcatVar) {
        super(zzcatVar, null);
        Objects.requireNonNull(zzcatVar);
        this.f77344b = zzcatVar;
        int i3 = zzcew.f77735a;
    }

    @Override // com.google.android.libraries.places.internal.zzcas
    public final void a() {
        zzcff zzcffVar = new zzcff();
        int i3 = zzcew.f77735a;
        zzcat zzcatVar = this.f77344b;
        synchronized (zzcatVar.c()) {
            zzcffVar.i2(zzcatVar.zze(), zzcatVar.zze().zzb());
            zzcatVar.j(false);
        }
        zzcat zzcatVar2 = this.f77344b;
        zzcatVar2.k().i2(zzcffVar, zzcffVar.zzb());
        zzcatVar2.k().flush();
    }
}
