package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableFromCallable extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable f135086a;

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        Disposable disposableB = Disposables.b();
        completableObserver.a(disposableB);
        try {
            this.f135086a.call();
            if (disposableB.e()) {
                return;
            }
            completableObserver.onComplete();
        } catch (Throwable th) {
            Exceptions.b(th);
            if (disposableB.e()) {
                RxJavaPlugins.s(th);
            } else {
                completableObserver.onError(th);
            }
        }
    }
}
