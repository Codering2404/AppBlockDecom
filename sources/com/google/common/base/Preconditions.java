package com.google.common.base;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Preconditions {
    public static void A(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void B(boolean z2, String str, int i3) {
        if (!z2) {
            throw new IllegalStateException(Strings.c(str, Integer.valueOf(i3)));
        }
    }

    public static void C(boolean z2, String str, long j3) {
        if (!z2) {
            throw new IllegalStateException(Strings.c(str, Long.valueOf(j3)));
        }
    }

    public static void D(boolean z2, String str, Object obj) {
        if (!z2) {
            throw new IllegalStateException(Strings.c(str, obj));
        }
    }

    public static void E(boolean z2, String str, Object obj, Object obj2) {
        if (!z2) {
            throw new IllegalStateException(Strings.c(str, obj, obj2));
        }
    }

    private static String a(int i3, int i4, String str) {
        if (i3 < 0) {
            return Strings.c("%s (%s) must not be negative", str, Integer.valueOf(i3));
        }
        if (i4 >= 0) {
            return Strings.c("%s (%s) must be less than size (%s)", str, Integer.valueOf(i3), Integer.valueOf(i4));
        }
        throw new IllegalArgumentException("negative size: " + i4);
    }

    private static String b(int i3, int i4, String str) {
        if (i3 < 0) {
            return Strings.c("%s (%s) must not be negative", str, Integer.valueOf(i3));
        }
        if (i4 >= 0) {
            return Strings.c("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i3), Integer.valueOf(i4));
        }
        throw new IllegalArgumentException("negative size: " + i4);
    }

    private static String c(int i3, int i4, int i5) {
        return (i3 < 0 || i3 > i5) ? b(i3, i5, "start index") : (i4 < 0 || i4 > i5) ? b(i4, i5, "end index") : Strings.c("end index (%s) must not be less than start index (%s)", Integer.valueOf(i4), Integer.valueOf(i3));
    }

    public static void d(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z2, String str, char c3) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.c(str, Character.valueOf(c3)));
        }
    }

    public static void g(boolean z2, String str, char c3, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.c(str, Character.valueOf(c3), obj));
        }
    }

    public static void h(boolean z2, String str, int i3) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.c(str, Integer.valueOf(i3)));
        }
    }

    public static void i(boolean z2, String str, int i3, int i4) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.c(str, Integer.valueOf(i3), Integer.valueOf(i4)));
        }
    }

    public static void j(boolean z2, String str, int i3, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.c(str, Integer.valueOf(i3), obj));
        }
    }

    public static void k(boolean z2, String str, long j3) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.c(str, Long.valueOf(j3)));
        }
    }

    public static void l(boolean z2, String str, long j3, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.c(str, Long.valueOf(j3), obj));
        }
    }

    public static void m(boolean z2, String str, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.c(str, obj));
        }
    }

    public static void n(boolean z2, String str, Object obj, int i3) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.c(str, obj, Integer.valueOf(i3)));
        }
    }

    public static void o(boolean z2, String str, Object obj, Object obj2) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.c(str, obj, obj2));
        }
    }

    public static void p(boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.c(str, obj, obj2, obj3));
        }
    }

    public static void q(boolean z2, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (!z2) {
            throw new IllegalArgumentException(Strings.c(str, obj, obj2, obj3, obj4));
        }
    }

    public static int r(int i3, int i4) {
        return s(i3, i4, "index");
    }

    public static int s(int i3, int i4, String str) {
        if (i3 < 0 || i3 >= i4) {
            throw new IndexOutOfBoundsException(a(i3, i4, str));
        }
        return i3;
    }

    public static Object t(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object u(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static Object v(Object obj, String str, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(Strings.c(str, obj2));
    }

    public static int w(int i3, int i4) {
        return x(i3, i4, "index");
    }

    public static int x(int i3, int i4, String str) {
        if (i3 < 0 || i3 > i4) {
            throw new IndexOutOfBoundsException(b(i3, i4, str));
        }
        return i3;
    }

    public static void y(int i3, int i4, int i5) {
        if (i3 < 0 || i4 < i3 || i4 > i5) {
            throw new IndexOutOfBoundsException(c(i3, i4, i5));
        }
    }

    public static void z(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }
}
