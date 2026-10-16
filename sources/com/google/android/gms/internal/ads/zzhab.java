package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhab {
    public static long zza(long j3, long j4, RoundingMode roundingMode) {
        roundingMode.getClass();
        long j5 = j3 / j4;
        long j6 = j3 - (j4 * j5);
        if (j6 == 0) {
            return j5;
        }
        int i3 = ((int) ((j3 ^ j4) >> 63)) | 1;
        switch (zzhaa.zza[roundingMode.ordinal()]) {
            case 1:
                zzhac.zzb(false);
                return j5;
            case 2:
                return j5;
            case 3:
                if (i3 >= 0) {
                    return j5;
                }
                break;
            case 4:
                break;
            case 5:
                if (i3 <= 0) {
                    return j5;
                }
                break;
            case 6:
            case 7:
            case 8:
                long jAbs = Math.abs(j6);
                long jAbs2 = jAbs - (Math.abs(j4) - jAbs);
                if (jAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP && (roundingMode != RoundingMode.HALF_EVEN || (1 & j5) == 0)) {
                        return j5;
                    }
                } else if (jAbs2 <= 0) {
                    return j5;
                }
            default:
                throw new AssertionError();
        }
        return j5 + ((long) i3);
    }

    public static long zzb(long j3, long j4) {
        zzhac.zza("a", j3);
        zzhac.zza("b", j4);
        if (j3 == 0) {
            return j4;
        }
        if (j4 == 0) {
            return j3;
        }
        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j3);
        long jNumberOfTrailingZeros = j3 >> iNumberOfTrailingZeros;
        int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(j4);
        long j5 = j4 >> iNumberOfTrailingZeros2;
        while (jNumberOfTrailingZeros != j5) {
            long j6 = jNumberOfTrailingZeros - j5;
            long j7 = (j6 >> 63) & j6;
            long j8 = (j6 - j7) - j7;
            jNumberOfTrailingZeros = j8 >> Long.numberOfTrailingZeros(j8);
            j5 += j7;
        }
        return jNumberOfTrailingZeros << Math.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros2);
    }

    public static long zzc(long j3, long j4) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j3) + Long.numberOfLeadingZeros(~j3) + Long.numberOfLeadingZeros(j4) + Long.numberOfLeadingZeros(~j4);
        if (iNumberOfLeadingZeros > 65) {
            return j3 * j4;
        }
        long j5 = j3 ^ j4;
        long j6 = (j5 >>> 63) + Long.MAX_VALUE;
        if (!((iNumberOfLeadingZeros < 64) | ((j4 == Long.MIN_VALUE) & (j3 < 0)))) {
            long j7 = j3 * j4;
            if (j3 == 0 || j7 / j3 == j4) {
                return j7;
            }
        }
        return j6;
    }
}
