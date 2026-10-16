package com.google.common.base;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets/audience_network/classes2.dex
  classes6.dex
 */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Strings {
    public static String a(String str) {
        return Platform.b(str);
    }

    public static boolean b(String str) {
        return Platform.f(str);
    }

    public static String c(String str, Object... objArr) {
        int iIndexOf;
        String strValueOf = String.valueOf(str);
        int i3 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i4 = 0; i4 < objArr.length; i4++) {
                objArr[i4] = d(objArr[i4]);
            }
        }
        StringBuilder sb = new StringBuilder(strValueOf.length() + (objArr.length * 16));
        int i5 = 0;
        while (i3 < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i5)) != -1) {
            sb.append((CharSequence) strValueOf, i5, iIndexOf);
            sb.append(objArr[i3]);
            i5 = iIndexOf + 2;
            i3++;
        }
        sb.append((CharSequence) strValueOf, i5, strValueOf.length());
        if (i3 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i3]);
            for (int i6 = i3 + 1; i6 < objArr.length; i6++) {
                sb.append(", ");
                sb.append(objArr[i6]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    private static String d(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e3) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, (Throwable) e3);
            return "<" + str + " threw " + e3.getClass().getName() + ">";
        }
    }

    public static String e(String str) {
        return Platform.e(str);
    }
}
