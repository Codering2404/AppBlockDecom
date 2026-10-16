package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ObjectArrays;
import com.google.common.util.concurrent.SimpleTimeLimiter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class SimpleTimeLimiter implements TimeLimiter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f85948a;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.SimpleTimeLimiter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f85949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f85950b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ TimeUnit f85951c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Set f85952d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ SimpleTimeLimiter f85953e;

        public static /* synthetic */ Object a(Method method, Object obj, Object[] objArr) throws Exception {
            try {
                return method.invoke(obj, objArr);
            } catch (InvocationTargetException e3) {
                throw SimpleTimeLimiter.e(e3, false);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, final Method method, final Object[] objArr) {
            final Object obj2 = this.f85949a;
            return this.f85953e.c(new Callable() { // from class: com.google.common.util.concurrent.h
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return SimpleTimeLimiter.AnonymousClass1.a(method, obj2, objArr);
                }
            }, this.f85950b, this.f85951c, this.f85952d.contains(method));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object c(Callable callable, long j3, TimeUnit timeUnit, boolean z2) throws Exception {
        Preconditions.t(callable);
        Preconditions.t(timeUnit);
        d(j3);
        Future futureSubmit = this.f85948a.submit(callable);
        try {
            return z2 ? futureSubmit.get(j3, timeUnit) : Uninterruptibles.b(futureSubmit, j3, timeUnit);
        } catch (InterruptedException e3) {
            futureSubmit.cancel(true);
            throw e3;
        } catch (ExecutionException e4) {
            throw e(e4, true);
        } catch (TimeoutException e5) {
            futureSubmit.cancel(true);
            throw new UncheckedTimeoutException(e5);
        }
    }

    private static void d(long j3) {
        Preconditions.k(j3 > 0, "timeout must be positive: %s", j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Exception e(Exception exc, boolean z2) throws Exception {
        Throwable cause = exc.getCause();
        if (cause == null) {
            throw exc;
        }
        if (z2) {
            cause.setStackTrace((StackTraceElement[]) ObjectArrays.d(cause.getStackTrace(), exc.getStackTrace(), StackTraceElement.class));
        }
        if (cause instanceof Exception) {
            throw ((Exception) cause);
        }
        if (cause instanceof Error) {
            throw ((Error) cause);
        }
        throw exc;
    }
}
