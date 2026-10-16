package com.google.common.math;

import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class DoubleMath {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final double f85302a = Math.log(2.0d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final double[] f85303b = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    /* JADX INFO: renamed from: com.google.common.math.DoubleMath$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f85304a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f85304a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f85304a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f85304a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f85304a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f85304a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f85304a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f85304a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f85304a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static boolean a(double d3, double d4, double d5) {
        MathPreconditions.d("tolerance", d5);
        if (Math.copySign(d3 - d4, 1.0d) <= d5 || d3 == d4) {
            return true;
        }
        return Double.isNaN(d3) && Double.isNaN(d4);
    }

    public static boolean b(double d3) {
        if (DoubleUtils.c(d3)) {
            return d3 == 0.0d || 52 - Long.numberOfTrailingZeros(DoubleUtils.b(d3)) <= Math.getExponent(d3);
        }
        return false;
    }

    public static boolean c(double d3) {
        if (d3 > 0.0d && DoubleUtils.c(d3)) {
            long jB = DoubleUtils.b(d3);
            if ((jB & (jB - 1)) == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d(double r5, java.math.RoundingMode r7) {
        /*
            r0 = 0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L10
            boolean r0 = com.google.common.math.DoubleUtils.c(r5)
            if (r0 == 0) goto L10
            r0 = r2
            goto L11
        L10:
            r0 = r1
        L11:
            java.lang.String r3 = "x must be positive and finite"
            com.google.common.base.Preconditions.e(r0, r3)
            int r0 = java.lang.Math.getExponent(r5)
            boolean r3 = com.google.common.math.DoubleUtils.d(r5)
            if (r3 != 0) goto L2a
            r0 = 4841369599423283200(0x4330000000000000, double:4.503599627370496E15)
            double r5 = r5 * r0
            int r5 = d(r5, r7)
            int r5 = r5 + (-52)
            return r5
        L2a:
            int[] r3 = com.google.common.math.DoubleMath.AnonymousClass1.f85304a
            int r7 = r7.ordinal()
            r7 = r3[r7]
            switch(r7) {
                case 1: goto L61;
                case 2: goto L68;
                case 3: goto L5a;
                case 4: goto L52;
                case 5: goto L48;
                case 6: goto L3b;
                case 7: goto L3b;
                case 8: goto L3b;
                default: goto L35;
            }
        L35:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        L3b:
            double r5 = com.google.common.math.DoubleUtils.e(r5)
            double r5 = r5 * r5
            r3 = 4611686018427387904(0x4000000000000000, double:2.0)
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 <= 0) goto L68
            r1 = r2
            goto L68
        L48:
            if (r0 < 0) goto L4b
            r1 = r2
        L4b:
            boolean r5 = c(r5)
        L4f:
            r5 = r5 ^ r2
            r1 = r1 & r5
            goto L68
        L52:
            if (r0 >= 0) goto L55
            r1 = r2
        L55:
            boolean r5 = c(r5)
            goto L4f
        L5a:
            boolean r5 = c(r5)
            r1 = r5 ^ 1
            goto L68
        L61:
            boolean r5 = c(r5)
            com.google.common.math.MathPreconditions.h(r5)
        L68:
            if (r1 == 0) goto L6b
            int r0 = r0 + r2
        L6b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.DoubleMath.d(double, java.math.RoundingMode):int");
    }

    static double e(double d3, RoundingMode roundingMode) {
        if (!DoubleUtils.c(d3)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (AnonymousClass1.f85304a[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.h(b(d3));
                return d3;
            case 2:
                return (d3 >= 0.0d || b(d3)) ? d3 : ((long) d3) - 1;
            case 3:
                return (d3 <= 0.0d || b(d3)) ? d3 : ((long) d3) + 1;
            case 4:
                return d3;
            case 5:
                if (b(d3)) {
                    return d3;
                }
                return ((long) d3) + ((long) (d3 > 0.0d ? 1 : -1));
            case 6:
                return Math.rint(d3);
            case 7:
                double dRint = Math.rint(d3);
                return Math.abs(d3 - dRint) == 0.5d ? d3 + Math.copySign(0.5d, d3) : dRint;
            case 8:
                double dRint2 = Math.rint(d3);
                return Math.abs(d3 - dRint2) == 0.5d ? d3 : dRint2;
            default:
                throw new AssertionError();
        }
    }

    public static long f(double d3, RoundingMode roundingMode) {
        double dE = e(d3, roundingMode);
        MathPreconditions.a(((-9.223372036854776E18d) - dE < 1.0d) & (dE < 9.223372036854776E18d), d3, roundingMode);
        return (long) dE;
    }
}
