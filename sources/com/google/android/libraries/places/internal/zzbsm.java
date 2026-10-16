package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbsm implements zzbpn {
    zzbsm() {
    }

    @Override // com.google.android.libraries.places.internal.zzbpn
    public final void a(zzbmg zzbmgVar) {
        d().a(zzbmgVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbpn
    public void b(zzbnp zzbnpVar, zzbpm zzbpmVar, zzbmg zzbmgVar) {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzcad
    public final void c(zzcac zzcacVar) {
        d().c(zzcacVar);
    }

    protected abstract zzbpn d();

    public final String toString() {
        return MoreObjects.c(this).d("delegate", d()).toString();
    }

    @Override // com.google.android.libraries.places.internal.zzcad
    public final void zzd() {
        d().zzd();
    }
}
