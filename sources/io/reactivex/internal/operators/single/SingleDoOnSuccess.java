package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleDoOnSuccess<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Consumer f138821b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class DoOnSuccess implements SingleObserver<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138822a;

        DoOnSuccess(SingleObserver singleObserver) {
            this.f138822a = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            this.f138822a.a(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f138822a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            try {
                SingleDoOnSuccess.this.f138821b.accept(obj);
                this.f138822a.onSuccess(obj);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f138822a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f138820a.b(new DoOnSuccess(singleObserver));
    }
}
