package io.reactivex.processors;

import androidx.compose.animation.core.h;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class AsyncProcessor<T> extends FlowableProcessor<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final AsyncSubscription[] f139295f = new AsyncSubscription[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final AsyncSubscription[] f139296g = new AsyncSubscription[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference f139297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Throwable f139298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f139299d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AsyncSubscription<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = 5629876084736248016L;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AsyncProcessor f139300c;

        AsyncSubscription(Subscriber subscriber, AsyncProcessor asyncProcessor) {
            super(subscriber);
            this.f139300c = asyncProcessor;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            if (super.k()) {
                this.f139300c.C(this);
            }
        }

        void onComplete() {
            if (j()) {
                return;
            }
            this.f139174a.onComplete();
        }

        void onError(Throwable th) {
            if (j()) {
                RxJavaPlugins.s(th);
            } else {
                this.f139174a.onError(th);
            }
        }
    }

    boolean B(AsyncSubscription asyncSubscription) {
        AsyncSubscription[] asyncSubscriptionArr;
        AsyncSubscription[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = (AsyncSubscription[]) this.f139297b.get();
            if (asyncSubscriptionArr == f139296g) {
                return false;
            }
            int length = asyncSubscriptionArr.length;
            asyncSubscriptionArr2 = new AsyncSubscription[length + 1];
            System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr2, 0, length);
            asyncSubscriptionArr2[length] = asyncSubscription;
        } while (!h.a(this.f139297b, asyncSubscriptionArr, asyncSubscriptionArr2));
        return true;
    }

    void C(AsyncSubscription asyncSubscription) {
        AsyncSubscription[] asyncSubscriptionArr;
        AsyncSubscription[] asyncSubscriptionArr2;
        do {
            asyncSubscriptionArr = (AsyncSubscription[]) this.f139297b.get();
            int length = asyncSubscriptionArr.length;
            if (length == 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    i3 = -1;
                    break;
                } else if (asyncSubscriptionArr[i3] == asyncSubscription) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                return;
            }
            if (length == 1) {
                asyncSubscriptionArr2 = f139295f;
            } else {
                AsyncSubscription[] asyncSubscriptionArr3 = new AsyncSubscription[length - 1];
                System.arraycopy(asyncSubscriptionArr, 0, asyncSubscriptionArr3, 0, i3);
                System.arraycopy(asyncSubscriptionArr, i3 + 1, asyncSubscriptionArr3, i3, (length - i3) - 1);
                asyncSubscriptionArr2 = asyncSubscriptionArr3;
            }
        } while (!h.a(this.f139297b, asyncSubscriptionArr, asyncSubscriptionArr2));
    }

    @Override // org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        if (this.f139297b.get() == f139296g) {
            subscription.cancel();
        } else {
            subscription.y(Long.MAX_VALUE);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        ObjectHelper.d(obj, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f139297b.get() == f139296g) {
            return;
        }
        this.f139299d = obj;
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        Object obj = this.f139297b.get();
        Object obj2 = f139296g;
        if (obj == obj2) {
            return;
        }
        Object obj3 = this.f139299d;
        AsyncSubscription[] asyncSubscriptionArr = (AsyncSubscription[]) this.f139297b.getAndSet(obj2);
        int i3 = 0;
        if (obj3 == null) {
            int length = asyncSubscriptionArr.length;
            while (i3 < length) {
                asyncSubscriptionArr[i3].onComplete();
                i3++;
            }
            return;
        }
        int length2 = asyncSubscriptionArr.length;
        while (i3 < length2) {
            asyncSubscriptionArr[i3].e(obj3);
            i3++;
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        ObjectHelper.d(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        Object obj = this.f139297b.get();
        Object obj2 = f139296g;
        if (obj == obj2) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f139299d = null;
        this.f139298c = th;
        for (AsyncSubscription asyncSubscription : (AsyncSubscription[]) this.f139297b.getAndSet(obj2)) {
            asyncSubscription.onError(th);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        AsyncSubscription asyncSubscription = new AsyncSubscription(subscriber, this);
        subscriber.g(asyncSubscription);
        if (B(asyncSubscription)) {
            if (asyncSubscription.j()) {
                C(asyncSubscription);
                return;
            }
            return;
        }
        Throwable th = this.f139298c;
        if (th != null) {
            subscriber.onError(th);
            return;
        }
        Object obj = this.f139299d;
        if (obj != null) {
            asyncSubscription.e(obj);
        } else {
            asyncSubscription.onComplete();
        }
    }
}
