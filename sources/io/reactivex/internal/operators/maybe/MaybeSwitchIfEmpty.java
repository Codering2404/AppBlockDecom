package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeSwitchIfEmpty<T> extends AbstractMaybeWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final MaybeSource f136978b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = -2223459372976438024L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final MaybeSource f136980b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class OtherMaybeObserver<T> implements MaybeObserver<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final MaybeObserver f136981a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final AtomicReference f136982b;

            OtherMaybeObserver(MaybeObserver maybeObserver, AtomicReference atomicReference) {
                this.f136981a = maybeObserver;
                this.f136982b = atomicReference;
            }

            @Override // io.reactivex.MaybeObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this.f136982b, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.f136981a.onComplete();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f136981a.onError(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(Object obj) {
                this.f136981a.onSuccess(obj);
            }
        }

        SwitchIfEmptyMaybeObserver(MaybeObserver maybeObserver, MaybeSource maybeSource) {
            this.f136979a = maybeObserver;
            this.f136980b = maybeSource;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this, disposable)) {
                this.f136979a.a(this);
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
            Disposable disposable = get();
            if (disposable == DisposableHelper.DISPOSED || !compareAndSet(disposable, null)) {
                return;
            }
            this.f136980b.b(new OtherMaybeObserver(this.f136979a, this));
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136979a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136979a.onSuccess(obj);
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136730a.b(new SwitchIfEmptyMaybeObserver(maybeObserver, this.f136978b));
    }
}
