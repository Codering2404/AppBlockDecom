package io.reactivex.internal.operators.single;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
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
public final class SingleFlatMapMaybe<T, R> extends Maybe<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f138860b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapMaybeObserver<R> implements MaybeObserver<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReference f138861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final MaybeObserver f138862b;

        FlatMapMaybeObserver(AtomicReference atomicReference, MaybeObserver maybeObserver) {
            this.f138861a = atomicReference;
            this.f138862b = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            DisposableHelper.c(this.f138861a, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f138862b.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f138862b.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f138862b.onSuccess(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapSingleObserver<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -5843758257109742742L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f138863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f138864b;

        FlatMapSingleObserver(MaybeObserver maybeObserver, Function function) {
            this.f138863a = maybeObserver;
            this.f138864b = function;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this, disposable)) {
                this.f138863a.a(this);
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
            this.f138863a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.d(this.f138864b.apply(obj), "The mapper returned a null MaybeSource");
                if (e()) {
                    return;
                }
                maybeSource.b(new FlatMapMaybeObserver(this, this.f138863a));
            } catch (Throwable th) {
                Exceptions.b(th);
                onError(th);
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f138859a.b(new FlatMapSingleObserver(maybeObserver, this.f138860b));
    }
}
