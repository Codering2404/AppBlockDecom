package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzial implements zzhqd {
    final zzhqd zza;
    final zzhqd zzb;

    /* synthetic */ zzial(zzhqd zzhqdVar, zzhqd zzhqdVar2, byte[] bArr) {
        this.zza = zzhqdVar;
        this.zzb = zzhqdVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhqd
    public final byte[] zza(byte[] bArr, int i3) throws GeneralSecurityException {
        return bArr.length <= 64 ? this.zza.zza(bArr, i3) : this.zzb.zza(bArr, i3);
    }
}
