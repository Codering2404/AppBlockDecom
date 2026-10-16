package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhak {
    public static long[] zza(long[]... jArr) {
        long length = 0;
        for (long[] jArr2 : jArr) {
            length += (long) jArr2.length;
        }
        int i3 = (int) length;
        zzgtj.zze(length == ((long) i3), "the total number of elements (%s) in the arrays must fit in an int", length);
        long[] jArr3 = new long[i3];
        int i4 = 0;
        for (long[] jArr4 : jArr) {
            int length2 = jArr4.length;
            System.arraycopy(jArr4, 0, jArr3, i4, length2);
            i4 += length2;
        }
        return jArr3;
    }
}
