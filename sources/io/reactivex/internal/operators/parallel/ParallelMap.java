package io.reactivex.internal.operators.parallel;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ParallelMap<T, R> extends ParallelFlowable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ParallelFlowable f138638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f138639b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ParallelMapConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ConditionalSubscriber f138640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f138641b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f138642c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f138643d;

        ParallelMapConditionalSubscriber(ConditionalSubscriber conditionalSubscriber, Function function) {
            this.f138640a = conditionalSubscriber;
            this.f138641b = function;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f138642c.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f138642c, subscription)) {
                this.f138642c = subscription;
                this.f138640a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f138643d) {
                return;
            }
            try {
                this.f138640a.h(ObjectHelper.d(this.f138641b.apply(obj), "The mapper returned a null value"));
            } catch (Throwable th) {
                Exceptions.b(th);
                cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean o(Object obj) {
            if (this.f138643d) {
                return false;
            }
            try {
                return this.f138640a.o(ObjectHelper.d(this.f138641b.apply(obj), "The mapper returned a null value"));
            } catch (Throwable th) {
                Exceptions.b(th);
                cancel();
                onError(th);
                return false;
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f138643d) {
                return;
            }
            this.f138643d = true;
            this.f138640a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f138643d) {
                RxJavaPlugins.s(th);
            } else {
                this.f138643d = true;
                this.f138640a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f138642c.y(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ParallelMapSubscriber<T, R> implements FlowableSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f138644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f138645b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f138646c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f138647d;

        ParallelMapSubscriber(Subscriber subscriber, Function function) {
            this.f138644a = subscriber;
            this.f138645b = function;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f138646c.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f138646c, subscription)) {
                this.f138646c = subscription;
                this.f138644a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f138647d) {
                return;
            }
            try {
                this.f138644a.h(ObjectHelper.d(this.f138645b.apply(obj), "The mapper returned a null value"));
            } catch (Throwable th) {
                Exceptions.b(th);
                cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f138647d) {
                return;
            }
            this.f138647d = true;
            this.f138644a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f138647d) {
                RxJavaPlugins.s(th);
            } else {
                this.f138647d = true;
                this.f138644a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f138646c.y(j3);
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int a() {
        return this.f138638a.a();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void b(Subscriber[] subscriberArr) {
        if (c(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i3 = 0; i3 < length; i3++) {
                Subscriber subscriber = subscriberArr[i3];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i3] = new ParallelMapConditionalSubscriber((ConditionalSubscriber) subscriber, this.f138639b);
                } else {
                    subscriberArr2[i3] = new ParallelMapSubscriber(subscriber, this.f138639b);
                }
            }
            this.f138638a.b(subscriberArr2);
        }
    }
}
