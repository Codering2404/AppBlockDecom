package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhem {
    public static zzheb zza(String str) throws GeneralSecurityException {
        try {
            try {
                try {
                    zzhsz zzhszVarZze = zzhsz.zze(zzhdp.zza(str).zzb().zzaN(), zzido.zza());
                    for (zzhsy zzhsyVar : zzhszVarZze.zzb()) {
                        if (zzhsyVar.zzb().zzc() == zzhsp.UNKNOWN_KEYMATERIAL || zzhsyVar.zzb().zzc() == zzhsp.SYMMETRIC || zzhsyVar.zzb().zzc() == zzhsp.ASYMMETRIC_PRIVATE) {
                            throw new GeneralSecurityException(String.format("keyset contains key material of type %s for type url %s", zzhsyVar.zzb().zzc().name(), zzhsyVar.zzb().zza()));
                        }
                    }
                    return zzheb.zza(zzhszVarZze);
                } catch (zziet unused) {
                    throw new GeneralSecurityException("invalid keyset");
                }
            } catch (zziet unused2) {
                throw new GeneralSecurityException("invalid keyset");
            }
        } catch (IOException unused3) {
            throw new GeneralSecurityException("Parse keyset failed");
        }
    }
}
