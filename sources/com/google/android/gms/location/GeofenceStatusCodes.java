package com.google.android.gms.location;

import com.google.android.gms.common.api.CommonStatusCodes;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class GeofenceStatusCodes extends CommonStatusCodes {
    public static int b(int i3) {
        if (i3 == 0) {
            return i3;
        }
        if (i3 < 1000 || i3 >= 1006) {
            return 13;
        }
        return i3;
    }
}
