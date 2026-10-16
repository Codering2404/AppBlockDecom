package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ParallelFilter<T> extends ParallelFlowable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ParallelFlowable f138581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Predicate f138582b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class BaseFilterSubscriber<T> implements ConditionalSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Predicate f138583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Subscription f138584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f138585c;

        BaseFilterSubscriber(Predicate predicate) {
            this.f138583a = predicate;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.f138584b.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public final void h(Object obj) {
            if (o(obj) || this.f138585c) {
                return;
            }
            this.f138584b.y(1L);
        }

        @Override // org.reactivestreams.Subscription
        public final void y(long j3) {
            this.f138584b.y(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ParallelFilterConditionalSubscriber<T> extends BaseFilterSubscriber<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final ConditionalSubscriber f138586d;

        ParallelFilterConditionalSubscriber(ConditionalSubscriber conditionalSubscriber, Predicate predicate) {
            super(predicate);
            this.f138586d = conditionalSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f138584b, subscription)) {
                this.f138584b = subscription;
                this.f138586d.g(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean o(Object obj) {
            if (!this.f138585c) {
                try {
                    if (this.f138583a.test(obj)) {
                        return this.f138586d.o(obj);
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    cancel();
                    onError(th);
                }
            }
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f138585c) {
                return;
            }
            this.f138585c = true;
            this.f138586d.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f138585c) {
                RxJavaPlugins.s(th);
            } else {
                this.f138585c = true;
                this.f138586d.onError(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ParallelFilterSubscriber<T> extends BaseFilterSubscriber<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Subscriber f138587d;

        ParallelFilterSubscriber(Subscriber subscriber, Predicate predicate) {
            super(predicate);
            this.f138587d = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f138584b, subscription)) {
                this.f138584b = subscription;
                this.f138587d.g(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean o(Object obj) {
            if (!this.f138585c) {
                try {
                    if (this.f138583a.test(obj)) {
                        this.f138587d.h(obj);
                        return true;
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    cancel();
                    onError(th);
                }
            }
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f138585c) {
                return;
            }
            this.f138585c = true;
            this.f138587d.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f138585c) {
                RxJavaPlugins.s(th);
            } else {
                this.f138585c = true;
                this.f138587d.onError(th);
            }
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int a() {
        return this.f138581a.a();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void b(Subscriber[] subscriberArr) {
        if (c(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i3 = 0; i3 < length; i3++) {
                Subscriber subscriber = subscriberArr[i3];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i3] = new ParallelFilterConditionalSubscriber((ConditionalSubscriber) subscriber, this.f138582b);
                } else {
                    subscriberArr2[i3] = new ParallelFilterSubscriber(subscriber, this.f138582b);
                }
            }
            this.f138581a.b(subscriberArr2);
        }
    }
}
