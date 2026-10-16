package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbv {
    public static final String zza;
    public static final String zzb;

    static {
        String strReplaceAll = String.valueOf(GoogleApiAvailabilityLight.f71453a / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
        zza = strReplaceAll;
        zzb = "ma".concat(String.valueOf(strReplaceAll));
    }
}
