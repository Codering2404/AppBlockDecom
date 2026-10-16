package com.google.android.gms.internal.ads;

import androidx.appcompat.app.jE.vxrlPPpdv;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhzc {
    public static zzhek zza(zzhec zzhecVar, zzhnk zzhnkVar) throws GeneralSecurityException {
        zziaz zziazVarZzd;
        zzhna zzhnaVar = new zzhna();
        for (int i3 = 0; i3 < zzhecVar.zzd(); i3++) {
            zzhdz zzhdzVarZze = ((zzheb) zzhecVar).zze(i3);
            if (zzhdzVarZze.zzb().equals(zzhds.zza)) {
                zzhek zzhekVar = (zzhek) zzhnkVar.zza(zzhdzVarZze);
                zzhdq zzhdqVarZza = zzhdzVarZze.zza();
                if (zzhdqVarZza instanceof zzhxk) {
                    zziazVarZzd = ((zzhxk) zzhdqVarZza).zze();
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
                zzhnaVar.zza(zziazVarZzd, new zzhzb(zzhekVar, zzhdzVarZze.zzc()));
            }
        }
        zzhmc zzhmcVar = (zzhmc) zzhecVar.zzf(zzhmc.class);
        return new zzhza(zzhnaVar.zzb(), (zzhmcVar == null || zzhmcVar.zza()) ? zzhmg.zza : zzhmm.zza().zzb().zza(zzhecVar, zzhmcVar, vxrlPPpdv.UdOXQJJXyIho, "verify"));
    }
}
