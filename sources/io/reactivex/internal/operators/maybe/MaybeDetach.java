package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeDetach<T> extends AbstractMaybeWithUpstream<T, T> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DetachMaybeObserver<T> implements MaybeObserver<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        MaybeObserver f136809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f136810b;

        DetachMaybeObserver(MaybeObserver maybeObserver) {
            this.f136809a = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f136810b, disposable)) {
                this.f136810b = disposable;
                this.f136809a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f136809a = null;
            this.f136810b.dispose();
            this.f136810b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136810b.e();
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136810b = DisposableHelper.DISPOSED;
            MaybeObserver maybeObserver = this.f136809a;
            if (maybeObserver != null) {
                this.f136809a = null;
                maybeObserver.onComplete();
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136810b = DisposableHelper.DISPOSED;
            MaybeObserver maybeObserver = this.f136809a;
            if (maybeObserver != null) {
                this.f136809a = null;
                maybeObserver.onError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136810b = DisposableHelper.DISPOSED;
            MaybeObserver maybeObserver = this.f136809a;
            if (maybeObserver != null) {
                this.f136809a = null;
                maybeObserver.onSuccess(obj);
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136730a.b(new DetachMaybeObserver(maybeObserver));
    }
}
