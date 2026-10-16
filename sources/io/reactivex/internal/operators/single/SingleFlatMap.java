package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleFlatMap<T, R> extends Single<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f138833b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SingleFlatMapCallback<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = 3258103020495908596L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f138835b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class FlatMapSingleObserver<R> implements SingleObserver<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final AtomicReference f138836a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final SingleObserver f138837b;

            FlatMapSingleObserver(AtomicReference atomicReference, SingleObserver singleObserver) {
                this.f138836a = atomicReference;
                this.f138837b = singleObserver;
            }

            @Override // io.reactivex.SingleObserver
            public void a(Disposable disposable) {
                DisposableHelper.c(this.f138836a, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                this.f138837b.onError(th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(Object obj) {
                this.f138837b.onSuccess(obj);
            }
        }

        SingleFlatMapCallback(SingleObserver singleObserver, Function function) {
            this.f138834a = singleObserver;
            this.f138835b = function;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this, disposable)) {
                this.f138834a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f138834a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.d(this.f138835b.apply(obj), "The single returned by the mapper is null");
                if (e()) {
                    return;
                }
                singleSource.b(new FlatMapSingleObserver(this, this.f138834a));
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f138834a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f138832a.b(new SingleFlatMapCallback(singleObserver, this.f138833b));
    }
}
