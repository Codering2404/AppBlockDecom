package io.reactivex.internal.operators.maybe;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.FuseToMaybe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeIgnoreElementCompletable<T> extends Completable implements FuseToMaybe<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final MaybeSource f136914a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class IgnoreMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f136915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f136916b;

        IgnoreMaybeObserver(CompletableObserver completableObserver) {
            this.f136915a = completableObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f136916b, disposable)) {
                this.f136916b = disposable;
                this.f136915a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136916b.dispose();
            this.f136916b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136916b.e();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136916b = DisposableHelper.DISPOSED;
            this.f136915a.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136916b = DisposableHelper.DISPOSED;
            this.f136915a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136916b = DisposableHelper.DISPOSED;
            this.f136915a.onComplete();
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        this.f136914a.b(new IgnoreMaybeObserver(completableObserver));
    }
}
