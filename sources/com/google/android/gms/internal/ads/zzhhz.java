package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhhz {
    private static final zzhln zza = zzhhy.zza;
    private static final zzhnf zzb = zzhnf.zzd(zzhhx.zza, zzhhw.class, zzhdi.class);

    public static void zza(boolean z2) throws GeneralSecurityException {
        int i3 = zzhke.zza;
        zzhke.zza(zzhmr.zza());
        zzhmn zzhmnVarZza = zzhmn.zza();
        HashMap map = new HashMap();
        map.put("XAES_256_GCM_192_BIT_NONCE", zzhhv.zzg);
        map.put("XAES_256_GCM_192_BIT_NONCE_NO_PREFIX", zzhhv.zzh);
        map.put("XAES_256_GCM_160_BIT_NONCE_NO_PREFIX", zzhhv.zzi);
        map.put("X_AES_GCM_8_BYTE_SALT_NO_PREFIX", zzhhv.zzj);
        zzhmnVarZza.zzd(Collections.unmodifiableMap(map));
        zzhmo.zza().zzb(zzb);
        zzhmi.zza().zzb(zza, zzhib.class);
    }
}
