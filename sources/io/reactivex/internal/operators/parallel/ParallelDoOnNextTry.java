package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ParallelDoOnNextTry<T> extends ParallelFlowable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ParallelFlowable f138567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Consumer f138568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiFunction f138569c;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.parallel.ParallelDoOnNextTry$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f138570a;

        static {
            int[] iArr = new int[ParallelFailureHandling.values().length];
            f138570a = iArr;
            try {
                iArr[ParallelFailureHandling.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f138570a[ParallelFailureHandling.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f138570a[ParallelFailureHandling.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ParallelDoOnNextConditionalSubscriber<T> implements ConditionalSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ConditionalSubscriber f138571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Consumer f138572b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final BiFunction f138573c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Subscription f138574d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f138575f;

        ParallelDoOnNextConditionalSubscriber(ConditionalSubscriber conditionalSubscriber, Consumer consumer, BiFunction biFunction) {
            this.f138571a = conditionalSubscriber;
            this.f138572b = consumer;
            this.f138573c = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f138574d.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f138574d, subscription)) {
                this.f138574d = subscription;
                this.f138571a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (o(obj) || this.f138575f) {
                return;
            }
            this.f138574d.y(1L);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean o(Object obj) {
            int i3;
            if (this.f138575f) {
                return false;
            }
            long j3 = 0;
            do {
                try {
                    this.f138572b.accept(obj);
                    return this.f138571a.o(obj);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    try {
                        j3++;
                        i3 = AnonymousClass1.f138570a[((ParallelFailureHandling) ObjectHelper.d(this.f138573c.apply(Long.valueOf(j3), th), "The errorHandler returned a null item")).ordinal()];
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        cancel();
                        onError(new CompositeException(th, th2));
                        return false;
                    }
                }
            } while (i3 == 1);
            if (i3 != 2) {
                if (i3 != 3) {
                    cancel();
                    onError(th);
                    return false;
                }
                cancel();
                onComplete();
            }
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f138575f) {
                return;
            }
            this.f138575f = true;
            this.f138571a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f138575f) {
                RxJavaPlugins.s(th);
            } else {
                this.f138575f = true;
                this.f138571a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f138574d.y(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ParallelDoOnNextSubscriber<T> implements ConditionalSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f138576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Consumer f138577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final BiFunction f138578c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Subscription f138579d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f138580f;

        ParallelDoOnNextSubscriber(Subscriber subscriber, Consumer consumer, BiFunction biFunction) {
            this.f138576a = subscriber;
            this.f138577b = consumer;
            this.f138578c = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f138579d.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f138579d, subscription)) {
                this.f138579d = subscription;
                this.f138576a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (o(obj)) {
                return;
            }
            this.f138579d.y(1L);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean o(Object obj) {
            int i3;
            if (this.f138580f) {
                return false;
            }
            long j3 = 0;
            do {
                try {
                    this.f138577b.accept(obj);
                    this.f138576a.h(obj);
                    return true;
                } catch (Throwable th) {
                    Exceptions.b(th);
                    try {
                        j3++;
                        i3 = AnonymousClass1.f138570a[((ParallelFailureHandling) ObjectHelper.d(this.f138578c.apply(Long.valueOf(j3), th), "The errorHandler returned a null item")).ordinal()];
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        cancel();
                        onError(new CompositeException(th, th2));
                        return false;
                    }
                }
            } while (i3 == 1);
            if (i3 != 2) {
                if (i3 != 3) {
                    cancel();
                    onError(th);
                    return false;
                }
                cancel();
                onComplete();
            }
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f138580f) {
                return;
            }
            this.f138580f = true;
            this.f138576a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f138580f) {
                RxJavaPlugins.s(th);
            } else {
                this.f138580f = true;
                this.f138576a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f138579d.y(j3);
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int a() {
        return this.f138567a.a();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void b(Subscriber[] subscriberArr) {
        if (c(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i3 = 0; i3 < length; i3++) {
                Subscriber subscriber = subscriberArr[i3];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i3] = new ParallelDoOnNextConditionalSubscriber((ConditionalSubscriber) subscriber, this.f138568b, this.f138569c);
                } else {
                    subscriberArr2[i3] = new ParallelDoOnNextSubscriber(subscriber, this.f138568b, this.f138569c);
                }
            }
            this.f138567a.b(subscriberArr2);
        }
    }
}
