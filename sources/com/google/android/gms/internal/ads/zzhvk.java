package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhvk {
    public static final /* synthetic */ int zza = 0;
    private static final zzhnf zzb = zzhnf.zzd(zzhvi.zza, zzhvf.class, zzhej.class);
    private static final zzhnf zzc = zzhnf.zzd(zzhvj.zza, zzhvl.class, zzhek.class);
    private static final zzhei zzd = zzhlw.zzf("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey", zzhej.class, zzhsd.zzg());
    private static final zzhdr zze = zzhlw.zze("type.googleapis.com/google.crypto.tink.Ed25519PublicKey", zzhek.class, zzhsp.ASYMMETRIC_PUBLIC, zzhsf.zzg());
    private static final zzhmj zzf = zzhvh.zza;
    private static final zzhln zzg = zzhvg.zza;

    public static void zza(boolean z2) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            throw new GeneralSecurityException("Registering AES GCM SIV is not supported in FIPS mode");
        }
        int i3 = zzhya.zza;
        zzhya.zza(zzhmr.zza());
        zzhmn zzhmnVarZza = zzhmn.zza();
        HashMap map = new HashMap();
        map.put("ED25519", zzhve.zzb(zzhvd.zza));
        zzhvd zzhvdVar = zzhvd.zzd;
        map.put("ED25519_RAW", zzhve.zzb(zzhvdVar));
        map.put("ED25519WithRawOutput", zzhve.zzb(zzhvdVar));
        zzhmnVarZza.zzd(Collections.unmodifiableMap(map));
        zzhmi.zza().zzb(zzg, zzhve.class);
        zzhmk.zza().zzb(zzf, zzhve.class);
        zzhmo.zza().zzb(zzb);
        zzhmo.zza().zzb(zzc);
        zzhlo.zza().zzb(zzd, true);
        zzhlo.zza().zzb(zze, false);
    }
}
