package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhgk {
    public static final /* synthetic */ int zza = 0;
    private static final zzhnf zzb = zzhnf.zzd(zzhgj.zza, zzhgh.class, zzhdi.class);
    private static final zzhln zzc = zzhgi.zza;
    private static final zzhdr zzd = zzhlw.zze("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", zzhdi.class, zzhsp.SYMMETRIC, zzhro.zze());

    public static void zza(boolean z2) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            throw new GeneralSecurityException("Registering ChaCha20Poly1305 is not supported in FIPS mode");
        }
        int i3 = zzhjm.zza;
        zzhjm.zza(zzhmr.zza());
        zzhmo.zza().zzb(zzb);
        zzhmi.zza().zzb(zzc, zzhgm.class);
        zzhmn zzhmnVarZza = zzhmn.zza();
        HashMap map = new HashMap();
        map.put("CHACHA20_POLY1305", zzhgm.zzb(zzhgl.zza));
        map.put("CHACHA20_POLY1305_RAW", zzhgm.zzb(zzhgl.zzc));
        zzhmnVarZza.zzd(Collections.unmodifiableMap(map));
        zzhlo.zza().zzb(zzd, true);
    }
}
