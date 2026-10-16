package com.google.android.libraries.places.internal;

import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzfh implements zzbie {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbih f77815a;

    private zzfh(zzbih zzbihVar) {
        this.f77815a = zzbihVar;
    }

    public static zzfh a(zzbih zzbihVar) {
        return new zzfh(zzbihVar);
    }

    @Override // com.google.android.libraries.places.internal.zzcez
    public final /* bridge */ /* synthetic */ Object zzb() {
        Optional optional = (Optional) this.f77815a.zzb();
        zzcbd zzcbdVarE = zzcbd.e("mapsmobilesdks-pa.googleapis.com", 443);
        zzcbdVarE.f();
        zzbmg zzbmgVar = new zzbmg();
        zzbmgVar.c(zzbmc.c("X-Goog-Api-Key", zzbmg.f76399d), (String) optional.orElse("AIzaSyDgmW4ZMvNblSXqMOgsbY8uRrTnfR3E7pY"));
        zzcbdVarE.c(zzcei.a(zzbmgVar));
        return zzcbdVarE.a();
    }
}
