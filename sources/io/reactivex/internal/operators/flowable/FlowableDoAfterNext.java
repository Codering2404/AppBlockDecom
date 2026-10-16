package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableDoAfterNext<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Consumer f135579c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DoAfterConditionalSubscriber<T> extends BasicFuseableConditionalSubscriber<T, T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Consumer f135580g;

        DoAfterConditionalSubscriber(ConditionalSubscriber conditionalSubscriber, Consumer consumer) {
            super(conditionalSubscriber);
            this.f135580g = consumer;
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f139111a.h(obj);
            if (this.f139115f == 0) {
                try {
                    this.f135580g.accept(obj);
                } catch (Throwable th) {
                    c(th);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            return e(i3);
        }

        @Override // io.reactivex.internal.fuseable.ConditionalSubscriber
        public boolean o(Object obj) {
            boolean zO = this.f139111a.o(obj);
            try {
                this.f135580g.accept(obj);
                return zO;
            } catch (Throwable th) {
                c(th);
                return zO;
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            Object objPoll = this.f139113c.poll();
            if (objPoll != null) {
                this.f135580g.accept(objPoll);
            }
            return objPoll;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DoAfterSubscriber<T> extends BasicFuseableSubscriber<T, T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Consumer f135581g;

        DoAfterSubscriber(Subscriber subscriber, Consumer consumer) {
            super(subscriber);
            this.f135581g = consumer;
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f139119d) {
                return;
            }
            this.f139116a.h(obj);
            if (this.f139120f == 0) {
                try {
                    this.f135581g.accept(obj);
                } catch (Throwable th) {
                    c(th);
                }
            }
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int l(int i3) {
            return e(i3);
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            Object objPoll = this.f139118c.poll();
            if (objPoll != null) {
                this.f135581g.accept(objPoll);
            }
            return objPoll;
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f135196b.w(new DoAfterConditionalSubscriber((ConditionalSubscriber) subscriber, this.f135579c));
        } else {
            this.f135196b.w(new DoAfterSubscriber(subscriber, this.f135579c));
        }
    }
}
