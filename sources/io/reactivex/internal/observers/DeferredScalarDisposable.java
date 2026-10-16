package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    private static final long serialVersionUID = -5502432239815349361L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Observer f134971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Object f134972b;

    public DeferredScalarDisposable(Observer observer) {
        this.f134971a = observer;
    }

    public final void b() {
        if ((get() & 54) != 0) {
            return;
        }
        lazySet(2);
        this.f134971a.onComplete();
    }

    public final void c(Object obj) {
        int i3 = get();
        if ((i3 & 54) != 0) {
            return;
        }
        Observer observer = this.f134971a;
        if (i3 == 8) {
            this.f134972b = obj;
            lazySet(16);
            observer.h(null);
        } else {
            lazySet(2);
            observer.h(obj);
        }
        if (get() != 4) {
            observer.onComplete();
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final void clear() {
        lazySet(32);
        this.f134972b = null;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        set(4);
        this.f134972b = null;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean e() {
        return get() == 4;
    }

    public final void g(Throwable th) {
        if ((get() & 54) != 0) {
            RxJavaPlugins.s(th);
        } else {
            lazySet(2);
            this.f134971a.onError(th);
        }
    }

    public final boolean i() {
        return getAndSet(4) != 4;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public final int l(int i3) {
        if ((i3 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public final Object poll() {
        if (get() != 16) {
            return null;
        }
        Object obj = this.f134972b;
        this.f134972b = null;
        lazySet(32);
        return obj;
    }
}
