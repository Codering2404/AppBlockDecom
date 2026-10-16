package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Predicate;
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
public final class ParallelFilterTry<T> extends ParallelFlowable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ParallelFlowable f138588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Predicate f138589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiFunction f138590c;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.parallel.ParallelFilterTry$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f138591a;

        static {
            int[] iArr = new int[ParallelFailureHandling.values().length];
            f138591a = iArr;
            try {
                iArr[ParallelFailureHandling.RETRY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f138591a[ParallelFailureHandling.SKIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f138591a[ParallelFailureHandling.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class BaseFilterSubscriber<T> implements ConditionalSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Predicate f138592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiFunction f138593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f138594c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f138595d;

        BaseFilterSubscriber(Predicate predicate, BiFunction biFunction) {
            this.f138592a = predicate;
            this.f138593b = biFunction;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.f138594c.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public final void h(Object obj) {
            if (o(obj) || this.f138595d) {
                return;
            }
            this.f138594c.y(1L);
        }

        @Override // org.reactivestreams.Subscription
        public final void y(long j3) {
            this.f138594c.y(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ParallelFilterConditionalSubscriber<T> extends BaseFilterSubscriber<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final ConditionalSubscriber f138596f;

        ParallelFilterConditionalSubscriber(ConditionalSubscriber conditionalSubscriber, Predicate predicate, BiFunction biFunction) {
            super(predicate, biFunction);
            this.f138596f = conditionalSubscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f138594c, subscription)) {
                this.f138594c = subscription;
                this.f138596f.g(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean o(Object obj) {
            int i3;
            if (!this.f138595d) {
                long j3 = 0;
                do {
                    try {
                        return this.f138592a.test(obj) && this.f138596f.o(obj);
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        try {
                            j3++;
                            i3 = AnonymousClass1.f138591a[((ParallelFailureHandling) ObjectHelper.d(this.f138593b.apply(Long.valueOf(j3), th), "The errorHandler returned a null item")).ordinal()];
                        } catch (Throwable th2) {
                            Exceptions.b(th2);
                            cancel();
                            onError(new CompositeException(th, th2));
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
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f138595d) {
                return;
            }
            this.f138595d = true;
            this.f138596f.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f138595d) {
                RxJavaPlugins.s(th);
            } else {
                this.f138595d = true;
                this.f138596f.onError(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ParallelFilterSubscriber<T> extends BaseFilterSubscriber<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Subscriber f138597f;

        ParallelFilterSubscriber(Subscriber subscriber, Predicate predicate, BiFunction biFunction) {
            super(predicate, biFunction);
            this.f138597f = subscriber;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f138594c, subscription)) {
                this.f138594c = subscription;
                this.f138597f.g(this);
            }
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean o(Object obj) {
            int i3;
            if (!this.f138595d) {
                long j3 = 0;
                do {
                    try {
                        if (!this.f138592a.test(obj)) {
                            return false;
                        }
                        this.f138597f.h(obj);
                        return true;
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        try {
                            j3++;
                            i3 = AnonymousClass1.f138591a[((ParallelFailureHandling) ObjectHelper.d(this.f138593b.apply(Long.valueOf(j3), th), "The errorHandler returned a null item")).ordinal()];
                        } catch (Throwable th2) {
                            Exceptions.b(th2);
                            cancel();
                            onError(new CompositeException(th, th2));
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
            return false;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f138595d) {
                return;
            }
            this.f138595d = true;
            this.f138597f.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f138595d) {
                RxJavaPlugins.s(th);
            } else {
                this.f138595d = true;
                this.f138597f.onError(th);
            }
        }
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public int a() {
        return this.f138588a.a();
    }

    @Override // io.reactivex.parallel.ParallelFlowable
    public void b(Subscriber[] subscriberArr) {
        if (c(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i3 = 0; i3 < length; i3++) {
                Subscriber subscriber = subscriberArr[i3];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i3] = new ParallelFilterConditionalSubscriber((ConditionalSubscriber) subscriber, this.f138589b, this.f138590c);
                } else {
                    subscriberArr2[i3] = new ParallelFilterSubscriber(subscriber, this.f138589b, this.f138590c);
                }
            }
            this.f138588a.b(subscriberArr2);
        }
    }
}
