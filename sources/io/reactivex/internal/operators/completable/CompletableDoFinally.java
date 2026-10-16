package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class CompletableDoFinally extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final CompletableSource f135073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Action f135074b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DoFinallyObserver extends AtomicInteger implements CompletableObserver, Disposable {
        private static final long serialVersionUID = 4109457741734051389L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CompletableObserver f135075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Action f135076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f135077c;

        DoFinallyObserver(CompletableObserver completableObserver, Action action) {
            this.f135075a = completableObserver;
            this.f135076b = action;
        }

        @Override // io.reactivex.CompletableObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f135077c, disposable)) {
                this.f135077c = disposable;
                this.f135075a.a(this);
            }
        }

        void b() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f135076b.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f135077c.dispose();
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f135077c.e();
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            this.f135075a.onComplete();
            b();
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            this.f135075a.onError(th);
            b();
        }
    }

    @Override // io.reactivex.Completable
    protected void c(CompletableObserver completableObserver) {
        this.f135073a.b(new DoFinallyObserver(completableObserver, this.f135074b));
    }
}
