package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableAndThenCompletable extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CompletableSource f135013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final CompletableSource f135014b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class NextObserver implements CompletableObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReference f135015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CompletableObserver f135016b;

        public NextObserver(AtomicReference atomicReference, CompletableObserver completableObserver) {
            this.f135015a = atomicReference;
            this.f135016b = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            DisposableHelper.c(this.f135015a, disposable);
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.f135016b.onComplete();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.f135016b.onError(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SourceObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = -4101678820158072998L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CompletableSource f135018b;

        SourceObserver(CompletableObserver completableObserver, CompletableSource completableSource) {
            this.f135017a = completableObserver;
            this.f135018b = completableSource;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this, disposable)) {
                this.f135017a.a(this);
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

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.f135018b.b(new NextObserver(this, this.f135017a));
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.f135017a.onError(th);
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        this.f135013a.b(new SourceObserver(completableObserver, this.f135014b));
    }
}
