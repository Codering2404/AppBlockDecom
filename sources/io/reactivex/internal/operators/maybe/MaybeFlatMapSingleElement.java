package io.reactivex.internal.operators.maybe;

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
public final class MaybeFlatMapSingleElement<T, R> extends Maybe<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final MaybeSource f136887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f136888b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4827726964688405508L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f136890b;

        FlatMapMaybeObserver(MaybeObserver maybeObserver, Function function) {
            this.f136889a = maybeObserver;
            this.f136890b = function;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this, disposable)) {
                this.f136889a.a(this);
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
            this.f136889a.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136889a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            try {
                ((SingleSource) ObjectHelper.d(this.f136890b.apply(obj), "The mapper returned a null SingleSource")).b(new FlatMapSingleObserver(this, this.f136889a));
            } catch (Throwable th) {
                Exceptions.b(th);
                onError(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapSingleObserver<R> implements SingleObserver<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReference f136891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final MaybeObserver f136892b;

        FlatMapSingleObserver(AtomicReference atomicReference, MaybeObserver maybeObserver) {
            this.f136891a = atomicReference;
            this.f136892b = maybeObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            DisposableHelper.c(this.f136891a, disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f136892b.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            this.f136892b.onSuccess(obj);
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136887a.b(new FlatMapMaybeObserver(maybeObserver, this.f136888b));
    }
}
