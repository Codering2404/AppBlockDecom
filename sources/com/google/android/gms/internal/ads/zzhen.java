package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhen {
    public static byte[] zza(zzheh zzhehVar) throws GeneralSecurityException {
        return ((zzhnn) zzhmr.zza().zzk(zzhehVar, zzhnn.class)).zzc().zzaN();
    }

    public static zzheh zzb(byte[] bArr) throws GeneralSecurityException {
        try {
            zzhst zzhstVarZzd = zzhst.zzd(bArr, zzido.zza());
            zzhmr zzhmrVarZza = zzhmr.zza();
            zzhnn zzhnnVarZzb = zzhnn.zzb(zzhstVarZzd);
            return !zzhmrVarZza.zzi(zzhnnVarZzb) ? new zzhma(zzhnnVarZzb) : zzhmrVarZza.zzj(zzhnnVarZzb);
        } catch (IOException e3) {
            throw new GeneralSecurityException("Failed to parse proto", e3);
        }
    }
}
