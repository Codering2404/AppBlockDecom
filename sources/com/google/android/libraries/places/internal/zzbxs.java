package com.google.android.libraries.places.internal;

import com.google.common.cache.LSNn.vfptEEmYY;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbxs implements zzbug {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f77170b = Logger.getLogger(zzbxs.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Constructor f77171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Method f77172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final RuntimeException f77173e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object[] f77174f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f77175a;

    zzbxs() {
        RuntimeException runtimeException = f77173e;
        if (runtimeException != null) {
            throw runtimeException;
        }
        try {
            this.f77175a = f77171c.newInstance(null);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        } catch (InstantiationException e4) {
            throw new RuntimeException(e4);
        } catch (InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    static boolean a() {
        return f77173e == null;
    }

    @Override // com.google.android.libraries.places.internal.zzbug
    public final void zza(long j3) {
        try {
            f77172d.invoke(this.f77175a, f77174f);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    static {
        Throwable th;
        Method method;
        Method method2;
        Constructor<?> constructor;
        Class<?> cls;
        try {
            cls = Class.forName("java.util.concurrent.atomic.LongAdder");
            method2 = cls.getMethod("add", Long.TYPE);
        } catch (Throwable th2) {
            th = th2;
            method = null;
        }
        try {
            cls.getMethod("sum", null);
            Constructor<?>[] constructors = cls.getConstructors();
            int length = constructors.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    constructor = null;
                    break;
                }
                constructor = constructors[i3];
                if (constructor.getParameterTypes().length == 0) {
                    break;
                } else {
                    i3++;
                }
            }
            th = null;
        } catch (Throwable th3) {
            th = th3;
            method = method2;
            f77170b.logp(Level.FINE, vfptEEmYY.AlSpqmckL, "<clinit>", "LongAdder can not be found via reflection, this is normal for JDK7 and below", th);
            method2 = method;
            constructor = null;
        }
        if (th != null || constructor == null) {
            f77171c = null;
            f77172d = null;
            f77173e = new RuntimeException(th);
        } else {
            f77171c = constructor;
            f77172d = method2;
            f77173e = null;
        }
        f77174f = new Object[]{1L};
    }
}
