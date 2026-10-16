package org.threeten.bp.jdk8;

import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class Jdk8Methods {
    public static int a(int i3, int i4) {
        if (i3 < i4) {
            return -1;
        }
        return i3 > i4 ? 1 : 0;
    }

    public static int b(long j3, long j4) {
        if (j3 < j4) {
            return -1;
        }
        return j3 > j4 ? 1 : 0;
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static int d(int i3, int i4) {
        return i3 >= 0 ? i3 / i4 : ((i3 + 1) / i4) - 1;
    }

    public static long e(long j3, long j4) {
        return j3 >= 0 ? j3 / j4 : ((j3 + 1) / j4) - 1;
    }

    public static int f(int i3, int i4) {
        return ((i3 % i4) + i4) % i4;
    }

    public static int g(long j3, int i3) {
        long j4 = i3;
        return (int) (((j3 % j4) + j4) % j4);
    }

    public static long h(long j3, long j4) {
        return ((j3 % j4) + j4) % j4;
    }

    public static Object i(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str + " must not be null");
    }

    public static int j(int i3, int i4) {
        int i5 = i3 + i4;
        if ((i3 ^ i5) >= 0 || (i3 ^ i4) < 0) {
            return i5;
        }
        throw new ArithmeticException("Addition overflows an int: " + i3 + " + " + i4);
    }

    public static int l(int i3, int i4) {
        long j3 = ((long) i3) * ((long) i4);
        if (j3 >= -2147483648L && j3 <= 2147483647L) {
            return (int) j3;
        }
        throw new ArithmeticException("Multiplication overflows an int: " + i3 + " * " + i4);
    }

    public static long m(long j3, int i3) {
        if (i3 == -1) {
            if (j3 != Long.MIN_VALUE) {
                return -j3;
            }
            throw new ArithmeticException("Multiplication overflows a long: " + j3 + " * " + i3);
        }
        if (i3 == 0) {
            return 0L;
        }
        if (i3 == 1) {
            return j3;
        }
        long j4 = i3;
        long j5 = j3 * j4;
        if (j5 / j4 == j3) {
            return j5;
        }
        throw new ArithmeticException("Multiplication overflows a long: " + j3 + " * " + i3);
    }

    public static long n(long j3, long j4) {
        if (j4 == 1) {
            return j3;
        }
        if (j3 == 1) {
            return j4;
        }
        if (j3 == 0 || j4 == 0) {
            return 0L;
        }
        long j5 = j3 * j4;
        if (j5 / j4 == j3 && ((j3 != Long.MIN_VALUE || j4 != -1) && (j4 != Long.MIN_VALUE || j3 != -1))) {
            return j5;
        }
        throw new ArithmeticException("Multiplication overflows a long: " + j3 + " * " + j4);
    }

    public static int o(int i3, int i4) {
        int i5 = i3 - i4;
        if ((i3 ^ i5) >= 0 || (i3 ^ i4) >= 0) {
            return i5;
        }
        throw new ArithmeticException("Subtraction overflows an int: " + i3 + " - " + i4);
    }

    public static long p(long j3, long j4) {
        long j5 = j3 - j4;
        if ((j3 ^ j5) >= 0 || (j3 ^ j4) >= 0) {
            return j5;
        }
        throw new ArithmeticException("Subtraction overflows a long: " + j3 + " - " + j4);
    }

    public static int q(long j3) {
        if (j3 <= 2147483647L && j3 >= -2147483648L) {
            return (int) j3;
        }
        throw new ArithmeticException("Calculation overflows an int: " + j3);
    }

    public static long k(long j3, long j4) {
        long j5 = j3 + j4;
        if ((j3 ^ j5) >= 0 || (j3 ^ j4) < 0) {
            return j5;
        }
        throw new ArithmeticException(sKeKFMqmvNzY.zNO + j3 + " + " + j4);
    }
}
