package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaub {
    public static zzasn zza(zzata zzataVar) {
        long j3;
        boolean z2;
        long j4;
        long j5;
        long j6;
        long jZzb;
        long j7;
        long j8;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map map = zzataVar.zzc;
        if (map == null) {
            return null;
        }
        String str = (String) map.get("Date");
        long jZzb2 = str != null ? zzb(str) : 0L;
        String str2 = (String) map.get("Cache-Control");
        int i3 = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            z2 = false;
            j4 = 0;
            j5 = 0;
            while (i3 < strArrSplit.length) {
                String strTrim = strArrSplit[i3].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j5 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j4 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    z2 = true;
                }
                i3++;
            }
            j3 = 0;
            i3 = 1;
        } else {
            j3 = 0;
            z2 = false;
            j4 = 0;
            j5 = 0;
        }
        String str3 = (String) map.get("Expires");
        long jZzb3 = str3 != null ? zzb(str3) : j3;
        String str4 = (String) map.get("Last-Modified");
        if (str4 != null) {
            j6 = jCurrentTimeMillis;
            jZzb = zzb(str4);
        } else {
            j6 = jCurrentTimeMillis;
            jZzb = j3;
        }
        String str5 = (String) map.get("ETag");
        if (i3 != 0) {
            long j9 = (j5 * 1000) + j6;
            j8 = z2 ? j9 : (j4 * 1000) + j9;
            j7 = j9;
        } else {
            j7 = (jZzb2 <= j3 || jZzb3 < jZzb2) ? j3 : (jZzb3 - jZzb2) + j6;
            j8 = j7;
        }
        zzasn zzasnVar = new zzasn();
        zzasnVar.zza = zzataVar.zzb;
        zzasnVar.zzb = str5;
        zzasnVar.zzf = j7;
        zzasnVar.zze = j8;
        zzasnVar.zzc = jZzb2;
        zzasnVar.zzd = jZzb;
        zzasnVar.zzg = map;
        zzasnVar.zzh = zzataVar.zzd;
        return zzasnVar;
    }

    public static long zzb(String str) {
        try {
            return zzd("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e3) {
            if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str) || "-1".equals(str)) {
                zzatq.zza("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            zzatq.zzd(e3, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    static String zzc(long j3) {
        return zzd("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j3));
    }

    private static SimpleDateFormat zzd(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
