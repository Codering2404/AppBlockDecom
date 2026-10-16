package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleDoOnDispose<T> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Action f138804b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DoOnDisposeObserver<T> extends AtomicReference<Action> implements SingleObserver<T>, Disposable {
        private static final long serialVersionUID = -8583764624474935784L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f138806b;

        DoOnDisposeObserver(SingleObserver singleObserver, Action action) {
            this.f138805a = singleObserver;
            lazySet(action);
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f138806b, disposable)) {
                this.f138806b = disposable;
                this.f138805a.a(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Action andSet = getAndSet(null);
            if (andSet != null) {
                try {
                    andSet.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
                this.f138806b.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f138806b.e();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f138805a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            this.f138805a.onSuccess(obj);
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f138803a.b(new DoOnDisposeObserver(singleObserver, this.f138804b));
    }
}
