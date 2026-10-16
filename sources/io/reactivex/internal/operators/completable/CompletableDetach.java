package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableDetach extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CompletableSource f135064a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DetachCompletableObserver implements CompletableObserver, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        CompletableObserver f135065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f135066b;

        DetachCompletableObserver(CompletableObserver completableObserver) {
            this.f135065a = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f135066b, disposable)) {
                this.f135066b = disposable;
                this.f135065a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f135065a = null;
            this.f135066b.dispose();
            this.f135066b = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135066b.e();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.f135066b = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.f135065a;
            if (completableObserver != null) {
                this.f135065a = null;
                completableObserver.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.f135066b = DisposableHelper.DISPOSED;
            CompletableObserver completableObserver = this.f135065a;
            if (completableObserver != null) {
                this.f135065a = null;
                completableObserver.onError(th);
            }
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        this.f135064a.b(new DetachCompletableObserver(completableObserver));
    }
}
