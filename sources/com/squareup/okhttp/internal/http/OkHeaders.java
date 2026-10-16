package com.squareup.okhttp.internal.http;

import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import com.facebook.stetho.server.http.HttpHeaders;
import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Challenge;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class OkHeaders {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator f93396a = new Comparator<String>() { // from class: com.squareup.okhttp.internal.http.OkHeaders.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f93397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f93398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f93399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f93400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f93401f;

    static {
        String strG = Platform.f().g();
        f93397b = strG;
        f93398c = strG + "-Sent-Millis";
        f93399d = strG + "-Received-Millis";
        f93400e = strG + "-Selected-Protocol";
        f93401f = strG + "-Response-Source";
    }

    public static void a(Request.Builder builder, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if ("Cookie".equalsIgnoreCase(str) || "Cookie2".equalsIgnoreCase(str)) {
                if (!((List) entry.getValue()).isEmpty()) {
                    builder.f(str, b((List) entry.getValue()));
                }
            }
        }
    }

    private static String b(List list) {
        if (list.size() == 1) {
            return (String) list.get(0);
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (i3 > 0) {
                sb.append("; ");
            }
            sb.append((String) list.get(i3));
        }
        return sb.toString();
    }

    public static long c(Headers headers) {
        return k(headers.a(HttpHeaders.CONTENT_LENGTH));
    }

    public static long d(Request request) {
        return c(request.i());
    }

    public static long e(Response response) {
        return c(response.r());
    }

    public static boolean f(Headers headers) {
        return m(headers).contains("*");
    }

    public static boolean g(Response response) {
        return f(response.r());
    }

    public static List i(Headers headers, String str) {
        ArrayList arrayList = new ArrayList();
        int iF = headers.f();
        for (int i3 = 0; i3 < iF; i3++) {
            if (str.equalsIgnoreCase(headers.d(i3))) {
                String strG = headers.g(i3);
                int i4 = 0;
                while (i4 < strG.length()) {
                    int iB = HeaderParser.b(strG, i4, " ");
                    String strTrim = strG.substring(i4, iB).trim();
                    int iC = HeaderParser.c(strG, iB);
                    if (!strG.regionMatches(true, iC, "realm=\"", 0, 7)) {
                        break;
                    }
                    int i5 = iC + 7;
                    int iB2 = HeaderParser.b(strG, i5, "\"");
                    String strSubstring = strG.substring(i5, iB2);
                    int iC2 = HeaderParser.c(strG, HeaderParser.b(strG, iB2 + 1, ",") + 1);
                    arrayList.add(new Challenge(strTrim, strSubstring));
                    i4 = iC2;
                }
            }
        }
        return arrayList;
    }

    public static Request j(Authenticator authenticator, Response response, Proxy proxy) {
        return response.n() == 407 ? authenticator.a(proxy, response) : authenticator.b(proxy, response);
    }

    private static long k(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static Map l(Headers headers, String str) {
        TreeMap treeMap = new TreeMap(f93396a);
        int iF = headers.f();
        for (int i3 = 0; i3 < iF; i3++) {
            String strD = headers.d(i3);
            String strG = headers.g(i3);
            ArrayList arrayList = new ArrayList();
            List list = (List) treeMap.get(strD);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(strG);
            treeMap.put(strD, Collections.unmodifiableList(arrayList));
        }
        if (str != null) {
            treeMap.put(null, Collections.unmodifiableList(Collections.singletonList(str)));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    public static Set m(Headers headers) {
        Set treeSet = Collections.EMPTY_SET;
        int iF = headers.f();
        for (int i3 = 0; i3 < iF; i3++) {
            if ("Vary".equalsIgnoreCase(headers.d(i3))) {
                String strG = headers.g(i3);
                if (treeSet.isEmpty()) {
                    treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strG.split(",")) {
                    treeSet.add(str.trim());
                }
            }
        }
        return treeSet;
    }

    private static Set n(Response response) {
        return m(response.r());
    }

    public static Headers o(Headers headers, Headers headers2) {
        Set setM = m(headers2);
        if (setM.isEmpty()) {
            return new Headers.Builder().e();
        }
        Headers.Builder builder = new Headers.Builder();
        int iF = headers.f();
        for (int i3 = 0; i3 < iF; i3++) {
            String strD = headers.d(i3);
            if (setM.contains(strD)) {
                builder.b(strD, headers.g(i3));
            }
        }
        return builder.e();
    }

    public static Headers p(Response response) {
        return o(response.t().w().i(), response.r());
    }

    public static boolean q(Response response, Headers headers, Request request) {
        for (String str : n(response)) {
            if (!Util.h(headers.h(str), request.j(str))) {
                return false;
            }
        }
        return true;
    }

    static boolean h(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || bfIdKSjLOVjG.qkG.equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
