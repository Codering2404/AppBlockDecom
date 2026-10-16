package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Notification;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableDematerialize<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f135558c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DematerializeSubscriber<T, R> implements FlowableSubscriber<T>, Subscription {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Function f135560b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f135561c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Subscription f135562d;

        DematerializeSubscriber(Subscriber subscriber, Function function) {
            this.f135559a = subscriber;
            this.f135560b = function;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f135562d.cancel();
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135562d, subscription)) {
                this.f135562d = subscription;
                this.f135559a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f135561c) {
                if (obj instanceof Notification) {
                    Notification notification = (Notification) obj;
                    if (notification.g()) {
                        RxJavaPlugins.s(notification.d());
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                Notification notification2 = (Notification) ObjectHelper.d(this.f135560b.apply(obj), "The selector returned a null Notification");
                if (notification2.g()) {
                    this.f135562d.cancel();
                    onError(notification2.d());
                } else if (!notification2.f()) {
                    this.f135559a.h(notification2.e());
                } else {
                    this.f135562d.cancel();
                    onComplete();
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f135562d.cancel();
                onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f135561c) {
                return;
            }
            this.f135561c = true;
            this.f135559a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f135561c) {
                RxJavaPlugins.s(th);
            } else {
                this.f135561c = true;
                this.f135559a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f135562d.y(j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new DematerializeSubscriber(subscriber, this.f135558c));
    }
}
