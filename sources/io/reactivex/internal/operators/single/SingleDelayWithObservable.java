package io.reactivex.internal.operators.single;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleDelayWithObservable<T, U> extends Single<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SingleSource f138765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ObservableSource f138766b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OtherSubscriber<T, U> extends AtomicReference<Disposable> implements Observer<U>, Disposable {
        private static final long serialVersionUID = -8565274649390031272L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final SingleObserver f138767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SingleSource f138768b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f138769c;

        OtherSubscriber(SingleObserver singleObserver, SingleSource singleSource) {
            this.f138767a = singleObserver;
            this.f138768b = singleSource;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            if (DisposableHelper.f(this, disposable)) {
                this.f138767a.a(this);
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

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            get().dispose();
            onComplete();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.f138769c) {
                return;
            }
            this.f138769c = true;
            this.f138768b.b(new ResumeSingleObserver(this, this.f138767a));
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.f138769c) {
                RxJavaPlugins.s(th);
            } else {
                this.f138769c = true;
                this.f138767a.onError(th);
            }
        }
    }

    @Override // io.reactivex.Single
    protected void c(SingleObserver singleObserver) {
        this.f138766b.b(new OtherSubscriber(singleObserver, this.f138765a));
    }
}
