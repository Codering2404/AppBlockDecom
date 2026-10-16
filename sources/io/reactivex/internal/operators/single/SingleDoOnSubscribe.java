package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleDoOnSubscribe<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Consumer f138816b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DoOnSubscribeSingleObserver<T> implements SingleObserver<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Consumer f138818b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f138819c;

        DoOnSubscribeSingleObserver(SingleObserver singleObserver, Consumer consumer) {
            this.f138817a = singleObserver;
            this.f138818b = consumer;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            try {
                this.f138818b.accept(disposable);
                this.f138817a.a(disposable);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f138819c = true;
                disposable.dispose();
                EmptyDisposable.j(th, this.f138817a);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            if (this.f138819c) {
                RxJavaPlugins.s(th);
            } else {
                this.f138817a.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            if (this.f138819c) {
                return;
            }
            this.f138817a.onSuccess(obj);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f138815a.b(new DoOnSubscribeSingleObserver(singleObserver, this.f138816b));
    }
}
