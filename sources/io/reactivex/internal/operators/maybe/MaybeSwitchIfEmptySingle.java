package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeSwitchIfEmptySingle<T> extends Single<T> implements HasUpstreamMaybeSource<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final MaybeSource f136983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final SingleSource f136984b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SwitchIfEmptyMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 4603919676453758899L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f136985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SingleSource f136986b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class OtherSingleObserver<T> implements SingleObserver<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final SingleObserver f136987a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final AtomicReference f136988b;

            OtherSingleObserver(SingleObserver singleObserver, AtomicReference atomicReference) {
                this.f136987a = singleObserver;
                this.f136988b = atomicReference;
            }

            @Override // io.reactivex.SingleObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this.f136988b, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                this.f136987a.onError(th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(Object obj) {
                this.f136987a.onSuccess(obj);
            }
        }

        SwitchIfEmptyMaybeObserver(SingleObserver singleObserver, SingleSource singleSource) {
            this.f136985a = singleObserver;
            this.f136986b = singleSource;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this, disposable)) {
                this.f136985a.a(this);
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
            this.f136986b.b(new OtherSingleObserver(this.f136985a, this));
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136985a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136985a.onSuccess(obj);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f136983a.b(new SwitchIfEmptyMaybeObserver(singleObserver, this.f136984b));
    }
}
