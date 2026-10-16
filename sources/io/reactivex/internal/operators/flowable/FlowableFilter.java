package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableFilter<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Predicate f135640c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FilterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Predicate f135641g;

        FilterConditionalSubscriber(ConditionalSubscriber conditionalSubscriber, Predicate predicate) {
            super(conditionalSubscriber);
            this.f135641g = predicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (o(obj)) {
                return;
            }
            this.f139112b.y(1L);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            return e(i3);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean o(Object obj) {
            if (this.f139114d) {
                return false;
            }
            if (this.f139115f != 0) {
                return this.f139111a.o(null);
            }
            try {
                return this.f135641g.test(obj) && this.f139111a.o(obj);
            } catch (Throwable th) {
                c(th);
                return true;
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            QueueSubscription queueSubscription = this.f139113c;
            Predicate predicate = this.f135641g;
            while (true) {
                Object objPoll = queueSubscription.poll();
                if (objPoll == null) {
                    return null;
                }
                if (predicate.test(objPoll)) {
                    return objPoll;
                }
                if (this.f139115f == 2) {
                    queueSubscription.y(1L);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class FilterSubscriber<T> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Predicate f135642g;

        FilterSubscriber(Subscriber subscriber, Predicate predicate) {
            super(subscriber);
            this.f135642g = predicate;
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (o(obj)) {
                return;
            }
            this.f139117b.y(1L);
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            return e(i3);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean o(Object obj) {
            if (this.f139119d) {
                return false;
            }
            if (this.f139120f != 0) {
                this.f139116a.h(null);
                return true;
            }
            try {
                boolean zTest = this.f135642g.test(obj);
                if (zTest) {
                    this.f139116a.h(obj);
                }
                return zTest;
            } catch (Throwable th) {
                c(th);
                return true;
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            QueueSubscription queueSubscription = this.f139118c;
            Predicate predicate = this.f135642g;
            while (true) {
                Object objPoll = queueSubscription.poll();
                if (objPoll == null) {
                    return null;
                }
                if (predicate.test(objPoll)) {
                    return objPoll;
                }
                if (this.f139120f == 2) {
                    queueSubscription.y(1L);
                }
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f135196b.w(new FilterConditionalSubscriber((ConditionalSubscriber) subscriber, this.f135640c));
        } else {
            this.f135196b.w(new FilterSubscriber(subscriber, this.f135640c));
        }
    }
}
