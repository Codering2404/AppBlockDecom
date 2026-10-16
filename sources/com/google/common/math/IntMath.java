package com.google.common.math;

import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.api.Api;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class IntMath {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final byte[] f85305a = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int[] f85306b = {1, 10, 100, 1000, ColorExtractionConstants.MAX_PIXEL_SAMPLES, 100000, 1000000, 10000000, 100000000, 1000000000};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int[] f85307c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Api.BaseClientBuilder.API_PRIORITY_OTHER};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f85308d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static int[] f85309e = {Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    /* JADX INFO: renamed from: com.google.common.math.IntMath$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f85310a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f85310a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f85310a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f85310a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f85310a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f85310a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f85310a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f85310a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f85310a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static int a(int i3, int i4) {
        MathPreconditions.e("n", i3);
        MathPreconditions.e("k", i4);
        int i5 = 0;
        Preconditions.i(i4 <= i3, "k (%s) > n (%s)", i4, i3);
        if (i4 > (i3 >> 1)) {
            i4 = i3 - i4;
        }
        int[] iArr = f85309e;
        if (i4 >= iArr.length || i3 > iArr[i4]) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (i4 == 0) {
            return 1;
        }
        if (i4 == 1) {
            return i3;
        }
        long j3 = 1;
        while (i5 < i4) {
            long j4 = j3 * ((long) (i3 - i5));
            i5++;
            j3 = j4 / ((long) i5);
        }
        return (int) j3;
    }

    public static int b(int i3, int i4) {
        long j3 = ((long) i3) + ((long) i4);
        int i5 = (int) j3;
        MathPreconditions.b(j3 == ((long) i5), "checkedAdd", i3, i4);
        return i5;
    }

    public static int c(int i3, int i4) {
        long j3 = ((long) i3) * ((long) i4);
        int i5 = (int) j3;
        MathPreconditions.b(j3 == ((long) i5), "checkedMultiply", i3, i4);
        return i5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int d(int i3, int i4, RoundingMode roundingMode) {
        Preconditions.t(roundingMode);
        if (i4 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i5 = i3 / i4;
        int i6 = i3 - (i4 * i5);
        if (i6 == 0) {
            return i5;
        }
        int i7 = ((i3 ^ i4) >> 31) | 1;
        switch (AnonymousClass1.f85310a[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.h(i6 == 0);
                return i5;
            case 2:
                return i5;
            case 3:
                if (i7 >= 0) {
                    return i5;
                }
                return i5 + i7;
            case 4:
                return i5 + i7;
            case 5:
                if (i7 <= 0) {
                    return i5;
                }
                return i5 + i7;
            case 6:
            case 7:
            case 8:
                int iAbs = Math.abs(i6);
                int iAbs2 = iAbs - (Math.abs(i4) - iAbs);
                if (iAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP) {
                        if (!((roundingMode == RoundingMode.HALF_EVEN) & ((i5 & 1) != 0))) {
                            return i5;
                        }
                    }
                } else if (iAbs2 <= 0) {
                    return i5;
                }
                return i5 + i7;
            default:
                throw new AssertionError();
        }
    }

    public static int e(int i3) {
        MathPreconditions.e("n", i3);
        int[] iArr = f85308d;
        return i3 < iArr.length ? iArr[i3] : Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static boolean f(int i3) {
        return (i3 > 0) & ((i3 & (i3 + (-1))) == 0);
    }

    static int g(int i3, int i4) {
        return (~(~(i3 - i4))) >>> 31;
    }

    public static int h(int i3, RoundingMode roundingMode) {
        MathPreconditions.g("x", i3);
        switch (AnonymousClass1.f85310a[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.h(f(i3));
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
                return (31 - iNumberOfLeadingZeros) + g((-1257966797) >>> iNumberOfLeadingZeros, i3);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i3);
    }

    public static int i(int i3, int i4) {
        return Ints.m(((long) i3) + ((long) i4));
    }

    public static int j(int i3, int i4) {
        return Ints.m(((long) i3) * ((long) i4));
    }
}
