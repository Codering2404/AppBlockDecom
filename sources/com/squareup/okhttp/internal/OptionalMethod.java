package com.squareup.okhttp.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
class OptionalMethod<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class f93100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f93101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class[] f93102c;

    public OptionalMethod(Class cls, String str, Class... clsArr) {
        this.f93100a = cls;
        this.f93101b = str;
        this.f93102c = clsArr;
    }

    private Method a(Class cls) {
        Class cls2;
        String str = this.f93101b;
        if (str == null) {
            return null;
        }
        Method methodB = b(cls, str, this.f93102c);
        if (methodB == null || (cls2 = this.f93100a) == null || cls2.isAssignableFrom(methodB.getReturnType())) {
            return methodB;
        }
        return null;
    }

    private static Method b(Class cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
                return method;
            } catch (NoSuchMethodException unused) {
                return method;
            }
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    public Object c(Object obj, Object... objArr) {
        Method methodA = a(obj.getClass());
        if (methodA == null) {
            throw new AssertionError("Method " + this.f93101b + " not supported for object " + obj);
        }
        try {
            return methodA.invoke(obj, objArr);
        } catch (IllegalAccessException e3) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + methodA);
            assertionError.initCause(e3);
            throw assertionError;
        }
    }

    public Object d(Object obj, Object... objArr) {
        Method methodA = a(obj.getClass());
        if (methodA == null) {
            return null;
        }
        try {
            return methodA.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    public Object e(Object obj, Object... objArr) {
        try {
            return d(obj, objArr);
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

    public Object f(Object obj, Object... objArr) {
        try {
            return c(obj, objArr);
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

    public boolean g(Object obj) {
        return a(obj.getClass()) != null;
    }
}
