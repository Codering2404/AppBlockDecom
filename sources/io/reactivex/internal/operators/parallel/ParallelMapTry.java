package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
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
public final class ParallelMapTry<T, R> extends ParallelFlowable<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ParallelFlowable f138648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Function f138649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiFunction f138650c;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.parallel.ParallelMapTry$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f138651a;

        static {
            int[] iArr = new int[ParallelFailureHandling.values().length];
            f138651a = iArr;
            try {
                iArr[ParallelFailureHandling.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f138651a[ParallelFailureHandling.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f138651a[ParallelFailureHandling.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ParallelMapTryConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ConditionalSubscriber f138652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f138653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final BiFunction f138654c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Subscription f138655d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f138656f;

        ParallelMapTryConditionalSubscriber(ConditionalSubscriber conditionalSubscriber, Function function, BiFunction biFunction) {
            this.f138652a = conditionalSubscriber;
            this.f138653b = function;
            this.f138654c = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f138655d.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f138655d, subscription)) {
                this.f138655d = subscription;
                this.f138652a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (o(obj) || this.f138656f) {
                return;
            }
            this.f138655d.y(1L);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean o(Object obj) {
            int i3;
            if (this.f138656f) {
                return false;
            }
            long j3 = 0;
            do {
                try {
                    return this.f138652a.o(ObjectHelper.d(this.f138653b.apply(obj), "The mapper returned a null value"));
                } catch (Throwable th) {
                    Exceptions.b(th);
                    try {
                        j3++;
                        i3 = AnonymousClass1.f138651a[((ParallelFailureHandling) ObjectHelper.d(this.f138654c.apply(Long.valueOf(j3), th), "The errorHandler returned a null item")).ordinal()];
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
            if (this.f138656f) {
                return;
            }
            this.f138656f = true;
            this.f138652a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f138656f) {
                RxJavaPlugins.s(th);
            } else {
                this.f138656f = true;
                this.f138652a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f138655d.y(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ParallelMapTrySubscriber<T, R> implements ConditionalSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f138657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f138658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final BiFunction f138659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Subscription f138660d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f138661f;

        ParallelMapTrySubscriber(Subscriber subscriber, Function function, BiFunction biFunction) {
            this.f138657a = subscriber;
            this.f138658b = function;
            this.f138659c = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f138660d.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f138660d, subscription)) {
                this.f138660d = subscription;
                this.f138657a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (o(obj) || this.f138661f) {
                return;
            }
            this.f138660d.y(1L);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean o(Object obj) {
            int i3;
            if (this.f138661f) {
                return false;
            }
            long j3 = 0;
            do {
                try {
                    this.f138657a.h(ObjectHelper.d(this.f138658b.apply(obj), "The mapper returned a null value"));
                    return true;
                } catch (Throwable th) {
                    Exceptions.b(th);
                    try {
                        j3++;
                        i3 = AnonymousClass1.f138651a[((ParallelFailureHandling) ObjectHelper.d(this.f138659c.apply(Long.valueOf(j3), th), "The errorHandler returned a null item")).ordinal()];
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
            if (this.f138661f) {
                return;
            }
            this.f138661f = true;
            this.f138657a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f138661f) {
                RxJavaPlugins.s(th);
            } else {
                this.f138661f = true;
                this.f138657a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f138660d.y(j3);
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int a() {
        return this.f138648a.a();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void b(Subscriber[] subscriberArr) {
        if (c(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i3 = 0; i3 < length; i3++) {
                Subscriber subscriber = subscriberArr[i3];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i3] = new ParallelMapTryConditionalSubscriber((ConditionalSubscriber) subscriber, this.f138649b, this.f138650c);
                } else {
                    subscriberArr2[i3] = new ParallelMapTrySubscriber(subscriber, this.f138649b, this.f138650c);
                }
            }
            this.f138648a.b(subscriberArr2);
        }
    }
}
