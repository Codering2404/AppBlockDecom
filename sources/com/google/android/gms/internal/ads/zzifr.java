package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzifr {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String zza(zzifp zzifpVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzc(zzifpVar, sb, 0);
        return sb.toString();
    }

    static void zzb(StringBuilder sb, int i3, String str, Object obj) {
        String strReplace;
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i3, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i3, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zzd(i3, sb);
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
        if (!(obj instanceof String)) {
            if (obj instanceof zzida) {
                sb.append(": \"");
                sb.append(zzigp.zza(((zzida) obj).zzA()));
                sb.append('\"');
                return;
            }
            if (obj instanceof zziee) {
                sb.append(" {");
                zzc((zziee) obj, sb, i3 + 2);
                sb.append("\n");
                zzd(i3, sb);
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
            zzb(sb, i5, "key", entry.getKey());
            zzb(sb, i5, "value", entry.getValue());
            sb.append("\n");
            zzd(i3, sb);
            sb.append("}");
            return;
        }
        sb.append(": \"");
        String strReplace2 = (String) obj;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        for (int i6 = 0; i6 < strReplace2.length(); i6++) {
            char cCharAt2 = strReplace2.charAt(i6);
            if (cCharAt2 < ' ' || cCharAt2 > '~') {
                strReplace = zzigp.zza(strReplace2.getBytes(StandardCharsets.UTF_8));
                break;
            }
            if (cCharAt2 == '\"') {
                z4 = true;
            } else if (cCharAt2 == '\'') {
                z3 = true;
            } else if (cCharAt2 == '\\') {
                z2 = true;
            }
        }
        if (z2) {
            strReplace2 = strReplace2.replace("\\", "\\\\");
        }
        strReplace = z3 ? strReplace2.replace("'", "\\'") : strReplace2;
        if (z4) {
            strReplace = strReplace.replace("\"", "\\\"");
        }
        sb.append(strReplace);
        sb.append('\"');
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zzc(com.google.android.gms.internal.ads.zzifp r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instruction units count: 596
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzifr.zzc(com.google.android.gms.internal.ads.zzifp, java.lang.StringBuilder, int):void");
    }

    private static void zzd(int i3, StringBuilder sb) {
        while (i3 > 0) {
            int i4 = 80;
            if (i3 <= 80) {
                i4 = i3;
            }
            sb.append(zza, 0, i4);
            i3 -= i4;
        }
    }
}
