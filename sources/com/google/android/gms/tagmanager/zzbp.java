package com.google.android.gms.tagmanager;

import android.util.Base64;
import android.util.Log;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbp extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.ENCODE.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.ARG0.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.NO_PADDING.toString();
    private static final String zzd = com.google.android.gms.internal.gtm.zzb.INPUT_FORMAT.toString();
    private static final String zze = com.google.android.gms.internal.gtm.zzb.OUTPUT_FORMAT.toString();

    public zzbp() {
        super(zza, zzb);
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        byte[] bArrDecode;
        String strEncodeToString;
        com.google.android.gms.internal.gtm.zzam zzamVar = (com.google.android.gms.internal.gtm.zzam) map.get(zzb);
        if (zzamVar == null || zzamVar == zzfu.zza()) {
            return zzfu.zza();
        }
        String strZzm = zzfu.zzm(zzfu.zzk(zzamVar));
        com.google.android.gms.internal.gtm.zzam zzamVar2 = (com.google.android.gms.internal.gtm.zzam) map.get(zzd);
        String strZzm2 = zzamVar2 == null ? "text" : zzfu.zzm(zzfu.zzk(zzamVar2));
        com.google.android.gms.internal.gtm.zzam zzamVar3 = (com.google.android.gms.internal.gtm.zzam) map.get(zze);
        String strZzm3 = zzamVar3 == null ? "base16" : zzfu.zzm(zzfu.zzk(zzamVar3));
        com.google.android.gms.internal.gtm.zzam zzamVar4 = (com.google.android.gms.internal.gtm.zzam) map.get(zzc);
        int i3 = 2;
        if (zzamVar4 != null && zzfu.zzf(zzfu.zzk(zzamVar4)).booleanValue()) {
            i3 = 3;
        }
        try {
            if ("text".equals(strZzm2)) {
                bArrDecode = strZzm.getBytes();
            } else if ("base16".equals(strZzm2)) {
                bArrDecode = zzp.zzb(strZzm);
            } else if ("base64".equals(strZzm2)) {
                bArrDecode = Base64.decode(strZzm, i3);
            } else {
                if (!"base64url".equals(strZzm2)) {
                    Log.e("GoogleTagManager", "Encode: unknown input format: " + strZzm2);
                    return zzfu.zza();
                }
                bArrDecode = Base64.decode(strZzm, i3 | 8);
            }
            if ("base16".equals(strZzm3)) {
                strEncodeToString = zzp.zza(bArrDecode);
            } else if ("base64".equals(strZzm3)) {
                strEncodeToString = Base64.encodeToString(bArrDecode, i3);
            } else {
                if (!"base64url".equals(strZzm3)) {
                    Log.e("GoogleTagManager", "Encode: unknown output format: ".concat(String.valueOf(strZzm3)));
                    return zzfu.zza();
                }
                strEncodeToString = Base64.encodeToString(bArrDecode, i3 | 8);
            }
            return zzfu.zzb(strEncodeToString);
        } catch (IllegalArgumentException unused) {
            Log.e("GoogleTagManager", "Encode: invalid input:");
            return zzfu.zza();
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return true;
    }
}
