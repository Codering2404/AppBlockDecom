package com.google.crypto.tink.shaded.protobuf;

import com.facebook.appevents.integrity.IntegrityManager;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.experimental.kJ.HcgZcEUYo;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class UnsafeUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Unsafe f87150a = I();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class f87151b = Android.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f87152c = r(Long.TYPE);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f87153d = r(Integer.TYPE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final MemoryAccessor f87154e = G();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f87155f = a0();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f87156g = Z();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final long f87157h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f87158i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f87159j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f87160k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f87161l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final long f87162m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final long f87163n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final long f87164o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final long f87165p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final long f87166q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final long f87167r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final long f87168s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final long f87169t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final long f87170u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f87171v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final boolean f87172w;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Android32MemoryAccessor extends MemoryAccessor {
        Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void c(long j3, byte[] bArr, long j4, long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void d(byte[] bArr, long j3, long j4, long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean e(Object obj, long j3) {
            return UnsafeUtil.f87172w ? UnsafeUtil.v(obj, j3) : UnsafeUtil.w(obj, j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte f(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte g(Object obj, long j3) {
            return UnsafeUtil.f87172w ? UnsafeUtil.z(obj, j3) : UnsafeUtil.A(obj, j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public double h(Object obj, long j3) {
            return Double.longBitsToDouble(l(obj, j3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public float i(Object obj, long j3) {
            return Float.intBitsToFloat(j(obj, j3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public long k(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void o(Object obj, long j3, boolean z2) {
            if (UnsafeUtil.f87172w) {
                UnsafeUtil.O(obj, j3, z2);
            } else {
                UnsafeUtil.P(obj, j3, z2);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void p(long j3, byte b3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void q(Object obj, long j3, byte b3) {
            if (UnsafeUtil.f87172w) {
                UnsafeUtil.S(obj, j3, b3);
            } else {
                UnsafeUtil.T(obj, j3, b3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void r(Object obj, long j3, double d3) {
            u(obj, j3, Double.doubleToLongBits(d3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void s(Object obj, long j3, float f3) {
            t(obj, j3, Float.floatToIntBits(f3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean x() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Android64MemoryAccessor extends MemoryAccessor {
        Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void c(long j3, byte[] bArr, long j4, long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void d(byte[] bArr, long j3, long j4, long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean e(Object obj, long j3) {
            return UnsafeUtil.f87172w ? UnsafeUtil.v(obj, j3) : UnsafeUtil.w(obj, j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte f(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte g(Object obj, long j3) {
            return UnsafeUtil.f87172w ? UnsafeUtil.z(obj, j3) : UnsafeUtil.A(obj, j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public double h(Object obj, long j3) {
            return Double.longBitsToDouble(l(obj, j3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public float i(Object obj, long j3) {
            return Float.intBitsToFloat(j(obj, j3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public long k(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void o(Object obj, long j3, boolean z2) {
            if (UnsafeUtil.f87172w) {
                UnsafeUtil.O(obj, j3, z2);
            } else {
                UnsafeUtil.P(obj, j3, z2);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void p(long j3, byte b3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void q(Object obj, long j3, byte b3) {
            if (UnsafeUtil.f87172w) {
                UnsafeUtil.S(obj, j3, b3);
            } else {
                UnsafeUtil.T(obj, j3, b3);
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void r(Object obj, long j3, double d3) {
            u(obj, j3, Double.doubleToLongBits(d3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void s(Object obj, long j3, float f3) {
            t(obj, j3, Float.floatToIntBits(f3));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean x() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class JvmMemoryAccessor extends MemoryAccessor {
        JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void c(long j3, byte[] bArr, long j4, long j5) {
            this.f87173a.copyMemory((Object) null, j3, bArr, UnsafeUtil.f87157h + j4, j5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void d(byte[] bArr, long j3, long j4, long j5) {
            this.f87173a.copyMemory(bArr, UnsafeUtil.f87157h + j3, (Object) null, j4, j5);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean e(Object obj, long j3) {
            return this.f87173a.getBoolean(obj, j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte f(long j3) {
            return this.f87173a.getByte(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public byte g(Object obj, long j3) {
            return this.f87173a.getByte(obj, j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public double h(Object obj, long j3) {
            return this.f87173a.getDouble(obj, j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public float i(Object obj, long j3) {
            return this.f87173a.getFloat(obj, j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public long k(long j3) {
            return this.f87173a.getLong(j3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void o(Object obj, long j3, boolean z2) {
            this.f87173a.putBoolean(obj, j3, z2);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void p(long j3, byte b3) {
            this.f87173a.putByte(j3, b3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void q(Object obj, long j3, byte b3) {
            this.f87173a.putByte(obj, j3, b3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void r(Object obj, long j3, double d3) {
            this.f87173a.putDouble(obj, j3, d3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public void s(Object obj, long j3, float f3) {
            this.f87173a.putFloat(obj, j3, f3);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean x() {
            if (!super.x()) {
                return false;
            }
            try {
                Class<?> cls = this.f87173a.getClass();
                Class cls2 = Long.TYPE;
                cls.getMethod("getByte", cls2);
                cls.getMethod("putByte", cls2, Byte.TYPE);
                cls.getMethod("getInt", cls2);
                cls.getMethod("putInt", cls2, Integer.TYPE);
                cls.getMethod("getLong", cls2);
                cls.getMethod("putLong", cls2, cls2);
                cls.getMethod("copyMemory", cls2, cls2, cls2);
                cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.L(th);
                return false;
            }
        }

        @Override // com.google.crypto.tink.shaded.protobuf.UnsafeUtil.MemoryAccessor
        public boolean w() {
            if (!super.w()) {
                return false;
            }
            try {
                Class<?> cls = this.f87173a.getClass();
                Class cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getBoolean", Object.class, cls2);
                cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                cls.getMethod("getFloat", Object.class, cls2);
                cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                cls.getMethod("getDouble", Object.class, cls2);
                cls.getMethod(HcgZcEUYo.AhZeo, Object.class, cls2, Double.TYPE);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.L(th);
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class MemoryAccessor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Unsafe f87173a;

        MemoryAccessor(Unsafe unsafe) {
            this.f87173a = unsafe;
        }

        public final int a(Class cls) {
            return this.f87173a.arrayBaseOffset(cls);
        }

        public final int b(Class cls) {
            return this.f87173a.arrayIndexScale(cls);
        }

        public abstract void c(long j3, byte[] bArr, long j4, long j5);

        public abstract void d(byte[] bArr, long j3, long j4, long j5);

        public abstract boolean e(Object obj, long j3);

        public abstract byte f(long j3);

        public abstract byte g(Object obj, long j3);

        public abstract double h(Object obj, long j3);

        public abstract float i(Object obj, long j3);

        public final int j(Object obj, long j3) {
            return this.f87173a.getInt(obj, j3);
        }

        public abstract long k(long j3);

        public final long l(Object obj, long j3) {
            return this.f87173a.getLong(obj, j3);
        }

        public final Object m(Object obj, long j3) {
            return this.f87173a.getObject(obj, j3);
        }

        public final long n(java.lang.reflect.Field field) {
            return this.f87173a.objectFieldOffset(field);
        }

        public abstract void o(Object obj, long j3, boolean z2);

        public abstract void p(long j3, byte b3);

        public abstract void q(Object obj, long j3, byte b3);

        public abstract void r(Object obj, long j3, double d3);

        public abstract void s(Object obj, long j3, float f3);

        public final void t(Object obj, long j3, int i3) {
            this.f87173a.putInt(obj, j3, i3);
        }

        public final void u(Object obj, long j3, long j4) {
            this.f87173a.putLong(obj, j3, j4);
        }

        public final void v(Object obj, long j3, Object obj2) {
            this.f87173a.putObject(obj, j3, obj2);
        }

        public boolean w() {
            Unsafe unsafe = this.f87173a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.L(th);
                return false;
            }
        }

        public boolean x() {
            Unsafe unsafe = this.f87173a;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", java.lang.reflect.Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return UnsafeUtil.o() != null;
            } catch (Throwable th) {
                UnsafeUtil.L(th);
                return false;
            }
        }
    }

    static {
        long jM = m(byte[].class);
        f87157h = jM;
        f87158i = m(boolean[].class);
        f87159j = n(boolean[].class);
        f87160k = m(int[].class);
        f87161l = n(int[].class);
        f87162m = m(long[].class);
        f87163n = n(long[].class);
        f87164o = m(float[].class);
        f87165p = n(float[].class);
        f87166q = m(double[].class);
        f87167r = n(double[].class);
        f87168s = m(Object[].class);
        f87169t = n(Object[].class);
        f87170u = t(o());
        f87171v = (int) (jM & 7);
        f87172w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte A(Object obj, long j3) {
        return (byte) ((D(obj, (-4) & j3) >>> ((int) ((j3 & 3) << 3))) & 255);
    }

    static double B(Object obj, long j3) {
        return f87154e.h(obj, j3);
    }

    static float C(Object obj, long j3) {
        return f87154e.i(obj, j3);
    }

    static int D(Object obj, long j3) {
        return f87154e.j(obj, j3);
    }

    static long E(long j3) {
        return f87154e.k(j3);
    }

    static long F(Object obj, long j3) {
        return f87154e.l(obj, j3);
    }

    private static MemoryAccessor G() {
        Unsafe unsafe = f87150a;
        if (unsafe == null) {
            return null;
        }
        if (!Android.c()) {
            return new JvmMemoryAccessor(unsafe);
        }
        if (f87152c) {
            return new Android64MemoryAccessor(unsafe);
        }
        if (f87153d) {
            return new Android32MemoryAccessor(unsafe);
        }
        return null;
    }

    static Object H(Object obj, long j3) {
        return f87154e.m(obj, j3);
    }

    static Unsafe I() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.crypto.tink.shaded.protobuf.UnsafeUtil.1
                @Override // java.security.PrivilegedExceptionAction
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Unsafe run() throws IllegalAccessException {
                    for (java.lang.reflect.Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean J() {
        return f87156g;
    }

    static boolean K() {
        return f87155f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void L(Throwable th) {
        Logger.getLogger(UnsafeUtil.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    static long M(java.lang.reflect.Field field) {
        return f87154e.n(field);
    }

    static void N(Object obj, long j3, boolean z2) {
        f87154e.o(obj, j3, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void O(Object obj, long j3, boolean z2) {
        S(obj, j3, z2 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void P(Object obj, long j3, boolean z2) {
        T(obj, j3, z2 ? (byte) 1 : (byte) 0);
    }

    static void Q(long j3, byte b3) {
        f87154e.p(j3, b3);
    }

    static void R(byte[] bArr, long j3, byte b3) {
        f87154e.q(bArr, f87157h + j3, b3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void S(Object obj, long j3, byte b3) {
        long j4 = (-4) & j3;
        int iD = D(obj, j4);
        int i3 = ((~((int) j3)) & 3) << 3;
        W(obj, j4, ((255 & b3) << i3) | (iD & (~(255 << i3))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void T(Object obj, long j3, byte b3) {
        long j4 = (-4) & j3;
        int i3 = (((int) j3) & 3) << 3;
        W(obj, j4, ((255 & b3) << i3) | (D(obj, j4) & (~(255 << i3))));
    }

    static void U(Object obj, long j3, double d3) {
        f87154e.r(obj, j3, d3);
    }

    static void V(Object obj, long j3, float f3) {
        f87154e.s(obj, j3, f3);
    }

    static void W(Object obj, long j3, int i3) {
        f87154e.t(obj, j3, i3);
    }

    static void X(Object obj, long j3, long j4) {
        f87154e.u(obj, j3, j4);
    }

    static void Y(Object obj, long j3, Object obj2) {
        f87154e.v(obj, j3, obj2);
    }

    private static boolean Z() {
        MemoryAccessor memoryAccessor = f87154e;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.w();
    }

    private static boolean a0() {
        MemoryAccessor memoryAccessor = f87154e;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.x();
    }

    static long k(ByteBuffer byteBuffer) {
        return f87154e.l(byteBuffer, f87170u);
    }

    static Object l(Class cls) {
        try {
            return f87150a.allocateInstance(cls);
        } catch (InstantiationException e3) {
            throw new IllegalStateException(e3);
        }
    }

    private static int m(Class cls) {
        if (f87156g) {
            return f87154e.a(cls);
        }
        return -1;
    }

    private static int n(Class cls) {
        if (f87156g) {
            return f87154e.b(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.reflect.Field o() {
        java.lang.reflect.Field fieldS;
        if (Android.c() && (fieldS = s(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldS;
        }
        java.lang.reflect.Field fieldS2 = s(Buffer.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (fieldS2 == null || fieldS2.getType() != Long.TYPE) {
            return null;
        }
        return fieldS2;
    }

    static void p(long j3, byte[] bArr, long j4, long j5) {
        f87154e.c(j3, bArr, j4, j5);
    }

    static void q(byte[] bArr, long j3, long j4, long j5) {
        f87154e.d(bArr, j3, j4, j5);
    }

    static boolean r(Class cls) {
        if (!Android.c()) {
            return false;
        }
        try {
            Class cls2 = f87151b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static java.lang.reflect.Field s(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long t(java.lang.reflect.Field field) {
        MemoryAccessor memoryAccessor;
        if (field == null || (memoryAccessor = f87154e) == null) {
            return -1L;
        }
        return memoryAccessor.n(field);
    }

    static boolean u(Object obj, long j3) {
        return f87154e.e(obj, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean v(Object obj, long j3) {
        return z(obj, j3) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean w(Object obj, long j3) {
        return A(obj, j3) != 0;
    }

    static byte x(long j3) {
        return f87154e.f(j3);
    }

    static byte y(byte[] bArr, long j3) {
        return f87154e.g(bArr, f87157h + j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte z(Object obj, long j3) {
        return (byte) ((D(obj, (-4) & j3) >>> ((int) (((~j3) & 3) << 3))) & 255);
    }
}
