package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f135451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f135452d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f135453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final ErrorMode f135454g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
        private static final long serialVersionUID = -4255299542215038287L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f135456b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f135457c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f135458d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final ErrorMode f135459f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicThrowable f135460g = new AtomicThrowable();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicLong f135461h = new AtomicLong();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final SpscLinkedArrayQueue f135462i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Subscription f135463j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f135464k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile boolean f135465l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        volatile InnerQueuedSubscriber f135466m;

        ConcatMapEagerDelayErrorSubscriber(Subscriber subscriber, Function function, int i3, int i4, ErrorMode errorMode) {
            this.f135455a = subscriber;
            this.f135456b = function;
            this.f135457c = i3;
            this.f135458d = i4;
            this.f135459f = errorMode;
            this.f135462i = new SpscLinkedArrayQueue(Math.min(i4, i3));
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void a(InnerQueuedSubscriber innerQueuedSubscriber, Object obj) {
            if (innerQueuedSubscriber.b().offer(obj)) {
                c();
            } else {
                innerQueuedSubscriber.cancel();
                d(innerQueuedSubscriber, new MissingBackpressureException());
            }
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void b(InnerQueuedSubscriber innerQueuedSubscriber) {
            innerQueuedSubscriber.d();
            c();
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void c() {
            InnerQueuedSubscriber innerQueuedSubscriber;
            long j3;
            long j4;
            boolean z2;
            SimpleQueue simpleQueueB;
            if (getAndIncrement() != 0) {
                return;
            }
            InnerQueuedSubscriber innerQueuedSubscriber2 = this.f135466m;
            Subscriber subscriber = this.f135455a;
            ErrorMode errorMode = this.f135459f;
            int iAddAndGet = 1;
            while (true) {
                long j5 = this.f135461h.get();
                if (innerQueuedSubscriber2 != null) {
                    innerQueuedSubscriber = innerQueuedSubscriber2;
                } else {
                    if (errorMode != ErrorMode.END && this.f135460g.get() != null) {
                        e();
                        subscriber.onError(this.f135460g.b());
                        return;
                    }
                    boolean z3 = this.f135465l;
                    innerQueuedSubscriber = (InnerQueuedSubscriber) this.f135462i.poll();
                    if (z3 && innerQueuedSubscriber == null) {
                        Throwable thB = this.f135460g.b();
                        if (thB != null) {
                            subscriber.onError(thB);
                            return;
                        } else {
                            subscriber.onComplete();
                            return;
                        }
                    }
                    if (innerQueuedSubscriber != null) {
                        this.f135466m = innerQueuedSubscriber;
                    }
                }
                if (innerQueuedSubscriber == null || (simpleQueueB = innerQueuedSubscriber.b()) == null) {
                    j3 = 0;
                    j4 = 0;
                    z2 = false;
                } else {
                    j4 = 0;
                    while (true) {
                        if (j4 == j5) {
                            j3 = 0;
                            break;
                        }
                        if (this.f135464k) {
                            e();
                            return;
                        }
                        if (errorMode == ErrorMode.IMMEDIATE && this.f135460g.get() != null) {
                            this.f135466m = null;
                            innerQueuedSubscriber.cancel();
                            e();
                            subscriber.onError(this.f135460g.b());
                            return;
                        }
                        boolean zA = innerQueuedSubscriber.a();
                        j3 = 0;
                        try {
                            Object objPoll = simpleQueueB.poll();
                            boolean z4 = objPoll == null;
                            if (zA && z4) {
                                this.f135466m = null;
                                this.f135463j.y(1L);
                                innerQueuedSubscriber = null;
                                z2 = true;
                                break;
                            }
                            if (z4) {
                                break;
                            }
                            subscriber.h(objPoll);
                            j4++;
                            innerQueuedSubscriber.c();
                        } catch (Throwable th) {
                            Exceptions.b(th);
                            this.f135466m = null;
                            innerQueuedSubscriber.cancel();
                            e();
                            subscriber.onError(th);
                            return;
                        }
                    }
                    z2 = false;
                    if (j4 == j5) {
                        if (this.f135464k) {
                            e();
                            return;
                        }
                        if (errorMode == ErrorMode.IMMEDIATE && this.f135460g.get() != null) {
                            this.f135466m = null;
                            innerQueuedSubscriber.cancel();
                            e();
                            subscriber.onError(this.f135460g.b());
                            return;
                        }
                        boolean zA2 = innerQueuedSubscriber.a();
                        boolean zIsEmpty = simpleQueueB.isEmpty();
                        if (zA2 && zIsEmpty) {
                            this.f135466m = null;
                            this.f135463j.y(1L);
                            innerQueuedSubscriber = null;
                            z2 = true;
                        }
                    }
                }
                if (j4 != j3 && j5 != Long.MAX_VALUE) {
                    this.f135461h.addAndGet(-j4);
                }
                if (!z2 && (iAddAndGet = addAndGet(-iAddAndGet)) == 0) {
                    return;
                } else {
                    innerQueuedSubscriber2 = innerQueuedSubscriber;
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.f135464k) {
                return;
            }
            this.f135464k = true;
            this.f135463j.cancel();
            f();
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void d(InnerQueuedSubscriber innerQueuedSubscriber, Throwable th) {
            if (!this.f135460g.a(th)) {
                RxJavaPlugins.s(th);
                return;
            }
            innerQueuedSubscriber.d();
            if (this.f135459f != ErrorMode.END) {
                this.f135463j.cancel();
            }
            c();
        }

        void e() {
            while (true) {
                InnerQueuedSubscriber innerQueuedSubscriber = (InnerQueuedSubscriber) this.f135462i.poll();
                if (innerQueuedSubscriber == null) {
                    return;
                } else {
                    innerQueuedSubscriber.cancel();
                }
            }
        }

        void f() {
            if (getAndIncrement() == 0) {
                do {
                    e();
                } while (decrementAndGet() != 0);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135463j, subscription)) {
                this.f135463j = subscription;
                this.f135455a.g(this);
                int i3 = this.f135457c;
                subscription.y(i3 == Integer.MAX_VALUE ? Long.MAX_VALUE : i3);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.d(this.f135456b.apply(obj), "The mapper returned a null Publisher");
                InnerQueuedSubscriber innerQueuedSubscriber = new InnerQueuedSubscriber(this, this.f135458d);
                if (this.f135464k) {
                    return;
                }
                this.f135462i.offer(innerQueuedSubscriber);
                publisher.i(innerQueuedSubscriber);
                if (this.f135464k) {
                    innerQueuedSubscriber.cancel();
                    f();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f135463j.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135465l = true;
            c();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f135460g.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                this.f135465l = true;
                c();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f135461h, j3);
                c();
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new ConcatMapEagerDelayErrorSubscriber(subscriber, this.f135451c, this.f135452d, this.f135453f, this.f135454g));
    }
}
