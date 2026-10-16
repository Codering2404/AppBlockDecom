package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeFlatMapSingle<T, R> extends Single<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final MaybeSource f136881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f136882b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4827726964688405508L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f136883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f136884b;

        FlatMapMaybeObserver(SingleObserver singleObserver, Function function) {
            this.f136883a = singleObserver;
            this.f136884b = function;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this, disposable)) {
                this.f136883a.a(this);
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

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136883a.onError(new NoSuchElementException());
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136883a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.d(this.f136884b.apply(obj), "The mapper returned a null SingleSource");
                if (e()) {
                    return;
                }
                singleSource.b(new FlatMapSingleObserver(this, this.f136883a));
            } catch (Throwable th) {
                Exceptions.b(th);
                onError(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapSingleObserver<R> implements SingleObserver<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReference f136885a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SingleObserver f136886b;

        FlatMapSingleObserver(AtomicReference atomicReference, SingleObserver singleObserver) {
            this.f136885a = atomicReference;
            this.f136886b = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            DisposableHelper.c(this.f136885a, disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f136886b.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            this.f136886b.onSuccess(obj);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f136881a.b(new FlatMapMaybeObserver(singleObserver, this.f136882b));
    }
}
