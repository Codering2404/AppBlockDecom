package com.iab.omid.library.applovin;

import com.iab.omid.library.applovin.utils.g;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f92121a = Pattern.compile("<(head)( [^>]*)?>", 2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f92122b = Pattern.compile("<(head)( [^>]*)?/>", 2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f92123c = Pattern.compile("<(body)( [^>]*?)?>", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f92124d = Pattern.compile("<(body)( [^>]*?)?/>", 2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern f92125e = Pattern.compile("<(html)( [^>]*?)?>", 2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f92126f = Pattern.compile("<(html)( [^>]*?)?/>", 2);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Pattern f92127g = Pattern.compile("<!DOCTYPE [^>]*>", 2);

    static String a(String str, String str2) {
        g.a(str, "HTML is null or empty");
        int[][] iArrA = a(str);
        StringBuilder sb = new StringBuilder(str.length() + str2.length() + 16);
        if (!b(str, sb, f92122b, str2, iArrA) && !a(str, sb, f92121a, str2, iArrA) && !b(str, sb, f92124d, str2, iArrA) && !a(str, sb, f92123c, str2, iArrA) && !b(str, sb, f92126f, str2, iArrA) && !a(str, sb, f92125e, str2, iArrA) && !a(str, sb, f92127g, str2, iArrA)) {
            return str2 + str;
        }
        return sb.toString();
    }

    static String b(String str, String str2) {
        return a(str2, "<script type=\"text/javascript\">" + str + "</script>");
    }

    private static boolean a(int i3, int[][] iArr) {
        if (iArr != null) {
            for (int[] iArr2 : iArr) {
                if (i3 >= iArr2[0] && i3 <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean b(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i3 = 0;
        while (matcher.find(i3)) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (!a(iStart, iArr)) {
                sb.append(str.substring(0, matcher.end() - 2));
                sb.append(">");
                sb.append(str2);
                sb.append("</");
                sb.append(matcher.group(1));
                sb.append(">");
                sb.append(str.substring(matcher.end()));
                return true;
            }
            i3 = iEnd;
        }
        return false;
    }

    private static boolean a(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i3 = 0;
        while (matcher.find(i3)) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            if (!a(iStart, iArr)) {
                sb.append(str.substring(0, matcher.end()));
                sb.append(str2);
                sb.append(str.substring(matcher.end()));
                return true;
            }
            i3 = iEnd;
        }
        return false;
    }

    private static int[][] a(String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int iIndexOf = str.indexOf("<!--", i3);
            if (iIndexOf >= 0) {
                int iIndexOf2 = str.indexOf("-->", iIndexOf);
                if (iIndexOf2 >= 0) {
                    arrayList.add(new int[]{iIndexOf, iIndexOf2});
                    i3 = iIndexOf2 + 3;
                } else {
                    arrayList.add(new int[]{iIndexOf, length});
                }
            }
            i3 = length;
        }
        return (int[][]) arrayList.toArray((int[][]) Array.newInstance((Class<?>) Integer.TYPE, 0, 2));
    }
}
