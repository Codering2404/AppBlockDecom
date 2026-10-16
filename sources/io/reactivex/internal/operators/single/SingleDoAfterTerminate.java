package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleDoAfterTerminate<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Action f138794b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DoAfterTerminateObserver<T> implements SingleObserver<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Action f138796b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f138797c;

        DoAfterTerminateObserver(SingleObserver singleObserver, Action action) {
            this.f138795a = singleObserver;
            this.f138796b = action;
        }

        private void b() {
            try {
                this.f138796b.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138797c, disposable)) {
                this.f138797c = disposable;
                this.f138795a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f138797c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138797c.e();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f138795a.onError(th);
            b();
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            this.f138795a.onSuccess(obj);
            b();
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f138793a.b(new DoAfterTerminateObserver(singleObserver, this.f138794b));
    }
}
