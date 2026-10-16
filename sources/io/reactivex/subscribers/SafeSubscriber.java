package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class SafeSubscriber<T> implements FlowableSubscriber<T>, Subscription {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Subscriber f139512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Subscription f139513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f139514c;

    void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f139512a.g(EmptySubscription.INSTANCE);
            try {
                this.f139512a.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.s(new CompositeException(nullPointerException, th2));
        }
    }

    void b() {
        this.f139514c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f139512a.g(EmptySubscription.INSTANCE);
            try {
                this.f139512a.onError(nullPointerException);
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.s(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            RxJavaPlugins.s(new CompositeException(nullPointerException, th2));
        }
    }

    @Override // org.reactivestreams.Subscription
    public void cancel() {
        try {
            this.f139513b.cancel();
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.s(th);
        }
    }

    @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
    public void g(Subscription subscription) {
        if (SubscriptionHelper.i(this.f139513b, subscription)) {
            this.f139513b = subscription;
            try {
                this.f139512a.g(this);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f139514c = true;
                try {
                    subscription.cancel();
                    RxJavaPlugins.s(th);
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    RxJavaPlugins.s(new CompositeException(th, th2));
                }
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void h(Object obj) {
        if (this.f139514c) {
            return;
        }
        if (this.f139513b == null) {
            b();
            return;
        }
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.f139513b.cancel();
                onError(nullPointerException);
                return;
            } catch (Throwable th) {
                Exceptions.b(th);
                onError(new CompositeException(nullPointerException, th));
                return;
            }
        }
        try {
            this.f139512a.h(obj);
        } catch (Throwable th2) {
            Exceptions.b(th2);
            try {
                this.f139513b.cancel();
                onError(th2);
            } catch (Throwable th3) {
                Exceptions.b(th3);
                onError(new CompositeException(th2, th3));
            }
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onComplete() {
        if (this.f139514c) {
            return;
        }
        this.f139514c = true;
        if (this.f139513b == null) {
            a();
            return;
        }
        try {
            this.f139512a.onComplete();
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.s(th);
        }
    }

    @Override // org.reactivestreams.Subscriber
    public void onError(Throwable th) {
        if (this.f139514c) {
            RxJavaPlugins.s(th);
            return;
        }
        this.f139514c = true;
        if (this.f139513b != null) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f139512a.onError(th);
                return;
            } catch (Throwable th2) {
                Exceptions.b(th2);
                RxJavaPlugins.s(new CompositeException(th, th2));
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f139512a.g(EmptySubscription.INSTANCE);
            try {
                this.f139512a.onError(new CompositeException(th, nullPointerException));
            } catch (Throwable th3) {
                Exceptions.b(th3);
                RxJavaPlugins.s(new CompositeException(th, nullPointerException, th3));
            }
        } catch (Throwable th4) {
            Exceptions.b(th4);
            RxJavaPlugins.s(new CompositeException(th, nullPointerException, th4));
        }
    }

    @Override // org.reactivestreams.Subscription
    public void y(long j3) {
        try {
            this.f139513b.y(j3);
        } catch (Throwable th) {
            Exceptions.b(th);
            try {
                this.f139513b.cancel();
                RxJavaPlugins.s(th);
            } catch (Throwable th2) {
                Exceptions.b(th2);
                RxJavaPlugins.s(new CompositeException(th, th2));
            }
        }
    }
}
