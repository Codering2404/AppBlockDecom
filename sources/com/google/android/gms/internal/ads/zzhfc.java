package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhfc {
    public static final /* synthetic */ int zza = 0;
    private static final zzhnf zzb = zzhnf.zzd(zzhfb.zza, zzhey.class, zzhdi.class);
    private static final zzhdr zzc = zzhlw.zze("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", zzhdi.class, zzhsp.SYMMETRIC, zzhqq.zzg());
    private static final zzhmj zzd = zzhfa.zza;
    private static final zzhln zze = zzhez.zza;
    private static final int zzf = 2;

    public static void zza(boolean z2) throws GeneralSecurityException {
        int i3 = zzf;
        if (!zzhkr.zza(i3)) {
            throw new GeneralSecurityException("Can not use AES-CTR-HMAC in FIPS-mode, as BoringCrypto module is not available.");
        }
        int i4 = zzhin.zza;
        zzhin.zza(zzhmr.zza());
        zzhmo.zza().zzb(zzb);
        zzhmn zzhmnVarZza = zzhmn.zza();
        HashMap map = new HashMap();
        map.put("AES128_CTR_HMAC_SHA256", zzhhv.zze);
        zzhfd zzhfdVar = new zzhfd(null);
        zzhfdVar.zza(16);
        zzhfdVar.zzb(32);
        zzhfdVar.zzd(16);
        zzhfdVar.zzc(16);
        zzhfe zzhfeVar = zzhfe.zzc;
        zzhfdVar.zzf(zzhfeVar);
        zzhff zzhffVar = zzhff.zzc;
        zzhfdVar.zze(zzhffVar);
        map.put("AES128_CTR_HMAC_SHA256_RAW", zzhfdVar.zzg());
        map.put("AES256_CTR_HMAC_SHA256", zzhhv.zzf);
        zzhfd zzhfdVar2 = new zzhfd(null);
        zzhfdVar2.zza(32);
        zzhfdVar2.zzb(32);
        zzhfdVar2.zzd(32);
        zzhfdVar2.zzc(16);
        zzhfdVar2.zzf(zzhfeVar);
        zzhfdVar2.zze(zzhffVar);
        map.put("AES256_CTR_HMAC_SHA256_RAW", zzhfdVar2.zzg());
        zzhmnVarZza.zzd(Collections.unmodifiableMap(map));
        zzhmk.zza().zzb(zzd, zzhfg.class);
        zzhmi.zza().zzb(zze, zzhfg.class);
        zzhlo.zza().zzf(zzc, i3, true);
    }
}
