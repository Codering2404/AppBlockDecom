package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.LongConsumer;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ParallelPeek<T> extends ParallelFlowable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ParallelFlowable f138662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Consumer f138663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Consumer f138664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Consumer f138665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Action f138666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Action f138667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Consumer f138668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final LongConsumer f138669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Action f138670i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ParallelPeekSubscriber<T> implements FlowableSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f138671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ParallelPeek f138672b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f138673c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f138674d;

        ParallelPeekSubscriber(Subscriber subscriber, ParallelPeek parallelPeek) {
            this.f138671a = subscriber;
            this.f138672b = parallelPeek;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            try {
                this.f138672b.f138670i.run();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
            this.f138673c.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f138673c, subscription)) {
                this.f138673c = subscription;
                try {
                    this.f138672b.f138668g.accept(subscription);
                    this.f138671a.g(this);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    subscription.cancel();
                    this.f138671a.g(EmptySubscription.INSTANCE);
                    onError(th);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f138674d) {
                return;
            }
            try {
                this.f138672b.f138663b.accept(obj);
                this.f138671a.h(obj);
                try {
                    this.f138672b.f138664c.accept(obj);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                onError(th2);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f138674d) {
                return;
            }
            this.f138674d = true;
            try {
                this.f138672b.f138666e.run();
                this.f138671a.onComplete();
                try {
                    this.f138672b.f138667f.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f138671a.onError(th2);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f138674d) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f138674d = true;
            try {
                this.f138672b.f138665d.accept(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f138671a.onError(th);
            try {
                this.f138672b.f138667f.run();
            } catch (Throwable th3) {
                Exceptions.b(th3);
                RxJavaPlugins.s(th3);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            try {
                this.f138672b.f138669h.accept(j3);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(th);
            }
            this.f138673c.y(j3);
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int a() {
        return this.f138662a.a();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void b(Subscriber[] subscriberArr) {
        if (c(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i3 = 0; i3 < length; i3++) {
                subscriberArr2[i3] = new ParallelPeekSubscriber(subscriberArr[i3], this);
            }
            this.f138662a.b(subscriberArr2);
        }
    }
}
