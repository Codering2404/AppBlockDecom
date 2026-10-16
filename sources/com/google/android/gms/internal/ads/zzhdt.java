package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhdt {
    static final zzhst zza(zzheh zzhehVar) {
        try {
            return ((zzhnn) zzhmr.zza().zzk(null, zzhnn.class)).zzc();
        } catch (GeneralSecurityException e3) {
            throw new zzhny("Parsing parameters failed in getProto(). You probably want to call some Tink register function for ".concat("null"), e3);
        }
    }

    public static final zzheh zzb(zzheh zzhehVar) throws GeneralSecurityException {
        return zzhehVar != null ? zzhehVar : zzhen.zzb(zza(null).zzaN());
    }
}
