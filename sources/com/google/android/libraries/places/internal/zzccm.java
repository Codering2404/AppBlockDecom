package com.google.android.libraries.places.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzccm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f77565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f77566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class[] f77567c;

    public zzccm(Class cls, String str, Class... clsArr) {
        this.f77565a = cls;
        this.f77566b = str;
        this.f77567c = clsArr;
    }

    private final Method d(Class cls) {
        Class cls2;
        Method methodE = e(cls, this.f77566b, this.f77567c);
        if (methodE == null || (cls2 = this.f77565a) == null || cls2.isAssignableFrom(methodE.getReturnType())) {
            return methodE;
        }
        return null;
    }

    private static Method e(Class cls, String str, Class[] clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            if ((cls.getModifiers() & 1) == 0) {
                return e(cls.getSuperclass(), str, clsArr);
            }
            Method method = cls.getMethod(str, clsArr);
            try {
                if (1 != (method.getModifiers() & 1)) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    public final boolean a(Object obj) {
        return d(obj.getClass()) != null;
    }

    public final Object b(Object obj, Object... objArr) {
        try {
            Method methodD = d(obj.getClass());
            if (methodD == null) {
                return null;
            }
            try {
                return methodD.invoke(obj, objArr);
            } catch (IllegalAccessException unused) {
                return null;
            }
        } catch (InvocationTargetException e3) {
            Throwable targetException = e3.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    public final Object c(Object obj, Object... objArr) {
        try {
            Method methodD = d(obj.getClass());
            if (methodD != null) {
                try {
                    return methodD.invoke(obj, objArr);
                } catch (IllegalAccessException e3) {
                    AssertionError assertionError = new AssertionError("Unexpectedly could not call: ".concat(methodD.toString()));
                    assertionError.initCause(e3);
                    throw assertionError;
                }
            }
            String str = this.f77566b;
            String strValueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(str.length() + 33 + strValueOf.length());
            sb.append("Method ");
            sb.append(str);
            sb.append(" not supported for object ");
            sb.append(strValueOf);
            throw new AssertionError(sb.toString());
        } catch (InvocationTargetException e4) {
            Throwable targetException = e4.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError2 = new AssertionError("Unexpected exception");
            assertionError2.initCause(targetException);
            throw assertionError2;
        }
    }
}
