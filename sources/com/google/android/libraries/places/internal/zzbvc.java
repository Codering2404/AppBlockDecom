package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbvc extends zzbit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbvl f76940a;

    zzbvc(zzbvl zzbvlVar) {
        Objects.requireNonNull(zzbvlVar);
        this.f76940a = zzbvlVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbit
    public final zzbix d(zzbml zzbmlVar, zzbis zzbisVar) {
        zzbvr zzbvrVar = this.f76940a.f76957d;
        zzbpk zzbpkVar = new zzbpk(zzbmlVar, zzbvrVar.i0(zzbisVar), zzbisVar, zzbvrVar.P(), zzbvrVar.z() ? null : zzbvrVar.o0().zzb(), zzbvrVar.B(), null);
        zzbpkVar.f(zzbvrVar.s0());
        return zzbpkVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbit
    public final String f() {
        return this.f76940a.k();
    }
}
