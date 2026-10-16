package com.google.android.gms.internal.ads;

import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzibx {
    public static BigDecimal zza(String str) throws NumberFormatException {
        zzc(str);
        BigDecimal bigDecimal = new BigDecimal(str);
        if (Math.abs(bigDecimal.scale()) < 10000) {
            return bigDecimal;
        }
        throw new NumberFormatException("Number has unsupported scale: ".concat(String.valueOf(str)));
    }

    public static BigInteger zzb(String str) throws NumberFormatException {
        zzc(str);
        return new BigInteger(str);
    }

    private static void zzc(String str) {
        if (str.length() <= 10000) {
            return;
        }
        String strSubstring = str.substring(0, 30);
        StringBuilder sb = new StringBuilder(String.valueOf(strSubstring).length() + 28);
        sb.append("Number string too large: ");
        sb.append(strSubstring);
        sb.append("...");
        throw new NumberFormatException(sb.toString());
    }
}
