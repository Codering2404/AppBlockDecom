package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbsn implements zzbqa {
    zzbsn() {
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public void a(zzbnp zzbnpVar) {
        d().a(zzbnpVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public final Runnable b(zzbwc zzbwcVar) {
        d().b(zzbwcVar);
        return null;
    }

    @Override // com.google.android.libraries.places.internal.zzbwd
    public void c(zzbnp zzbnpVar) {
        d().c(zzbnpVar);
    }

    protected abstract zzbqa d();

    @Override // com.google.android.libraries.places.internal.zzbpo
    public zzbpl e(zzbml zzbmlVar, zzbmg zzbmgVar, zzbis zzbisVar, zzbje[] zzbjeVarArr) {
        throw null;
    }

    public final String toString() {
        return MoreObjects.c(this).d("delegate", d()).toString();
    }

    @Override // com.google.android.libraries.places.internal.zzbkz
    public final zzbku zzc() {
        return d().zzc();
    }

    @Override // com.google.android.libraries.places.internal.zzbqa
    public final zzbio zzf() {
        return d().zzf();
    }
}
