package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbzj extends zzbmu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbmu f77285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbzk f77286b;

    zzbzj(zzbzk zzbzkVar, zzbmu zzbmuVar) {
        Objects.requireNonNull(zzbzkVar);
        this.f77286b = zzbzkVar;
        this.f77285a = zzbmuVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbmu
    public final zzbnp a(zzbmw zzbmwVar) {
        zzbnp zzbnpVarA = this.f77285a.a(zzbmwVar);
        if (zzbnpVarA.j()) {
            this.f77286b.e().zzb();
            return zzbnpVarA;
        }
        zzbzk zzbzkVar = this.f77286b;
        zzbzkVar.e().zza(new zzbzi(zzbzkVar));
        return zzbnpVarA;
    }
}
