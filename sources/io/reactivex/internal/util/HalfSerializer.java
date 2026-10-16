package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class HalfSerializer {
    public static void a(Observer observer, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thB = atomicThrowable.b();
            if (thB != null) {
                observer.onError(thB);
            } else {
                observer.onComplete();
            }
        }
    }

    public static void b(Subscriber subscriber, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thB = atomicThrowable.b();
            if (thB != null) {
                subscriber.onError(thB);
            } else {
                subscriber.onComplete();
            }
        }
    }

    public static void c(Observer observer, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.a(th)) {
            RxJavaPlugins.s(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            observer.onError(atomicThrowable.b());
        }
    }

    public static void d(Subscriber subscriber, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.a(th)) {
            RxJavaPlugins.s(th);
        } else if (atomicInteger.getAndIncrement() == 0) {
            subscriber.onError(atomicThrowable.b());
        }
    }

    public static void e(Observer observer, Object obj, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            observer.h(obj);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thB = atomicThrowable.b();
                if (thB != null) {
                    observer.onError(thB);
                } else {
                    observer.onComplete();
                }
            }
        }
    }

    public static void f(Subscriber subscriber, Object obj, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            subscriber.h(obj);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thB = atomicThrowable.b();
                if (thB != null) {
                    subscriber.onError(thB);
                } else {
                    subscriber.onComplete();
                }
            }
        }
    }
}
