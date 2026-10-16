package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzceh implements zzbiy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbmg f77709a;

    zzceh(zzbmg zzbmgVar) {
        this.f77709a = (zzbmg) Preconditions.u(zzbmgVar, "extraHeaders");
    }

    @Override // com.google.android.libraries.places.internal.zzbiy
    public final zzbix a(zzbml zzbmlVar, zzbis zzbisVar, zzbit zzbitVar) {
        return new zzceg(this, zzbitVar.d(zzbmlVar, zzbisVar));
    }

    final /* synthetic */ zzbmg b() {
        return this.f77709a;
    }
}
