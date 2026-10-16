package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeFromCallable<T> extends Maybe<T> implements Callable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable f136899a;

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        Disposable disposableB = Disposables.b();
        maybeObserver.a(disposableB);
        if (disposableB.e()) {
            return;
        }
        try {
            Object objCall = this.f136899a.call();
            if (disposableB.e()) {
                return;
            }
            if (objCall == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(objCall);
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            if (disposableB.e()) {
                RxJavaPlugins.s(th);
            } else {
                maybeObserver.onError(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return this.f136899a.call();
    }
}
