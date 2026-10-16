package com.google.android.gms.analytics;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzj {
    private static String a(Object obj, int i3) {
        if (i3 > 10) {
            return "ERROR: Recursive toString calls";
        }
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return TextUtils.isEmpty((String) obj) ? "" : obj.toString();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0 ? "" : obj.toString();
        }
        if (obj instanceof Long) {
            return ((Long) obj).longValue() == 0 ? "" : obj.toString();
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue() == 0.0d ? "" : obj.toString();
        }
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue() ? "" : obj.toString();
        }
        if (obj instanceof List) {
            StringBuilder sb = new StringBuilder();
            if (i3 > 0) {
                sb.append("[");
            }
            int length = sb.length();
            for (Object obj2 : (List) obj) {
                if (sb.length() > length) {
                    sb.append(", ");
                }
                sb.append(a(obj2, i3 + 1));
            }
            if (i3 > 0) {
                sb.append("]");
            }
            return sb.toString();
        }
        if (!(obj instanceof Map)) {
            return obj.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = false;
        int length2 = 0;
        for (Map.Entry entry : new TreeMap((Map) obj).entrySet()) {
            String strA = a(entry.getValue(), i3 + 1);
            if (!TextUtils.isEmpty(strA)) {
                if (i3 > 0 && !z2) {
                    sb2.append("{");
                    length2 = sb2.length();
                    z2 = true;
                }
                if (sb2.length() > length2) {
                    sb2.append(", ");
                }
                sb2.append((String) entry.getKey());
                sb2.append('=');
                sb2.append(strA);
            }
        }
        if (z2) {
            sb2.append("}");
        }
        return sb2.toString();
    }

    public static String zza(Object obj) {
        return a(obj, 0);
    }

    public static String zzb(Map map) {
        return a(map, 1);
    }

    public abstract void zzc(zzj zzjVar);
}
