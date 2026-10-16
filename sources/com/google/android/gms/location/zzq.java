package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzq {
    public static int a(int i3) {
        boolean z2 = true;
        if (i3 != 0 && i3 != 1) {
            if (i3 == 2) {
                i3 = 2;
            } else {
                z2 = false;
            }
        }
        Preconditions.c(z2, "granularity %d must be a Granularity.GRANULARITY_* constant", Integer.valueOf(i3));
        return i3;
    }

    public static String b(int i3) {
        if (i3 == 0) {
            return "GRANULARITY_PERMISSION_LEVEL";
        }
        if (i3 == 1) {
            return "GRANULARITY_COARSE";
        }
        if (i3 == 2) {
            return "GRANULARITY_FINE";
        }
        throw new IllegalArgumentException();
    }
}
