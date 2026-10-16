package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeObserveOn<T> extends AbstractMaybeWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Scheduler f136944b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ObserveOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Scheduler f136946b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f136947c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Throwable f136948d;

        ObserveOnMaybeObserver(MaybeObserver maybeObserver, Scheduler scheduler) {
            this.f136945a = maybeObserver;
            this.f136946b = scheduler;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.g(this, disposable)) {
                this.f136945a.a(this);
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

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            DisposableHelper.c(this, this.f136946b.d(this));
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136948d = th;
            DisposableHelper.c(this, this.f136946b.d(this));
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136947c = obj;
            DisposableHelper.c(this, this.f136946b.d(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f136948d;
            if (th != null) {
                this.f136948d = null;
                this.f136945a.onError(th);
                return;
            }
            Object obj = this.f136947c;
            if (obj == null) {
                this.f136945a.onComplete();
            } else {
                this.f136947c = null;
                this.f136945a.onSuccess(obj);
            }
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        this.f136730a.b(new ObserveOnMaybeObserver(maybeObserver, this.f136944b));
    }
}
