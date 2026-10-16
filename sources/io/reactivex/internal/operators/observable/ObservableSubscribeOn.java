package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ObservableSubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Scheduler f138226b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        private static final long serialVersionUID = 8094547886072529208L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Observer f138227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReference f138228b = new AtomicReference();

        SubscribeOnObserver(Observer observer) {
            this.f138227a = observer;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            DisposableHelper.g(this.f138228b, disposable);
        }

        void b(Disposable disposable) {
            DisposableHelper.g(this, disposable);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.a(this.f138228b);
            DisposableHelper.a(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return DisposableHelper.b(get());
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f138227a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f138227a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f138227a.onError(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class SubscribeTask implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SubscribeOnObserver f138229a;

        SubscribeTask(SubscribeOnObserver subscribeOnObserver) {
            this.f138229a = subscribeOnObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableSubscribeOn.this.f137267a.b(this.f138229a);
        }
    }

    public ObservableSubscribeOn(ObservableSource observableSource, Scheduler scheduler) {
        super(observableSource);
        this.f138226b = scheduler;
    }

    @Override // io.reactivex.Observable
    public void u(Observer observer) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(observer);
        observer.a(subscribeOnObserver);
        subscribeOnObserver.b(this.f138226b.d(new SubscribeTask(subscribeOnObserver)));
    }
}
