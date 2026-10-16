package com.google.android.libraries.places.internal;

import com.facebook.appevents.integrity.IntegrityManager;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbgf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Unsafe f76178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class f76179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f76180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzbge f76181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final boolean f76182e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f76183f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final long f76184g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final boolean f76185h;

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    static {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbgf.<clinit>():void");
    }

    private zzbgf() {
    }

    static /* synthetic */ boolean A(Object obj, long j3) {
        return ((byte) ((f76181d.f76177a.getInt(obj, (-4) & j3) >>> ((int) ((j3 & 3) << 3))) & 255)) != 0;
    }

    static /* synthetic */ void D(Throwable th) {
        Logger.getLogger(zzbgf.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    private static int E(Class cls) {
        if (f76183f) {
            return f76181d.f76177a.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int a(Class cls) {
        if (f76183f) {
            return f76181d.f76177a.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field b() {
        int i3 = zzbcc.f75986a;
        Field fieldC = c(Buffer.class, "effectiveDirectAddress");
        if (fieldC != null) {
            return fieldC;
        }
        Field fieldC2 = c(Buffer.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (fieldC2 == null || fieldC2.getType() != Long.TYPE) {
            return null;
        }
        return fieldC2;
    }

    private static Field c(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Object obj, long j3, byte b3) {
        Unsafe unsafe = f76181d.f76177a;
        long j4 = (-4) & j3;
        int i3 = unsafe.getInt(obj, j4);
        int i4 = ((~((int) j3)) & 3) << 3;
        unsafe.putInt(obj, j4, ((255 & b3) << i4) | (i3 & (~(255 << i4))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Object obj, long j3, byte b3) {
        Unsafe unsafe = f76181d.f76177a;
        long j4 = (-4) & j3;
        int i3 = (((int) j3) & 3) << 3;
        unsafe.putInt(obj, j4, ((255 & b3) << i3) | (unsafe.getInt(obj, j4) & (~(255 << i3))));
    }

    static boolean f() {
        return f76183f;
    }

    static boolean g() {
        return f76182e;
    }

    static Object h(Class cls) {
        try {
            return f76178a.allocateInstance(cls);
        } catch (InstantiationException e3) {
            throw new IllegalStateException(e3);
        }
    }

    static int i(Object obj, long j3) {
        return f76181d.f76177a.getInt(obj, j3);
    }

    static void j(Object obj, long j3, int i3) {
        f76181d.f76177a.putInt(obj, j3, i3);
    }

    static long k(Object obj, long j3) {
        return f76181d.f76177a.getLong(obj, j3);
    }

    static void l(Object obj, long j3, long j4) {
        f76181d.f76177a.putLong(obj, j3, j4);
    }

    static boolean m(Object obj, long j3) {
        return f76181d.b(obj, j3);
    }

    static void n(Object obj, long j3, boolean z2) {
        f76181d.c(obj, j3, z2);
    }

    static float o(Object obj, long j3) {
        return f76181d.d(obj, j3);
    }

    static void p(Object obj, long j3, float f3) {
        f76181d.e(obj, j3, f3);
    }

    static double q(Object obj, long j3) {
        return f76181d.f(obj, j3);
    }

    static void r(Object obj, long j3, double d3) {
        f76181d.g(obj, j3, d3);
    }

    static Object s(Object obj, long j3) {
        return f76181d.f76177a.getObject(obj, j3);
    }

    static void t(Object obj, long j3, Object obj2) {
        f76181d.f76177a.putObject(obj, j3, obj2);
    }

    static void u(byte[] bArr, long j3, byte b3) {
        f76181d.a(bArr, f76184g + j3, b3);
    }

    static Unsafe v() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzbgb());
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean w(Class cls) {
        int i3 = zzbcc.f75986a;
        try {
            Class cls2 = f76179b;
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

    static /* synthetic */ boolean z(Object obj, long j3) {
        return ((byte) ((f76181d.f76177a.getInt(obj, (-4) & j3) >>> ((int) (((~j3) & 3) << 3))) & 255)) != 0;
    }
}
