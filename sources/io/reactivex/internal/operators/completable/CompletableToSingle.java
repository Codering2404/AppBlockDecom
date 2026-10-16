package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableToSingle<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CompletableSource f135183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable f135184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Object f135185c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class ToSingle implements CompletableObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SingleObserver f135186a;

        ToSingle(SingleObserver singleObserver) {
            this.f135186a = singleObserver;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            this.f135186a.a(disposable);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            Object objCall;
            CompletableToSingle completableToSingle = CompletableToSingle.this;
            Callable callable = completableToSingle.f135184b;
            if (callable != null) {
                try {
                    objCall = callable.call();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f135186a.onError(th);
                    return;
                }
            } else {
                objCall = completableToSingle.f135185c;
            }
            if (objCall == null) {
                this.f135186a.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.f135186a.onSuccess(objCall);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.f135186a.onError(th);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f135183a.b(new ToSingle(singleObserver));
    }
}
