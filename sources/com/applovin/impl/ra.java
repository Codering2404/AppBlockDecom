package com.applovin.impl;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ra {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f62810a = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f62811b = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    public static String a(long j3, long j4) {
        if (j3 == 0 && j4 == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bytes=");
        sb.append(j3);
        sb.append("-");
        if (j4 != -1) {
            sb.append((j3 + j4) - 1);
        }
        return sb.toString();
    }

    public static long a(String str, String str2) {
        long j3;
        if (TextUtils.isEmpty(str)) {
            j3 = -1;
        } else {
            try {
                j3 = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                oc.b("HttpUtil", "Unexpected Content-Length [" + str + "]");
                j3 = -1;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return j3;
        }
        Matcher matcher = f62810a.matcher(str2);
        if (!matcher.matches()) {
            return j3;
        }
        try {
            long j4 = (Long.parseLong((String) b1.a((Object) matcher.group(2))) - Long.parseLong((String) b1.a((Object) matcher.group(1)))) + 1;
            if (j3 < 0) {
                return j4;
            }
            if (j3 == j4) {
                return j3;
            }
            oc.d("HttpUtil", "Inconsistent headers [" + str + "] [" + str2 + "]");
            return Math.max(j3, j4);
        } catch (NumberFormatException unused2) {
            oc.b("HttpUtil", "Unexpected Content-Range [" + str2 + "]");
            return j3;
        }
    }

    public static long a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Matcher matcher = f62811b.matcher(str);
        if (matcher.matches()) {
            return Long.parseLong((String) b1.a((Object) matcher.group(1)));
        }
        return -1L;
    }
}
