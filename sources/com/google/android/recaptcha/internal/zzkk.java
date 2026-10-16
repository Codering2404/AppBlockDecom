package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzkk {
    public static long zza(long j3, long j4) {
        long j5 = j3 + j4;
        zzkl.zza(((j3 ^ j4) < 0) | ((j3 ^ j5) >= 0), "checkedAdd", j3, j4);
        return j5;
    }

    public static long zzb(long j3, long j4) {
        long j5 = (-1) + j3;
        zzkl.zza(((1 ^ j3) >= 0) | ((j3 ^ j5) >= 0), "checkedSubtract", j3, 1L);
        return j5;
    }
}
