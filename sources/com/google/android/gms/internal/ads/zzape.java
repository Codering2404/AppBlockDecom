package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.common.Constants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzape {
    public static long zza(String str) {
        String str2 = zzfl.zza;
        String[] strArrSplit = str.split("\\.", 2);
        long j3 = 0;
        for (String str3 : strArrSplit[0].split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, -1)) {
            j3 = (j3 * 60) + Long.parseLong(str3);
        }
        long j4 = j3 * 1000;
        if (strArrSplit.length == 2) {
            String strTrim = strArrSplit[1].trim();
            if (strTrim.length() != 3) {
                throw new IllegalArgumentException("Expected 3 decimal places, got: ".concat(strTrim));
            }
            j4 += Long.parseLong(strTrim);
        }
        return j4 * 1000;
    }

    public static float zzb(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }
}
