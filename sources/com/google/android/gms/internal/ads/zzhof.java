package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhof {
    private static final zzhln zza = zzhoe.zza;
    private static final zzhnf zzb = zzhnf.zzd(zzhoc.zza, zzhob.class, zzhoj.class);
    private static final zzhnf zzc = zzhnf.zzd(zzhod.zza, zzhob.class, zzheg.class);
    private static final zzhdr zzd = zzhlw.zze("type.googleapis.com/google.crypto.tink.AesCmacKey", zzheg.class, zzhsp.SYMMETRIC, zzhqk.zzg());

    public static void zza(boolean z2) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            throw new GeneralSecurityException("Registering AES CMAC is not supported in FIPS mode");
        }
        int i3 = zzhpl.zza;
        zzhpl.zza(zzhmr.zza());
        zzhmi.zza().zzb(zza, zzhoi.class);
        zzhmo.zza().zzb(zzb);
        zzhmo.zza().zzb(zzc);
        zzhmn zzhmnVarZza = zzhmn.zza();
        HashMap map = new HashMap();
        zzhoi zzhoiVar = zzhpg.zzc;
        map.put("AES_CMAC", zzhoiVar);
        map.put("AES256_CMAC", zzhoiVar);
        zzhog zzhogVar = new zzhog(null);
        zzhogVar.zza(32);
        zzhogVar.zzb(16);
        zzhogVar.zzc(zzhoh.zzd);
        map.put("AES256_CMAC_RAW", zzhogVar.zzd());
        zzhmnVarZza.zzd(Collections.unmodifiableMap(map));
        zzhlo.zza().zzb(zzd, true);
    }

    static /* synthetic */ zzhob zzb(zzhoi zzhoiVar, Integer num) throws GeneralSecurityException {
        zze(zzhoiVar);
        zzhoa zzhoaVar = new zzhoa(null);
        zzhoaVar.zza(zzhoiVar);
        zzhoaVar.zzb(zzibb.zzb(zzhoiVar.zzc()));
        zzhoaVar.zzc(num);
        return zzhoaVar.zzd();
    }

    static /* synthetic */ zzhoj zzc(zzhob zzhobVar) throws GeneralSecurityException {
        zze(zzhobVar.zzf());
        return zzhpo.zza(zzhobVar);
    }

    static /* synthetic */ zzheg zzd(zzhob zzhobVar) throws GeneralSecurityException {
        zze(zzhobVar.zzf());
        return zziap.zza(zzhobVar);
    }

    private static void zze(zzhoi zzhoiVar) throws GeneralSecurityException {
        if (zzhoiVar.zzc() != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }
}
