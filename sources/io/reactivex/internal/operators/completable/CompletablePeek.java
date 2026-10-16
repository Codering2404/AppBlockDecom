package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletablePeek extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CompletableSource f135136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Consumer f135137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Consumer f135138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Action f135139d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Action f135140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Action f135141g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Action f135142h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class CompletableObserverImplementation implements CompletableObserver, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f135144b;

        CompletableObserverImplementation(CompletableObserver completableObserver) {
            this.f135143a = completableObserver;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            try {
                CompletablePeek.this.f135137b.accept(disposable);
                if (DisposableHelper.i(this.f135144b, disposable)) {
                    this.f135144b = disposable;
                    this.f135143a.a(this);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                disposable.dispose();
                this.f135144b = DisposableHelper.DISPOSED;
                EmptyDisposable.g(th, this.f135143a);
            }
        }

        void b() {
            try {
                CompletablePeek.this.f135141g.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            try {
                CompletablePeek.this.f135142h.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
            this.f135144b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135144b.e();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            if (this.f135144b == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                CompletablePeek.this.f135139d.run();
                CompletablePeek.this.f135140f.run();
                this.f135143a.onComplete();
                b();
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f135143a.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            if (this.f135144b == DisposableHelper.DISPOSED) {
                RxJavaPlugins.s(th);
                return;
            }
            try {
                CompletablePeek.this.f135138c.accept(th);
                CompletablePeek.this.f135140f.run();
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f135143a.onError(th);
            b();
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        this.f135136a.b(new CompletableObserverImplementation(completableObserver));
    }
}
