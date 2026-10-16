package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Action;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableOnBackpressureBufferStrategy<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f136018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Action f136019d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final BackpressureOverflowStrategy f136020f;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f136021a;

        static {
            int[] iArr = new int[BackpressureOverflowStrategy.values().length];
            f136021a = iArr;
            try {
                iArr[BackpressureOverflowStrategy.DROP_LATEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f136021a[BackpressureOverflowStrategy.DROP_OLDEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 3240706908776709697L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Action f136023b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final BackpressureOverflowStrategy f136024c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final long f136025d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicLong f136026f = new AtomicLong();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Deque f136027g = new ArrayDeque();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Subscription f136028h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f136029i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f136030j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Throwable f136031k;

        OnBackpressureBufferStrategySubscriber(Subscriber subscriber, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy, long j3) {
            this.f136022a = subscriber;
            this.f136023b = action;
            this.f136024c = backpressureOverflowStrategy;
            this.f136025d = j3;
        }

        void a(Deque deque) {
            synchronized (deque) {
                deque.clear();
            }
        }

        void b() {
            boolean zIsEmpty;
            Object objPoll;
            if (getAndIncrement() != 0) {
                return;
            }
            Deque deque = this.f136027g;
            Subscriber subscriber = this.f136022a;
            int iAddAndGet = 1;
            do {
                long j3 = this.f136026f.get();
                long j4 = 0;
                while (j4 != j3) {
                    if (this.f136029i) {
                        a(deque);
                        return;
                    }
                    boolean z2 = this.f136030j;
                    synchronized (deque) {
                        objPoll = deque.poll();
                    }
                    boolean z3 = objPoll == null;
                    if (z2) {
                        Throwable th = this.f136031k;
                        if (th != null) {
                            a(deque);
                            subscriber.onError(th);
                            return;
                        } else if (z3) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                    if (z3) {
                        break;
                    }
                    subscriber.h(objPoll);
                    j4++;
                }
                if (j4 == j3) {
                    if (this.f136029i) {
                        a(deque);
                        return;
                    }
                    boolean z4 = this.f136030j;
                    synchronized (deque) {
                        zIsEmpty = deque.isEmpty();
                    }
                    if (z4) {
                        Throwable th2 = this.f136031k;
                        if (th2 != null) {
                            a(deque);
                            subscriber.onError(th2);
                            return;
                        } else if (zIsEmpty) {
                            subscriber.onComplete();
                            return;
                        }
                    }
                }
                if (j4 != 0) {
                    BackpressureHelper.e(this.f136026f, j4);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136029i = true;
            this.f136028h.cancel();
            if (getAndIncrement() == 0) {
                a(this.f136027g);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136028h, subscription)) {
                this.f136028h = subscription;
                this.f136022a.g(this);
                subscription.y(Long.MAX_VALUE);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            boolean z2;
            boolean z3;
            if (this.f136030j) {
                return;
            }
            Deque deque = this.f136027g;
            synchronized (deque) {
                try {
                    z2 = false;
                    if (deque.size() == this.f136025d) {
                        int i3 = AnonymousClass1.f136021a[this.f136024c.ordinal()];
                        z3 = true;
                        if (i3 == 1) {
                            deque.pollLast();
                            deque.offer(obj);
                        } else if (i3 == 2) {
                            deque.poll();
                            deque.offer(obj);
                        }
                        z3 = false;
                        z2 = true;
                    } else {
                        deque.offer(obj);
                        z3 = false;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (!z2) {
                if (!z3) {
                    b();
                    return;
                } else {
                    this.f136028h.cancel();
                    onError(new MissingBackpressureException());
                    return;
                }
            }
            Action action = this.f136023b;
            if (action != null) {
                try {
                    action.run();
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.f136028h.cancel();
                    onError(th2);
                }
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136030j = true;
            b();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136030j) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f136031k = th;
            this.f136030j = true;
            b();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.a(this.f136026f, j3);
                b();
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new OnBackpressureBufferStrategySubscriber(subscriber, this.f136019d, this.f136020f, this.f136018c));
    }
}
