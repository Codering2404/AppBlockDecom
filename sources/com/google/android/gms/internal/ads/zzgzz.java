package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgzz {
    public static int zza(int i3, RoundingMode roundingMode) {
        if (i3 <= 0) {
            throw new IllegalArgumentException("x (0) must be > 0");
        }
        switch (zzgzy.zza[roundingMode.ordinal()]) {
            case 1:
                zzhac.zzb(((i3 + (-1)) & i3) == 0);
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i3 - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i3);
                return (31 - iNumberOfLeadingZeros) + ((((-1257966797) >>> iNumberOfLeadingZeros) - i3) >>> 31);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i3);
    }

    public static int zzb(int i3, int i4, RoundingMode roundingMode) {
        roundingMode.getClass();
        if (i4 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i5 = i3 / i4;
        int i6 = i3 - (i4 * i5);
        if (i6 == 0) {
            return i5;
        }
        int i7 = ((i3 ^ i4) >> 31) | 1;
        switch (zzgzy.zza[roundingMode.ordinal()]) {
            case 1:
                zzhac.zzb(false);
                return i5;
            case 2:
                return i5;
            case 3:
                if (i7 >= 0) {
                    return i5;
                }
                break;
            case 4:
                break;
            case 5:
                if (i7 <= 0) {
                    return i5;
                }
                break;
            case 6:
            case 7:
            case 8:
                int iAbs = Math.abs(i6);
                int iAbs2 = iAbs - (Math.abs(i4) - iAbs);
                if (iAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP) {
                        if ((i5 & 1 & (roundingMode != RoundingMode.HALF_EVEN ? 0 : 1)) == 0) {
                            return i5;
                        }
                    }
                } else if (iAbs2 <= 0) {
                    return i5;
                }
            default:
                throw new AssertionError();
        }
        return i5 + i7;
    }
}
