package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;
import java.net.Proxy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class RequestLine {
    static String a(Request request, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(request.m());
        sb.append(' ');
        if (b(request, type)) {
            sb.append(request.k());
        } else {
            sb.append(c(request.k()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(Request request, Proxy.Type type) {
        return !request.l() && type == Proxy.Type.HTTP;
    }

    public static String c(HttpUrl httpUrl) {
        String strM = httpUrl.m();
        String strO = httpUrl.o();
        if (strO == null) {
            return strM;
        }
        return strM + '?' + strO;
    }
}
