package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzai<E> {
    zzai() {
    }

    static int zza(int i3, int i4) {
        if (i4 < 0) {
            throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
        }
        if (i4 <= i3) {
            return i3;
        }
        int iHighestOneBit = i3 + (i3 >> 1) + 1;
        if (iHighestOneBit < i4) {
            iHighestOneBit = Integer.highestOneBit(i4 - 1) << 1;
        }
        return iHighestOneBit < 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : iHighestOneBit;
    }
}
