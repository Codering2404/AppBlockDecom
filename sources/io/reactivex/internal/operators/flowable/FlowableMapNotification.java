package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class FlowableMapNotification<T, R> extends AbstractFlowableWithUpstream<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Function f135935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Function f135936d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Callable f135937f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
        private static final long serialVersionUID = 2757120512858778108L;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Function f135938f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Function f135939g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final Callable f135940h;

        MapNotificationSubscriber(Subscriber subscriber, Function function, Function function2, Callable callable) {
            super(subscriber);
            this.f135938f = function;
            this.f135939g = function2;
            this.f135940h = callable;
        }

        @Override // org.reactivestreams.Subscriber
        public void h(Object obj) {
            try {
                Object objD = ObjectHelper.d(this.f135938f.apply(obj), "The onNext publisher returned is null");
                this.f139163d++;
                this.f139160a.h(objD);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f139160a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            try {
                b(ObjectHelper.d(this.f135940h.call(), "The onComplete publisher returned is null"));
            } catch (Throwable th) {
                Exceptions.b(th);
                this.f139160a.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            try {
                b(ObjectHelper.d(this.f135939g.apply(th), "The onError publisher returned is null"));
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.f139160a.onError(new CompositeException(th, th2));
            }
        }
    }

    @Override // io.reactivex.Flowable
    protected void x(Subscriber subscriber) {
        this.f135196b.w(new MapNotificationSubscriber(subscriber, this.f135935c, this.f135936d, this.f135937f));
    }
}
