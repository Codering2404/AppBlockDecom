package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbsj implements zzbpo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final zzbnp f76795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbpm f76796b;

    zzbsj(zzbnp zzbnpVar, zzbpm zzbpmVar) {
        Preconditions.e(!zzbnpVar.j(), "error must not be OK");
        this.f76795a = zzbnpVar;
        this.f76796b = zzbpmVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbpo
    public final zzbpl e(zzbml zzbmlVar, zzbmg zzbmgVar, zzbis zzbisVar, zzbje[] zzbjeVarArr) {
        return new zzbsi(this.f76795a, this.f76796b, zzbjeVarArr);
    }

    @Override // com.google.android.libraries.places.internal.zzbkz
    public final zzbku zzc() {
        throw new UnsupportedOperationException("Not a real transport");
    }
}
