package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.StringReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhlm {
    public static boolean zza(String str) {
        int length = str.length();
        int i3 = 0;
        while (i3 != length) {
            char cCharAt = str.charAt(i3);
            int i4 = i3 + 1;
            if (!Character.isSurrogate(cCharAt)) {
                i3 = i4;
            } else {
                if (Character.isLowSurrogate(cCharAt) || i4 == length || !Character.isLowSurrogate(str.charAt(i4))) {
                    return false;
                }
                i3 += 2;
            }
        }
        return true;
    }

    public static zzibg zzb(String str) throws IOException {
        try {
            zzicd zzicdVar = new zzicd(new StringReader(str));
            zzicdVar.zza(zzibl.LEGACY_STRICT);
            return zzhlk.zza(zzicdVar);
        } catch (NumberFormatException e3) {
            throw new IOException(e3);
        }
    }

    public static long zzc(Number number) {
        if (number instanceof zzhll) {
            return Long.parseLong(number.toString());
        }
        throw new IllegalArgumentException("does not contain a parsed number.");
    }
}
