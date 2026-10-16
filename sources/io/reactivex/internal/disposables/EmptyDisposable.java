package io.reactivex.internal.disposables;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.internal.fuseable.QueueDisposable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public enum EmptyDisposable implements QueueDisposable<Object> {
    INSTANCE,
    NEVER;

    public static void a(CompletableObserver completableObserver) {
        completableObserver.a(INSTANCE);
        completableObserver.onComplete();
    }

    public static void b(MaybeObserver maybeObserver) {
        maybeObserver.a(INSTANCE);
        maybeObserver.onComplete();
    }

    public static void c(Observer observer) {
        observer.a(INSTANCE);
        observer.onComplete();
    }

    public static void g(Throwable th, CompletableObserver completableObserver) {
        completableObserver.a(INSTANCE);
        completableObserver.onError(th);
    }

    public static void h(Throwable th, MaybeObserver maybeObserver) {
        maybeObserver.a(INSTANCE);
        maybeObserver.onError(th);
    }

    public static void i(Throwable th, Observer observer) {
        observer.a(INSTANCE);
        observer.onError(th);
    }

    public static void j(Throwable th, SingleObserver singleObserver) {
        singleObserver.a(INSTANCE);
        singleObserver.onError(th);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean e() {
        return this == INSTANCE;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int l(int i3) {
        return i3 & 2;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public Object poll() {
        return null;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }
}
