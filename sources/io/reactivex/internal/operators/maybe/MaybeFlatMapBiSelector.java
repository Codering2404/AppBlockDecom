package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeFlatMapBiSelector<T, U, R> extends AbstractMaybeWithUpstream<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f136844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiFunction f136845c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapBiMainObserver<T, U, R> implements MaybeObserver<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Function f136846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final InnerObserver f136847b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class InnerObserver<T, U, R> extends AtomicReference<Disposable> implements MaybeObserver<U> {
            private static final long serialVersionUID = -2897979525538174559L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final MaybeObserver f136848a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final BiFunction f136849b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Object f136850c;

            InnerObserver(MaybeObserver maybeObserver, BiFunction biFunction) {
                this.f136848a = maybeObserver;
                this.f136849b = biFunction;
            }

            @Override // io.reactivex.MaybeObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.f136848a.onComplete();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f136848a.onError(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(Object obj) {
                Object obj2 = this.f136850c;
                this.f136850c = null;
                try {
                    this.f136848a.onSuccess(ObjectHelper.d(this.f136849b.apply(obj2, obj), "The resultSelector returned a null value"));
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.f136848a.onError(th);
                }
            }
        }

        FlatMapBiMainObserver(MaybeObserver maybeObserver, Function function, BiFunction biFunction) {
            this.f136847b = new InnerObserver(maybeObserver, biFunction);
            this.f136846a = function;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this.f136847b, disposable)) {
                this.f136847b.f136848a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f136847b);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(this.f136847b.get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136847b.f136848a.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136847b.f136848a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.d(this.f136846a.apply(obj), "The mapper returned a null MaybeSource");
                if (DisposableHelper.c(this.f136847b, null)) {
                    InnerObserver innerObserver = this.f136847b;
                    innerObserver.f136850c = obj;
                    maybeSource.b(innerObserver);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f136847b.f136848a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136730a.b(new FlatMapBiMainObserver(maybeObserver, this.f136844b, this.f136845c));
    }
}
