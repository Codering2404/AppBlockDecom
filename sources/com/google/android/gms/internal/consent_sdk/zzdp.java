package com.google.android.gms.internal.consent_sdk;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdp {
    public static String zza(String str, Object... objArr) {
        int length;
        int iIndexOf;
        StringBuilder sb = new StringBuilder(str.length() + (objArr.length * 16));
        int i3 = 0;
        int i4 = 0;
        while (true) {
            length = objArr.length;
            if (i3 >= length || (iIndexOf = str.indexOf("%s", i4)) == -1) {
                break;
            }
            sb.append((CharSequence) str, i4, iIndexOf);
            sb.append(zzb(objArr[i3]));
            i4 = iIndexOf + 2;
            i3++;
        }
        sb.append((CharSequence) str, i4, str.length());
        if (i3 < length) {
            String str2 = " [";
            while (i3 < objArr.length) {
                sb.append(str2);
                sb.append(zzb(objArr[i3]));
                i3++;
                str2 = ", ";
            }
            sb.append(']');
        }
        return sb.toString();
    }

    private static String zzb(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e3) {
            String str = obj.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str), (Throwable) e3);
            return "<" + str + " threw " + e3.getClass().getName() + ">";
        }
    }
}
