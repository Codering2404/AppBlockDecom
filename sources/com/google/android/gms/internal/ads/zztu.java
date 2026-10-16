package com.google.android.gms.internal.ads;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zztu {
    public static boolean zza(int i3) {
        if (i3 == 8 || i3 == 7) {
            return true;
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 31 || !(i3 == 26 || i3 == 27)) {
            return i4 >= 33 && i3 == 30;
        }
        return true;
    }
}
