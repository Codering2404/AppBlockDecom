package com.google.android.gms.tagmanager;

import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzby extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.HASH.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.ARG0.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.ALGORITHM.toString();
    private static final String zzd = com.google.android.gms.internal.gtm.zzb.INPUT_FORMAT.toString();

    public zzby() {
        super(zza, zzb);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        byte[] bArrZzb;
        com.google.android.gms.internal.gtm.zzam zzamVar = (com.google.android.gms.internal.gtm.zzam) map.get(zzb);
        if (zzamVar == null || zzamVar == zzfu.zza()) {
            return zzfu.zza();
        }
        String strZzm = zzfu.zzm(zzfu.zzk(zzamVar));
        com.google.android.gms.internal.gtm.zzam zzamVar2 = (com.google.android.gms.internal.gtm.zzam) map.get(zzc);
        String strZzm2 = zzamVar2 == null ? "MD5" : zzfu.zzm(zzfu.zzk(zzamVar2));
        com.google.android.gms.internal.gtm.zzam zzamVar3 = (com.google.android.gms.internal.gtm.zzam) map.get(zzd);
        String strZzm3 = zzamVar3 == null ? "text" : zzfu.zzm(zzfu.zzk(zzamVar3));
        if ("text".equals(strZzm3)) {
            bArrZzb = strZzm.getBytes();
        } else {
            if (!"base16".equals(strZzm3)) {
                Log.e("GoogleTagManager", "Hash: unknown input format: ".concat(String.valueOf(strZzm3)));
                return zzfu.zza();
            }
            bArrZzb = zzp.zzb(strZzm);
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(strZzm2);
            messageDigest.update(bArrZzb);
            return zzfu.zzb(zzp.zza(messageDigest.digest()));
        } catch (NoSuchAlgorithmException unused) {
            Log.e("GoogleTagManager", "Hash: unknown algorithm: ".concat(String.valueOf(strZzm2)));
            return zzfu.zza();
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return true;
    }
}
