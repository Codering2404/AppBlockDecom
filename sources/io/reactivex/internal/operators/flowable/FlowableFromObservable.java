package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableFromObservable<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Observable f135765b;

    public FlowableFromObservable(Observable observable) {
        this.f135765b = observable;
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135765b.b(new SubscriberObserver(subscriber));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SubscriberObserver<T> implements Observer<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Disposable f135767b;

        SubscriberObserver(Subscriber subscriber) {
            this.f135766a = subscriber;
        }

        @Override // io.reactivex.Observer
        public void a(Disposable disposable) {
            this.f135767b = disposable;
            this.f135766a.g(this);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f135767b.dispose();
        }

        @Override // io.reactivex.Observer
        public void h(Object obj) {
            this.f135766a.h(obj);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f135766a.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f135766a.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
        }
    }
}
