package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzij {
    private static final Pattern zza = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");
    private static final Pattern zzb = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    public static long zza(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Matcher matcher = zzb.matcher(str);
        if (!matcher.matches()) {
            return -1L;
        }
        String strGroup = matcher.group(1);
        strGroup.getClass();
        return Long.parseLong(strGroup);
    }

    public static long zzb(String str, String str2) {
        long j3 = -1;
        if (!TextUtils.isEmpty(str)) {
            try {
                j3 = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 28);
                sb.append("Unexpected Content-Length [");
                sb.append(str);
                sb.append("]");
                zzeg.zze("HttpUtil", sb.toString());
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return j3;
        }
        Matcher matcher = zza.matcher(str2);
        if (!matcher.matches()) {
            return j3;
        }
        try {
            String strGroup = matcher.group(2);
            if (strGroup == null) {
                throw null;
            }
            long j4 = Long.parseLong(strGroup);
            String strGroup2 = matcher.group(1);
            if (strGroup2 == null) {
                throw null;
            }
            long j5 = (j4 - Long.parseLong(strGroup2)) + 1;
            if (j3 < 0) {
                return j5;
            }
            if (j3 == j5) {
                return j3;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 25 + String.valueOf(str2).length() + 1);
            sb2.append("Inconsistent headers [");
            sb2.append(str);
            sb2.append("] [");
            sb2.append(str2);
            sb2.append("]");
            zzeg.zzc("HttpUtil", sb2.toString());
            return Math.max(j3, j5);
        } catch (NumberFormatException unused2) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str2).length() + 27);
            sb3.append("Unexpected Content-Range [");
            sb3.append(str2);
            sb3.append("]");
            zzeg.zze("HttpUtil", sb3.toString());
            return j3;
        }
    }
}
