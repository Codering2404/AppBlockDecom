package io.reactivex.internal.operators.flowable;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableDoFinally<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Action f135582c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements ConditionalSubscriber<T> {
        private static final long serialVersionUID = 4109457741734051389L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ConditionalSubscriber f135583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Action f135584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f135585c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        QueueSubscription f135586d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f135587f;

        DoFinallyConditionalSubscriber(ConditionalSubscriber conditionalSubscriber, Action action) {
            this.f135583a = conditionalSubscriber;
            this.f135584b = action;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f135585c.cancel();
            e();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f135586d.clear();
        }

        void e() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f135584b.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135585c, subscription)) {
                this.f135585c = subscription;
                if (subscription instanceof QueueSubscription) {
                    this.f135586d = (QueueSubscription) subscription;
                }
                this.f135583a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f135583a.h(obj);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f135586d.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            QueueSubscription queueSubscription = this.f135586d;
            if (queueSubscription == null || (i3 & 4) != 0) {
                return 0;
            }
            int iL = queueSubscription.l(i3);
            if (iL != 0) {
                this.f135587f = iL == 1;
            }
            return iL;
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean o(Object obj) {
            return this.f135583a.o(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135583a.onComplete();
            e();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f135583a.onError(th);
            e();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            Object objPoll = this.f135586d.poll();
            if (objPoll == null && this.f135587f) {
                e();
            }
            return objPoll;
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f135585c.y(j3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = 4109457741734051389L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Subscriber f135588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Action f135589b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Subscription f135590c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        QueueSubscription f135591d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f135592f;

        DoFinallySubscriber(Subscriber subscriber, Action action) {
            this.f135588a = subscriber;
            this.f135589b = action;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f135590c.cancel();
            e();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.f135591d.clear();
        }

        void e() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f135589b.run();
                } catch (Throwable th) {
                    Exceptions.b(th);
                    RxJavaPlugins.s(th);
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void g(Subscription subscription) {
            if (SubscriptionHelper.i(this.f135590c, subscription)) {
                this.f135590c = subscription;
                if (subscription instanceof QueueSubscription) {
                    this.f135591d = (QueueSubscription) subscription;
                }
                this.f135588a.g(this);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f135588a.h(obj);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.f135591d.isEmpty();
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            QueueSubscription queueSubscription = this.f135591d;
            if (queueSubscription == null || (i3 & 4) != 0) {
                return 0;
            }
            int iL = queueSubscription.l(i3);
            if (iL != 0) {
                this.f135592f = iL == 1;
            }
            return iL;
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f135588a.onComplete();
            e();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f135588a.onError(th);
            e();
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            Object objPoll = this.f135591d.poll();
            if (objPoll == null && this.f135592f) {
                e();
            }
            return objPoll;
        }

        @Override // org.reactivestreams.Subscription
        public void y(long j3) {
            this.f135590c.y(j3);
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f135196b.w(new DoFinallyConditionalSubscriber((ConditionalSubscriber) subscriber, this.f135582c));
        } else {
            this.f135196b.w(new DoFinallySubscriber(subscriber, this.f135582c));
        }
    }
}
