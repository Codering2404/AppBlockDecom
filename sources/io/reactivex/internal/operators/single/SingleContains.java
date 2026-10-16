package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleContains<T> extends Single<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f138742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiPredicate f138743c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class ContainsSingleObserver implements SingleObserver<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SingleObserver f138744a;

        ContainsSingleObserver(SingleObserver singleObserver) {
            this.f138744a = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            this.f138744a.a(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f138744a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            try {
                SingleContains singleContains = SingleContains.this;
                this.f138744a.onSuccess(Boolean.valueOf(singleContains.f138743c.test(obj, singleContains.f138742b)));
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f138744a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f138741a.b(new ContainsSingleObserver(singleObserver));
    }
}
