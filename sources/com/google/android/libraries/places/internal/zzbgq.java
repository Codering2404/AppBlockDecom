package com.google.android.libraries.places.internal;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbgq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f76219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f76220b = 0;

    static {
        zzbfv zzbfvVarI = zzbfw.I();
        zzbfvVarI.y(-62135596800L);
        zzbfvVarI.z(0);
        zzbfv zzbfvVarI2 = zzbfw.I();
        zzbfvVarI2.y(253402300799L);
        zzbfvVarI2.z(999999999);
        zzbfv zzbfvVarI3 = zzbfw.I();
        zzbfvVarI3.y(0L);
        zzbfvVarI3.z(0);
        f76219a = new zzbgp();
        b("now");
        b("getEpochSecond");
        b("getNano");
    }

    public static String a(zzbfw zzbfwVar) {
        long jG = zzbfwVar.G();
        int iH = zzbfwVar.H();
        if (jG < -62135596800L || jG > 253402300799L || iH < 0 || iH >= 1000000000) {
            StringBuilder sb = new StringBuilder(String.valueOf(jG).length() + 135 + String.valueOf(iH).length() + 37);
            sb.append("Timestamp is not valid. See proto definition for valid values. Seconds (");
            sb.append(jG);
            sb.append(") must be in range [-62,135,596,800, +253,402,300,799]. Nanos (");
            sb.append(iH);
            sb.append(") must be in range [0, +999,999,999].");
            throw new IllegalArgumentException(sb.toString());
        }
        long jG2 = zzbfwVar.G();
        int iH2 = zzbfwVar.H();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((SimpleDateFormat) f76219a.get()).format(new Date(jG2 * 1000)));
        if (iH2 != 0) {
            sb2.append(".");
            sb2.append(iH2 % 1000000 == 0 ? String.format(Locale.ENGLISH, "%1$03d", Integer.valueOf(iH2 / 1000000)) : iH2 % 1000 == 0 ? String.format(Locale.ENGLISH, "%1$06d", Integer.valueOf(iH2 / 1000)) : String.format(Locale.ENGLISH, "%1$09d", Integer.valueOf(iH2)));
        }
        sb2.append("Z");
        return sb2.toString();
    }

    private static Method b(String str) {
        try {
            return Class.forName("java.time.Instant").getMethod(str, null);
        } catch (Exception unused) {
            return null;
        }
    }
}
