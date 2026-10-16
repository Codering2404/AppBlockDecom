package io.reactivex.internal.operators.flowable;

import androidx.compose.animation.core.h;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.HasUpstreamPublisher;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowablePublish<T> extends ConnectableFlowable<T> implements HasUpstreamPublisher<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Flowable f136057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference f136058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f136059d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Publisher f136060f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FlowablePublisher<T> implements Publisher<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicReference f136061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f136062b;

        @Override // org.reactivestreams.Publisher
        public void i(Subscriber subscriber) {
            PublishSubscriber publishSubscriber;
            InnerSubscriber innerSubscriber = new InnerSubscriber(subscriber);
            subscriber.g(innerSubscriber);
            while (true) {
                publishSubscriber = (PublishSubscriber) this.f136061a.get();
                if (publishSubscriber == null || publishSubscriber.e()) {
                    PublishSubscriber publishSubscriber2 = new PublishSubscriber(this.f136061a, this.f136062b);
                    if (h.a(this.f136061a, publishSubscriber, publishSubscriber2)) {
                        publishSubscriber = publishSubscriber2;
                    } else {
                        continue;
                    }
                }
                if (publishSubscriber.a(innerSubscriber)) {
                    break;
                }
            }
            if (innerSubscriber.get() == Long.MIN_VALUE) {
                publishSubscriber.d(innerSubscriber);
            } else {
                innerSubscriber.f136064b = publishSubscriber;
            }
            publishSubscriber.c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class InnerSubscriber<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = -4453897557930727610L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile PublishSubscriber f136064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f136065c;

        InnerSubscriber(Subscriber subscriber) {
            this.f136063a = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            PublishSubscriber publishSubscriber;
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE || (publishSubscriber = this.f136064b) == null) {
                return;
            }
            publishSubscriber.d(this);
            publishSubscriber.c();
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.b(this, j3);
                PublishSubscriber publishSubscriber = this.f136064b;
                if (publishSubscriber != null) {
                    publishSubscriber.c();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class PublishSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final InnerSubscriber[] f136066j = new InnerSubscriber[0];

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        static final InnerSubscriber[] f136067k = new InnerSubscriber[0];
        private static final long serialVersionUID = -202316842419149694L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReference f136068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f136069b;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile Object f136073g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f136074h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile SimpleQueue f136075i;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicReference f136072f = new AtomicReference();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference f136070c = new AtomicReference(f136066j);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicBoolean f136071d = new AtomicBoolean();

        PublishSubscriber(AtomicReference atomicReference, int i3) {
            this.f136068a = atomicReference;
            this.f136069b = i3;
        }

        boolean a(InnerSubscriber innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.f136070c.get();
                if (innerSubscriberArr == f136067k) {
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!h.a(this.f136070c, innerSubscriberArr, innerSubscriberArr2));
            return true;
        }

        boolean b(Object obj, boolean z2) {
            int i3 = 0;
            if (obj != null) {
                if (!NotificationLite.j(obj)) {
                    Throwable thH = NotificationLite.h(obj);
                    h.a(this.f136068a, this, null);
                    InnerSubscriber[] innerSubscriberArr = (InnerSubscriber[]) this.f136070c.getAndSet(f136067k);
                    if (innerSubscriberArr.length != 0) {
                        int length = innerSubscriberArr.length;
                        while (i3 < length) {
                            innerSubscriberArr[i3].f136063a.onError(thH);
                            i3++;
                        }
                    } else {
                        RxJavaPlugins.s(thH);
                    }
                    return true;
                }
                if (z2) {
                    h.a(this.f136068a, this, null);
                    InnerSubscriber[] innerSubscriberArr2 = (InnerSubscriber[]) this.f136070c.getAndSet(f136067k);
                    int length2 = innerSubscriberArr2.length;
                    while (i3 < length2) {
                        innerSubscriberArr2[i3].f136063a.onComplete();
                        i3++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:75:0x0125, code lost:
        
            if (r11 == 0) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x012a, code lost:
        
            if (r26.f136074h == 1) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x012c, code lost:
        
            ((org.reactivestreams.Subscription) r26.f136072f.get()).y(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x0138, code lost:
        
            r4 = r0;
            r3 = true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void c() {
            /*
                Method dump skipped, instruction units count: 365
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowablePublish.PublishSubscriber.c():void");
        }

        void d(InnerSubscriber innerSubscriber) {
            InnerSubscriber[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = (InnerSubscriber[]) this.f136070c.get();
                int length = innerSubscriberArr.length;
                if (length == 0) {
                    return;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        i3 = -1;
                        break;
                    } else if (innerSubscriberArr[i3].equals(innerSubscriber)) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriberArr2 = f136066j;
                } else {
                    InnerSubscriber[] innerSubscriberArr3 = new InnerSubscriber[length - 1];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i3);
                    System.arraycopy(innerSubscriberArr, i3 + 1, innerSubscriberArr3, i3, (length - i3) - 1);
                    innerSubscriberArr2 = innerSubscriberArr3;
                }
            } while (!h.a(this.f136070c, innerSubscriberArr, innerSubscriberArr2));
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Object obj = this.f136070c.get();
            Object obj2 = f136067k;
            if (obj == obj2 || ((InnerSubscriber[]) this.f136070c.getAndSet(obj2)) == obj2) {
                return;
            }
            h.a(this.f136068a, this, null);
            SubscriptionHelper.a(this.f136072f);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean e() {
            return this.f136070c.get() == f136067k;
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.f(this.f136072f, subscription)) {
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int iL = queueSubscription.l(7);
                    if (iL == 1) {
                        this.f136074h = iL;
                        this.f136075i = queueSubscription;
                        this.f136073g = NotificationLite.e();
                        c();
                        return;
                    }
                    if (iL == 2) {
                        this.f136074h = iL;
                        this.f136075i = queueSubscription;
                        subscription.y(this.f136069b);
                        return;
                    }
                }
                this.f136075i = new SpscArrayQueue(this.f136069b);
                subscription.y(this.f136069b);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136074h != 0 || this.f136075i.offer(obj)) {
                c();
            } else {
                onError(new MissingBackpressureException("Prefetch queue is full?!"));
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136073g == null) {
                this.f136073g = NotificationLite.e();
                c();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136073g != null) {
                RxJavaPlugins.s(th);
            } else {
                this.f136073g = NotificationLite.g(th);
                c();
            }
        }
    }

    @Override // io.reactivex.flowables.ConnectableFlowable
    public void A(Consumer consumer) {
        PublishSubscriber publishSubscriber;
        while (true) {
            publishSubscriber = (PublishSubscriber) this.f136058c.get();
            if (publishSubscriber != null && !publishSubscriber.e()) {
                break;
            }
            PublishSubscriber publishSubscriber2 = new PublishSubscriber(this.f136058c, this.f136059d);
            if (h.a(this.f136058c, publishSubscriber, publishSubscriber2)) {
                publishSubscriber = publishSubscriber2;
                break;
            }
        }
        boolean z2 = false;
        if (!publishSubscriber.f136071d.get() && publishSubscriber.f136071d.compareAndSet(false, true)) {
            z2 = true;
        }
        try {
            consumer.accept(publishSubscriber);
            if (z2) {
                this.f136057b.w(publishSubscriber);
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            throw ExceptionHelper.e(th);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f136060f.i(subscriber);
    }
}
