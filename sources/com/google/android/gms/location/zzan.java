package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzan {
    public static int a(int i3) {
        boolean z2 = true;
        if (i3 != 100 && i3 != 102 && i3 != 104) {
            if (i3 == 105) {
                i3 = 105;
            } else {
                z2 = false;
            }
        }
        Preconditions.c(z2, "priority %d must be a Priority.PRIORITY_* constant", Integer.valueOf(i3));
        return i3;
    }

    public static String b(int i3) {
        if (i3 == 100) {
            return "HIGH_ACCURACY";
        }
        if (i3 == 102) {
            return "BALANCED_POWER_ACCURACY";
        }
        if (i3 == 104) {
            return "LOW_POWER";
        }
        if (i3 == 105) {
            return "PASSIVE";
        }
        throw new IllegalArgumentException();
    }
}
