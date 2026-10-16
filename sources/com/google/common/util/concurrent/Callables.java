package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Callables {
    public static /* synthetic */ void a(Supplier supplier, Runnable runnable) {
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        boolean zE = e((String) supplier.get(), threadCurrentThread);
        try {
            runnable.run();
        } finally {
            if (zE) {
                e(name, threadCurrentThread);
            }
        }
    }

    public static /* synthetic */ Object b(Supplier supplier, Callable callable) {
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        boolean zE = e((String) supplier.get(), threadCurrentThread);
        try {
            return callable.call();
        } finally {
            if (zE) {
                e(name, threadCurrentThread);
            }
        }
    }

    static Runnable c(final Runnable runnable, final Supplier supplier) {
        Preconditions.t(supplier);
        Preconditions.t(runnable);
        return new Runnable() { // from class: com.google.common.util.concurrent.b
            @Override // java.lang.Runnable
            public final void run() {
                Callables.a(supplier, runnable);
            }
        };
    }

    static Callable d(final Callable callable, final Supplier supplier) {
        Preconditions.t(supplier);
        Preconditions.t(callable);
        return new Callable() { // from class: com.google.common.util.concurrent.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Callables.b(supplier, callable);
            }
        };
    }

    private static boolean e(String str, Thread thread) {
        try {
            thread.setName(str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
