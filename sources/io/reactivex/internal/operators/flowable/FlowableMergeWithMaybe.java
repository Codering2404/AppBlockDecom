package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
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
public final class FlowableMergeWithMaybe<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final MaybeSource f135952c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MergeWithObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -4592979584110982903L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReference f135954b = new AtomicReference();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final OtherObserver f135955c = new OtherObserver(this);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicThrowable f135956d = new AtomicThrowable();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicLong f135957f = new AtomicLong();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f135958g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final int f135959h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile SimplePlainQueue f135960i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f135961j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f135962k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        volatile boolean f135963l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        volatile int f135964m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        long f135965n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f135966o;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class OtherObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
            private static final long serialVersionUID = -2935427570954647017L;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final MergeWithObserver f135967a;

            OtherObserver(MergeWithObserver mergeWithObserver) {
                this.f135967a = mergeWithObserver;
            }

            @Override // io.reactivex.MaybeObserver
            public void a(Disposable disposable) {
                DisposableHelper.g(this, disposable);
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                this.f135967a.d();
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                this.f135967a.e(th);
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(Object obj) {
                this.f135967a.f(obj);
            }
        }

        MergeWithObserver(Subscriber subscriber) {
            this.f135953a = subscriber;
            int iA = Flowable.a();
            this.f135958g = iA;
            this.f135959h = iA - (iA >> 2);
        }

        void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        void b() {
            Subscriber subscriber = this.f135953a;
            long j3 = this.f135965n;
            int i3 = this.f135966o;
            int i4 = this.f135959h;
            int i5 = 1;
            int iAddAndGet = 1;
            while (true) {
                long j4 = this.f135957f.get();
                while (j3 != j4) {
                    if (this.f135962k) {
                        this.f135961j = null;
                        this.f135960i = null;
                        return;
                    }
                    if (this.f135956d.get() != null) {
                        this.f135961j = null;
                        this.f135960i = null;
                        subscriber.onError(this.f135956d.b());
                        return;
                    }
                    int i6 = this.f135964m;
                    if (i6 == i5) {
                        Object obj = this.f135961j;
                        this.f135961j = null;
                        this.f135964m = 2;
                        subscriber.h(obj);
                        j3++;
                    } else {
                        boolean z2 = this.f135963l;
                        SimplePlainQueue simplePlainQueue = this.f135960i;
                        Object objPoll = simplePlainQueue != null ? simplePlainQueue.poll() : null;
                        boolean z3 = objPoll == null;
                        if (z2 && z3 && i6 == 2) {
                            this.f135960i = null;
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
                                ((Subscription) this.f135954b.get()).y(i4);
                                i3 = 0;
                            }
                            i5 = 1;
                        }
                    }
                }
                if (j3 == j4) {
                    if (this.f135962k) {
                        this.f135961j = null;
                        this.f135960i = null;
                        return;
                    }
                    if (this.f135956d.get() != null) {
                        this.f135961j = null;
                        this.f135960i = null;
                        subscriber.onError(this.f135956d.b());
                        return;
                    }
                    boolean z4 = this.f135963l;
                    SimplePlainQueue simplePlainQueue2 = this.f135960i;
                    boolean z5 = simplePlainQueue2 == null || simplePlainQueue2.isEmpty();
                    if (z4 && z5 && this.f135964m == 2) {
                        this.f135960i = null;
                        subscriber.onComplete();
                        return;
                    }
                }
                this.f135965n = j3;
                this.f135966o = i3;
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                } else {
                    i5 = 1;
                }
            }
        }

        SimplePlainQueue c() {
            SimplePlainQueue simplePlainQueue = this.f135960i;
            if (simplePlainQueue != null) {
                return simplePlainQueue;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(Flowable.a());
            this.f135960i = spscArrayQueue;
            return spscArrayQueue;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f135962k = true;
            SubscriptionHelper.a(this.f135954b);
            DisposableHelper.a(this.f135955c);
            if (getAndIncrement() == 0) {
                this.f135960i = null;
                this.f135961j = null;
            }
        }

        void d() {
            this.f135964m = 2;
            a();
        }

        void e(Throwable th) {
            if (!this.f135956d.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                SubscriptionHelper.a(this.f135954b);
                a();
            }
        }

        void f(Object obj) {
            if (compareAndSet(0, 1)) {
                long j3 = this.f135965n;
                if (this.f135957f.get() != j3) {
                    this.f135965n = j3 + 1;
                    this.f135953a.h(obj);
                    this.f135964m = 2;
                } else {
                    this.f135961j = obj;
                    this.f135964m = 1;
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            } else {
                this.f135961j = obj;
                this.f135964m = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.g(this.f135954b, subscription, this.f135958g);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (compareAndSet(0, 1)) {
                long j3 = this.f135965n;
                if (this.f135957f.get() != j3) {
                    SimplePlainQueue simplePlainQueue = this.f135960i;
                    if (simplePlainQueue == null || simplePlainQueue.isEmpty()) {
                        this.f135965n = j3 + 1;
                        this.f135953a.h(obj);
                        int i3 = this.f135966o + 1;
                        if (i3 == this.f135959h) {
                            this.f135966o = 0;
                            ((Subscription) this.f135954b.get()).y(i3);
                        } else {
                            this.f135966o = i3;
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
            this.f135963l = true;
            a();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.f135956d.a(th)) {
                RxJavaPlugins.s(th);
            } else {
                SubscriptionHelper.a(this.f135954b);
                a();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            BackpressureHelper.a(this.f135957f, j3);
            a();
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(subscriber);
        subscriber.g(mergeWithObserver);
        this.f135196b.w(mergeWithObserver);
        this.f135952c.b(mergeWithObserver.f135955c);
    }
}
