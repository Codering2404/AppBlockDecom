package io.reactivex.internal.operators.parallel;

import androidx.compose.animation.core.h;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class ParallelReduceFull<T> extends Flowable<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ParallelFlowable f138681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BiFunction f138682c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ParallelReduceFullInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7954444275102466525L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ParallelReduceFullMainSubscriber f138683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final BiFunction f138684b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f138685c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f138686d;

        ParallelReduceFullInnerSubscriber(ParallelReduceFullMainSubscriber parallelReduceFullMainSubscriber, BiFunction biFunction) {
            this.f138683a = parallelReduceFullMainSubscriber;
            this.f138684b = biFunction;
        }

        void a() {
            SubscriptionHelper.a(this);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            SubscriptionHelper.g(this, subscription, Long.MAX_VALUE);
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f138686d) {
                return;
            }
            Object obj2 = this.f138685c;
            if (obj2 == null) {
                this.f138685c = obj;
                return;
            }
            try {
                this.f138685c = ObjectHelper.d(this.f138684b.apply(obj2, obj), "The reducer returned a null value");
            } catch (Throwable th) {
                Exceptions.b(th);
                get().cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f138686d) {
                return;
            }
            this.f138686d = true;
            this.f138683a.p(this.f138685c);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f138686d) {
                RxJavaPlugins.s(th);
            } else {
                this.f138686d = true;
                this.f138683a.b(th);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ParallelReduceFullMainSubscriber<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = -5370107872170712765L;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ParallelReduceFullInnerSubscriber[] f138687c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final BiFunction f138688d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicReference f138689f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicInteger f138690g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicReference f138691h;

        ParallelReduceFullMainSubscriber(Subscriber subscriber, int i3, BiFunction biFunction) {
            super(subscriber);
            this.f138689f = new AtomicReference();
            this.f138690g = new AtomicInteger();
            this.f138691h = new AtomicReference();
            ParallelReduceFullInnerSubscriber[] parallelReduceFullInnerSubscriberArr = new ParallelReduceFullInnerSubscriber[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                parallelReduceFullInnerSubscriberArr[i4] = new ParallelReduceFullInnerSubscriber(this, biFunction);
            }
            this.f138687c = parallelReduceFullInnerSubscriberArr;
            this.f138688d = biFunction;
            this.f138690g.lazySet(i3);
        }

        void b(Throwable th) {
            if (h.a(this.f138691h, null, th)) {
                cancel();
                this.f139174a.onError(th);
            } else if (th != this.f138691h.get()) {
                RxJavaPlugins.s(th);
            }
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            for (ParallelReduceFullInnerSubscriber parallelReduceFullInnerSubscriber : this.f138687c) {
                parallelReduceFullInnerSubscriber.a();
            }
        }

        SlotPair m(Object obj) {
            SlotPair slotPair;
            int iB;
            while (true) {
                slotPair = (SlotPair) this.f138689f.get();
                if (slotPair == null) {
                    slotPair = new SlotPair();
                    if (!h.a(this.f138689f, null, slotPair)) {
                        continue;
                    }
                }
                iB = slotPair.b();
                if (iB >= 0) {
                    break;
                }
                h.a(this.f138689f, slotPair, null);
            }
            if (iB == 0) {
                slotPair.f138692a = obj;
            } else {
                slotPair.f138693b = obj;
            }
            if (!slotPair.a()) {
                return null;
            }
            h.a(this.f138689f, slotPair, null);
            return slotPair;
        }

        void p(Object obj) {
            if (obj != null) {
                while (true) {
                    SlotPair slotPairM = m(obj);
                    if (slotPairM == null) {
                        break;
                    }
                    try {
                        obj = ObjectHelper.d(this.f138688d.apply(slotPairM.f138692a, slotPairM.f138693b), "The reducer returned a null value");
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        b(th);
                        return;
                    }
                }
            }
            if (this.f138690g.decrementAndGet() == 0) {
                SlotPair slotPair = (SlotPair) this.f138689f.get();
                this.f138689f.lazySet(null);
                if (slotPair != null) {
                    e(slotPair.f138692a);
                } else {
                    this.f139174a.onComplete();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SlotPair<T> extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f138692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f138693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicInteger f138694c = new AtomicInteger();

        SlotPair() {
        }

        boolean a() {
            return this.f138694c.incrementAndGet() == 2;
        }

        int b() {
            int i3;
            do {
                i3 = get();
                if (i3 >= 2) {
                    return -1;
                }
            } while (!compareAndSet(i3, i3 + 1));
            return i3;
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        ParallelReduceFullMainSubscriber parallelReduceFullMainSubscriber = new ParallelReduceFullMainSubscriber(subscriber, this.f138681b.a(), this.f138682c);
        subscriber.g(parallelReduceFullMainSubscriber);
        this.f138681b.b(parallelReduceFullMainSubscriber.f138687c);
    }
}
