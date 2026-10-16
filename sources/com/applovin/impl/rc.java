package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class rc {
    public static int a(long j3) {
        return (int) (j3 ^ (j3 >>> 32));
    }

    public static int a(long j3, long j4) {
        if (j3 < j4) {
            return -1;
        }
        return j3 > j4 ? 1 : 0;
    }

    public static long a(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long j3 = jArr[0];
        for (int i3 = 1; i3 < jArr.length; i3++) {
            long j4 = jArr[i3];
            if (j4 > j3) {
                j3 = j4;
            }
        }
        return j3;
    }
}
