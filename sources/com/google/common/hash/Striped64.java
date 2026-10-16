package com.google.common.hash;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class Striped64 extends Number {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final ThreadLocal f85167d = new ThreadLocal();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Random f85168f = new Random();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int f85169g = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Unsafe f85170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f85171i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f85172j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile transient Cell[] f85173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile transient long f85174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile transient int f85175c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Cell {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Unsafe f85176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f85177c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile long f85178a;

        static {
            try {
                Unsafe unsafeE = Striped64.e();
                f85176b = unsafeE;
                f85177c = unsafeE.objectFieldOffset(Cell.class.getDeclaredField("a"));
            } catch (Exception e3) {
                throw new Error(e3);
            }
        }

        Cell(long j3) {
            this.f85178a = j3;
        }

        final boolean a(long j3, long j4) {
            return f85176b.compareAndSwapLong(this, f85177c, j3, j4);
        }
    }

    static {
        try {
            Unsafe unsafeE = e();
            f85170h = unsafeE;
            f85171i = unsafeE.objectFieldOffset(Striped64.class.getDeclaredField("b"));
            f85172j = unsafeE.objectFieldOffset(Striped64.class.getDeclaredField("c"));
        } catch (Exception e3) {
            throw new Error(e3);
        }
    }

    Striped64() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Unsafe e() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e3) {
                throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.hash.Striped64.1
                @Override // java.security.PrivilegedExceptionAction
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Unsafe run() throws IllegalAccessException {
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    throw new NoSuchFieldError("the Unsafe");
                }
            });
        }
    }

    final boolean b(long j3, long j4) {
        return f85170h.compareAndSwapLong(this, f85171i, j3, j4);
    }

    final boolean c() {
        return f85170h.compareAndSwapInt(this, f85172j, 0, 1);
    }

    abstract long d(long j3, long j4);

    /* JADX WARN: Removed duplicated region for block: B:120:0x0023 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00f1 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void f(long r17, int[] r19, boolean r20) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.hash.Striped64.f(long, int[], boolean):void");
    }
}
