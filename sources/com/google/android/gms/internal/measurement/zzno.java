package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzno {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String zza(zznm zznmVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzc(zznmVar, sb, 0);
        return sb.toString();
    }

    static void zzb(StringBuilder sb, int i3, String str, Object obj) {
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
        if (obj instanceof String) {
            sb.append(": \"");
            zzlh zzlhVar = zzlh.zzb;
            sb.append(zzog.zza(new zzlg(((String) obj).getBytes(zzmp.zza))));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzlh) {
            sb.append(": \"");
            sb.append(zzog.zza((zzlh) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzmf) {
            sb.append(" {");
            zzc((zzmf) obj, sb, i3 + 2);
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
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zzc(com.google.android.gms.internal.measurement.zznm r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instruction units count: 555
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzno.zzc(com.google.android.gms.internal.measurement.zznm, java.lang.StringBuilder, int):void");
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
