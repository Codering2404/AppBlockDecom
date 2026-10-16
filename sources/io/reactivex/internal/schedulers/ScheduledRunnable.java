package io.reactivex.internal.schedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, Disposable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Object f139062b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Object f139063c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Object f139064d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Object f139065f = new Object();
    private static final long serialVersionUID = -6120223772001106981L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Runnable f139066a;

    public ScheduledRunnable(Runnable runnable, DisposableContainer disposableContainer) {
        super(3);
        this.f139066a = runnable;
        lazySet(0, disposableContainer);
    }

    public void a(Future future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == f139065f) {
                return;
            }
            if (obj == f139063c) {
                future.cancel(false);
                return;
            } else if (obj == f139064d) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        while (true) {
            Object obj5 = get(1);
            if (obj5 == f139065f || obj5 == (obj3 = f139063c) || obj5 == (obj4 = f139064d)) {
                break;
            }
            boolean z2 = get(2) != Thread.currentThread();
            if (z2) {
                obj3 = obj4;
            }
            if (compareAndSet(1, obj5, obj3)) {
                if (obj5 != null) {
                    ((Future) obj5).cancel(z2);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == f139065f || obj == (obj2 = f139062b) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((DisposableContainer) obj).c(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        Object obj = get(0);
        return obj == f139062b || obj == f139065f;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        boolean zCompareAndSet;
        Object obj4;
        lazySet(2, Thread.currentThread());
        try {
            this.f139066a.run();
        } finally {
            try {
            } catch (Throwable th) {
                do {
                    if (obj == obj2) {
                        break;
                    } else if (obj == obj3) {
                        break;
                    }
                } while (!zCompareAndSet);
            }
        }
        lazySet(2, null);
        Object obj5 = get(0);
        if (obj5 != f139062b && compareAndSet(0, obj5, f139065f) && obj5 != null) {
            ((DisposableContainer) obj5).c(this);
        }
        do {
            obj4 = get(1);
            if (obj4 == f139063c || obj4 == f139064d) {
                return;
            }
        } while (!compareAndSet(1, obj4, f139065f));
    }
}
