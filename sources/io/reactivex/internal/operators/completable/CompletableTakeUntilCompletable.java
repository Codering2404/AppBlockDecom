package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableTakeUntilCompletable extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Completable f135156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final CompletableSource f135157b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class TakeUntilMainObserver extends AtomicReference<Disposable> implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 3533011714830024923L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final OtherObserver f135159b = new OtherObserver(this);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicBoolean f135160c = new AtomicBoolean();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long serialVersionUID = 5176264485428790318L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final TakeUntilMainObserver f135161a;

            OtherObserver(TakeUntilMainObserver takeUntilMainObserver) {
                this.f135161a = takeUntilMainObserver;
            }

            @Override // io.reactivex.CompletableObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
            public void onComplete() {
                this.f135161a.b();
            }

            @Override // io.reactivex.CompletableObserver
            public void onError(Throwable th) {
                this.f135161a.c(th);
            }
        }

        TakeUntilMainObserver(CompletableObserver completableObserver) {
            this.f135158a = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        void b() {
            if (this.f135160c.compareAndSet(false, true)) {
                DisposableHelper.a(this);
                this.f135158a.onComplete();
            }
        }

        void c(Throwable th) {
            if (!this.f135160c.compareAndSet(false, true)) {
                RxJavaPlugins.s(th);
            } else {
                DisposableHelper.a(this);
                this.f135158a.onError(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.f135160c.compareAndSet(false, true)) {
                DisposableHelper.a(this);
                DisposableHelper.a(this.f135159b);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135160c.get();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.f135160c.compareAndSet(false, true)) {
                DisposableHelper.a(this.f135159b);
                this.f135158a.onComplete();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            if (!this.f135160c.compareAndSet(false, true)) {
                RxJavaPlugins.s(th);
            } else {
                DisposableHelper.a(this.f135159b);
                this.f135158a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(completableObserver);
        completableObserver.a(takeUntilMainObserver);
        this.f135157b.b(takeUntilMainObserver.f135159b);
        this.f135156a.b(takeUntilMainObserver);
    }
}
