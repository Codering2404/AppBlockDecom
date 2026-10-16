package com.squareup.okhttp.internal.http;

import com.google.android.gms.ads_identifier.mrU.pMpIcGE;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class HttpMethod {
    public static boolean a(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean c(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean d(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean b(String str) {
        if (!d(str) && !str.equals("OPTIONS") && !str.equals("DELETE") && !str.equals("PROPFIND") && !str.equals("MKCOL") && !str.equals(pMpIcGE.xRZnKeOmnKF)) {
            return false;
        }
        return true;
    }
}
