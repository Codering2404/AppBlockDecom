package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableDistinct<T, K> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f135565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Callable f135566d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DistinctSubscriber<T, K> extends BasicFuseableSubscriber<T, T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Collection f135567g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final Function f135568h;

        DistinctSubscriber(Subscriber subscriber, Function function, Collection collection) {
            super(subscriber);
            this.f135568h = function;
            this.f135567g = collection;
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f135567g.clear();
            super.clear();
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f139119d) {
                return;
            }
            if (this.f139120f != 0) {
                this.f139116a.h(null);
                return;
            }
            try {
                if (this.f135567g.add(ObjectHelper.d(this.f135568h.apply(obj), "The keySelector returned a null key"))) {
                    this.f139116a.h(obj);
                } else {
                    this.f139117b.y(1L);
                }
            } catch (Throwable th) {
                c(th);
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            return e(i3);
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.f139119d) {
                return;
            }
            this.f139119d = true;
            this.f135567g.clear();
            this.f139116a.onComplete();
        }

        @Override // io.reactivex.internal.subscribers.BasicFuseableSubscriber, org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.f139119d) {
                RxJavaPlugins.s(th);
                return;
            }
            this.f139119d = true;
            this.f135567g.clear();
            this.f139116a.onError(th);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            Object objPoll;
            while (true) {
                objPoll = this.f139118c.poll();
                if (objPoll == null || this.f135567g.add(ObjectHelper.d(this.f135568h.apply(objPoll), "The keySelector returned a null key"))) {
                    break;
                }
                if (this.f139120f == 2) {
                    this.f139117b.y(1L);
                }
            }
            return objPoll;
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        try {
            this.f135196b.w(new DistinctSubscriber(subscriber, this.f135565c, (Collection) ObjectHelper.d(this.f135566d.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptySubscription.b(th, subscriber);
        }
    }
}
