package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeCount<T> extends Single<Long> implements HasUpstreamMaybeSource<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final MaybeSource f136776a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CountMaybeObserver implements MaybeObserver<Object>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f136777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f136778b;

        CountMaybeObserver(SingleObserver singleObserver) {
            this.f136777a = singleObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f136778b, disposable)) {
                this.f136778b = disposable;
                this.f136777a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136778b.dispose();
            this.f136778b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136778b.e();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136778b = DisposableHelper.DISPOSED;
            this.f136777a.onSuccess(0L);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136778b = DisposableHelper.DISPOSED;
            this.f136777a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136778b = DisposableHelper.DISPOSED;
            this.f136777a.onSuccess(1L);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f136776a.b(new CountMaybeObserver(singleObserver));
    }
}
