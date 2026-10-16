package io.reactivex.processors;

import androidx.compose.animation.core.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class PublishProcessor<T> extends FlowableProcessor<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final PublishSubscription[] f139335d = new PublishSubscription[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final PublishSubscription[] f139336f = new PublishSubscription[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference f139337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Throwable f139338c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class PublishSubscription<T> extends AtomicLong implements Subscription {
        private static final long serialVersionUID = 3562861878281475070L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f139339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final PublishProcessor f139340b;

        PublishSubscription(Subscriber subscriber, PublishProcessor publishProcessor) {
            this.f139339a = subscriber;
            this.f139340b = publishProcessor;
        }

        public boolean a() {
            return get() == Long.MIN_VALUE;
        }

        public void b() {
            if (get() != Long.MIN_VALUE) {
                this.f139339a.onComplete();
            }
        }

        public void c(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.f139339a.onError(th);
            } else {
                RxJavaPlugins.s(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f139340b.C(this);
            }
        }

        public void d(Object obj) {
            long j3 = get();
            if (j3 == Long.MIN_VALUE) {
                return;
            }
            if (j3 != 0) {
                this.f139339a.h(obj);
                BackpressureHelper.f(this, 1L);
            } else {
                cancel();
                this.f139339a.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            if (SubscriptionHelper.h(j3)) {
                BackpressureHelper.b(this, j3);
            }
        }
    }

    boolean B(PublishSubscription publishSubscription) {
        PublishSubscription[] publishSubscriptionArr;
        PublishSubscription[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = (PublishSubscription[]) this.f139337b.get();
            if (publishSubscriptionArr == f139335d) {
                return false;
            }
            int length = publishSubscriptionArr.length;
            publishSubscriptionArr2 = new PublishSubscription[length + 1];
            System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr2, 0, length);
            publishSubscriptionArr2[length] = publishSubscription;
        } while (!h.a(this.f139337b, publishSubscriptionArr, publishSubscriptionArr2));
        return true;
    }

    void C(PublishSubscription publishSubscription) {
        PublishSubscription[] publishSubscriptionArr;
        PublishSubscription[] publishSubscriptionArr2;
        do {
            publishSubscriptionArr = (PublishSubscription[]) this.f139337b.get();
            if (publishSubscriptionArr == f139335d || publishSubscriptionArr == f139336f) {
                return;
            }
            int length = publishSubscriptionArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (publishSubscriptionArr[i3] == publishSubscription) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length == 1) {
                publishSubscriptionArr2 = f139336f;
            } else {
                PublishSubscription[] publishSubscriptionArr3 = new PublishSubscription[length - 1];
                System.arraycopy(publishSubscriptionArr, 0, publishSubscriptionArr3, 0, i3);
                System.arraycopy(publishSubscriptionArr, i3 + 1, publishSubscriptionArr3, i3, (length - i3) - 1);
                publishSubscriptionArr2 = publishSubscriptionArr3;
            }
        } while (!h.a(this.f139337b, publishSubscriptionArr, publishSubscriptionArr2));
    }

    @Override // org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        if (this.f139337b.get() == f139335d) {
            subscription.cancel();
        } else {
            subscription.y(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        ObjectHelper.d(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishSubscription publishSubscription : (PublishSubscription[]) this.f139337b.get()) {
            publishSubscription.d(obj);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Object obj = this.f139337b.get();
        Object obj2 = f139335d;
        if (obj == obj2) {
            return;
        }
        for (PublishSubscription publishSubscription : (PublishSubscription[]) this.f139337b.getAndSet(obj2)) {
            publishSubscription.b();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        ObjectHelper.d(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        Object obj = this.f139337b.get();
        Object obj2 = f139335d;
        if (obj == obj2) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f139338c = th;
        for (PublishSubscription publishSubscription : (PublishSubscription[]) this.f139337b.getAndSet(obj2)) {
            publishSubscription.c(th);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        PublishSubscription publishSubscription = new PublishSubscription(subscriber, this);
        subscriber.g(publishSubscription);
        if (B(publishSubscription)) {
            if (publishSubscription.a()) {
                C(publishSubscription);
            }
        } else {
            Throwable th = this.f139338c;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onComplete();
            }
        }
    }
}
