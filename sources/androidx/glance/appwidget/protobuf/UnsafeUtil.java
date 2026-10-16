package androidx.glance.appwidget.protobuf;

import com.facebook.appevents.integrity.IntegrityManager;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class UnsafeUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Unsafe f39289a = I();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class f39290b = Android.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f39291c = r(Long.TYPE);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f39292d = r(Integer.TYPE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final MemoryAccessor f39293e = G();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f39294f = a0();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f39295g = Z();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final long f39296h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final long f39297i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final long f39298j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f39299k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final long f39300l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final long f39301m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final long f39302n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final long f39303o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final long f39304p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final long f39305q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final long f39306r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final long f39307s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final long f39308t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final long f39309u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f39310v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final boolean f39311w;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Android32MemoryAccessor extends MemoryAccessor {
        Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void c(long j3, byte[] bArr, long j4, long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void d(byte[] bArr, long j3, long j4, long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public boolean e(Object obj, long j3) {
            return UnsafeUtil.f39311w ? UnsafeUtil.v(obj, j3) : UnsafeUtil.w(obj, j3);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public byte f(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public byte g(Object obj, long j3) {
            return UnsafeUtil.f39311w ? UnsafeUtil.z(obj, j3) : UnsafeUtil.A(obj, j3);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public double h(Object obj, long j3) {
            return Double.longBitsToDouble(l(obj, j3));
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public float i(Object obj, long j3) {
            return Float.intBitsToFloat(j(obj, j3));
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public long k(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void o(Object obj, long j3, boolean z2) {
            if (UnsafeUtil.f39311w) {
                UnsafeUtil.O(obj, j3, z2);
            } else {
                UnsafeUtil.P(obj, j3, z2);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void p(long j3, byte b3) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void q(Object obj, long j3, byte b3) {
            if (UnsafeUtil.f39311w) {
                UnsafeUtil.S(obj, j3, b3);
            } else {
                UnsafeUtil.T(obj, j3, b3);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void r(Object obj, long j3, double d3) {
            u(obj, j3, Double.doubleToLongBits(d3));
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void s(Object obj, long j3, float f3) {
            t(obj, j3, Float.floatToIntBits(f3));
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public boolean x() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Android64MemoryAccessor extends MemoryAccessor {
        Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void c(long j3, byte[] bArr, long j4, long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void d(byte[] bArr, long j3, long j4, long j5) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public boolean e(Object obj, long j3) {
            return UnsafeUtil.f39311w ? UnsafeUtil.v(obj, j3) : UnsafeUtil.w(obj, j3);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public byte f(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public byte g(Object obj, long j3) {
            return UnsafeUtil.f39311w ? UnsafeUtil.z(obj, j3) : UnsafeUtil.A(obj, j3);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public double h(Object obj, long j3) {
            return Double.longBitsToDouble(l(obj, j3));
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public float i(Object obj, long j3) {
            return Float.intBitsToFloat(j(obj, j3));
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public long k(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void o(Object obj, long j3, boolean z2) {
            if (UnsafeUtil.f39311w) {
                UnsafeUtil.O(obj, j3, z2);
            } else {
                UnsafeUtil.P(obj, j3, z2);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void p(long j3, byte b3) {
            throw new UnsupportedOperationException();
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void q(Object obj, long j3, byte b3) {
            if (UnsafeUtil.f39311w) {
                UnsafeUtil.S(obj, j3, b3);
            } else {
                UnsafeUtil.T(obj, j3, b3);
            }
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void r(Object obj, long j3, double d3) {
            u(obj, j3, Double.doubleToLongBits(d3));
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void s(Object obj, long j3, float f3) {
            t(obj, j3, Float.floatToIntBits(f3));
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public boolean x() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class JvmMemoryAccessor extends MemoryAccessor {
        JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void c(long j3, byte[] bArr, long j4, long j5) {
            this.f39312a.copyMemory((Object) null, j3, bArr, UnsafeUtil.f39296h + j4, j5);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void d(byte[] bArr, long j3, long j4, long j5) {
            this.f39312a.copyMemory(bArr, UnsafeUtil.f39296h + j3, (Object) null, j4, j5);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public boolean e(Object obj, long j3) {
            return this.f39312a.getBoolean(obj, j3);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public byte f(long j3) {
            return this.f39312a.getByte(j3);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public byte g(Object obj, long j3) {
            return this.f39312a.getByte(obj, j3);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public double h(Object obj, long j3) {
            return this.f39312a.getDouble(obj, j3);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public float i(Object obj, long j3) {
            return this.f39312a.getFloat(obj, j3);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public long k(long j3) {
            return this.f39312a.getLong(j3);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void o(Object obj, long j3, boolean z2) {
            this.f39312a.putBoolean(obj, j3, z2);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void p(long j3, byte b3) {
            this.f39312a.putByte(j3, b3);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void q(Object obj, long j3, byte b3) {
            this.f39312a.putByte(obj, j3, b3);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void r(Object obj, long j3, double d3) {
            this.f39312a.putDouble(obj, j3, d3);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public void s(Object obj, long j3, float f3) {
            this.f39312a.putFloat(obj, j3, f3);
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public boolean w() {
            if (!super.w()) {
                return false;
            }
            try {
                Class<?> cls = this.f39312a.getClass();
                Class cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getBoolean", Object.class, cls2);
                cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                cls.getMethod("getFloat", Object.class, cls2);
                cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                cls.getMethod("getDouble", Object.class, cls2);
                cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.L(th);
                return false;
            }
        }

        @Override // androidx.glance.appwidget.protobuf.UnsafeUtil.MemoryAccessor
        public boolean x() {
            if (!super.x()) {
                return false;
            }
            try {
                Class<?> cls = this.f39312a.getClass();
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
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class MemoryAccessor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Unsafe f39312a;

        MemoryAccessor(Unsafe unsafe) {
            this.f39312a = unsafe;
        }

        public final int a(Class cls) {
            return this.f39312a.arrayBaseOffset(cls);
        }

        public final int b(Class cls) {
            return this.f39312a.arrayIndexScale(cls);
        }

        public abstract void c(long j3, byte[] bArr, long j4, long j5);

        public abstract void d(byte[] bArr, long j3, long j4, long j5);

        public abstract boolean e(Object obj, long j3);

        public abstract byte f(long j3);

        public abstract byte g(Object obj, long j3);

        public abstract double h(Object obj, long j3);

        public abstract float i(Object obj, long j3);

        public final int j(Object obj, long j3) {
            return this.f39312a.getInt(obj, j3);
        }

        public abstract long k(long j3);

        public final long l(Object obj, long j3) {
            return this.f39312a.getLong(obj, j3);
        }

        public final Object m(Object obj, long j3) {
            return this.f39312a.getObject(obj, j3);
        }

        public final long n(java.lang.reflect.Field field) {
            return this.f39312a.objectFieldOffset(field);
        }

        public abstract void o(Object obj, long j3, boolean z2);

        public abstract void p(long j3, byte b3);

        public abstract void q(Object obj, long j3, byte b3);

        public abstract void r(Object obj, long j3, double d3);

        public abstract void s(Object obj, long j3, float f3);

        public final void t(Object obj, long j3, int i3) {
            this.f39312a.putInt(obj, j3, i3);
        }

        public final void u(Object obj, long j3, long j4) {
            this.f39312a.putLong(obj, j3, j4);
        }

        public final void v(Object obj, long j3, Object obj2) {
            this.f39312a.putObject(obj, j3, obj2);
        }

        public boolean w() {
            Unsafe unsafe = this.f39312a;
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
            Unsafe unsafe = this.f39312a;
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
        f39296h = jM;
        f39297i = m(boolean[].class);
        f39298j = n(boolean[].class);
        f39299k = m(int[].class);
        f39300l = n(int[].class);
        f39301m = m(long[].class);
        f39302n = n(long[].class);
        f39303o = m(float[].class);
        f39304p = n(float[].class);
        f39305q = m(double[].class);
        f39306r = n(double[].class);
        f39307s = m(Object[].class);
        f39308t = n(Object[].class);
        f39309u = t(o());
        f39310v = (int) (jM & 7);
        f39311w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte A(Object obj, long j3) {
        return (byte) ((D(obj, (-4) & j3) >>> ((int) ((j3 & 3) << 3))) & 255);
    }

    static double B(Object obj, long j3) {
        return f39293e.h(obj, j3);
    }

    static float C(Object obj, long j3) {
        return f39293e.i(obj, j3);
    }

    static int D(Object obj, long j3) {
        return f39293e.j(obj, j3);
    }

    static long E(long j3) {
        return f39293e.k(j3);
    }

    static long F(Object obj, long j3) {
        return f39293e.l(obj, j3);
    }

    private static MemoryAccessor G() {
        Unsafe unsafe = f39289a;
        if (unsafe == null) {
            return null;
        }
        if (!Android.c()) {
            return new JvmMemoryAccessor(unsafe);
        }
        if (f39291c) {
            return new Android64MemoryAccessor(unsafe);
        }
        if (f39292d) {
            return new Android32MemoryAccessor(unsafe);
        }
        return null;
    }

    static Object H(Object obj, long j3) {
        return f39293e.m(obj, j3);
    }

    static Unsafe I() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: androidx.glance.appwidget.protobuf.UnsafeUtil.1
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
        return f39295g;
    }

    static boolean K() {
        return f39294f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void L(Throwable th) {
        Logger.getLogger(UnsafeUtil.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    static long M(java.lang.reflect.Field field) {
        return f39293e.n(field);
    }

    static void N(Object obj, long j3, boolean z2) {
        f39293e.o(obj, j3, z2);
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
        f39293e.p(j3, b3);
    }

    static void R(byte[] bArr, long j3, byte b3) {
        f39293e.q(bArr, f39296h + j3, b3);
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
        f39293e.r(obj, j3, d3);
    }

    static void V(Object obj, long j3, float f3) {
        f39293e.s(obj, j3, f3);
    }

    static void W(Object obj, long j3, int i3) {
        f39293e.t(obj, j3, i3);
    }

    static void X(Object obj, long j3, long j4) {
        f39293e.u(obj, j3, j4);
    }

    static void Y(Object obj, long j3, Object obj2) {
        f39293e.v(obj, j3, obj2);
    }

    private static boolean Z() {
        MemoryAccessor memoryAccessor = f39293e;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.w();
    }

    private static boolean a0() {
        MemoryAccessor memoryAccessor = f39293e;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.x();
    }

    static long k(ByteBuffer byteBuffer) {
        return f39293e.l(byteBuffer, f39309u);
    }

    static Object l(Class cls) {
        try {
            return f39289a.allocateInstance(cls);
        } catch (InstantiationException e3) {
            throw new IllegalStateException(e3);
        }
    }

    private static int m(Class cls) {
        if (f39295g) {
            return f39293e.a(cls);
        }
        return -1;
    }

    private static int n(Class cls) {
        if (f39295g) {
            return f39293e.b(cls);
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
        f39293e.c(j3, bArr, j4, j5);
    }

    static void q(byte[] bArr, long j3, long j4, long j5) {
        f39293e.d(bArr, j3, j4, j5);
    }

    static boolean r(Class cls) {
        if (!Android.c()) {
            return false;
        }
        try {
            Class cls2 = f39290b;
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
        if (field == null || (memoryAccessor = f39293e) == null) {
            return -1L;
        }
        return memoryAccessor.n(field);
    }

    static boolean u(Object obj, long j3) {
        return f39293e.e(obj, j3);
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
        return f39293e.f(j3);
    }

    static byte y(byte[] bArr, long j3) {
        return f39293e.g(bArr, f39296h + j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte z(Object obj, long j3) {
        return (byte) ((D(obj, (-4) & j3) >>> ((int) (((~j3) & 3) << 3))) & 255);
    }
}
