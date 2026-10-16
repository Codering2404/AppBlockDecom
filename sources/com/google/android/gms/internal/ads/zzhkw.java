package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhkw {
    static void zza(long[] jArr, long[] jArr2, int i3) {
        for (int i4 = 0; i4 < 10; i4++) {
            int i5 = (int) jArr[i4];
            jArr[i4] = ((-i3) & (((int) jArr2[i4]) ^ i5)) ^ i5;
        }
    }
}
