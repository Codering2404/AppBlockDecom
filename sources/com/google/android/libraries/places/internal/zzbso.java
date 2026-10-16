package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class zzbso extends zzblw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzblw f76798a;

    zzbso(zzblw zzblwVar) {
        this.f76798a = zzblwVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbit
    public final zzbix d(zzbml zzbmlVar, zzbis zzbisVar) {
        return this.f76798a.d(zzbmlVar, zzbisVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbit
    public final String f() {
        return this.f76798a.f();
    }

    @Override // com.google.android.libraries.places.internal.zzblw
    public zzblw g() {
        zzblw zzblwVar = this.f76798a;
        ((zzbvr) zzblwVar).Z();
        return zzblwVar;
    }

    public final String toString() {
        return MoreObjects.c(this).d("delegate", this.f76798a).toString();
    }
}
