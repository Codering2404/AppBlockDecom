package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbiz extends zzbit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbit f76267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbiy f76268b;

    /* synthetic */ zzbiz(zzbit zzbitVar, zzbiy zzbiyVar, byte[] bArr) {
        this.f76267a = zzbitVar;
        this.f76268b = (zzbiy) Preconditions.u(zzbiyVar, "interceptor");
    }

    @Override // com.google.android.libraries.places.internal.zzbit
    public final zzbix d(zzbml zzbmlVar, zzbis zzbisVar) {
        return this.f76268b.a(zzbmlVar, zzbisVar, this.f76267a);
    }

    @Override // com.google.android.libraries.places.internal.zzbit
    public final String f() {
        return this.f76267a.f();
    }
}
