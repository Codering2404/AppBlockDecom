package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhjy {
    public static zzhdi zza(zzhec zzhecVar, zzhnk zzhnkVar) throws GeneralSecurityException {
        zzhmd zzhmdVar;
        zzhmd zzhmdVarZza;
        zziaz zziazVarZzd;
        zzhna zzhnaVar = new zzhna();
        for (int i3 = 0; i3 < zzhecVar.zzd(); i3++) {
            zzhdz zzhdzVarZze = ((zzheb) zzhecVar).zze(i3);
            if (zzhdzVarZze.zzb().equals(zzhds.zza)) {
                zzhdq zzhdqVarZza = zzhdzVarZze.zza();
                if (zzhdqVarZza instanceof zzhet) {
                    zziazVarZzd = ((zzhet) zzhdqVarZza).zzc();
                } else {
                    if (!(zzhdqVarZza instanceof zzhlz)) {
                        String name = zzhdqVarZza.getClass().getName();
                        String strValueOf = String.valueOf(zzhdqVarZza.zza());
                        StringBuilder sb = new StringBuilder(name.length() + 59 + strValueOf.length());
                        sb.append("Cannot get output prefix for key of class ");
                        sb.append(name);
                        sb.append(" with parameters ");
                        sb.append(strValueOf);
                        throw new GeneralSecurityException(sb.toString());
                    }
                    zziazVarZzd = ((zzhlz) zzhdqVarZza).zzd();
                }
                zzhnaVar.zza(zziazVarZzd, new zzhjw((zzhdi) zzhnkVar.zza(zzhdzVarZze), zzhdzVarZze.zzc()));
            }
        }
        zzhmc zzhmcVar = (zzhmc) zzhecVar.zzf(zzhmc.class);
        if (zzhmcVar == null || zzhmcVar.zza()) {
            zzhmdVar = zzhmg.zza;
            zzhmdVarZza = zzhmdVar;
        } else {
            zzhme zzhmeVarZzb = zzhmm.zza().zzb();
            zzhmd zzhmdVarZza2 = zzhmeVarZzb.zza(zzhecVar, zzhmcVar, "aead", "encrypt");
            zzhmdVarZza = zzhmeVarZzb.zza(zzhecVar, zzhmcVar, "aead", "decrypt");
            zzhmdVar = zzhmdVarZza2;
        }
        zzheb zzhebVar = (zzheb) zzhecVar;
        return new zzhjx(new zzhjw((zzhdi) zzhnkVar.zza(zzhebVar.zzc()), zzhebVar.zzc().zzc()), zzhnaVar.zzb(), zzhmdVar, zzhmdVarZza, null);
    }
}
