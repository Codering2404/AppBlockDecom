package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleDoFinally<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Action f138799b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DoFinallyObserver<T> extends AtomicInteger implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = 4109457741734051389L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Action f138801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f138802c;

        DoFinallyObserver(SingleObserver singleObserver, Action action) {
            this.f138800a = singleObserver;
            this.f138801b = action;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138802c, disposable)) {
                this.f138802c = disposable;
                this.f138800a.a(this);
            }
        }

        void b() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f138801b.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138802c.dispose();
            b();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138802c.e();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f138800a.onError(th);
            b();
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            this.f138800a.onSuccess(obj);
            b();
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f138798a.b(new DoFinallyObserver(singleObserver, this.f138799b));
    }
}
