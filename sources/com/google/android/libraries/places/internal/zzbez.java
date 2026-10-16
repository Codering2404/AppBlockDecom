package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbez {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f76122a;

    static {
        char[] cArr = new char[80];
        f76122a = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String a(zzbex zzbexVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        c(zzbexVar, sb, 0);
        return sb.toString();
    }

    static void b(StringBuilder sb, int i3, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                b(sb, i3, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                b(sb, i3, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        d(i3, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i4 = 1; i4 < str.length(); i4++) {
                char cCharAt = str.charAt(i4);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            zzbcl zzbclVar = zzbcl.f75997b;
            sb.append(zzbfu.a(new zzbck(((String) obj).getBytes(zzbeb.f76091a))));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzbcl) {
            sb.append(": \"");
            sb.append(zzbfu.a((zzbcl) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzbdq) {
            sb.append(" {");
            c((zzbdq) obj, sb, i3 + 2);
            sb.append("\n");
            d(i3, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i5 = i3 + 2;
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        b(sb, i5, "key", entry.getKey());
        b(sb, i5, "value", entry.getValue());
        sb.append("\n");
        d(i3, sb);
        sb.append("}");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(com.google.android.libraries.places.internal.zzbex r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instruction units count: 562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbez.c(com.google.android.libraries.places.internal.zzbex, java.lang.StringBuilder, int):void");
    }

    private static void d(int i3, StringBuilder sb) {
        while (i3 > 0) {
            int i4 = 80;
            if (i3 <= 80) {
                i4 = i3;
            }
            sb.append(f76122a, 0, i4);
            i3 -= i4;
        }
    }
}
