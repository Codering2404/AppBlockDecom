package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeContains<T> extends Single<Boolean> implements HasUpstreamMaybeSource<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final MaybeSource f136771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f136772b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ContainsMaybeObserver implements MaybeObserver<Object>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f136773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f136774b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f136775c;

        ContainsMaybeObserver(SingleObserver singleObserver, Object obj) {
            this.f136773a = singleObserver;
            this.f136774b = obj;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f136775c, disposable)) {
                this.f136775c = disposable;
                this.f136773a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136775c.dispose();
            this.f136775c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136775c.e();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136775c = DisposableHelper.DISPOSED;
            this.f136773a.onSuccess(Boolean.FALSE);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136775c = DisposableHelper.DISPOSED;
            this.f136773a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136775c = DisposableHelper.DISPOSED;
            this.f136773a.onSuccess(Boolean.valueOf(ObjectHelper.c(obj, this.f136774b)));
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f136771a.b(new ContainsMaybeObserver(singleObserver, this.f136772b));
    }
}
