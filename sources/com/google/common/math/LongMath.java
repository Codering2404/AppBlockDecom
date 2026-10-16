package com.google.common.math;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import com.google.common.base.Preconditions;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class LongMath {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f85315a = {19, Ascii.DC2, Ascii.DC2, Ascii.DC2, Ascii.DC2, 17, 17, 17, Ascii.DLE, Ascii.DLE, Ascii.DLE, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.SO, Ascii.SO, Ascii.SO, Ascii.CR, Ascii.CR, Ascii.CR, Ascii.FF, Ascii.FF, Ascii.FF, Ascii.FF, Ascii.VT, Ascii.VT, Ascii.VT, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final long[] f85316b = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final long[] f85317c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final long[] f85318d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f85319e = {Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int[] f85320f = {Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final long[][] f85321g = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    /* JADX INFO: renamed from: com.google.common.math.LongMath$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f85322a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f85322a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f85322a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f85322a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f85322a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f85322a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f85322a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f85322a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f85322a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum MillerRabinTester {
        SMALL { // from class: com.google.common.math.LongMath.MillerRabinTester.1
        },
        LARGE { // from class: com.google.common.math.LongMath.MillerRabinTester.2
        };

        /* synthetic */ MillerRabinTester(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static long a(long j3, long j4) {
        long j5 = j3 + j4;
        MathPreconditions.c(((j3 ^ j4) < 0) | ((j3 ^ j5) >= 0), "checkedAdd", j3, j4);
        return j5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static long b(long j3, long j4, RoundingMode roundingMode) {
        Preconditions.t(roundingMode);
        long j5 = j3 / j4;
        long j6 = j3 - (j4 * j5);
        if (j6 == 0) {
            return j5;
        }
        int i3 = ((int) ((j3 ^ j4) >> 63)) | 1;
        switch (AnonymousClass1.f85322a[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.h(j6 == 0);
                return j5;
            case 2:
                return j5;
            case 3:
                if (i3 >= 0) {
                    return j5;
                }
                return j5 + ((long) i3);
            case 4:
                return j5 + ((long) i3);
            case 5:
                if (i3 <= 0) {
                    return j5;
                }
                return j5 + ((long) i3);
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
                return j5 + ((long) i3);
            default:
                throw new AssertionError();
        }
    }

    public static long c(long j3, long j4) {
        MathPreconditions.f("a", j3);
        MathPreconditions.f("b", j4);
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
            j5 += j7;
            jNumberOfTrailingZeros = j8 >> Long.numberOfTrailingZeros(j8);
        }
        return jNumberOfTrailingZeros << Math.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros2);
    }

    public static long d(long j3, long j4) {
        long j5 = j3 + j4;
        return (((j4 ^ j3) > 0L ? 1 : ((j4 ^ j3) == 0L ? 0 : -1)) < 0) | ((j3 ^ j5) >= 0) ? j5 : ((j5 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    public static long e(long j3, long j4) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j3) + Long.numberOfLeadingZeros(~j3) + Long.numberOfLeadingZeros(j4) + Long.numberOfLeadingZeros(~j4);
        if (iNumberOfLeadingZeros > 65) {
            return j3 * j4;
        }
        long j5 = ((j3 ^ j4) >>> 63) + Long.MAX_VALUE;
        if (!((iNumberOfLeadingZeros < 64) | ((j4 == Long.MIN_VALUE) & (j3 < 0)))) {
            long j6 = j3 * j4;
            if (j3 == 0 || j6 / j3 == j4) {
                return j6;
            }
        }
        return j5;
    }
}
