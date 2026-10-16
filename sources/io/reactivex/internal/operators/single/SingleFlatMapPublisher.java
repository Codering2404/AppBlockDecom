package io.reactivex.internal.operators.single;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SingleFlatMapPublisher<T, R> extends Flowable<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final SingleSource f138865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f138866c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SingleFlatMapPublisherObserver<S, T> extends AtomicLong implements SingleObserver<S>, FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 7759721921468635667L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f138867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f138868b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference f138869c = new AtomicReference();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Disposable f138870d;

        SingleFlatMapPublisherObserver(Subscriber subscriber, Function function) {
            this.f138867a = subscriber;
            this.f138868b = function;
        }

        @Override // io.reactivex.SingleObserver
        public void a(Disposable disposable) {
            this.f138870d = disposable;
            this.f138867a.g(this);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f138870d.dispose();
            SubscriptionHelper.a(this.f138869c);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.c(this.f138869c, this, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f138867a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f138867a.onComplete();
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.f138867a.onError(th);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            try {
                ((Publisher) ObjectHelper.d(this.f138868b.apply(obj), "the mapper returned a null Publisher")).i(this);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f138867a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            SubscriptionHelper.b(this.f138869c, this, j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f138865b.b(new SingleFlatMapPublisherObserver(subscriber, this.f138866c));
    }
}
