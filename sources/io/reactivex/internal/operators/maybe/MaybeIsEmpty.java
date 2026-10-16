package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeIsEmpty<T> extends AbstractMaybeWithUpstream<T, Boolean> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class IsEmptyMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f136918b;

        IsEmptyMaybeObserver(MaybeObserver maybeObserver) {
            this.f136917a = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f136918b, disposable)) {
                this.f136918b = disposable;
                this.f136917a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136918b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136918b.e();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136917a.onSuccess(Boolean.TRUE);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136917a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136917a.onSuccess(Boolean.FALSE);
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136730a.b(new IsEmptyMaybeObserver(maybeObserver));
    }
}
