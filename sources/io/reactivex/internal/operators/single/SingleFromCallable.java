package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleFromCallable<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable f138871a;

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        Disposable disposableB = Disposables.b();
        singleObserver.a(disposableB);
        if (disposableB.e()) {
            return;
        }
        try {
            Object objD = ObjectHelper.d(this.f138871a.call(), "The callable returned a null value");
            if (disposableB.e()) {
                return;
            }
            singleObserver.onSuccess(objD);
        } catch (Throwable th) {
            Exceptions.b(th);
            if (disposableB.e()) {
                RxJavaPlugins.s(th);
            } else {
                singleObserver.onError(th);
            }
        }
    }
}
