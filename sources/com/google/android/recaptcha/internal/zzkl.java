package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzkl {
    static void zza(boolean z2, String str, long j3, long j4) {
        if (z2) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j3 + ", " + j4 + ")");
    }

    static void zzb(boolean z2) {
        if (!z2) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
