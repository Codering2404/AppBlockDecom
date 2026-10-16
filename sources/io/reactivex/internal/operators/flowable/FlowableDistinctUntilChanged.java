package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableConditionalSubscriber;
import io.reactivex.internal.subscribers.BasicFuseableSubscriber;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableDistinctUntilChanged<T, K> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f135569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final BiPredicate f135570d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DistinctUntilChangedConditionalSubscriber<T, K> extends BasicFuseableConditionalSubscriber<T, T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Function f135571g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final BiPredicate f135572h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f135573i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f135574j;

        DistinctUntilChangedConditionalSubscriber(ConditionalSubscriber conditionalSubscriber, Function function, BiPredicate biPredicate) {
            super(conditionalSubscriber);
            this.f135571g = function;
            this.f135572h = biPredicate;
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
                return this.f139111a.o(obj);
            }
            try {
                Object objApply = this.f135571g.apply(obj);
                if (this.f135574j) {
                    boolean zTest = this.f135572h.test(this.f135573i, objApply);
                    this.f135573i = objApply;
                    if (zTest) {
                        return false;
                    }
                } else {
                    this.f135574j = true;
                    this.f135573i = objApply;
                }
                this.f139111a.h(obj);
                return true;
            } catch (Throwable th) {
                c(th);
                return true;
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            while (true) {
                Object objPoll = this.f139113c.poll();
                if (objPoll == null) {
                    return null;
                }
                Object objApply = this.f135571g.apply(objPoll);
                if (!this.f135574j) {
                    this.f135574j = true;
                    this.f135573i = objApply;
                    return objPoll;
                }
                if (!this.f135572h.test(this.f135573i, objApply)) {
                    this.f135573i = objApply;
                    return objPoll;
                }
                this.f135573i = objApply;
                if (this.f139115f != 1) {
                    this.f139112b.y(1L);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DistinctUntilChangedSubscriber<T, K> extends BasicFuseableSubscriber<T, T> implements ConditionalSubscriber<T> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Function f135575g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final BiPredicate f135576h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f135577i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f135578j;

        DistinctUntilChangedSubscriber(Subscriber subscriber, Function function, BiPredicate biPredicate) {
            super(subscriber);
            this.f135575g = function;
            this.f135576h = biPredicate;
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
                this.f139116a.h(obj);
                return true;
            }
            try {
                Object objApply = this.f135575g.apply(obj);
                if (this.f135578j) {
                    boolean zTest = this.f135576h.test(this.f135577i, objApply);
                    this.f135577i = objApply;
                    if (zTest) {
                        return false;
                    }
                } else {
                    this.f135578j = true;
                    this.f135577i = objApply;
                }
                this.f139116a.h(obj);
                return true;
            } catch (Throwable th) {
                c(th);
                return true;
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public Object poll() {
            while (true) {
                Object objPoll = this.f139118c.poll();
                if (objPoll == null) {
                    return null;
                }
                Object objApply = this.f135575g.apply(objPoll);
                if (!this.f135578j) {
                    this.f135578j = true;
                    this.f135577i = objApply;
                    return objPoll;
                }
                if (!this.f135576h.test(this.f135577i, objApply)) {
                    this.f135577i = objApply;
                    return objPoll;
                }
                this.f135577i = objApply;
                if (this.f139120f != 1) {
                    this.f139117b.y(1L);
                }
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        if (subscriber instanceof ConditionalSubscriber) {
            this.f135196b.w(new DistinctUntilChangedConditionalSubscriber((ConditionalSubscriber) subscriber, this.f135569c, this.f135570d));
        } else {
            this.f135196b.w(new DistinctUntilChangedSubscriber(subscriber, this.f135569c, this.f135570d));
        }
    }
}
