package com.google.common.primitives;

import com.facebook.appevents.AppEventsConstants;
import com.google.common.base.Preconditions;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import java.math.BigInteger;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class UnsignedLongs {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int compare(long[] jArr, long[] jArr2) {
            int iMin = Math.min(jArr.length, jArr2.length);
            for (int i3 = 0; i3 < iMin; i3++) {
                long j3 = jArr[i3];
                long j4 = jArr2[i3];
                if (j3 != j4) {
                    return UnsignedLongs.a(j3, j4);
                }
            }
            return jArr.length - jArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return wgbAZXYjrv.tgnBbpo;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ParseOverflowDetection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final long[] f85527a = new long[37];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final int[] f85528b = new int[37];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final int[] f85529c = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i3 = 2; i3 <= 36; i3++) {
                long j3 = i3;
                f85527a[i3] = UnsignedLongs.b(-1L, j3);
                f85528b[i3] = (int) UnsignedLongs.d(-1L, j3);
                f85529c[i3] = bigInteger.toString(i3).length() - 1;
            }
        }
    }

    public static int a(long j3, long j4) {
        return Longs.c(c(j3), c(j4));
    }

    public static long b(long j3, long j4) {
        if (j4 < 0) {
            return a(j3, j4) < 0 ? 0L : 1L;
        }
        if (j3 >= 0) {
            return j3 / j4;
        }
        long j5 = ((j3 >>> 1) / j4) << 1;
        return j5 + ((long) (a(j3 - (j5 * j4), j4) < 0 ? 0 : 1));
    }

    private static long c(long j3) {
        return j3 ^ Long.MIN_VALUE;
    }

    public static long d(long j3, long j4) {
        if (j4 < 0) {
            return a(j3, j4) < 0 ? j3 : j3 - j4;
        }
        if (j3 >= 0) {
            return j3 % j4;
        }
        long j5 = j3 - ((((j3 >>> 1) / j4) << 1) * j4);
        if (a(j5, j4) < 0) {
            j4 = 0;
        }
        return j5 - j4;
    }

    public static String e(long j3) {
        return f(j3, 10);
    }

    public static String f(long j3, int i3) {
        Preconditions.h(i3 >= 2 && i3 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i3);
        if (j3 == 0) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        if (j3 > 0) {
            return Long.toString(j3, i3);
        }
        int i4 = 64;
        char[] cArr = new char[64];
        int i5 = i3 - 1;
        if ((i3 & i5) == 0) {
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i3);
            do {
                i4--;
                cArr[i4] = Character.forDigit(((int) j3) & i5, i3);
                j3 >>>= iNumberOfTrailingZeros;
            } while (j3 != 0);
        } else {
            long jB = (i3 & 1) == 0 ? (j3 >>> 1) / ((long) (i3 >>> 1)) : b(j3, i3);
            long j4 = i3;
            int i6 = 63;
            cArr[63] = Character.forDigit((int) (j3 - (jB * j4)), i3);
            while (jB > 0) {
                i6--;
                cArr[i6] = Character.forDigit((int) (jB % j4), i3);
                jB /= j4;
            }
            i4 = i6;
        }
        return new String(cArr, i4, 64 - i4);
    }
}
