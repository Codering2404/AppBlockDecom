package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableMergeWithSingle<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final SingleSource f135968c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MergeWithObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReference f135970b = new AtomicReference();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final OtherObserver f135971c = new OtherObserver(this);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicThrowable f135972d = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicLong f135973f = new AtomicLong();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f135974g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final int f135975h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile SimplePlainQueue f135976i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f135977j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f135978k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile boolean f135979l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        volatile int f135980m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        long f135981n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f135982o;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class OtherObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final MergeWithObserver f135983a;

            OtherObserver(MergeWithObserver mergeWithObserver) {
                this.f135983a = mergeWithObserver;
            }

            @Override // io.reactivex.SingleObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            @Override // io.reactivex.SingleObserver
            public void onError(Throwable th) {
                this.f135983a.d(th);
            }

            @Override // io.reactivex.SingleObserver
            public void onSuccess(Object obj) {
                this.f135983a.e(obj);
            }
        }

        MergeWithObserver(Subscriber subscriber) {
            this.f135969a = subscriber;
            int iA = Flowable.a();
            this.f135974g = iA;
            this.f135975h = iA - (iA >> 2);
        }

        void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        void b() {
            Subscriber subscriber = this.f135969a;
            long j3 = this.f135981n;
            int i3 = this.f135982o;
            int i4 = this.f135975h;
            int i5 = 1;
            int iAddAndGet = 1;
            while (true) {
                long j4 = this.f135973f.get();
                while (j3 != j4) {
                    if (this.f135978k) {
                        this.f135977j = null;
                        this.f135976i = null;
                        return;
                    }
                    if (this.f135972d.get() != null) {
                        this.f135977j = null;
                        this.f135976i = null;
                        subscriber.onError(this.f135972d.b());
                        return;
                    }
                    int i6 = this.f135980m;
                    if (i6 == i5) {
                        Object obj = this.f135977j;
                        this.f135977j = null;
                        this.f135980m = 2;
                        subscriber.h(obj);
                        j3++;
                    } else {
                        boolean z2 = this.f135979l;
                        SimplePlainQueue simplePlainQueue = this.f135976i;
                        Object objPoll = simplePlainQueue != null ? simplePlainQueue.poll() : null;
                        boolean z3 = objPoll == null;
                        if (z2 && z3 && i6 == 2) {
                            this.f135976i = null;
                            subscriber.onComplete();
                            return;
                        } else {
                            if (z3) {
                                break;
                            }
                            subscriber.h(objPoll);
                            j3++;
                            i3++;
                            if (i3 == i4) {
                                ((Subscription) this.f135970b.get()).y(i4);
                                i3 = 0;
                            }
                            i5 = 1;
                        }
                    }
                }
                if (j3 == j4) {
                    if (this.f135978k) {
                        this.f135977j = null;
                        this.f135976i = null;
                        return;
                    }
                    if (this.f135972d.get() != null) {
                        this.f135977j = null;
                        this.f135976i = null;
                        subscriber.onError(this.f135972d.b());
                        return;
                    }
                    boolean z4 = this.f135979l;
                    SimplePlainQueue simplePlainQueue2 = this.f135976i;
                    boolean z5 = simplePlainQueue2 == null || simplePlainQueue2.isEmpty();
                    if (z4 && z5 && this.f135980m == 2) {
                        this.f135976i = null;
                        subscriber.onComplete();
                        return;
                    }
                }
                this.f135981n = j3;
                this.f135982o = i3;
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                } else {
                    i5 = 1;
                }
            }
        }

        SimplePlainQueue c() {
            SimplePlainQueue simplePlainQueue = this.f135976i;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(Flowable.a());
            this.f135976i = spscArrayQueue;
            return spscArrayQueue;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f135978k = true;
            SubscriptionHelper.a(this.f135970b);
            DisposableHelper.a(this.f135971c);
            if (getAndIncrement() == 0) {
                this.f135976i = null;
                this.f135977j = null;
            }
        }

        void d(Throwable th) {
            if (!this.f135972d.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                SubscriptionHelper.a(this.f135970b);
                a();
            }
        }

        void e(Object obj) {
            if (compareAndSet(0, 1)) {
                long j3 = this.f135981n;
                if (this.f135973f.get() != j3) {
                    this.f135981n = j3 + 1;
                    this.f135969a.h(obj);
                    this.f135980m = 2;
                } else {
                    this.f135977j = obj;
                    this.f135980m = 1;
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            } else {
                this.f135977j = obj;
                this.f135980m = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.g(this.f135970b, subscription, this.f135974g);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (compareAndSet(0, 1)) {
                long j3 = this.f135981n;
                if (this.f135973f.get() != j3) {
                    SimplePlainQueue simplePlainQueue = this.f135976i;
                    if (simplePlainQueue == null || simplePlainQueue.isEmpty()) {
                        this.f135981n = j3 + 1;
                        this.f135969a.h(obj);
                        int i3 = this.f135982o + 1;
                        if (i3 == this.f135975h) {
                            this.f135982o = 0;
                            ((Subscription) this.f135970b.get()).y(i3);
                        } else {
                            this.f135982o = i3;
                        }
                    } else {
                        simplePlainQueue.offer(obj);
                    }
                } else {
                    c().offer(obj);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                c().offer(obj);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135979l = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f135972d.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                SubscriptionHelper.a(this.f135970b);
                a();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            BackpressureHelper.a(this.f135973f, j3);
            a();
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(subscriber);
        subscriber.g(mergeWithObserver);
        this.f135196b.w(mergeWithObserver);
        this.f135968c.b(mergeWithObserver.f135971c);
    }
}
