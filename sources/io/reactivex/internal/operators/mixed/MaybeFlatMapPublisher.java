package io.reactivex.internal.operators.mixed;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class MaybeFlatMapPublisher<T, R> extends Flowable<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final MaybeSource f137169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f137170c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlatMapPublisherSubscriber<T, R> extends AtomicReference<Subscription> implements FlowableSubscriber<R>, MaybeObserver<T>, Subscription {
        private static final long serialVersionUID = -8948264376121066672L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f137171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f137172b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Disposable f137173c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicLong f137174d = new AtomicLong();

        FlatMapPublisherSubscriber(Subscriber subscriber, Function function) {
            this.f137171a = subscriber;
            this.f137172b = function;
        }

        @Override // io.reactivex.MaybeObserver
        public void a(Disposable disposable) {
            if (DisposableHelper.i(this.f137173c, disposable)) {
                this.f137173c = disposable;
                this.f137171a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f137173c.dispose();
            SubscriptionHelper.a(this);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.c(this, this.f137174d, subscription);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f137171a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f137171a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f137171a.onError(th);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            try {
                ((Publisher) ObjectHelper.d(this.f137172b.apply(obj), "The mapper returned a null Publisher")).i(this);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f137171a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            SubscriptionHelper.b(this, this.f137174d, j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f137169b.b(new FlatMapPublisherSubscriber(subscriber, this.f137170c));
    }
}
