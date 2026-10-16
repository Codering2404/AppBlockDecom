package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeSubscribeOn<T> extends AbstractMaybeWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Scheduler f136973b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SubscribeOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long serialVersionUID = 8571289934935992137L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SequentialDisposable f136974a = new SequentialDisposable();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final MaybeObserver f136975b;

        SubscribeOnMaybeObserver(MaybeObserver maybeObserver) {
            this.f136975b = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this);
            this.f136974a.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.f136975b.onComplete();
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.f136975b.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            this.f136975b.onSuccess(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SubscribeTask<T> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MaybeObserver f136976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final MaybeSource f136977b;

        SubscribeTask(MaybeObserver maybeObserver, MaybeSource maybeSource) {
            this.f136976a = maybeObserver;
            this.f136977b = maybeSource;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f136977b.b(this.f136976a);
        }
    }

    @Override // io.reactivex.Maybe
    protected void c(MaybeObserver maybeObserver) {
        SubscribeOnMaybeObserver subscribeOnMaybeObserver = new SubscribeOnMaybeObserver(maybeObserver);
        maybeObserver.a(subscribeOnMaybeObserver);
        subscribeOnMaybeObserver.f136974a.a(this.f136973b.d(new SubscribeTask(subscribeOnMaybeObserver, this.f136730a)));
    }
}
