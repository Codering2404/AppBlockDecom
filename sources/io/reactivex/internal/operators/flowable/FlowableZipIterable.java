package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableZipIterable<T, U, V> extends AbstractFlowableWithUpstream<T, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Iterable f136723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final BiFunction f136724d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ZipIterableSubscriber<T, U, V> implements FlowableSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f136725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Iterator f136726b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final BiFunction f136727c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Subscription f136728d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f136729f;

        ZipIterableSubscriber(Subscriber subscriber, Iterator it, BiFunction biFunction) {
            this.f136725a = subscriber;
            this.f136726b = it;
            this.f136727c = biFunction;
        }

        void a(Throwable th) {
            Exceptions.b(th);
            this.f136729f = true;
            this.f136728d.cancel();
            this.f136725a.onError(th);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f136728d.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f136728d, subscription)) {
                this.f136728d = subscription;
                this.f136725a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f136729f) {
                return;
            }
            try {
                try {
                    this.f136725a.h(ObjectHelper.d(this.f136727c.apply(obj, ObjectHelper.d(this.f136726b.next(), "The iterator returned a null value")), "The zipper function returned a null value"));
                    try {
                        if (this.f136726b.hasNext()) {
                            return;
                        }
                        this.f136729f = true;
                        this.f136728d.cancel();
                        this.f136725a.onComplete();
                    } catch (Throwable th) {
                        a(th);
                    }
                } catch (Throwable th2) {
                    a(th2);
                }
            } catch (Throwable th3) {
                a(th3);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f136729f) {
                return;
            }
            this.f136729f = true;
            this.f136725a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f136729f) {
                RxJavaPlugins.s(th);
            } else {
                this.f136729f = true;
                this.f136725a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f136728d.y(j3);
        }
    }

    @Override // io.reactivex.Flowable
    public void x(Subscriber subscriber) {
        try {
            Iterator it = (Iterator) ObjectHelper.d(this.f136723c.iterator(), "The iterator returned by other is null");
            try {
                if (it.hasNext()) {
                    this.f135196b.w(new ZipIterableSubscriber(subscriber, it, this.f136724d));
                } else {
                    EmptySubscription.a(subscriber);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptySubscription.b(th, subscriber);
            }
        } catch (Throwable th2) {
            Exceptions.b(th2);
            EmptySubscription.b(th2, subscriber);
        }
    }
}
