package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zziam implements zzhqd {
    public static zzhqd zzb(zzhqb zzhqbVar) throws GeneralSecurityException {
        zzhqd zzhqdVarZzb = zzhqh.zzb(zzhqbVar);
        try {
            return new zzial(zzhqdVarZzb, zzhqi.zzb(zzhqbVar), null);
        } catch (GeneralSecurityException unused) {
            return zzhqdVarZzb;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhqd
    public final byte[] zza(byte[] bArr, int i3) throws GeneralSecurityException {
        throw null;
    }
}
