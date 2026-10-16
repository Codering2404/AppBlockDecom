package com.google.android.libraries.places.internal;

import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzvv {
    public static String a(String str, String str2, boolean z2) {
        if (str2.length() > 23) {
            int i3 = -1;
            for (int length = str2.length() - 1; length >= 0; length--) {
                char cCharAt = str2.charAt(length);
                if (cCharAt == '.' || cCharAt == '$') {
                    i3 = length;
                    break;
                }
            }
            str2 = str2.substring(i3 + 1);
        }
        String strConcat = "".concat(String.valueOf(str2));
        return strConcat.substring(0, Math.min(strConcat.length(), 23));
    }

    public static int b(Level level) {
        int iIntValue = level.intValue();
        if (iIntValue >= Level.SEVERE.intValue()) {
            return 6;
        }
        if (iIntValue >= Level.WARNING.intValue()) {
            return 5;
        }
        if (iIntValue >= Level.INFO.intValue()) {
            return 4;
        }
        return iIntValue >= Level.FINE.intValue() ? 3 : 2;
    }
}
