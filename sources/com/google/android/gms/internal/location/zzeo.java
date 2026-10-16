package com.google.android.gms.internal.location;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeo {
    private static final SimpleDateFormat zza;
    private static final SimpleDateFormat zzb;
    private static final StringBuilder zzc;

    static {
        Locale locale = Locale.ROOT;
        zza = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", locale);
        zzb = new SimpleDateFormat("MM-dd HH:mm:ss", locale);
        zzc = new StringBuilder(33);
    }

    public static String zza(long j3) {
        return j3 >= 0 ? zza.format(new Date(j3)) : Long.toString(j3);
    }

    public static String zzb(long j3) {
        String string;
        StringBuilder sb = zzc;
        synchronized (sb) {
            sb.setLength(0);
            zzc(j3, sb);
            string = sb.toString();
        }
        return string;
    }

    public static StringBuilder zzc(long j3, StringBuilder sb) {
        if (j3 == 0) {
            sb.append("0s");
            return sb;
        }
        sb.ensureCapacity(sb.length() + 27);
        boolean z2 = false;
        if (j3 < 0) {
            sb.append("-");
            if (j3 != Long.MIN_VALUE) {
                j3 = -j3;
            } else {
                j3 = Long.MAX_VALUE;
                z2 = true;
            }
        }
        if (j3 >= 86400000) {
            sb.append(j3 / 86400000);
            sb.append("d");
            j3 %= 86400000;
        }
        if (true == z2) {
            j3 = 25975808;
        }
        if (j3 >= 3600000) {
            sb.append(j3 / 3600000);
            sb.append("h");
            j3 %= 3600000;
        }
        if (j3 >= 60000) {
            sb.append(j3 / 60000);
            sb.append("m");
            j3 %= 60000;
        }
        if (j3 >= 1000) {
            sb.append(j3 / 1000);
            sb.append("s");
            j3 %= 1000;
        }
        if (j3 > 0) {
            sb.append(j3);
            sb.append("ms");
        }
        return sb;
    }
}
