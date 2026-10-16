package com.google.common.base.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class Finalizer implements Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Logger f83429d = Logger.getLogger(Finalizer.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Constructor f83430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Field f83431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f83432h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference f83433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PhantomReference f83434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReferenceQueue f83435c;

    static {
        Constructor constructorC = c();
        f83430f = constructorC;
        f83431g = constructorC == null ? e() : null;
    }

    private boolean a(Reference reference) {
        Reference referencePoll;
        Method methodD = d();
        if (methodD == null || !b(reference, methodD)) {
            return false;
        }
        do {
            referencePoll = this.f83435c.poll();
            if (referencePoll == null) {
                return true;
            }
        } while (b(referencePoll, methodD));
        return false;
    }

    private boolean b(Reference reference, Method method) {
        reference.clear();
        if (reference == this.f83434b) {
            return false;
        }
        try {
            method.invoke(reference, null);
            return true;
        } catch (Throwable th) {
            f83429d.log(Level.SEVERE, "Error cleaning up after reference.", th);
            return true;
        }
    }

    private static Constructor c() {
        try {
            return Thread.class.getConstructor(ThreadGroup.class, Runnable.class, String.class, Long.TYPE, Boolean.TYPE);
        } catch (Throwable unused) {
            return null;
        }
    }

    private Method d() {
        Class cls = (Class) this.f83433a.get();
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod("finalizeReferent", null);
        } catch (NoSuchMethodException e3) {
            throw new AssertionError(e3);
        }
    }

    private static Field e() {
        try {
            Field declaredField = Thread.class.getDeclaredField("inheritableThreadLocals");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            f83429d.log(Level.INFO, "Couldn't access Thread.inheritableThreadLocals. Reference finalizer threads will inherit thread local values.");
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (a(this.f83435c.remove())) {
        }
    }
}
