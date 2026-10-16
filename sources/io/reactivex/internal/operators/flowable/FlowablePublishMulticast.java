package io.reactivex.internal.operators.flowable;

import androidx.compose.animation.core.h;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowablePublishMulticast<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f136076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f136077d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f136078f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MulticastProcessor<T> extends Flowable<T> implements FlowableSubscriber<T>, Disposable {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        static final MulticastSubscription[] f136079n = new MulticastSubscription[0];

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        static final MulticastSubscription[] f136080o = new MulticastSubscription[0];

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f136083d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f136084f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final boolean f136085g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile SimpleQueue f136087i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f136088j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        volatile boolean f136089k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Throwable f136090l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f136091m;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicInteger f136081b = new AtomicInteger();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicReference f136086h = new AtomicReference();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference f136082c = new AtomicReference(f136079n);

        MulticastProcessor(int i3, boolean z2) {
            this.f136083d = i3;
            this.f136084f = i3 - (i3 >> 2);
            this.f136085g = z2;
        }

        boolean A(MulticastSubscription multicastSubscription) {
            MulticastSubscription[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = (MulticastSubscription[]) this.f136082c.get();
                if (multicastSubscriptionArr == f136080o) {
                    return false;
                }
                int length = multicastSubscriptionArr.length;
                multicastSubscriptionArr2 = new MulticastSubscription[length + 1];
                System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr2, 0, length);
                multicastSubscriptionArr2[length] = multicastSubscription;
            } while (!h.a(this.f136082c, multicastSubscriptionArr, multicastSubscriptionArr2));
            return true;
        }

        void B() {
            for (MulticastSubscription multicastSubscription : (MulticastSubscription[]) this.f136082c.getAndSet(f136080o)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.f136092a.onComplete();
                }
            }
        }

        void C() {
            AtomicReference atomicReference;
            Throwable th;
            Throwable th2;
            if (this.f136081b.getAndIncrement() != 0) {
                return;
            }
            SimpleQueue simpleQueue = this.f136087i;
            int i3 = this.f136091m;
            int i4 = this.f136084f;
            boolean z2 = this.f136088j != 1;
            AtomicReference atomicReference2 = this.f136082c;
            MulticastSubscription[] multicastSubscriptionArr = (MulticastSubscription[]) atomicReference2.get();
            int iAddAndGet = 1;
            while (true) {
                int length = multicastSubscriptionArr.length;
                if (simpleQueue == null || length == 0) {
                    atomicReference = atomicReference2;
                } else {
                    int length2 = multicastSubscriptionArr.length;
                    long j3 = Long.MAX_VALUE;
                    long j4 = Long.MAX_VALUE;
                    int i5 = 0;
                    while (i5 < length2) {
                        MulticastSubscription multicastSubscription = multicastSubscriptionArr[i5];
                        AtomicReference atomicReference3 = atomicReference2;
                        long j5 = multicastSubscription.get() - multicastSubscription.f136094c;
                        if (j5 == Long.MIN_VALUE) {
                            length--;
                        } else if (j4 > j5) {
                            j4 = j5;
                        }
                        i5++;
                        atomicReference2 = atomicReference3;
                    }
                    atomicReference = atomicReference2;
                    long j6 = 0;
                    if (length == 0) {
                        j4 = 0;
                    }
                    while (j4 != j6) {
                        if (e()) {
                            simpleQueue.clear();
                            return;
                        }
                        boolean z3 = this.f136089k;
                        if (z3 && !this.f136085g && (th2 = this.f136090l) != null) {
                            D(th2);
                            return;
                        }
                        try {
                            Object objPoll = simpleQueue.poll();
                            boolean z4 = objPoll == null;
                            if (z3 && z4) {
                                Throwable th3 = this.f136090l;
                                if (th3 != null) {
                                    D(th3);
                                    return;
                                } else {
                                    B();
                                    return;
                                }
                            }
                            if (z4) {
                                break;
                            }
                            int length3 = multicastSubscriptionArr.length;
                            int i6 = 0;
                            boolean z5 = false;
                            while (i6 < length3) {
                                MulticastSubscription multicastSubscription2 = multicastSubscriptionArr[i6];
                                long j7 = multicastSubscription2.get();
                                if (j7 != Long.MIN_VALUE) {
                                    if (j7 != j3) {
                                        multicastSubscription2.f136094c++;
                                    }
                                    multicastSubscription2.f136092a.h(objPoll);
                                } else {
                                    z5 = true;
                                }
                                i6++;
                                j3 = Long.MAX_VALUE;
                            }
                            j4--;
                            if (z2 && (i3 = i3 + 1) == i4) {
                                ((Subscription) this.f136086h.get()).y(i4);
                                i3 = 0;
                            }
                            MulticastSubscription[] multicastSubscriptionArr2 = (MulticastSubscription[]) atomicReference.get();
                            if (z5 || multicastSubscriptionArr2 != multicastSubscriptionArr) {
                                multicastSubscriptionArr = multicastSubscriptionArr2;
                                break;
                            } else {
                                j6 = 0;
                                j3 = Long.MAX_VALUE;
                            }
                        } catch (Throwable th4) {
                            Exceptions.b(th4);
                            SubscriptionHelper.a(this.f136086h);
                            D(th4);
                            return;
                        }
                    }
                    if (j4 == j6) {
                        if (e()) {
                            simpleQueue.clear();
                            return;
                        }
                        boolean z6 = this.f136089k;
                        if (z6 && !this.f136085g && (th = this.f136090l) != null) {
                            D(th);
                            return;
                        }
                        if (z6 && simpleQueue.isEmpty()) {
                            Throwable th5 = this.f136090l;
                            if (th5 != null) {
                                D(th5);
                                return;
                            } else {
                                B();
                                return;
                            }
                        }
                    }
                }
                this.f136091m = i3;
                iAddAndGet = this.f136081b.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (simpleQueue == null) {
                    simpleQueue = this.f136087i;
                }
                multicastSubscriptionArr = (MulticastSubscription[]) atomicReference.get();
                atomicReference2 = atomicReference;
            }
        }

        void D(Throwable th) {
            for (MulticastSubscription multicastSubscription : (MulticastSubscription[]) this.f136082c.getAndSet(f136080o)) {
                if (multicastSubscription.get() != Long.MIN_VALUE) {
                    multicastSubscription.f136092a.onError(th);
                }
            }
        }

        void E(MulticastSubscription multicastSubscription) {
            MulticastSubscription[] multicastSubscriptionArr;
            MulticastSubscription[] multicastSubscriptionArr2;
            do {
                multicastSubscriptionArr = (MulticastSubscription[]) this.f136082c.get();
                int length = multicastSubscriptionArr.length;
                if (length == 0) {
                    return;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        i3 = -1;
                        break;
                    } else if (multicastSubscriptionArr[i3] == multicastSubscription) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 < 0) {
                    return;
                }
                if (length == 1) {
                    multicastSubscriptionArr2 = f136079n;
                } else {
                    MulticastSubscription[] multicastSubscriptionArr3 = new MulticastSubscription[length - 1];
                    System.arraycopy(multicastSubscriptionArr, 0, multicastSubscriptionArr3, 0, i3);
                    System.arraycopy(multicastSubscriptionArr, i3 + 1, multicastSubscriptionArr3, i3, (length - i3) - 1);
                    multicastSubscriptionArr2 = multicastSubscriptionArr3;
                }
            } while (!h.a(this.f136082c, multicastSubscriptionArr, multicastSubscriptionArr2));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            SimpleQueue simpleQueue;
            SubscriptionHelper.a(this.f136086h);
            if (this.f136081b.getAndIncrement() != 0 || (simpleQueue = this.f136087i) == null) {
                return;
            }
            simpleQueue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136086h.get() == SubscriptionHelper.CANCELLED;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.f(this.f136086h, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int iL = queueSubscription.l(3);
                    if (iL == 1) {
                        this.f136088j = iL;
                        this.f136087i = queueSubscription;
                        this.f136089k = true;
                        C();
                        return;
                    }
                    if (iL == 2) {
                        this.f136088j = iL;
                        this.f136087i = queueSubscription;
                        QueueDrainHelper.j(subscription, this.f136083d);
                        return;
                    }
                }
                this.f136087i = QueueDrainHelper.c(this.f136083d);
                QueueDrainHelper.j(subscription, this.f136083d);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136089k) {
                return;
            }
            if (this.f136088j != 0 || this.f136087i.offer(obj)) {
                C();
            } else {
                ((Subscription) this.f136086h.get()).cancel();
                onError(new MissingBackpressureException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136089k) {
                return;
            }
            this.f136089k = true;
            C();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136089k) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f136090l = th;
            this.f136089k = true;
            C();
        }

        @Override // io.reactivex.Flowable
        protected void x(Subscriber subscriber) {
            MulticastSubscription multicastSubscription = new MulticastSubscription(subscriber, this);
            subscriber.g(multicastSubscription);
            if (A(multicastSubscription)) {
                if (multicastSubscription.a()) {
                    E(multicastSubscription);
                    return;
                } else {
                    C();
                    return;
                }
            }
            Throwable th = this.f136090l;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onComplete();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MulticastSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 8664815189257569791L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final MulticastProcessor f136093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f136094c;

        MulticastSubscription(Subscriber subscriber, MulticastProcessor multicastProcessor) {
            this.f136092a = subscriber;
            this.f136093b = multicastProcessor;
        }

        public boolean a() {
            return get() == Long.MIN_VALUE;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f136093b.E(this);
                this.f136093b.C();
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.b(this, j3);
                this.f136093b.C();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OutputCanceller<R> implements FlowableSubscriber<R>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final MulticastProcessor f136096b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f136097c;

        OutputCanceller(Subscriber subscriber, MulticastProcessor multicastProcessor) {
            this.f136095a = subscriber;
            this.f136096b = multicastProcessor;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136097c.cancel();
            this.f136096b.dispose();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136097c, subscription)) {
                this.f136097c = subscription;
                this.f136095a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f136095a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f136095a.onComplete();
            this.f136096b.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f136095a.onError(th);
            this.f136096b.dispose();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f136097c.y(j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        MulticastProcessor multicastProcessor = new MulticastProcessor(this.f136077d, this.f136078f);
        try {
            ((Publisher) ObjectHelper.d(this.f136076c.apply(multicastProcessor), "selector returned a null Publisher")).i(new OutputCanceller(subscriber, multicastProcessor));
            this.f135196b.w(multicastProcessor);
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
