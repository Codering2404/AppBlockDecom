package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableMap<T, U> extends AbstractFlowableWithUpstream<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f135932c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MapConditionalSubscriber<T, U> extends BasicFuseableConditionalSubscriber<T, U> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Function f135933g;

        MapConditionalSubscriber(ConditionalSubscriber conditionalSubscriber, Function function) {
            super(conditionalSubscriber);
            this.f135933g = function;
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            if (this.f139114d) {
                return;
            }
            if (this.f139115f != 0) {
                this.f139111a.h(null);
                return;
            }
            try {
                this.f139111a.h(ObjectHelper.d(this.f135933g.apply(obj), "The mapper function returned a null value."));
            } catch (Throwable th) {
                c(th);
            }
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
            try {
                return this.f139111a.o(ObjectHelper.d(this.f135933g.apply(obj), "The mapper function returned a null value."));
            } catch (Throwable th) {
                c(th);
                return true;
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            Object objPoll = this.f139113c.poll();
            if (objPoll != null) {
                return ObjectHelper.d(this.f135933g.apply(objPoll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MapSubscriber<T, U> extends BasicFuseableSubscriber<T, U> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Function f135934g;

        MapSubscriber(Subscriber subscriber, Function function) {
            super(subscriber);
            this.f135934g = function;
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
                this.f139116a.h(ObjectHelper.d(this.f135934g.apply(obj), "The mapper function returned a null value."));
            } catch (Throwable th) {
                c(th);
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
                return ObjectHelper.d(this.f135934g.apply(objPoll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    public FlowableMap(Flowable flowable, Function function) {
        super(flowable);
        this.f135932c = function;
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f135196b.w(new MapConditionalSubscriber((ConditionalSubscriber) subscriber, this.f135932c));
        } else {
            this.f135196b.w(new MapSubscriber(subscriber, this.f135932c));
        }
    }
}
