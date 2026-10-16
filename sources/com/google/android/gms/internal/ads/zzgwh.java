package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzgwh {
    zzgwh() {
    }

    static int zze(int i3, int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
        }
        if (i4 <= i3) {
            return i3;
        }
        int i5 = i3 + (i3 >> 1) + 1;
        if (i5 < i4) {
            int iHighestOneBit = Integer.highestOneBit(i4 - 1);
            i5 = iHighestOneBit + iHighestOneBit;
        }
        return i5 < 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i5;
    }

    public abstract zzgwh zzd(Object obj);
}
