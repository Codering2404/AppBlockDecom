package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableOnErrorReturn<T> extends AbstractFlowableWithUpstream<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f136055c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
        private static final long serialVersionUID = -3740826063558713822L;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Function f136056f;

        OnErrorReturnSubscriber(Subscriber subscriber, Function function) {
            super(subscriber);
            this.f136056f = function;
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            this.f139163d++;
            this.f139160a.h(obj);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f139160a.onComplete();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            try {
                b(ObjectHelper.d(this.f136056f.apply(th), "The valueSupplier returned a null value"));
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f139160a.onError(new CompositeException(th, th2));
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new OnErrorReturnSubscriber(subscriber, this.f136055c));
    }
}
