package com.squareup.okhttp.internal.http;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class HeaderParser {
    public static int a(String str, int i3) {
        try {
            long j3 = Long.parseLong(str);
            if (j3 > 2147483647L) {
                return Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            if (j3 < 0) {
                return 0;
            }
            return (int) j3;
        } catch (NumberFormatException unused) {
            return i3;
        }
    }

    public static int b(String str, int i3, String str2) {
        while (i3 < str.length() && str2.indexOf(str.charAt(i3)) == -1) {
            i3++;
        }
        return i3;
    }

    public static int c(String str, int i3) {
        char cCharAt;
        while (i3 < str.length() && ((cCharAt = str.charAt(i3)) == ' ' || cCharAt == '\t')) {
            i3++;
        }
        return i3;
    }
}
