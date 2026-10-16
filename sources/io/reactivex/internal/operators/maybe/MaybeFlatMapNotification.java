package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeFlatMapNotification<T, R> extends AbstractMaybeWithUpstream<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f136872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f136873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Callable f136874d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4375739915521278546L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f136876b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Function f136877c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Callable f136878d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Disposable f136879f;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class InnerObserver implements MaybeObserver<R> {
            InnerObserver() {
            }

            @Override // io.reactivex.MaybeObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(FlatMapMaybeObserver.this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                FlatMapMaybeObserver.this.f136875a.onComplete();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                FlatMapMaybeObserver.this.f136875a.onError(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(Object obj) {
                FlatMapMaybeObserver.this.f136875a.onSuccess(obj);
            }
        }

        FlatMapMaybeObserver(MaybeObserver maybeObserver, Function function, Function function2, Callable callable) {
            this.f136875a = maybeObserver;
            this.f136876b = function;
            this.f136877c = function2;
            this.f136878d = callable;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f136879f, disposable)) {
                this.f136879f = disposable;
                this.f136875a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
            this.f136879f.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            try {
                ((MaybeSource) ObjectHelper.d(this.f136878d.call(), "The onCompleteSupplier returned a null MaybeSource")).b(new InnerObserver());
            } catch (Exception e3) {
                Exceptions.b(e3);
                this.f136875a.onError(e3);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            try {
                ((MaybeSource) ObjectHelper.d(this.f136877c.apply(th), "The onErrorMapper returned a null MaybeSource")).b(new InnerObserver());
            } catch (Exception e3) {
                Exceptions.b(e3);
                this.f136875a.onError(new CompositeException(th, e3));
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            try {
                ((MaybeSource) ObjectHelper.d(this.f136876b.apply(obj), "The onSuccessMapper returned a null MaybeSource")).b(new InnerObserver());
            } catch (Exception e3) {
                Exceptions.b(e3);
                this.f136875a.onError(e3);
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136730a.b(new FlatMapMaybeObserver(maybeObserver, this.f136872b, this.f136873c, this.f136874d));
    }
}
